/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.utils

import com.mongodb.client.{MongoClient, MongoClients, MongoCollection}
import com.typesafe.scalalogging.LazyLogging
import org.bson.Document
import org.bson.types.ObjectId
import play.api.libs.json.Json
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.generator.SupportGenerator

import java.util.UUID
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object MongoOps extends LazyLogging {

  private def mongoClient[T](f: MongoClient => T): T = {
    val client = MongoClients.create("mongodb://localhost:27017/")
    val result = f(client)
    client.close()
    result
  }

  private def collection(client: MongoClient, database: String, collection: String): MongoCollection[Document] =
    client.getDatabase(database).getCollection(collection)

  private def insertSubscriptionFields(client: MongoClient): Unit = {
    val subscriptionFields = collection(client, "api-subscription-fields", "subscriptionFields")
    subscriptionFields.deleteMany(new Document())

    val jsonAsString       = FileOps.fileAsString("./src/test/resources/ile_setup.json")
    val document: Document = Document.parse(jsonAsString).append("fieldsId", UUID.randomUUID.toString)
    subscriptionFields.insertOne(document)
  }

  /*
   * clean only the local stuff don't touch jenkins, however there is another problem with that
   * if we have more than 1 submission on local run we can't submit it, we need to clean it before doing that,
   * which is kinda tricky while running tests in parallel
   */
  def clearLocalMongoDB(): Unit =
    TestConfiguration.env match {
      case "local" =>
        mongoClient { client =>
          val document = new Document()
          List(
            collection(client, "message", "conversation"),
            collection(client, "customs-declare-exports", "declarations"),
            collection(client, "customs-declare-exports", "notifications"),
            collection(client, "customs-declare-exports", "submissions")
          ).foreach(_.deleteMany(document))

          insertSubscriptionFields(client)
        }

      case _ => logger.debug("-> data is not removed for selected profile")
    }

  /*
   * example messages are here: https://github.com/hmrc/secure-message/tree/master/test/resources/model/core
   */
  def insertMessage(messageType: String, eori: String): Unit = {
    logger.info(s"-> inserting fake sfus message: $messageType, $eori")

    mongoClient { client =>
      val jsonAsString           =
        FileOps.fileAsString(s"./src/test/scala/uk/gov/hmrc/test/ui/cucumber/messages/$messageType.json")
      val conversation: Document = Document.parse(jsonAsString)

      // update conversationId as this is unique
      val identifier: String =
        s"TEST-${SupportGenerator.generateAlphaNumeric(5, 5)}-${SupportGenerator.generateAlphaNumeric(8, 8)}"
      conversation.append("id", identifier)
      conversation.append("subject", identifier)

      val participants = conversation.getList("participants", classOf[Document])

      // user eori is unique
      val user = participants.get(1).get("identifier", classOf[Document])
      user.append("value", eori)

      conversation.append("participants", participants)
      conversation.append("_id", new ObjectId())

      val conversations = client.getDatabase("message").getCollection("conversation")
      conversations.insertOne(conversation)
    }
  }

  def insertMessages(messages: List[String], eori: String): Unit =
    for (i <- messages.indices) insertMessage(messages(i), eori)

  def loadDraftDeclarationData(eori: String, lrn: String, ducr: String): String = {

    val json =
      s"""{
         "eori": "$eori",
         "itemCount" : 1,
         "lrn":"$lrn",
         "ducr":"$ducr"
         }""".stripMargin

    val response = WSClient.httpPost(
      TestConfiguration.url("load-draft-declaration"),
      Json.parse(json),
      "Content-Type" -> "application/json"
    )
    val body     = Await.result(response.map(_.body), 5 seconds)
    val decId    = body.substring(18).replaceFirst("\"}", "")

    decId
  }
}
