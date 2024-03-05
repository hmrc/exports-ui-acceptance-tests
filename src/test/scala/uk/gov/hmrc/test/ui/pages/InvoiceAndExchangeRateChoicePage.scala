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

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object InvoiceAndExchangeRateChoicePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/invoices-and-exchange-rate-choice"
  val invoiceAndExchangeRateChoicePageTitle = "Is the total amount invoiced less than £100,000 in value? "
  var invoiceAndExchangeRateChoiceDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    InvoiceAndExchangeRateChoicePage.pageTitle(invoiceAndExchangeRateChoicePageTitle)
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
