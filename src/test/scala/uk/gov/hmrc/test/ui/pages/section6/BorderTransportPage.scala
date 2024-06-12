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

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.borderTransport
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.{BorderTransport, DepartureTransport, TransportLeavingBorder}

object BorderTransportPage extends BasePage {

  def backButtonHref: String = maybeDetails(DepartureTransport).fold(DepartureTransportPage.backButtonHref)(_ => DepartureTransportPage.path)

  val path: String  = "/declaration/border-transport"

  def title: String = s"What are the details for the ${detail(TransportLeavingBorder).toLowerCase}?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(borderTransport))

  case class BorderTransportData(radioId: String, textboxId: String, textboxValue: String, summaryValue: String)

  // ex: fillPage("Flight number and date of flight")

  override def fillPage(values: String*): Unit = {
    val data = values.head match {
      case "Ship IMO number" =>
          BorderTransportData("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", if (isAmendmentMode) "REJECTED" else "123456", "Ship IMO number")

      case "Ship name" =>
        BorderTransportData("radio_NameOfVessel", "NameOfVessel", if (isAmendmentMode) "DENIED" else "Seraphim", "Ship name")

      case "Train" =>
        BorderTransportData("radio_WagonNumber", "WagonNumber", if (isAmendmentMode) "PENDING" else "EuroTunnel", "Train")

      case "Vehicle registration" =>
        BorderTransportData("radio_VehicleRegistrationNumber", "VehicleRegistrationNumber", "EXTERNAL AMEND", "Vehicle registration")

      case "Flight number" =>
        BorderTransportData("radio_FlightNumber", "FlightNumber", "123456", "Flight number")

      case "Aircraft number" =>
        BorderTransportData("radio_AircraftRegistrationNumber", "AircraftRegistrationNumber", "123456", "Aircraft number")

      case "European vessel number (ENI)" =>
        BorderTransportData("radio_EuropeanVesselIDNumber", "EuropeanVesselIDNumber", "123456", "European vessel number (ENI)")

      case "Inland vessel’s name" =>
        BorderTransportData("radio_NameOfInlandWaterwayVessel", "NameOfInlandWaterwayVessel", "123456", "Inland vessel’s name")
    }

    fillRadioButton(data.radioId, data.textboxId, data.textboxValue)
    store(BorderTransport -> Details(List(data.summaryValue, data.textboxValue)))
  }
}
