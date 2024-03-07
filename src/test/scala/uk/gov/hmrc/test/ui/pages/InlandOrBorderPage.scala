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

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{InlandOrBorderId, InlandOrBorderValue, cache}

object InlandOrBorderPage extends BasePage {

  val path: String                   = "/declaration/inland-or-border"
  def title                         = "Where are you presenting your goods to customs?"
  val backButtonHrefs: List[String] = List.empty
  override val expanderHrefs        = List(
    "https://www.gov.uk/government/collections/goods-location-codes-for-data-element-523-of-the-customs-declaration-service"
  )

  def performActionsAndCache(selectOption: String*): Unit = {
    selectOption match {
      case "Border" => clickById("Border")
      case "Inland" => clickById("Inland")
    }
    cache += (InlandOrBorderId -> "Customs supervising office", InlandOrBorderValue -> selectOption)

  }
}
