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

package uk.gov.hmrc.test.ui.pages.common

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.common.DetailKeys._

object CancelDeclarationPage extends BasePage {

  def backButtonHref: String = detail(DeclarationInfoPath)
  val path: String = if (isAmendmentMode) "/cancel-your-amendment" else "/cancel-declaration"
  val title: String = if(isAmendmentMode) "Cancel amendment request" else "Cancel declaration"

  override def checkExpanders(): Unit = ()

  val reason = 0

  // ex: fillPage("No longer required")

  override def fillPage(values: String*): Unit = {
    if (isAmendmentMode) {
      val govUKWarningText: WebElement = findElementByCssSelector("div.govuk-warning-text > strong")
      govUKWarningText.isDisplayed
       fillTextBoxById("fullName", "User Name")
       fillTextBoxById("jobRole", "Job Role")
       fillTextBoxById("email", "test@mail.com")
       fillTextBoxById("reason", values(reason))
      clickById("confirmation")
    }
    else {
      val reasonToSelect = values(reason) match {
        case "No longer required" => "noLongerRequired"
        case "Duplication" => "duplication"
        case "Other reason" => "otherReason"
      }
      clickById(reasonToSelect)
      fillTextBoxById("statementDescription", "no longer needed")
    }
  }

  def cancelDeclaration(): Unit = clickById("cancel-declaration")
}