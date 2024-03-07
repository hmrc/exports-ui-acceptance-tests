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
import uk.gov.hmrc.test.ui.pages.base.BasePage

object ChoicePage extends BasePage {

  val path: String   = "/choice"
  val title = "Make and manage export declarations - Make an export declaration online - GOV.UK"
  val backButtonHrefs: List[String] = List.empty

  val createDeclaration                   = "create-declaration"
  val manageDraftDeclaration              = "manage-draft-declarations"
  val manageSubmitDeclaration             = "manage-submitted-declarations"
  val manageMovementsDeclaration          = "movements"
  val manageDocumentsByConnectingWithSFUS = "upload-documents"

  def performActionsAndStore(selectOption: String*): Unit = {
    selectOption.head match {
      case "CreateDeclaration"       => clickById(createDeclaration)
      case "ManageDraftDeclaration"  => clickById(manageDraftDeclaration)
      case "ManageSubmitDeclaration" => clickById(manageSubmitDeclaration)
      case "ManageMovementsDeclaration" => clickById(manageMovementsDeclaration)
      case "ManageDocumentsByConnectingWithSFUS" => clickById(manageDocumentsByConnectingWithSFUS)
    }
  }

  override def checkBackButton(): Unit = ()
}
