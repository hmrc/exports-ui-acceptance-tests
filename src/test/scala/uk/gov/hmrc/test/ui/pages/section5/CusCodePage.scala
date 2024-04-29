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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.itemsCusCode
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants, Detail}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.CusCode

object CusCodePage extends BasePage {

  def backButtonHref: String = DangerousGoodsCodePage.path
  def path: String           = itemUrl("cus-code")
  val title: String          = "Is there a CUS code for this item?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(itemsCusCode))

  val code  = 1

  // No  => fillPage(no)
  // Yes => fillPage(yes, "1234")

  override def fillPage(values: String*): Unit = {
    if (selectYesOrNoRadio(values(yesNo))) {
      fillTextBoxById("cusCode", values(code))
      store(CusCode(itemId) -> Detail(values(code)))
    }
    else store(CusCode(itemId) -> Detail(Constants.no))
  }

}
