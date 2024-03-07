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
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{DepartureTransportId, DepartureTransportRef, DepartureTransportValue, TransportLeavingBorderValue, cache}

object DepartureTransportPage extends BasePage {

  val path: String                   = "/declaration/departure-transport"
  def title: String                 =
    s"What are the details for the ${store.getOrElse(TransportLeavingBorderValue, "default value").toLowerCase} transport?"
  val backButtonHrefs: List[String] = List.empty
  override val expanderHrefs: List[String] = List(
    "group-7-transport-information-modes-means-and-equipment#de-77-identity-of-the-means-of-transport-at-departure"
  )

  override def checkBackButton(): Unit = {}

  def performActionsAndStore(selectOptions: String*): Unit = {
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

    for (selectOption <- selectOptions)
      optionToRadioMap.get(selectOption).foreach { case (radioId, radioName, radioValue) =>
        fillRadioButton(radioId, radioName, radioValue)
        store += (DepartureTransportId -> "Transport details at the border", DepartureTransportValue -> selectOption, DepartureTransportRef -> radioValue)
      }
  }
}
