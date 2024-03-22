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

package uk.gov.hmrc.test.ui.pages.section4

import uk.gov.hmrc.test.ui.pages.base.Constants.{Common, no, yes}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{invoiceAndExchangeRateChoice, invoiceAndExchangeRateChoice1}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail, Details}
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys.{ExchangeRate, TotalAmountInvoiced}

object InvoicesAndExchangeRatePage extends BasePage {

  def backButtonHref: String = InvoicesAndExchangeRateChoicePage.path
  val path: String = "/declaration/invoices-and-exchange-rate"
  def title = "Total amount invoiced"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(invoiceAndExchangeRateChoice, invoiceAndExchangeRateChoice1)
  )

  // No Scenario  => fillPage("AFN", "1000", "No")
  // Yes Scenario => fillPage("GBP", "123456", "1.25")

  override def fillPage(values: String*): Unit = {
    val currency = values(0)
    val totalAmountInvoiced = values(1)
    val exchangeRate = values(2)

    fillDropdown("totalAmountInvoicedCurrency", currency)
    fillTextBoxById("totalAmountInvoiced", totalAmountInvoiced)

    if (exchangeRate == no) {
      selectYesOrNoRadio(no)
    }
    else {
      selectYesOrNoRadio(yes)
      fillTextBoxById("exchangeRate", exchangeRate)
      store(ExchangeRate -> Detail(exchangeRate))
    }

    store(TotalAmountInvoiced -> Detail(s"$currency $totalAmountInvoiced"))
  }
}
