package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val section6 = 6

  val Section6: DetailKey = DetailKey("Section 6 of 6: Transport", section6, Some("transport-card"))

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

  // /express-consignment
  val TransportPayment: DetailKey = DetailKey("Method of payment for transport", section6)

  def Container(containerId: String): DetailKey = DetailKey("Container ID", section6, Some(containerId))

  def NoContainers: DetailKey = DetailKey("Goods in a container", section6)

  def Seals(containerId: String): DetailKey = DetailKey("Security seals", section6, Some(containerId))
}
