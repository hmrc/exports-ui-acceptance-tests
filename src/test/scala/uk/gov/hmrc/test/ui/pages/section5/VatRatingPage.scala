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

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.PageLinks.{previousProcedureCodes, vatOnGoodsExportedFromUK}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.itemsZeroRatedForVat
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{CusCode, VatRating}
import uk.gov.hmrc.test.ui.pages.section5.ProcedureCodesPage.hasRestrictingZeroVatPC

object VatRatingPage extends BasePage {

  def backButtonHref: String = maybeDetail(CusCode(itemId)).fold(DangerousGoodsCodePage.path)(_ => CusCodePage.path)
  def path: String = itemUrl("vat-rating")
  val title: String = "What is the VAT rating for these goods?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(itemsZeroRatedForVat))

  override def pageLinkHrefs: Seq[String] =
    super.pageLinkHrefs ++ List(if (hasRestrictingZeroVatPC) previousProcedureCodes else vatOnGoodsExportedFromUK)

  // fillPage('Report VAT rating after this declaration has been submitted')
  // fillPage("The goods are zero-rated")
  // fillPage("The goods are VAT exempt in the UK")
  // fillPage("A 20% VAT rate will be paid in the UK")
  // fillPage("A reduced 5% VAT duty rate will be paid in the UK")

  override def fillPage(values: String*): Unit = {
    val value = values.head match {
      case "Report VAT rating after this declaration has been submitted" =>
        clickById("VAT_RAD"); "Report VAT rating after this declaration has been submitted"
      case "The goods are zero-rated"                          => clickById("VATZ"); "Yes"
      case "The goods are VAT exempt in the UK"                => clickById("VATE"); "No, exempt"
      case "A 20% VAT rate will be paid in the UK"             => clickById("VAT_NO"); "No, paid"
      case "A reduced 5% VAT duty rate will be paid in the UK" => clickById("VATR"); "No, reduced"
    }
    store(VatRating(itemId) -> Detail(value))
  }
}
