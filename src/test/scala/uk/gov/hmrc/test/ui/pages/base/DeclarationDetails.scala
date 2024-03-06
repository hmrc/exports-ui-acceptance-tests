package uk.gov.hmrc.test.ui.pages.base

import scala.collection.mutable

object DeclarationDetails {

  val cache: mutable.Map[String, String] = mutable.Map.empty[String, String]

  val DeclarationChoiceId = "declarationChoiceId"
  val DeclarationChoiceValue = "declarationChoiceValue"
  val DepartureTransportId = "departureTransportId"
  val DepartureTransportValue = "departureTransportValue"
  val DepartureTransportRef         = "departureTransportRef"
  val TransportLeavingBorderId      = "transportLeavingBorderId"
  val TransportLeavingBorderValue   = "transportLeavingBorderValue"
  val WareHouseId                   = "wareHouseId"
  val WareHouseValue                = "wareHouseValue"
  val SuperVisingCustomsOfficeId    = "superVisingCustomsOfficeId"
  val SuperVisingCustomsOfficeValue = "superVisingCustomsOfficeValue"
  val InlandOrBorderId              = "inlandOrBorderId"
  val InlandOrBorderValue           = "inlandOrBorderValue"
  val InlandModeOfTransportId       = "inlandModeOfTransportId"
  val InlandModeOfTransportValue    = "inlandModeOfTransportValue"
  val BorderTransportId             = "borderTransportId"
  val BorderTransportValue          = "borderTransportValue"
  val BorderTransportRef            = "borderTransportRef"
  val TransportCountryId            = "transportCountryId"
  val TransportCountryValue         = "transportCountryValue"
  val ExpressConsignmentId          = "expressConsignmentId"
  val ExpressConsignmentValue       = "expressConsignmentValue"
  val TransportPaymentId            = "transportPaymentId"
  val TransportPaymentValue         = "transportPaymentValue"
}
