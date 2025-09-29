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

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val section6 = 6
  val Section6: DetailKey = DetailKey("Section 6 of 6: Transportation of the goods", section6, Some("transport-card"))

  val ContainerLabel = "Container ID"
  val SealLabel = "Security seals"

  // /transport-leaving-the-border
  val TransportLeavingBorder: DetailKey = DetailKey("Transport at the border", section6)

  // /warehouse-details
  val WarehouseHouse: DetailKey = DetailKey("Warehouse ID", section6)

  // /supervising-customs-office
  val SuperVisingCustomsOffice: DetailKey = DetailKey("Customs supervising office", section6)

  // /inland-or-border
  val InlandOrBorder: DetailKey = DetailKey("Presenting to customs", section6)

  // /inland-transport-details
  val InlandModeOfTransport: DetailKey = DetailKey("Inland mode of transport", section6)

  // /departure-transport
  val DepartureTransport: DetailKey = DetailKey("Transport details at the border", section6)

  // /border-transport
  val BorderTransport: DetailKey = DetailKey("Transport leaving the border", section6)

  // /transport-country
  val TransportCountry: DetailKey =
    DetailKey("Country of registration for the transport leaving the UK border", section6)

  // /express-consignment
  val ExpressConsignment: DetailKey = DetailKey("Express consignment", section6)

  // /transport-payment
  val TransportPayment: DetailKey = DetailKey("Method of payment for transport", section6)

  // /container
  def NoContainers: DetailKey = DetailKey("Goods in a container", section6)
  def Container(containerId: String): DetailKey = DetailKey(ContainerLabel, section6, Some(containerId))

  // /container/seal
  def Seals(containerId: String): DetailKey = DetailKey(SealLabel, section6, Some(containerId), checkChangeLink = false)
}
