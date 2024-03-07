package uk.gov.hmrc.test.ui.pages.base

import scala.collection.mutable

trait DeclarationDetails

case class Detail(value: String) extends DeclarationDetails
case class Details(values: Seq[String]) extends DeclarationDetails

object DeclarationDetails {

  val cache: mutable.Map[String, DeclarationDetails] = mutable.Map.empty[String, DeclarationDetails]

  val DeclarationChoiceId           = "declarationChoiceId"
  val DeclarationChoiceValue        = "declarationChoiceValue"
  val DepartureTransportId          = "departureTransportId"
  val DepartureTransportValue       = "departureTransportValue"
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

  /*** SECTION 5: ITEMS ***/

  // /add-declaration-item
  val ItemIds = "item-identifiers"

  // /items/[id]/procedure-codes
  val ProcedureCode = "procedure-code"

  // /items/[id]/additional-procedure-codes
  val AdditionalProcedureCodes = "additional-procedure-codes"

  // /items/[id]/fiscal-information
  val FiscalInformationYesNo = "fiscal-information-yes-no"

  // /items/[id]/additional-fiscal-references
  val AdditionalFiscalReferencesCountry = "additional-fiscal-references-country"
  val AdditionalFiscalReferencesVAT = "additional-fiscal-references-vat"

  // /items/[id]/additional-fiscal-references-list
  val AdditionalFiscalReferencesListYesNo = "additional-fiscal-references-list-yes-no"

  // /items/[id]/commodity-details
  val CommodityDetailsCode        = "commodity-details-code"
  val CommodityDetailsDescription = "commodity-details-description"

  // /items/[id]/un-dangerous-goods-code
  val DangerousGoodsCodeYesNo = "dangerous-goods-code-yes-no"
  val DangerousGoodsCode      = "dangerous-goods-code"

  // /items/[id]/cus-code
  val CusCodeYesNo = "cus-code-yes-no"
  val CusCode = "cus-code"

  // /items/[id]/vat-rating
  val VatRating = "vat-rating"

  // /items/[id]/national-additional-code
  val NationalAdditionalCodeYesNo = "national-additional-code-yes-no"
  val NationalAdditionalCode      = "national-additional-code"

  // /items/[id]/national-additional-codes-list
  val NationalAdditionalCodesListYesNo = "national-additional-codes-list-yes-no"

  // /items/[id]/national-additional-code/[codeId]/remove
  val NationalAdditionalCodeRemoveYesNo = "national-additional-code-remove-yes-no"

  // /items/[id]/statistical-value
  val StatisticalValue = "statistical-value"

  // /items/[id]/package-information
  // /items/[id]/package-information/[packageId]/change
  val PackageInformationType         = "package-information-type"
  val PackageInformationNumber       = "package-information-number"
  val PackageInformationShippingMark = "package-information-shipping-mark"

  // /items/[id]/packages-list
  val PackagesListYesNo = "packages-yes-no"

  // /items/[id]/package-information/[packageId]/remove
  val PackageInformationRemoveYesNo = "package-information-remove-yes-no"

  // /items/[id]/commodity-measure
  val CommodityMeasureNet   = "commodity-measure-net"
  val CommodityMeasureGross = "commodity-measure-gross"

  // /items/[id]/supplementary-units
  val SupplementaryUnitsYesNo = "supplementary-units-yes-no"
  val SupplementaryUnits      = "supplementary-units"

  // /items/[id]/is-additional-information-required
  val IsAdditionalInformationRequired = "is-additional-information-required"

  // /items/[id]/additional-information
  // /items/[id]/additional-information/[addInfoId]/change
  val AdditionalInformationCode        = "additional-information-code"
  val AdditionalInformationDescription = "additional-information-description"

  // /items/[id]/additional-information-list
  val AdditionalInformationYesNo = "additional-information-yes-no"

  // /items/[id]/additional-information/[addInfoId]/remove
  val AdditionalInformationRemoveYesNo = "additional-information-remove-yes-no"

  // /items/[id]/is-additional-documentation-required
  val IsAdditionalDocumentationRequired = "is-additional-documentation-required"

  // /items/[id]/is-licence-required
  val IsLicenceRequired = "is-licence-required"

  // /items/[id]/additional-documentation
  // /items/[id]/additional-documentation/[docId]/change
  val AdditionalDocumentationCode       = "additional-documentation-code"
  val AdditionalDocumentationIdentifier = "additional-documentation-identifier"
  val AdditionalDocumentationStatus     = "additional-documentation-status"
  val AdditionalDocumentationReason     = "additional-documentation-reason"
  val AdditionalDocumentationAuthName   = "additional-documentation-authority-name"
  val AdditionalDocumentationDay        = "additional-documentation-day"
  val AdditionalDocumentationMonth      = "additional-documentation-month"
  val AdditionalDocumentationYear       = "additional-documentation-year"
  val AdditionalDocumentationUnit       = "additional-documentation-unit"
  val AdditionalDocumentationQualifier  = "additional-documentation-qualifier"
  val AdditionalDocumentationQuantity   = "additional-documentation-quantity"

  // /items/[id]/additional-documentation-list
  val additionalDocumentationYesNo = "additional-documentation-yes-no"

  // /items/[id]/additional-documentation/[docId]/remove
  val additionalDocumentationRemoveYesNo = "additional-documentation-remove-yes-no"

  // /remove-declaration-item/[id]
  val RemoveDeclarationItem = "remove-declaration-item-yes-no"

  // /items/[id]/declaration-items-list
  val DeclarationItemsListYesNo = "declaration-items-list-yes-no"

  // /summary-section/5
}
