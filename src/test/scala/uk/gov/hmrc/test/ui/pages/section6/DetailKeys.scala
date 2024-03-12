package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val Section6 = 6

  // /transport-leaving-the-border
  val TransportLeavingBorder: DetailKey = DetailKey("Transport at the border", Section6)

  // /warehouse-details
  val WarehouseHouse: DetailKey = DetailKey("Warehouse ID", Section6)

  // /supervising-customs-office
  val SuperVisingCustomsOffice: DetailKey = DetailKey("Customs supervising office", Section6)

  // /inland-or-border
  val InlandOrBorder: DetailKey = DetailKey("Presenting to customs", Section6)

  // /inland-transport-details
  val InlandModeOfTransport: DetailKey = DetailKey("Inland mode of transport", Section6)

  // /departure-transport
  val DepartureTransport: DetailKey = DetailKey("Transport details at the border", Section6)

  // /border-transport
  val BorderTransport: DetailKey = DetailKey("Transport leaving the border", Section6)

  // /transport-country
  val TransportCountry: DetailKey =
    DetailKey("Country of registration for the transport leaving the UK border", Section6)

  // /express-consignment
  val ExpressConsignment: DetailKey = DetailKey("Express consignment", Section6)

  // /express-consignment
  val TransportPayment: DetailKey = DetailKey("Method of payment for transport", Section6)

  val Container: DetailKey = DetailKey("Container ID", Section6)

  val AddSeals: DetailKey = DetailKey("Security seals", Section6)
}
