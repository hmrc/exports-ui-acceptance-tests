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
  val title: String = "Are these goods being zero-rated for VAT?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(itemsZeroRatedForVat))

  override def pageLinkHrefs: Seq[String] =
    super.pageLinkHrefs ++ List(if (hasRestrictingZeroVatPC) previousProcedureCodes else vatOnGoodsExportedFromUK)

  // fillPage("Yes")         => "Yes"
  // fillPage("VAT reduced") => "No, a reduced VAT 5% duty rate applies in the UK and is being paid"
  // fillPage("VAT exempt")  => "No, the goods are VAT exempt in the UK anyway"
  // fillPage("VAT paid")    => "No, 20% VAT is being paid in the UK on these goods"

  override def fillPage(values: String*): Unit = {
    val value = values.head match {
      case "Yes"         => clickById("VATZ"); "Yes"
      case "VAT reduced" => clickById("VATR"); "No, reduced"
      case "VAT exempt"  => clickById("VATE"); "No, exempt"
      case "VAT paid"    => clickById("VAT_NO"); "No, paid"
    }
    store(VatRating(itemId) -> Detail(value))
  }
}
