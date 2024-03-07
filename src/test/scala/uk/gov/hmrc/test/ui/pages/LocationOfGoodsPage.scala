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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.cache
import uk.gov.hmrc.test.ui.pages.base.BasePage

object LocationOfGoodsPage extends BasePage {

  val path: String                                    = "/declaration/location-of-goods"
  val title                       = "Where will the goods be presented to customs?"
  val backButtonHrefs: List[String] = ???

  private val selectOption = 0
  private val locationOfGoodsCode = 1

  def performActionsAndStore(locationOfGoods: String*): Unit = {
    locationOfGoods(selectOption) match {
      case "Yes" => clickById("code_yes")
        findElementById("code").sendKeys(locationOfGoods(locationOfGoodsCode))
      case "No"  => clickById("code_no")
    }
    store += ("LocationOfGoodsSelectOption" -> locationOfGoods(selectOption))
    store += ("LocationOfGoodsCodeEntered"  -> locationOfGoods(locationOfGoodsCode))
  }
}
