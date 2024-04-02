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

package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, sequenceId}
import uk.gov.hmrc.test.ui.pages.base.PageLinks.{additionalDocumentsReferenceCodes, additionalDocumentsUnionCodes, additionalDocumentsUnitCodes}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsAdditionalDocuments, itemsAdditionalDocumentsCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section2.AuthorisationPage.hasCodesRequiringAdditionalDocuments
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{AdditionalDocumentCode, AdditionalDocumentIdentifier}
import uk.gov.hmrc.test.ui.pages.section5.LicenseRequiredYesNoPage.isLicenseRequired

object AdditionalDocumentPage extends BasePage {

  def backButtonHref: String =
    maybeDetail(AdditionalDocumentCode(itemId, "0")).fold {
      if (isLicenseRequired || hasCodesRequiringAdditionalDocuments) LicenseRequiredYesNoPage.path
      else AdditionalDocumentsYesNoPage.path
    }(_ => AdditionalDocumentListPage.path)

  override def changeLink: String = AdditionalDocumentListPage.path
  def path: String = itemUrl("additional-documentation")

  def title: String =
    (detail(DeclarationType), hasCodesRequiringAdditionalDocuments, isLicenseRequired) match {
      case (Clearance, true, _)  => "Declare each document code and authorisation number"
      case (Clearance, false, _) => "Declare each additional document required for this item"
      case (_, true, true)       => "Enter licence details, authorisation numbers and any other document details"
      case (_, false, true)      => "Enter licence details and any other document details"
      case (_, true, false)      => "Enter authorisation numbers and any other document details"
      case (_, false, false)     => "Enter any other document details"
    }

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(itemsAdditionalDocuments), Clearance -> List(itemsAdditionalDocumentsCL))

  override val pageLinkHrefs: Seq[String] =
    super.pageLinkHrefs ++ List(
      additionalDocumentsUnionCodes,
      additionalDocumentsReferenceCodes,
      additionalDocumentsUnitCodes
    )

  val code = 1
  val identifier = 2

  // The 1st parameter is the sequenceId of the current "Additional Document" element: "0", "1", "2", ...
  // ex: fillPage("2", "C501", "GBAEOC717572504502801")

  override def fillPage(values: String*): Unit = {
    fillTextBoxById("documentTypeCode", values(code))
    fillTextBoxById("documentIdentifier", values(identifier))
    store(
      AdditionalDocumentCode(itemId, values(sequenceId)) -> Detail(values(code)),
      AdditionalDocumentIdentifier(itemId, values(sequenceId)) -> Detail(values(identifier))
    )
  }
}
