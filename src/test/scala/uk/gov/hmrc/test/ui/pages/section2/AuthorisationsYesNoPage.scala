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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, none, yesNo}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{NoAuthorisationRequired, ProcedureChoice}

object AuthorisationsYesNoPage extends BasePage {

  def backButtonHref: String = ProcedureChoicePage.path
  val path: String = "/declaration/is-authorisation-required"

  def title: String =
    detail(ProcedureChoice) match {
      case "Permanent" => "Do you have any authorisations you want to declare?"
      case "Temporary" => "Do you want to add any authorisations?"
    }

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(isAuthorisationRequired, isAuthorisationRequired1, isAuthorisationRequired2),
    Clearance -> List(isAuthorisationRequiredCL, isAuthorisationRequiredCL1, isAuthorisationRequiredCL2)
  )

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit =
    if (!selectYesOrNoRadio(values(yesNo))) store(NoAuthorisationRequired -> Detail(none))
}
