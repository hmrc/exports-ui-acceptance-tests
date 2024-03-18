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
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{AuthorisationType, yesNo}

object AuthorisationRemovePage extends BasePage {

  val path: String = removeUrl("/authorisations-required")
  val title: String = "Are you sure you want to remove this authorisation?"
  def backButtonHref: String = AuthorisationsListPage.path

  val authToBeRemoved = 1

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo))) clear(AuthorisationType(values(authToBeRemoved)))
}