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
import uk.gov.hmrc.test.ui.pages.base.BasePage.exitAndCompleteLater

object DraftSavedPage extends BasePage {

  val backButtonHref: String = ""
  val path: String = "/draft-saved"
  val title: String = "Your draft declaration will be saved for 30 days"

  override def checkExpanders(): Unit = ()
  override def checkBackButton(): Unit = ()

  val savedSummaryLink = "/saved-declarations"
  val choiceLink = "/choice"
  val backToGovUk = "https://www.gov.uk/"
  val viewDeclaration = "/saved-declaration"

  override def pageLinkHrefs: Seq[String] = {
    val additionalLinks =
      List(savedSummaryLink, choiceLink, backToGovUk, viewDeclaration)
    super.pageLinkHrefs.filterNot(_ == exitAndCompleteLater) ++ additionalLinks
  }

  override def fillPage(values: String*): Unit = ()

  def viewSavedDec(): Unit = clickById("draft_confirmation-continue_dec_link")

}
