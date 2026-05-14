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

object RemoveSavedDeclarationsPage extends BasePage {

  val backButtonHref: String = "/saved-declarations"
  val path: String = removeSavedDecLink.toString()
  val title: String = "Are you sure you want to remove this declaration?"

  override def checkExpanders(): Unit = ()

  override def pageLinkHrefs: Seq[String] =
    super.pageLinkHrefs.filterNot(_ == exitAndCompleteLater)

  // fillPage("Yes")
  override def fillPage(values: String*): Unit =
    selectRadioAndClick(values(0))

}
