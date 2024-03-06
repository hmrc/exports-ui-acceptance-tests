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
import uk.gov.hmrc.test.ui.conf.{Constants, TestConfiguration}

object DepartureTransportPage extends BasePage {

  val url: String   = TestConfiguration.url("exports-frontend") + "/declaration/departure-transport"
  def title: String =
    s"What are the details for the ${Sections.declarationDetails.getOrElse(Constants.TransportLeavingBorderValue, "default value")} transport?"

  def selectBorderModeOfTransportOption(selectOption: String): Unit = {
    val optionToRadioMap: Map[String, (String, String, String)] = Map(
      "Ship IMO number"                                 -> ("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", "123456"),
      "Ship name"                                       -> ("radio_NameOfVessel", "NameOfVessel", "Seraphim"),
      "Eurotunnel or other rail details"                -> ("radio_WagonNumber", "WagonNumber", "EuroTunnel"),
      "Flight number and date of flight"                -> ("radio_FlightNumber", "FlightNumber", "123456"),
      "Aircraft registration number and date of flight" -> ("radio_AircraftRegistrationNumber", "AircraftRegistrationNumber", "123456"),
      "European vessel identification (ENI) number"     -> ("radio_EuropeanVesselIDNumber", "EuropeanVesselIDNumber", "123456"),
      "Inland vessel’s name"                            -> ("radio_NameOfInlandWaterwayVessel", "NameOfVessel", "123456"),
      "Vehicle registration number"                     -> ("radio_VehicleRegistrationNumber", "NameOfVessel", "123456")
    )

    optionToRadioMap.get(selectOption).foreach { case (radioId, radioName, radioValue) =>
      fillRadioButton(radioId, radioName, radioValue)
      Sections.declarationDetails += (DepartureTransportId -> "Transport details at the border", DepartureTransportValue -> selectOption)
    }
  }
}
