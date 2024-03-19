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
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.TotalAmountInvoiced
import uk.gov.hmrc.test.ui.pages.section3.SummarySection3Page
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys.TotalAmountInvoiced

import scala.Predef.->

object InvoicesAndExchangeRateChoicePage extends BasePage {

  val path: String = "/declaration/office-of-exit"

  def title = "Is the total amount invoiced less than £100,000 in value?"

  val backButtonHref: String = SummarySection3Page.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(invoiceAndExchangeRateChoice, invoiceAndExchangeRateChoice1)
  )

  def fillPage(values: String*): Unit = {
    val yesNo = values.head
    if (selectYesOrNoRadio(yesNo)) store(TotalAmountInvoiced -> Detail("Less than £100,000"))
  }

}
