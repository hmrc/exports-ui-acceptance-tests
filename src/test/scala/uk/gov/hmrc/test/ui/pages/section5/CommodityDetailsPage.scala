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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys._

object CommodityDetailsPage extends BasePage {

  val pageId = "commodity-details"

  def backButtonHref: String =
      maybeDetail(FiscalInformationYesNo(itemId)).fold(AdditionalProcedureCodesPage.path) {
        _ => FiscalReferencesPage.backButtonHref
      }


  def path: String = itemUrl(pageId)
  val title: String = "Commodity code and item details"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(itemsCommodityDetails, itemsCommodityDetails1),
    Clearance -> List(itemsCommodityDetailsCL, itemsCommodityDetailsCL1)
  )

  val code = 0
  val description = 1

  // ex: fillPage("4203400090", "Straw for bottles")

  override def fillPage(values: String*): Unit = {
    fillTextBoxById("combinedNomenclatureCode", values(code))
    fillTextBoxById("descriptionOfGoods", values(description))
    store(
      CommodityDetailsCode(itemId) -> Detail(values(code)),
      CommodityDetailsDescription(itemId) -> Detail(values(description))
    )
  }

  private val chemicalCommodityCodes: Seq[String] =
    List("28", "29", "38")

  def hasChemicalCommodityCode: Boolean = {
    val commodityDetail = detail(CommodityDetailsCode(itemId))
    commodityDetail match {
      case s: String => chemicalCommodityCodes.exists(_.startsWith(s))
      case _ => false // handle non-String case appropriately
    }
  }
}
