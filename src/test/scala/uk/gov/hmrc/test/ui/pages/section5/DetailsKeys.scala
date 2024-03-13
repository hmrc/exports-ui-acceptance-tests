package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailsKeys {

  val Section5 = 5

  val AdditionalFiscalReferenceLabel = "VAT details"
  val ProcedureCodeLabel             = "Procedure code"
  val AdditionalProcedureCodeLabel   = "Additional procedure codes"

  // /add-declaration-item

  // /items/[id]/procedure-codes
  def ProcedureCode(itemId: String): DetailKey = DetailKey(ProcedureCodeLabel, Section5, Some(itemId))

  // /items/[id]/additional-procedure-codes
  def AdditionalProcedureCodes(itemId: String): DetailKey =
    DetailKey(AdditionalProcedureCodeLabel, Section5, Some(itemId))

  // /items/[id]/fiscal-information
  def FiscalInformationYesNo(itemId: String): DetailKey =
    DetailKey("Onward Supply Relief (OSR)", Section5, Some(itemId))

  // /items/[id]/additional-fiscal-references
  def AdditionalFiscalReferences(itemId: String, sequenceId: String): DetailKey =
    DetailKey(AdditionalFiscalReferenceLabel, Section5, Some(itemId), Some(sequenceId))

  // /items/[id]/additional-fiscal-references-list

  // /items/[id]/commodity-details
  def CommodityDetailsCode(itemId: String): DetailKey        = DetailKey("Commodity code", Section5, Some(itemId))
  def CommodityDetailsDescription(itemId: String): DetailKey = DetailKey("Goods description", Section5, Some(itemId))

  // /items/[id]/un-dangerous-goods-code
  def DangerousGoodsCode(itemId: String): DetailKey = DetailKey("UN dangerous goods code", Section5, Some(itemId))

  // /items/[id]/cus-code
  def CusCode(itemId: String): DetailKey = DetailKey("CUS code", Section5, Some(itemId))

  // /items/[id]/vat-rating
  def VatRating(itemId: String): DetailKey = DetailKey("VAT zero rating", Section5, Some(itemId))

  // /items/[id]/national-additional-code
  def NationalAdditionalCodes(itemId: String, sequenceId: String): DetailKey =
    DetailKey("National additional codes", Section5, Some(itemId), Some(sequenceId))

  // /items/[id]/national-additional-codes-list
  // /items/[id]/national-additional-code/[codeId]/remove

  // /items/[id]/statistical-value
  def StatisticalValue(itemId: String): DetailKey = DetailKey("Item value", Section5, Some(itemId))

  // /items/[id]/package-information
  def PackageInformationType(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Package type", Section5, Some(itemId), Some(sequenceId))

  def PackageInformationNumber(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Number of package type", Section5, Some(itemId), Some(sequenceId))

  def PackageInformationShippingMark(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Shipping marks", Section5, Some(itemId), Some(sequenceId))

  // /items/[id]/packages-list
  // /items/[id]/package-information/[packageId]/change
  // /items/[id]/package-information/[packageId]/remove

  // /items/[id]/commodity-measure
  def CommodityMeasureNet(itemId: String): DetailKey   = DetailKey("Net weight in kilograms", Section5, Some(itemId))
  def CommodityMeasureGross(itemId: String): DetailKey = DetailKey("Gross weight in kilograms", Section5, Some(itemId))

  // /items/[id]/supplementary-units
  def SupplementaryUnits(itemId: String): DetailKey = DetailKey("Supplementary units", Section5, Some(itemId))

  // /items/[id]/is-additional-information-required

  // /items/[id]/additional-information
  def AdditionalInformationCode(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Statement code", Section5, Some(itemId), Some(sequenceId))

  def AdditionalInformationDescription(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Required information", Section5, Some(itemId), Some(sequenceId))

  // /items/[id]/additional-information-list
  // /items/[id]/additional-information/[addInfoId]/change
  // /items/[id]/additional-information/[addInfoId]/remove

  // /items/[id]/is-additional-documentation-required

  // /items/[id]/is-licence-required
  def IsLicenceRequired(itemId: String): DetailKey = DetailKey("Licences", Section5, Some(itemId))

  // /items/[id]/additional-documentation
  def AdditionalDocumentationCode(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Document code", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationIdentifier(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Document identifier", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationStatus(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-status", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationReason(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-reason", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationAuthName(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-authority-name", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationDay(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-day", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationMonth(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-month", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationYear(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-year", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationUnit(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-unit", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationQualifier(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-qualifier", Section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationQuantity(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-quantity", Section5, Some(itemId), Some(sequenceId))

  // /items/[id]/additional-documentation-list
  // /items/[id]/additional-documentation/[docId]/change
  // /items/[id]/additional-documentation/[docId]/remove

  // /remove-declaration-item/[id]

  // /declaration-items-list

  // /summary-section/5
}
