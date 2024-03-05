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

object DepartureTransportPage extends BasePage {

  val url: String   = TestConfiguration.url("exports-frontend") + "/declaration/departure-transport"
  def title: String = s"What are the details for the ${Sections.declarationDetails.} transport?"



  def selectBorderModeOfTransportOption(selectOption: String): Unit = {
    selectOption match {
      case "Ship IMO number"                                 =>
        fillRadioButton("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", "123456")
      case "Ship name"                                       =>
        fillRadioButton("radio_NameOfVessel", "NameOfVessel", "Seraphim")
      case "Eurotunnel or other rail details"                =>
        fillRadioButton("radio_WagonNumber", "WagonNumber", "EuroTunnel")
      case "Flight number and date of flight"                =>
        fillRadioButton("radio_FlightNumber", "FlightNumber", "123456")
      case "Aircraft registration number and date of flight" =>
        fillRadioButton("radio_AircraftRegistrationNumber", "AircraftRegistrationNumber", "123456")
      case "European vessel identification (ENI) number"     =>
        fillRadioButton("radio_EuropeanVesselIDNumber", "EuropeanVesselIDNumber", "123456")
      case "Inland vessel’s name"                            =>
        fillRadioButton("radio_NameOfInlandWaterwayVessel", "NameOfVessel", "123456")
      case "Vehicle registration number"                     =>
        fillRadioButton("radio_VehicleRegistrationNumber", "NameOfVessel", "123456")
    }

    Sections.declarationDetails + (DepartureTransportId -> "Transport details at the border") + (DepartureTransportValue -> selectOption)
  }
}
