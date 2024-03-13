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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsUnDangerousGoodsCode, itemsUnDangerousGoodsCodeCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.DangerousGoodsCode

object DangerousGoodsCodePage extends BasePage {

  def backButtonHref: String = CommodityDetailsPage.path
  def path: String           = itemUrl("un-dangerous-goods-code")
  val title: String          = "Is there a UN dangerous goods code for this item?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(itemsUnDangerousGoodsCode),
    Clearance -> List(itemsUnDangerousGoodsCodeCL)
  )

  val yesNo = 0
  val code  = 1

  // No  => processPage(no)
  // Yes => processPage(yes, "1234")

  def processPage(values: String*): Unit = {
    if (selectYesOrNoRadio(values(yesNo))) fillTextBoxById("dangerousGoodsCode", values(code))
    store(DangerousGoodsCode(itemId) -> Details(values))
  }
}
