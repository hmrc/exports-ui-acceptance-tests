/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object InvoiceAndExchangeRateChoicePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/invoices-and-exchange-rate-choice"
  val invoiceAndExchangeRateChoicePageTitle = "Is the total amount invoiced less than £100,000 in value? "
  var invoiceAndExchangeRateChoiceDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    InvoiceAndExchangeRateChoicePage.onPage(invoiceAndExchangeRateChoicePageTitle)
  }

  def isTheTotalAmountInvoicedLessThan100000IValueOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    invoiceAndExchangeRateChoiceDetailsMap += ("InvoiceAndExchangeRateChoice" -> selectOption)
    declarationDetailsMap +=("InvoiceAndExchangeRateChoice" -> selectOption)
    submit()
  }
}
