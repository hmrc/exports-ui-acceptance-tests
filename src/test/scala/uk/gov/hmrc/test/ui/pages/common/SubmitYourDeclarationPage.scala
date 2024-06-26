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

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.common.SummaryPage.isRejectedMode

object SubmitYourDeclarationPage extends BasePage {

  def backButtonHref: String = SummaryPage.path
  def path: String = if (isAmendmentMode) "/declaration/submit-your-amendment" else "/declaration/submit-your-declaration"

  def title: String = if (isAmendmentMode) "Submit amendment request"
                      else if (isRejectedMode) "Resubmit your declaration"
                      else "Submit your declaration"

  override def checkExpanders(): Unit = ()

  // ex: fillPage()

  override def fillPage(values: String*): Unit = {
    fillTextBoxById("fullName", "Test Name")
    fillTextBoxById("jobRole", "Test Role")
    fillTextBoxById("email", "test@email.com")
    if (isAmendmentMode) fillTextBoxById("reason", "Some reason for amendment")
    clickById("confirmation")
    clickById("submit")
  }
}
