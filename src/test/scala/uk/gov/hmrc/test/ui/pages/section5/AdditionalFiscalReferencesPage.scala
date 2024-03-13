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

package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsAdditionalFiscalReferences, itemsAdditionalFiscalReferencesCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.AdditionalFiscalReferences

object AdditionalFiscalReferencesPage extends BasePage {

  def backButtonHref: String = FiscalInformationYesNoPage.path
  def path: String           = itemUrl("additional-fiscal-references")
  val title: String          = "What are the exporter’s VAT details?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(itemsAdditionalFiscalReferences),
    Clearance -> List(itemsAdditionalFiscalReferencesCL)
  )

  val country = 0
  val countryCode = 1
  val vatNumber = 2

  // ex: processPage("United States of America", "US", "1234567890")

  def processPage(values: String*): Unit = {
    fillAutoComplete("country", values(country))
    fillTextBoxById("reference", values(vatNumber))

    val detailKey = AdditionalFiscalReferences(itemId)
    store(detailKey -> Details(details(detailKey) :+ s"${values(countryCode)}${values(vatNumber)}"))
  }
}
