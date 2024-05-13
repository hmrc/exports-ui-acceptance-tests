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
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Lrn

object CancelResultPage extends BasePage {

  val backButtonHref: String = ""
  val path: String = "/cancellation-result"
  def title: String =
    if (detail(Lrn).startsWith("G1S")) "Your declaration has been cancelled"
    else
      "Your cancellation request has been denied"

  override def checkExpanders(): Unit = ()

  override def checkBackButton(): Unit = ()

  val reason = 0

  // ex: fillPage("No longer required")

  override def fillPage(values: String*): Unit = ()

  def backToChoicePage(): Unit = clickById("back-to-choice")
}
