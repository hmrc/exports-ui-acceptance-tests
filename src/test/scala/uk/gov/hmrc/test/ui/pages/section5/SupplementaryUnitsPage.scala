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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Common, yesNo}
import uk.gov.hmrc.test.ui.pages.base.PageLinks.{supplementaryCommodityTariffLink, tariffCommodities}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.itemsSupplementaryUnits
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{CommodityDetailsCode, SupplementaryUnits}

object SupplementaryUnitsPage extends BasePage {

  def backButtonHref: String = CommodityMeasurePage.path
  def path: String = itemUrl("supplementary-units")
  val title: String = "Do you need to add supplementary units?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(itemsSupplementaryUnits))

  override def pageLinkHrefs: Seq[String] =
    if (detail(CommodityDetailsCode(itemId)) == "None") {
      super.pageLinkHrefs :+ supplementaryCommodityTariffLink
    } else {
      val commodityCode = detail(CommodityDetailsCode(itemId))
      super.pageLinkHrefs :+ s"$tariffCommodities$commodityCode}"
    }

  val code = 1

  // No  => fillPage(no)
  // Yes => fillPage(yes, "11.1")

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo), "Yes", "No")) {
      fillTextBoxById("supplementaryUnits", values(code))
      store(SupplementaryUnits(itemId) -> Detail(values(code)))
    }
}
