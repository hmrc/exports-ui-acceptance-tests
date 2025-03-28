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

package uk.gov.hmrc.test.ui.pages.section4

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationChoicePage._
import uk.gov.hmrc.test.ui.pages.section1.StandardOrOtherPage.isStandard
import uk.gov.hmrc.test.ui.pages.section2.EntryIntoDeclarantRecordsPage.isEidr
import uk.gov.hmrc.test.ui.pages.section2.ProcedureChoicePage._
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys._

object PreviousDocumentPage extends BasePage {

  def backButtonHref: String =
    if (detailForLabel(section4, DocumentCodeLabel).nonEmpty) PreviousDocumentListPage.path
    else PreviousDocumentListPage.backButtonHref

  override def changeLink: String = PreviousDocumentListPage.path
  val path: String = "/declaration/add-previous-document"

  def title: String =
    if (
      ((isStandard || isSimplified || isSupplementary) && isProcedurePermanent) ||
      (isClearance && isProcedurePermanent && isEidr)
    ) { "Details for each document that supports this declaration" }
    else if (
      ((isStandard || isSimplified || isSupplementary) && isProcedurePermanentAndExcise) ||
      (isClearance && isProcedurePermanentAndExcise && isEidr)
    ) { "Declare each document, including excise guarantees" }
    else if (
      ((isStandard || isSimplified || isSupplementary) && isProcedureTemporary) ||
      (isClearance && isProcedureTemporary && isEidr)
    ) { "Declare each document, including previous declarations" }
    else if (
      (isStandard || isSimplified || isSupplementary) ||
      (isClearance && isEidr)
    ) { "Details for each document that supports this declaration" }
    else if (isClearance) { "Details for each document that supports this clearance request" }
    else if (isOccasional) { "Details for each document that supports this declaration" }
    else { "Details for each document that supports this declaration" }

  override def checkExpanders(): Unit = ()

  val documentCode = 1
  val documentReference = 2

  // The 1st parameter is the sequenceId of the current "Previous Document" element: "0", "1", "2", ...
  // ex: fillPage("3", "Commercial Invoice", "SMITH 321/890")
  // ex: fillPage(Constants.none)

  override def fillPage(values: String*): Unit =
    if (values.head == none) store(NoPreviousDocuments -> Detail(none))
    else {
      val code = fillDropdown("documentType", values(documentCode), Some("documentType__option--0"))
      fillTextBoxById("documentReference", values(documentReference))

      store(
        DocumentCode(values(sequenceId)) -> Detail(code),
        DocumentReference(values(sequenceId)) -> Detail(values(documentReference))
      )
    }
}
