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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsCommodityMeasure, itemsCommodityMeasure1, itemsCommodityMeasureCL, itemsCommodityMeasureCL1}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{CommodityMeasureGross, CommodityMeasureNet}

object CommodityMeasurePage extends BasePage {

  def backButtonHref: String = NationalAdditionalCodesListPage.path
  def path: String           = itemUrl("commodity-measure")
  val title: String          = "What is the weight of the goods?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(itemsCommodityMeasure, itemsCommodityMeasure1),
    Clearance -> List(itemsCommodityMeasureCL, itemsCommodityMeasureCL1)
  )

  val netWeight   = 0
  val grossWeight = 1

  // ex: performActionsAndStore()
  // ex: performActionsAndStore("500", "700")
  // ex: performActionsAndStore("500")
  // ex: performActionsAndStore("", "700")

  override protected def performActionsAndStore(values: String*): Unit =
    values.size match {
      case 0 =>
        clear(CommodityMeasureNet(itemId))
        clear(CommodityMeasureGross(itemId))

      case 1 => handleNetWeight(values(netWeight))
      case _ =>
        val netWeightValue = values(netWeight)
        if (netWeightValue.trim.nonEmpty) handleNetWeight(netWeightValue)
        handleGrossWeight(values(grossWeight))
    }

  private def handleGrossWeight(value: String): Unit = {
    fillTextBoxById("grossMass", value)
    store(CommodityMeasureGross(itemId) -> Detail(value))
  }

  private def handleNetWeight(value: String): Unit = {
    fillTextBoxById("netMass", value)
    store(CommodityMeasureNet(itemId) -> Detail(value))
  }
}
