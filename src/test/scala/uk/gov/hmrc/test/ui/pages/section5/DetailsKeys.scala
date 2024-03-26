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

package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailsKeys {

  val section5 = 5
  val Section5: DetailKey = DetailKey("Section 5 of 6: About the items", section5, Some("items-card"))

  val ProcedureCodeLabel = "Procedure code"
  val AdditionalProcedureCodeLabel = "Additional procedure codes"
  val AdditionalFiscalReferenceLabel = "VAT details"
  val PackageTypeLabel = "Package type"
  val AdditionalInformationCodeLabel = "Statement code"
  val AdditionalInformationDescriptionLabel = "Statement code"
  val AdditionalDocumentCodeLabel = "Document code"
  val NationalAdditionalCodeLabel = "National additional codes"

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
  def CommodityDetailsCode(itemId: String): DetailKey = DetailKey("Commodity code", section5, Some(itemId))
  def CommodityDetailsDescription(itemId: String): DetailKey = DetailKey("Goods description", section5, Some(itemId))

  // /items/[id]/un-dangerous-goods-code
  def DangerousGoodsCode(itemId: String): DetailKey = DetailKey("UN dangerous goods code", section5, Some(itemId))

  // /items/[id]/cus-code
  def CusCode(itemId: String): DetailKey = DetailKey("CUS code", section5, Some(itemId))

  // /items/[id]/vat-rating
  def VatRating(itemId: String): DetailKey = DetailKey("VAT zero rating", section5, Some(itemId))

  // /items/[id]/national-additional-code
  def NationalAdditionalCodes(itemId: String): DetailKey =
    DetailKey(NationalAdditionalCodeLabel, section5, Some(itemId))

  // /items/[id]/national-additional-codes-list
  // /items/[id]/national-additional-code/[codeId]/remove

  // /items/[id]/statistical-value
  def StatisticalValue(itemId: String): DetailKey = DetailKey("Item value", section5, Some(itemId))

  def NoPackageInformation(itemId: String): DetailKey = DetailKey("Packing details", section5, Some(itemId))

  // /items/[id]/package-information
  def PackageInformationType(itemId: String, sequenceId: String): DetailKey =
    DetailKey(PackageTypeLabel, section5, Some(itemId), Some(sequenceId))

  def PackageInformationNumber(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Number of package type", section5, Some(itemId), Some(sequenceId), checkChangeLink = false)

  def PackageInformationShippingMark(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Shipping marks", section5, Some(itemId), Some(sequenceId), checkChangeLink = false)

  // /items/[id]/packages-list
  // /items/[id]/package-information/[packageId]/change
  // /items/[id]/package-information/[packageId]/remove

  // /items/[id]/commodity-measure
  def CommodityMeasureNet(itemId: String): DetailKey = DetailKey("Net weight in kilograms", section5, Some(itemId), checkChangeLink = false)
  def CommodityMeasureGross(itemId: String): DetailKey = DetailKey("Gross weight in kilograms", section5, Some(itemId))

  // /items/[id]/supplementary-units
  def SupplementaryUnits(itemId: String): DetailKey = DetailKey("Supplementary units", section5, Some(itemId))

  // /items/[id]/is-additional-information-required
  def NoAdditionalInformation(itemId: String): DetailKey =
    DetailKey("Additional information statement codes", section5, Some(itemId))

  // /items/[id]/additional-information
  def AdditionalInformationCode(itemId: String, sequenceId: String): DetailKey =
    DetailKey(AdditionalInformationCodeLabel, section5, Some(itemId), Some(sequenceId))

  def AdditionalInformationDescription(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Required information", section5, Some(itemId), Some(sequenceId), checkChangeLink = false)

  // /items/[id]/additional-information-list
  // /items/[id]/additional-information/[addInfoId]/change
  // /items/[id]/additional-information/[addInfoId]/remove

  // /items/[id]/is-licence-required
  def IsLicenceRequired(itemId: String): DetailKey = DetailKey("Licences", section5, Some(itemId))

  // /items/[id]/is-additional-documentation-required
  def NoAdditionalDocuments(itemId: String): DetailKey =
    DetailKey("Additional references and documents", section5, Some(itemId))

  // /items/[id]/additional-documentation
  def AdditionalDocumentCode(itemId: String, sequenceId: String): DetailKey =
    DetailKey(AdditionalDocumentCodeLabel, section5, Some(itemId), Some(sequenceId))

  def AdditionalDocumentIdentifier(itemId: String, sequenceId: String): DetailKey =
    DetailKey("Document identifier", section5, Some(itemId), Some(sequenceId), checkChangeLink = false)

  // All the following Additional Document Keys are not in use. For future use
  def AdditionalDocumentStatus(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-status", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  def AdditionalDocumentReason(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-reason", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  def AdditionalDocumentAuthName(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-authority-name", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  def AdditionalDocumentDay(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-day", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  def AdditionalDocumentMonth(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-month", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  def AdditionalDocumentYear(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-year", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  def AdditionalDocumentUnit(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-unit", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  def AdditionalDocumentQualifier(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-qualifier", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  def AdditionalDocumentQuantity(itemId: String, sequenceId: String): DetailKey =
    DetailKey("additional-documentation-quantity", section5, Some(itemId), Some(sequenceId), skipRowCheck = true)

  // /items/[id]/additional-documentation-list
  // /items/[id]/additional-documentation/[docId]/change
  // /items/[id]/additional-documentation/[docId]/remove

  // /remove-declaration-item/[id]

  // /declaration-items-list

  // /summary-section/5
}
