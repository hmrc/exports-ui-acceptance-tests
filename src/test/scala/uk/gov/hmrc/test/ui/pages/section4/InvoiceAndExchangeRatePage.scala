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

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{invoiceAndExchangeRateChoice, invoiceAndExchangeRateChoice1}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.{InvoiceExchangeRate, TotalAmountInvoiced}

object InvoiceAndExchangeRatePage extends BasePage {

  val path: String = "/declaration/invoices-and-exchange-rate"

  def title = "Total amount invoiced"

  val backButtonHref: String = InvoicesAndExchangeRateChoicePage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(invoiceAndExchangeRateChoice, invoiceAndExchangeRateChoice1)
  )

  //Afghani AFN , 567640, No -- No Scenario
  //Pounds Sterling GBP, Yes, 1.25 -- Yes Scenario
  def performActionsAndStore(values: String*): Unit = {
    val currencySelected = values(0)
    val totalAmountInvoiced = values(1)
    val rateOfExchangeYesNo = values(2)
    val exchangeRateEntered = values(3)
    fillAutoComplete("totalAmountInvoicedCurrency", currencySelected)
    fillTextBoxById("totalAmountInvoiced", totalAmountInvoiced)
      if (selectYesOrNoRadio(rateOfExchangeYesNo)) {
        fillTextBoxById("exchangeRate", exchangeRateEntered)
        store(InvoiceExchangeRate -> Detail(exchangeRateEntered))
      }
   val  totalAmountInvoicedSummary = currencySelected.takeRight(3)+" "+totalAmountInvoiced
      store(TotalAmountInvoiced -> Detail(totalAmountInvoicedSummary))
    }
}
