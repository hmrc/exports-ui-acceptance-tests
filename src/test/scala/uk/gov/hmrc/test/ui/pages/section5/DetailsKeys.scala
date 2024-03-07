package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailsKeys {

  val Section5 = 5

  // /add-declaration-item

  // /items/[id]/procedure-codes
  def ProcedureCode(itemId: String): DetailKey = DetailKey("Procedure code", Section5, Some(itemId))

  // /items/[id]/additional-procedure-codes
  def AdditionalProcedureCodes(itemId: String): DetailKey = DetailKey("Additional procedure codes", Section5, Some(itemId))

  // /items/[id]/fiscal-information
  def FiscalInformationYesNo(itemId: String): DetailKey = DetailKey("Onward Supply Relief (OSR)", Section5, Some(itemId))

  // /items/[id]/additional-fiscal-references
  def AdditionalFiscalReferencesCountry(itemId: String): DetailKey = DetailKey("additional-fiscal-references-country", Section5, Some(itemId))
  def AdditionalFiscalReferencesVAT(itemId: String): DetailKey = DetailKey("additional-fiscal-references-vat", Section5, Some(itemId))

  // /items/[id]/additional-fiscal-references-list
  def AdditionalFiscalReferencesListYesNo(itemId: String): DetailKey = DetailKey("additional-fiscal-references-list-yes-no", Section5, Some(itemId))

  // /items/[id]/commodity-details
  def CommodityDetailsCode       (itemId: String): DetailKey = DetailKey("Commodity code", Section5, Some(itemId))
  def CommodityDetailsDescription(itemId: String): DetailKey = DetailKey("Goods description", Section5, Some(itemId))

  // /items/[id]/un-dangerous-goods-code
  def DangerousGoodsCodeYesNo(itemId: String): DetailKey = DetailKey("dangerous-goods-code-yes-no", Section5, Some(itemId))
  def DangerousGoodsCode     (itemId: String): DetailKey = DetailKey("UN dangerous goods code", Section5, Some(itemId))

  // /items/[id]/cus-code
  def CusCodeYesNo(itemId: String): DetailKey = DetailKey("cus-code-yes-no", Section5, Some(itemId))
  def CusCode(itemId: String): DetailKey = DetailKey("CUS code", Section5, Some(itemId))

  // /items/[id]/vat-rating
  def VatRating(itemId: String): DetailKey = DetailKey("VAT zero rating", Section5, Some(itemId))

  // /items/[id]/national-additional-code
  def NationalAdditionalCodeYesNo(itemId: String): DetailKey = DetailKey("national-additional-code-yes-no", Section5, Some(itemId))
  def NationalAdditionalCodes    (itemId: String): DetailKey = DetailKey("National additional codes", Section5, Some(itemId))

  // /items/[id]/national-additional-codes-list
  def NationalAdditionalCodesListYesNo(itemId: String): DetailKey = DetailKey("national-additional-codes-list-yes-no", Section5, Some(itemId))

  // /items/[id]/national-additional-code/[codeId]/remove
  def NationalAdditionalCodeRemoveYesNo(itemId: String): DetailKey = DetailKey("national-additional-code-remove-yes-no", Section5, Some(itemId))

  // /items/[id]/statistical-value
  def StatisticalValue(itemId: String): DetailKey = DetailKey("Item value", Section5, Some(itemId))

  // /items/[id]/package-information
  // /items/[id]/package-information/[packageId]/change
  def PackageInformationType        (itemId: String): DetailKey = DetailKey("Package type", Section5, Some(itemId))
  def PackageInformationNumber      (itemId: String): DetailKey = DetailKey("Number of package type", Section5, Some(itemId))
  def PackageInformationShippingMark(itemId: String): DetailKey = DetailKey("Shipping marks", Section5, Some(itemId))

  // /items/[id]/packages-list
  def PackagesListYesNo(itemId: String): DetailKey = DetailKey("packages-yes-no", Section5, Some(itemId))

  // /items/[id]/package-information/[packageId]/remove
  def PackageInformationRemoveYesNo(itemId: String): DetailKey = DetailKey("package-information-remove-yes-no", Section5, Some(itemId))

  // /items/[id]/commodity-measure
  def CommodityMeasureNet  (itemId: String): DetailKey = DetailKey("Net weight in kilograms", Section5, Some(itemId))
  def CommodityMeasureGross(itemId: String): DetailKey = DetailKey("Gross weight in kilograms", Section5, Some(itemId))

  // /items/[id]/supplementary-units
  def SupplementaryUnitsYesNo(itemId: String): DetailKey = DetailKey("supplementary-units-yes-no", Section5, Some(itemId))
  def SupplementaryUnits     (itemId: String): DetailKey = DetailKey("Supplementary units", Section5, Some(itemId))

  // /items/[id]/is-additional-information-required
  def IsAdditionalInformationRequired(itemId: String): DetailKey = DetailKey("is-additional-information-required", Section5, Some(itemId))

  // /items/[id]/additional-information
  // /items/[id]/additional-information/[addInfoId]/change
  def AdditionalInformationCode       (itemId: String): DetailKey = DetailKey("Statement code", Section5, Some(itemId))
  def AdditionalInformationDescription(itemId: String): DetailKey = DetailKey("Required information", Section5, Some(itemId))

  // /items/[id]/additional-information-list
  def AdditionalInformationYesNo(itemId: String): DetailKey = DetailKey("additional-information-yes-no", Section5, Some(itemId))

  // /items/[id]/additional-information/[addInfoId]/remove
  def AdditionalInformationRemoveYesNo(itemId: String): DetailKey = DetailKey("additional-information-remove-yes-no", Section5, Some(itemId))

  // /items/[id]/is-additional-documentation-required
  def IsAdditionalDocumentationRequired(itemId: String): DetailKey = DetailKey("is-additional-documentation-required", Section5, Some(itemId))

  // /items/[id]/is-licence-required
  def IsLicenceRequired(itemId: String): DetailKey = DetailKey("Licences", Section5, Some(itemId))

  // /items/[id]/additional-documentation
  // /items/[id]/additional-documentation/[docId]/change
  def AdditionalDocumentationCode      (itemId: String): DetailKey = DetailKey("Document code", Section5, Some(itemId))
  def AdditionalDocumentationIdentifier(itemId: String): DetailKey = DetailKey("Document identifier", Section5, Some(itemId))
  def AdditionalDocumentationStatus    (itemId: String): DetailKey = DetailKey("additional-documentation-status", Section5, Some(itemId))
  def AdditionalDocumentationReason    (itemId: String): DetailKey = DetailKey("additional-documentation-reason", Section5, Some(itemId))
  def AdditionalDocumentationAuthName  (itemId: String): DetailKey = DetailKey("additional-documentation-authority-name", Section5, Some(itemId))
  def AdditionalDocumentationDay       (itemId: String): DetailKey = DetailKey("additional-documentation-day", Section5, Some(itemId))
  def AdditionalDocumentationMonth     (itemId: String): DetailKey = DetailKey("additional-documentation-month", Section5, Some(itemId))
  def AdditionalDocumentationYear      (itemId: String): DetailKey = DetailKey("additional-documentation-year", Section5, Some(itemId))
  def AdditionalDocumentationUnit      (itemId: String): DetailKey = DetailKey("additional-documentation-unit", Section5, Some(itemId))
  def AdditionalDocumentationQualifier (itemId: String): DetailKey = DetailKey("additional-documentation-qualifier", Section5, Some(itemId))
  def AdditionalDocumentationQuantity  (itemId: String): DetailKey = DetailKey("additional-documentation-quantity", Section5, Some(itemId))

  // /items/[id]/additional-documentation-list
  def additionalDocumentationYesNo(itemId: String): DetailKey = DetailKey("additional-documentation-yes-no", Section5, Some(itemId))

  // /items/[id]/additional-documentation/[docId]/remove
  def additionalDocumentationRemoveYesNo(itemId: String): DetailKey = DetailKey("additional-documentation-remove-yes-no", Section5, Some(itemId))

  // /remove-declaration-item/[id]
  def RemoveDeclarationItem(itemId: String): DetailKey = DetailKey("remove-declaration-item-yes-no", Section5, Some(itemId))

  // /declaration-items-list
  val DeclarationItemsListYesNo: DetailKey = DetailKey("declaration-items-list-yes-no", Section5)

  // /summary-section/5
}