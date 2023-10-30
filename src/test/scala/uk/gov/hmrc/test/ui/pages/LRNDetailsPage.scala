/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap
import scala.util.Random

object LRNDetailsPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/local-reference-number"
  val pageTitle = "Create a Local Reference Number (LRN)"
  var lrnDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    LRNDetailsPage.onPage(pageTitle)

  def generateAndEnterRanomLRNEntry(): Unit = {
    def generateRandomString(length: Int): String = {
      val dynamicNumber = "0123456789"
      val random = new Random

      val randomChars = (1 to length).map(_ => dynamicNumber(random.nextInt(dynamicNumber.length)))
      randomChars.mkString
    }

    def generateRandomLRNString(): String = {
      val randomString = generateRandomString(7) // Generate a 7-digits random number
      s"MSLRN$randomString"
    }

    val generatedLrn = generateRandomLRNString()

    //Enter the Lrn Value
    findElement("id", "lrn").sendKeys(generatedLrn)
    lrnDetailsMap += ("DucrDetailsEntered" -> generatedLrn)
    submit()
  }
}
