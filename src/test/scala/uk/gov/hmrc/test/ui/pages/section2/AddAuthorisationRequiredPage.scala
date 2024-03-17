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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{addAuthorisationRequired, addAuthorisationRequiredCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys._

object AddAuthorisationRequiredPage extends BasePage {

  val path: String           = "/declaration/add-authorisation-required"
  val title: String          = "Add any authorisations for this export"
  val backButtonHref: String = IsAuthorisationRequiredPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(addAuthorisationRequired),
    Clearance -> List(addAuthorisationRequiredCL)
  )

  val typeIndex = 1
  val EORI      = 2

  override protected def fillPage(values: String*): Unit = {
    fillAutoComplete("authorisationTypeCode", values(typeIndex))
    store(AuthorisationType(values(sequenceId)) -> Detail(findElementById("authorisationTypeCode__option--0").getText))

    values(EORI) match {
      case "Declarant EORI" => store(AuthorisationHolderEORI(values(sequenceId)) -> Detail(detail(ExporterEORI)))
      case _                =>
        fillTextBoxById("eori", values(EORI))
        store(AuthorisationHolderEORI(values(sequenceId)) -> Detail(values(EORI)))
    }
  }
}
