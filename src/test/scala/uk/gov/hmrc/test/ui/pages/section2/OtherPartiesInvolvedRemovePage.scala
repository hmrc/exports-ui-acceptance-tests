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

package uk.gov.hmrc.test.ui.pages.section2

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.Constants.yesNo
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.AdditionalPartiesInvolvedType

object OtherPartiesInvolvedRemovePage extends BasePage {

  def backButtonHref: String = OtherPartiesInvolvedListPage.path

  val path: String = removeUrl("other-party")

  val title: String = "Are you sure you want to remove this party?"

  override def checkExpanders(): Unit = ()

  val partyToBeRemoved = 0

  // No  => fillPage(no)

  // The 2nd parameter is the sequenceId of the current "Other Party" element: "0", "1", "2", ...
  // Yes => fillPage(yes, "{sequenceId}")

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo))) clearIfAny(AdditionalPartiesInvolvedType(values(partyToBeRemoved)))
}
