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
import uk.gov.hmrc.test.ui.pages.section1.DeclarationTypePage.{isEIDR, isPrelodgedDeclaration}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Lrn

object DeclarationHoldingPage extends BasePage {

  val backButtonHref: String = ""

  def path: String =
    if (isAmendmentMode) "/declaration/amendment-holding\\?isCancellation=false" else "/declaration/holding"
  def title: String = if (isAmendmentMode) "Submitting amendment request" else "Submitting your declaration"

  override def checkBackButton(): Unit = ()

  override def checkExpanders(): Unit = ()

  // ex: fillPage()

  override def fillPage(values: String*): Unit = {
    val obtainedLrn = maybeDetail(Lrn).get

    // Set of characters that should trigger the first condition
    val triggerChars: Set[Char] = Set('Q', 'X', 'I', 'L', 'K', 'P', 'J', 'N')

    // Check if the obtainedLrn starts with any of the characters in triggerChars
    val startsWithTriggerChar: Boolean = triggerChars.contains(obtainedLrn.charAt(0))

    // Check if the obtainedLrn starts with 'C' and one of the additional conditions is true
    val startsWithCAndCondition: Boolean = obtainedLrn.startsWith("C") && (isPrelodgedDeclaration || isEIDR)

    if (startsWithTriggerChar || startsWithCAndCondition) {
      waitForLinkText("Your declarations")
    } else {
      waitForLinkText("Declaration status", Presence)
    }
  }
}
