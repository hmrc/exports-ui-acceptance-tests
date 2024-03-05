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

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object VatRatingPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/vat-rating"
  val vatRatingPageTitle = "Are these goods being zero-rated for VAT?"
  var vatRatingDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    VatRatingPage.pageTitle(vatRatingPageTitle)
  }

  def selectAreTheseGoodsBeingZeroRatedOption(selectOption: String): Unit = {
    selectOption match {
      case "VATZ" => findElement("id", "VATZ").click()
      case "VATR" => findElement("id", "VATR").click()
      case "VATE" => findElement("id", "VATE").click()
      case "VAT_NO" => findElement("id", "VAT_NO").click()
    }
    vatRatingDetailsMap += ("vatRatingDetails" -> selectOption)
    submit()
  }
}
