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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6.checkIfDecIsOcaOrSim
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object BorderTransportPage extends BasePage {

  val path: String  = "/declaration/border-transport"
  def title: String =
    s"What are the details for the ${detail(TransportLeavingBorder).toLowerCase} transport?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(borderTransport)
  )

  private val transport = 0

  def backButtonHref: String =
    if (checkIfDecIsOcaOrSim) {
      InlandModeOfTransportPage.path
    } else {
      DepartureTransportPage.path
    }

  case class BorderTransportData(radioId: String, textboxId: String, textboxValue: String, summaryValue: String)

  def fillPage(values: String*): Unit = {
    val data = values.head match {
      case "Ship or RoRo ferry IMO number"                   =>
        BorderTransportData("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", "123456", "Ship IMO number")
      case "Ship or RoRo ferry name"                         =>
        BorderTransportData("radio_NameOfVessel", "NameOfVessel", "Seraphim", "Ship name")
      case "Eurotunnel or other rail details"                =>
        BorderTransportData("radio_WagonNumber", "WagonNumber", "EuroTunnel", "Train")
      case "Vehicle registration number"                     =>
        BorderTransportData(
          "radio_VehicleRegistrationNumber",
          "VehicleRegistrationNumber",
          "123456",
          "Vehicle registration"
        )
      case "Flight number and date of flight"                =>
        BorderTransportData("radio_FlightNumber", "FlightNumber", "123456", "Flight number")
      case "Aircraft registration number and date of flight" =>
        BorderTransportData(
          "radio_AircraftRegistrationNumber",
          "AircraftRegistrationNumber",
          "123456",
          "Aircraft number"
        )
      case "European vessel identification (ENI) number"     =>
        BorderTransportData(
          "radio_EuropeanVesselIDNumber",
          "EuropeanVesselIDNumber",
          "123456",
          "European vessel number (ENI)"
        )
      case "Inland vessel’s name"                            =>
        BorderTransportData(
          "radio_NameOfInlandWaterwayVessel",
          "NameOfInlandWaterwayVessel",
          "123456",
          "Inland vessel’s name"
        )
    }
    fillRadioButton(data.radioId, data.textboxId, data.textboxValue)
    store(BorderTransport -> Details(List(data.summaryValue, data.textboxValue)))
  }
}
