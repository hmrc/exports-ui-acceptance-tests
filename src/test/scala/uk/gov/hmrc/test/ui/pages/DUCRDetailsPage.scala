/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap
import scala.util.Random

object DUCRDetailsPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/ducr-entry"
  val pageTitle   = "Enter your Declaration Unique Consignment Reference (DUCR)"
  var ducrDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    DUCRDetailsPage.onPage(pageTitle)

  def generateAndEnterRanomDucrEntry(): Unit = {
    def generateRandomString(length: Int): String = {
      val dynamicNumber  = "0123456789"
      val random = new Random

      val randomChars = (1 to length).map(_ => dynamicNumber(random.nextInt(dynamicNumber.length)))
      randomChars.mkString
    }

    def generateRandomDUCRString(): String = {
      val randomString = generateRandomString(12) // Generate a 12-character random string
      s"3GB$randomString-INVOICE${Random.nextInt(1000)}"
    }

    val generatedDucr = generateRandomDUCRString()

    //Enter the Ducr Value
    findElement("id", "ducr").sendKeys(generatedDucr)
    ducrDetailsMap+= ("DucrDetailsEntered" -> generatedDucr)
    submit()
  }
}
