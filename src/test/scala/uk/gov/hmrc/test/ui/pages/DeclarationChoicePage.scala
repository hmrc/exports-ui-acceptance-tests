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

import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.DeclarationType
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}

object DeclarationChoicePage extends BasePage {

  val path: String           = "/declaration/declaration-choice"
  val title                  = "Select a declaration type"
  val backButtonHref: String = StandardOrOtherPage.path

  override def performActionsAndStore(values: String*): Unit = {
    val declarationType = values(0)
    declarationType match {
      case Occasional    => clickById(Occasional)
      case Simplified    => clickById(Simplified)
      case Clearance     => clickById(Clearance)
      case Supplementary => clickById(Supplementary)
    }
    store(DeclarationType -> Detail("DeclarationType"), value(DeclarationType) -> Detail(declarationType))
  }
}
