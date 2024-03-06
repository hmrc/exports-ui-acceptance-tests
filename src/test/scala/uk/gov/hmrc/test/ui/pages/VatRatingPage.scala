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
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object VatRatingPage extends BasePage {

  val path: String                              = "/declaration/items/([^/]+)/vat-rating"
  val title                       = "Are these goods being zero-rated for VAT?"


  def checkPageTitle(): Unit =
    VatRatingPage.checkUrlAndTitle(vatRatingPageTitle)

  def selectAreTheseGoodsBeingZeroRatedOption(selectOption: String): Unit = {
    selectOption match {
      case "VATZ"   => findElementById("VATZ").click()
      case "VATR"   => findElementById("VATR").click()
      case "VATE"   => findElementById("VATE").click()
      case "VAT_NO" => findElementById("VAT_NO").click()
    }
cache += ("vatRatingDetails" -> selectOption)
    submit()
  }
}
