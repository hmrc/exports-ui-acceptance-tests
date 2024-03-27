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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{departureTransport, departureTransportCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.{DepartureTransport, InlandModeOfTransport, TransportLeavingBorder}

object DepartureTransportPage extends BasePage {

  def backButtonHref: String =
    maybeDetail(InlandModeOfTransport).fold(InlandModeOfTransportPage.backButtonHref)( _=> InlandModeOfTransportPage.path)

  val path: String  = "/declaration/departure-transport"
  def title: String = s"What are the details for the ${detail(TransportLeavingBorder).toLowerCase} transport?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(departureTransport),
    Clearance -> List(departureTransportCL)
  )

  private val departRef = 0

  // ex: fillPage("Flight number and date of flight")

  override def fillPage(values: String*): Unit = {
    val (radioId, textboxId, textboxValue) = values.head match {
      case "Ship IMO number"                                 => ("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", "123456")
      case "Ship name"                                       => ("radio_NameOfVessel", "NameOfVessel", "Seraphim")
      case "Eurotunnel or other rail details"                => ("radio_WagonNumber", "WagonNumber", "EuroTunnel")
      case "Flight number and date of flight"                => ("radio_FlightNumber", "FlightNumber", "123456")
      case "Aircraft registration number and date of flight" =>
        ("radio_AircraftRegistrationNumber", "AircraftRegistrationNumber", "123456")

      case "European vessel identification (ENI) number"     =>
        ("radio_EuropeanVesselIDNumber", "EuropeanVesselIDNumber", "123456")

      case "Inland vessel’s name"                            => ("radio_NameOfInlandWaterwayVessel", "NameOfVessel", "123456")
      case "Vehicle registration number"                     => ("radio_VehicleRegistrationNumber", "NameOfVessel", "123456")
    }

    fillRadioButton(radioId, textboxId, textboxValue)
    store(DepartureTransport -> Details(List(values(departRef), textboxValue)))
  }
}
