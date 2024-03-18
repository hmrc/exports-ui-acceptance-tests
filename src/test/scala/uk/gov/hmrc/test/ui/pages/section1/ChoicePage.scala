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

package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage

object ChoicePage extends BasePage {

  val backButtonHref: String = ""
  val path: String           = "/choice"
  val title                  = "Make and manage export declarations"

  override def checkBackButton(): Unit = ()

  override def checkExpanders(): Unit = ()

  // ex: fillPage("create a declaration")

  override def fillPage(values: String*): Unit =
    values.head match {
      case "create a declaration"                => clickById("create-declaration")
      case "ManageDraftDeclaration"              => clickById("manage-draft-declarations")
      case "ManageSubmitDeclaration"             => clickById("manage-submitted-declarations")
      case "ManageMovementsDeclaration"          => clickById("movements")
      case "ManageDocumentsByConnectingWithSFUS" => clickById("upload-documents")
    }
}
