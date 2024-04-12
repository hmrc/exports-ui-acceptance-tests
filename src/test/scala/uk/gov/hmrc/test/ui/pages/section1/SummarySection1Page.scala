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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{DeclarationType, Mucr, Section1}

object SummarySection1Page extends BasePage {

  def backButtonHref: String =
    if (detail(DeclarationType).equals(is)) {
      ConsignmentReferencesPage.path
    } else if (maybeDetail(Mucr).isDefined) {
      EnterAMucrPage.path
    } else {
      LinkMucrPage.path
    }

  val path: String = "/declaration/summary-section/1"
  val title: String = "Check your answers"

  override def checkExpanders(): Unit = ()

  // ex: fillPage()

  override def fillPage(values: String*): Unit = checkSectionSummary(Section1)
}
