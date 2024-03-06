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

import uk.gov.hmrc.test.ui.pages.DeclarationDetails._

object BorderTransportPage extends BasePage {

  val url: String                   = "/declaration/border-transport"
  def title: String                 =
    s"What are the details for the ${DeclarationDetails.cache.getOrElse(TransportLeavingBorderValue, "default value".toLowerCase)} transport?"
  val backButtonHrefs: List[String] = List.empty
  override val expanderHrefs        = List(
    "group-7-transport-information-modes-means-and-equipment#de-714-identity-of-active-means-of-transport-crossing-the-border-box-21---identity-and-nationality-of-the-active-means-of-transport-crossing-the-border"
  )

  override def checkBackButton(): Unit = {}

  def performActionsAndCache(selectOptions: String*): Unit = {
    val optionToRadioMap: Map[String, (String, String, String)] = Map(
      "Ship or RoRo ferry IMO number"                   -> ("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", "123456"),
      "Ship or RoRo ferry name"                         -> ("radio_NameOfVessel", "NameOfVessel", "Seraphim"),
      "Eurotunnel or other rail details"                -> ("radio_WagonNumber", "WagonNumber", "EuroTunnel"),
      "Vehicle registration number"                     -> ("radio_VehicleRegistrationNumber", "VehicleRegistrationNumber", "123456"),
      "Flight number and date of flight"                -> ("radio_FlightNumber", "FlightNumber", "123456"),
      "Aircraft registration number and date of flight" -> ("radio_AircraftRegistrationNumber", "AircraftRegistrationNumber", "123456"),
      "European vessel identification (ENI) number"     -> ("radio_EuropeanVesselIDNumber", "EuropeanVesselIDNumber", "123456"),
      "Inland vessel’s name"                            -> ("radio_NameOfInlandWaterwayVessel", "NameOfInlandWaterwayVessel", "123456")
    )

    val borderTypeDescInSummary: Map[String, String] = Map(
      "Ship or RoRo ferry IMO number"                   -> "Ship IMO number",
      "Ship or RoRo ferry name"                         -> "Ship name",
      "Eurotunnel or other rail details"                -> "Train",
      "Vehicle registration number"                     -> "Vehicle registration",
      "Flight number and date of flight"                -> "Flight number",
      "Aircraft registration number and date of flight" -> "Aircraft number",
      "European vessel identification (ENI) number"     -> "European vessel number (ENI)",
      "Inland vessel’s name"                            -> "Inland vessel’s name"
    )

    for (selectOption <- selectOptions)
      optionToRadioMap.get(selectOption).foreach { case (radioId, radioName, radioValue) =>
        fillRadioButton(radioId, radioName, radioValue)

        val borderTypeSecSummary = borderTypeDescInSummary.getOrElse(selectOption, "Border type is not defined")

        DeclarationDetails.cache += (BorderTransportId -> "Transport leaving the border", BorderTransportValue -> borderTypeSecSummary, BorderTransportRef -> radioValue)
      }
  }
}
