/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object InvoicesAndExchangeRatePage extends BasePage {

  val path: String                                           = TestConfiguration.url("exports-frontend") + "/declaration/invoices-and-exchange-rate"
  val invoiceAndExchangeRatePageTitle                       = "Total amount invoiced"
  var invoiceAndExchangeRateDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys                                        = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit =
    InvoicesAndExchangeRatePage.checkUrlAndTitle(invoiceAndExchangeRatePageTitle)

  def typeCurrencyCode(currencyCode: String): String = {
    findElement("id", "totalAmountInvoicedCurrency").clear()
    findElement("id", "totalAmountInvoicedCurrency").sendKeys(Keys.chord(superKey, "a"), Keys.BACK_SPACE)
    val enteredCurrencyCode: WebElement = findElement("id", "totalAmountInvoicedCurrency")
    enteredCurrencyCode.sendKeys(currencyCode)
    findElement("id", "totalAmountInvoicedCurrency").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    enteredCurrencyCode.getText
  }

  def enterExchangeRateWithDetails(currencyCode: String, totalAmountInvoiced: String, selectOption: String): Unit = {
    selectOption match {
      case "Yes" =>
        findElement("id", "code_yes").click()
        findElement("id", "exchangeRate").sendKeys("1.25")
      case "No"  => findElement("id", "code_no").click()
    }
    val enteredCurrencyCodeEntered: String     = typeCurrencyCode(currencyCode)
    val totalAmountInvoicedEntered: WebElement = findElement("id", "totalAmountInvoiced")
    totalAmountInvoicedEntered.sendKeys(totalAmountInvoiced)

    invoiceAndExchangeRateDetailsMap += ("CurrencyCode"               -> enteredCurrencyCodeEntered)
    invoiceAndExchangeRateDetailsMap += ("ExchangeRateWithDetails"    -> selectOption)
    invoiceAndExchangeRateDetailsMap += ("totalAmountInvoicedEntered" -> totalAmountInvoicedEntered.getText)
    submit()
  }
}
