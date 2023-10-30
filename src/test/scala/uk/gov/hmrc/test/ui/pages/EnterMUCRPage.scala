/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap
import scala.util.Random

object EnterMUCRPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/enter-a-mucr"
  val pageTitle = "Enter the MUCR"
  var mucrDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    DUCRDetailsPage.onPage(pageTitle)

  def generateAndEnterRanomMUCREntry(): Unit = {
    def generateRandomString(length: Int): String = {
      val dynamicNumber = "0123456789"
      val random = new Random

      val randomChars = (1 to length).map(_ => dynamicNumber(random.nextInt(dynamicNumber.length)))
      randomChars.mkString
    }

    def generateRandomMUCRString(): String = {
      val randomString = generateRandomString(5)
      s"3GB$randomString${Random.nextInt(100)}"
    }

    val generatedMucr = generateRandomMUCRString()

    //Enter the Ducr Value
    findElement("id", "MUCR").sendKeys(generatedMucr)
    mucrDetailsMap += ("MucrDetailsEntered" -> generatedMucr)
    submit()
  }
}
