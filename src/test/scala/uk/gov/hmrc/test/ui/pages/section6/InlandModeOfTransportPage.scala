/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.inlandTransportDetails
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object InlandModeOfTransportPage extends BasePage {

  val path: String  = "/declaration/inland-transport-details"
  val title: String = "How will the goods be transported to the UK border?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(inlandTransportDetails)
  )

  def backButtonHref: String =
    if (!shouldSkipInlandOrBorder && detail(InlandOrBorder) == "Border Location") {
      InlandOrBorderPage.path
    } else if (shouldSkipInlandOrBorder && isSPOFFNotNeeded) {
      TransportLeavingTheBorderPage.path
    } else {
      SupervisingCustomsOfficePage.path
    }

  private val mode = 0

  override def fillPage(values: String*): Unit = {
    val elementId = values(mode) match {
      case "Road transport"                           => "Inland_Road"
      case "Rail transport"                           => "Inland_Rail"
      case "Sea transport"                            => "Inland_Sea"
      case "Air transport"                            => "Inland_Air"
      case "Postal or mail"                           => "Inland_PostalOrMail"
      case "Fixed transport installations"            => "Inland_FixedTransportInstallations"
      case "Inland waterway transport"                => "Inland_InlandWaterway"
      case "Mode unknown, for example own propulsion" => "Inland_Unknown"
    }
    clickById(elementId)
    store(TransportLeavingBorder -> Detail(values(mode)))
  }
}
