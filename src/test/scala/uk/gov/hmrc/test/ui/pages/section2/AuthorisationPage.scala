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

package uk.gov.hmrc.test.ui.pages.section2

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, sequenceId}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{addAuthorisationRequired, addAuthorisationRequiredCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationEori
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys._

object AuthorisationPage extends BasePage {

  def backButtonHref: String =
    if (detailForLabel(section2, AuthorisationTypeLabel).isEmpty) AuthorisationsYesNoPage.path
    else AuthorisationsListPage.path

  override def changeLink: String = ProcedureChoicePage.path
  val path: String = "/declaration/add-authorisation-required"
  val title: String = "Add any authorisations for this export"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(addAuthorisationRequired), Clearance -> List(addAuthorisationRequiredCL))

  val typeIndex = 1
  val EORI = 2

  // The 1st parameter is the sequenceId of the current "Authorisation" element: "0", "1", "2", ...
  // ex: fillPage({sequenceId}, "CSE", "GB121212121212")
  // ex: fillPage({sequenceId}, "CSE", "Declarant EORI")

  override def fillPage(values: String*): Unit = {
    val selection = fillDropdown("authorisationTypeCode", values(typeIndex), Some("authorisationTypeCode__listbox"))

    val eori = values(EORI) match {
      case "Declarant EORI" =>
        clickById("UserEori")
        detail(DeclarationEori)

      case _ =>
        clickById("OtherEori")
        fillTextBoxById("eori", values(EORI))
        values(EORI)
    }

    store(
      AuthorisationType(values(sequenceId)) -> Detail(selection),
      AuthorisationHolderEORI(values(sequenceId)) -> Detail(eori)
    )
  }

  private val codesRequiringAdditionalDocuments = List(
    "ACE", "ACP", "ACR", "ACT", "AEOC", "AEOF", "AEOS",
    "BOI", "BTI", "CCL", "CGU", "CSE", "CVA", "CW1", "CW2",
    "CWP", "DEP", "DPO", "EIR", "EPSS", "ETD", "EUS", "EXW",
    "EXWH", "FAS", "FZ", "GGA", "IPO", "MIB", "MOU", "OPO",
    "REP", "REX", "RSS", "SDE", "SIVA", "SSE", "TEA", "TEAH",
    "TRD", "TST", "UKCS",
  )

  def hasCodesRequiringAdditionalDocuments: Boolean =
    detailForLabel(section2, AuthorisationTypeLabel).exists(codesRequiringAdditionalDocuments.contains)
}
