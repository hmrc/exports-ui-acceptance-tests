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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Presence}
import uk.gov.hmrc.test.ui.pages.common.DeclarationInformationPage.isCancelDeclaration

object DeclarationHoldingPage extends BasePage {

  val backButtonHref: String = ""

  def path: String =
    (isAmendmentMode, isCancelDeclaration) match {
      case (true, false) => "/declaration/amendment-holding\\?isCancellation=false"
      case (true, true)  => "/declaration/amendment-holding\\?isCancellation=true"
      case _             => "/declaration/holding"
    }

  def title: String =
    (isAmendmentMode, isCancelDeclaration) match {
      case (true, false) => "Submitting amendment request"
      case (true, true)  => "Submitting amendment cancellation request"
      case _             => "Submitting your declaration"
    }

  override def checkBackButton(): Unit = ()

  override def checkExpanders(): Unit = ()

  // ex: fillPage()

  override def fillPage(values: String*): Unit =

    if (isCancelDeclaration) {
      waitForLinkText("View declaration details")
    } else if (isAmendmentMode) {
      waitForLinkText("Declaration status", Presence)
    } else { waitForLinkText("Check the declaration details page", Presence) }
}
