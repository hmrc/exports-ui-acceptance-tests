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

package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{Ducr, Lrn}
import uk.gov.hmrc.test.ui.pages.section1.DucrEntryPage.ducrPrefix

object LrnPage extends BasePage {

  def backButtonHref: String =
    if (detail(Ducr).startsWith(ducrPrefix)) ConfirmDucrPage.path
    else DucrEntryPage.path

  val path: String = "/declaration/local-reference-number"
  val title: String = "Create a Local Reference Number (LRN)"

  override def checkExpanders(): Unit = ()

  // ex: fillPage("QSLRN1101100")

  override def fillPage(values: String*): Unit = {
    val lrn = values.head
    fillTextBoxById("lrn", lrn)
    store(Lrn -> Detail(lrn))
  }
}
