/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object InvoicesAndExchangeRatePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/invoices-and-exchange-rate"
  val invoiceAndExchangeRatePageTitle = "Total amount invoiced"
  var invoiceAndExchangeRateDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    InvoicesAndExchangeRatePage.onPage(invoiceAndExchangeRatePageTitle)
  }

  def typeCurrencyCode(currencyCode:String): String = {
    findElement("id", "totalAmountInvoicedCurrency").clear()
    findElement("id", "totalAmountInvoicedCurrency").sendKeys(Keys.chord(superKey, "a"))
    val enteredCurrencyCode : WebElement = findElement("id", "totalAmountInvoicedCurrency")
      enteredCurrencyCode.sendKeys(currencyCode)
    findElement("id", "totalAmountInvoicedCurrency").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    enteredCurrencyCode.getText
  }

  def enterExchangeRateWithDetails(currencyCode:String, totalAmountInvoiced:String, selectOption:String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
                    findElement("id","exchangeRate").sendKeys("1.25")
      case "No" => findElement("id", "code_no").click()
    }
    val enteredCurrencyCodeEntered: String = typeCurrencyCode(currencyCode)
    val totalAmountInvoicedEntered: WebElement = findElement("id","totalAmountInvoiced")
    totalAmountInvoicedEntered.sendKeys(totalAmountInvoiced)

    invoiceAndExchangeRateDetailsMap+=("CurrencyCode" -> enteredCurrencyCodeEntered)
    invoiceAndExchangeRateDetailsMap+=("ExchangeRateWithDetails" -> selectOption)
    invoiceAndExchangeRateDetailsMap+=("totalAmountInvoicedEntered" -> totalAmountInvoicedEntered.getText)
    submit()
  }
}
