/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.InvoicesAndExchangeRatePage.superKey

import scala.collection.immutable.HashMap

object TransportCountryPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/are-you-the-exporter"
  val transportCountryPageTitle = "Do you know the country where the sea transport is registered?"
  var transportCountryDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    TransportCountryPage.onPage(transportCountryPageTitle)
  }

  def typeTransportCountryCode(currencyCode: String): String = {
    findElement("id", "transportCountry").clear()
    findElement("id", "transportCountry").sendKeys(Keys.chord(superKey, "a"))
    val enteredCurrencyCode: WebElement = findElement("id", "transportCountry")
    enteredCurrencyCode.sendKeys(currencyCode)
    findElement("id", "transportCountry").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    enteredCurrencyCode.getText
  }

  def selectDoYouKnowTheCountryWhereTheSeaTransportIsRegisteredOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
                    typeTransportCountryCode("South Africa")
      case "No" => findElement("id", "code_no").click()
    }
    transportCountryDetailsMap += ("TransportCountryDetails" -> selectOption)
    submit()
  }
}
