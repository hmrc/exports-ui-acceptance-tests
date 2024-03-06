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

import uk.gov.hmrc.test.ui.conf.Constants._
import uk.gov.hmrc.test.ui.conf.TestConfiguration

object TransportLeavingTheBorderPage extends BasePage {

  val url: String   = TestConfiguration.url("exports-frontend") + "/declaration/transport-leaving-the-border"
  val title: String = "What mode of transport will the goods leave the UK on?"

  def selectBorderModeOfTransportOption(selectOption: String): Unit = {
    val optionToIdMap: Map[String, String] = Map(
      "Sea transport"                     -> "Border_Sea",
      "Roll on roll off (RoRo) transport" -> "Border_Ferry",
      "Rail transport"                    -> "Border_Rail",
      "Road transport"                    -> "Border_Road",
      "Air transport"                     -> "Border_Air",
      "Postal"                            -> "Border_PostalOrMail",
      "Fixed transport installation"      -> "Border_FixedTransportInstallations",
      "Inland waterway transport"         -> "Border_InlandWaterway",
      "Own propulsion"                    -> "Border_Unknown"
    )

    optionToIdMap.get(selectOption).foreach { id =>
      clickById(id)
      Sections.declarationDetails + (TransportLeavingBorderId -> "Transport at the border") + (TransportLeavingBorderValue -> selectOption)
    }
  }
}
