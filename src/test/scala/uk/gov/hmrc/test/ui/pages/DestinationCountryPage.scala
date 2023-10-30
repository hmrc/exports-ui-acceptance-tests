/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object DestinationCountryPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/destination-country"
  val destinationCountryPageTitle = "Where are the goods being exported to?"
  var destinationCountryDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    DestinationCountryPage.onPage(destinationCountryPageTitle)
  }

  def typeDestinationCountry(destinationCountry:String): String = {
    findElement("id", "countryCode").clear()
    findElement("id", "countryCode").sendKeys(Keys.chord(superKey, "a"))
    val destinationCountryEntered : WebElement = findElement("id", "countryCode")
    destinationCountryEntered.sendKeys(destinationCountry)
    findElement("id", "countryCode").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    destinationCountryEntered.getText
  }

  def enterDestinationCountry(destinationCountry:String): Unit = {
    val countryEntered: String = typeDestinationCountry(destinationCountry)
    destinationCountryDetailsMap += ("DestinationCountryEntered" -> countryEntered)
    submit()
  }
}
