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

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.DeclarationDetails.{DeclarationChoiceId, DeclarationChoiceValue, cache}

import scala.collection.immutable.HashMap

object DeclarationChoicePage extends BasePage {

  val url: String   = TestConfiguration.url("exports-frontend") + "/declaration/declaration-choice"
  val title = "Select a declaration type - Make an export declaration online - GOV.UK"
  val backButtonHrefs: List[String] = List(DeclarationTypePage.url)
  
  val simplifiedOccasional                   = "OCCASIONAL"
  val authorisedSimplifiedDeclaration        = "SIMPLIFIED"
  val clearanceDeclaration                   = "CLEARANCE"
  val supplementaryDeclaration               = "SUPPLEMENTARY"

  override def performActionsAndCache(selectOption: String*): Unit = {
    selectOption.head match {
      case "SimplifiedOccasional"            => clickById(simplifiedOccasional)
      case "AuthorisedSimplifiedDeclaration" => clickById(authorisedSimplifiedDeclaration)
      case "ClearanceDeclaration"            => clickById(clearanceDeclaration)
      case "SupplementaryDeclaration"        => clickById(supplementaryDeclaration)
    }
    cache + (DeclarationChoiceId -> DeclarationChoiceValue)
  }
}
