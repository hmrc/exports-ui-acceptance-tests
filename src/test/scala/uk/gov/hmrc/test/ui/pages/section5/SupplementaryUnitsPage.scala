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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.itemsSupplementaryUnits
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{CommodityDetailsCode, SupplementaryUnits}

object SupplementaryUnitsPage extends BasePage {

  def backButtonHref: String = CommodityMeasurePage.path
  def path: String           = itemUrl("supplementary-units")
  def title: String          = findElementByTag("h1").getText

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(itemsSupplementaryUnits))

  override def pageLinkHrefs: Seq[String] =
    if (title != "Do you need to add supplementary units?") super.pageLinkHrefs
    else {
      val commodityCode = detail(CommodityDetailsCode(itemId))
      super.pageLinkHrefs :+ s"https://www.trade-tariff.service.gov.uk/commodities/$commodityCode"
    }

  val yesNo = 0
  val code  = 1

  // No  => processPage(no)
  // Yes => processPage(yes, "11.1")

  def processPage(values: String*): Unit = {
    if (selectYesOrNoRadio(values(yesNo), "Yes", "No")) fillTextBoxById("supplementaryUnits", values(code))
    store(SupplementaryUnits(itemId) -> Details(values))
  }
}
