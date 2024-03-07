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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{DeclarationChoiceId, DeclarationChoiceValue, cache}
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._

object DeclarationChoicePage extends BasePage {

  val path: String   = "/declaration/declaration-choice"
  val title = "Select a declaration type"
  val backButtonHrefs: List[String] = List(StandardOrOtherPage.path)

  override def performActionsAndCache(selectOption: String*): Unit = {
    selectOption.headOption match {
      case "SimplifiedOccasional"            => clickById(Occasional)
      case "AuthorisedSimplifiedDeclaration" => clickById(Simplified)
      case "ClearanceDeclaration"            => clickById(Clearance)
      case "SupplementaryDeclaration"        => clickById(Supplementary)
    }
    cache + (DeclarationChoiceId -> "DeclarationType", DeclarationChoiceValue -> selectOption.head)
  }
}
