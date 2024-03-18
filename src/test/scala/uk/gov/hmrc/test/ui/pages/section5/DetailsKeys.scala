package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailsKeys {

  val section5 = 5
  val Section5: DetailKey = DetailKey("Section 5 of 6: About the items", section5, Some("items-card"))

  val ProcedureCodeLabel           = "Procedure code"
  val AdditionalProcedureCodeLabel = "Additional procedure codes"
  val AdditionalFiscalReferenceLabel = "VAT details"
  val PackageTypeLabel = "Package type"
  val AdditionalInformationCodeLabel = "Statement code"

  // /add-declaration-item

  // /items/[id]/procedure-codes
  def ProcedureCode(itemId: String): DetailKey = DetailKey(ProcedureCodeLabel, section5, Some(itemId))

  // /items/[id]/additional-procedure-codes
  def AdditionalProcedureCodes(itemId: String): DetailKey =
    DetailKey(AdditionalProcedureCodeLabel, section5, Some(itemId))

  // /items/[id]/fiscal-information
  def FiscalInformationYesNo(itemId: String): DetailKey =
    DetailKey("Onward Supply Relief (OSR)", section5, Some(itemId))

  // /items/[id]/additional-fiscal-references
  def AdditionalFiscalReferences(itemId: String): DetailKey =
    DetailKey(AdditionalFiscalReferenceLabel, section5, Some(itemId))

  // /items/[id]/additional-fiscal-references-list
  // /items/[id]/additional-fiscal-references/[id]/remove

  // /items/[id]/commodity-details
  def CommodityDetailsCode(itemId: String): DetailKey        = DetailKey("Commodity code", section5, Some(itemId))
  def CommodityDetailsDescription(itemId: String): DetailKey = DetailKey("Goods description", section5, Some(itemId))

  // /items/[id]/un-dangerous-goods-code
  def DangerousGoodsCode(itemId: String): DetailKey = DetailKey("UN dangerous goods code", section5, Some(itemId))

  // /items/[id]/cus-code
  def CusCode(itemId: String): DetailKey = DetailKey("CUS code", section5, Some(itemId))

  // /items/[id]/vat-rating
  def VatRating(itemId: String): DetailKey = DetailKey("VAT zero rating", section5, Some(itemId))

  // /items/[id]/national-additional-code
  def NationalAdditionalCodes(itemId: String): DetailKey =
    DetailKey("National additional codes", section5, Some(itemId))

  // /items/[id]/national-additional-codes-list
  // /items/[id]/national-additional-code/[codeId]/remove

  // /items/[id]/statistical-value
  def StatisticalValue(itemId: String): DetailKey = DetailKey("Item value", section5, Some(itemId))

  def NoPackageInformation(itemId: String): DetailKey = DetailKey("Packing details", section5, Some(itemId))

  // /items/[id]/package-information
  def PackageInformationType(itemId: String, sequenceId: String): DetailKey =
    DetailKey(PackageTypeLabel, section5, Some(itemId), Some(sequenceId))

  def PackageInformationNumber(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Number of package type", section5, Some(itemId), Some(sequenceId))

  def PackageInformationShippingMark(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Shipping marks", section5, Some(itemId), Some(sequenceId))

  // /items/[id]/packages-list
  // /items/[id]/package-information/[packageId]/change
  // /items/[id]/package-information/[packageId]/remove

  // /items/[id]/commodity-measure
  def CommodityMeasureNet(itemId: String): DetailKey   = DetailKey("Net weight in kilograms", section5, Some(itemId))
  def CommodityMeasureGross(itemId: String): DetailKey = DetailKey("Gross weight in kilograms", section5, Some(itemId))

  // /items/[id]/supplementary-units
  def SupplementaryUnits(itemId: String): DetailKey = DetailKey("Supplementary units", section5, Some(itemId))

  // /items/[id]/is-additional-information-required

  def NoAdditionalInformation(itemId: String): DetailKey = DetailKey("Additional information statement codes", section5, Some(itemId))

  // /items/[id]/additional-information
  def AdditionalInformationCode(itemId: String, sequenceId: String): DetailKey =
    DetailKey(AdditionalInformationCodeLabel, section5, Some(itemId), Some(sequenceId))

  def AdditionalInformationDescription(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Required information", section5, Some(itemId), Some(sequenceId))

  // /items/[id]/additional-information-list
  // /items/[id]/additional-information/[addInfoId]/change
  // /items/[id]/additional-information/[addInfoId]/remove

  // /items/[id]/is-additional-documentation-required

  // /items/[id]/is-licence-required
  def IsLicenceRequired(itemId: String): DetailKey = DetailKey("Licences", section5, Some(itemId))

  def NoAdditionalDocuments(itemId: String): DetailKey = DetailKey("Additional references and documents", section5, Some(itemId))

  // /items/[id]/additional-documentation
  def AdditionalDocumentationCode(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Document code", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationIdentifier(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Document identifier", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationStatus(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-status", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationReason(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-reason", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationAuthName(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-authority-name", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationDay(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-day", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationMonth(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-month", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationYear(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-year", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationUnit(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-unit", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationQualifier(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-qualifier", section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentationQuantity(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-quantity", section5, Some(itemId), Some(sequenceId))

  // /items/[id]/additional-documentation-list
  // /items/[id]/additional-documentation/[docId]/change
  // /items/[id]/additional-documentation/[docId]/remove

  // /remove-declaration-item/[id]

  // /declaration-items-list

  // /summary-section/5
}
