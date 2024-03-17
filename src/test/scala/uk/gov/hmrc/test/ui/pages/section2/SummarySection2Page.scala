/*
 * Copyright 2023 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.base.Constants.none
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{AuthorisationsRequired, Section2}

object SummarySection2Page extends BasePage {

  val path: String           = "/declaration/summary-section/2"
  val title: String          = "Check your answers"
  def backButtonHref: String =
    if (detail(AuthorisationsRequired) == none) IsAuthorisationRequiredPage.path else AuthorisationsRequiredPage.path

  override protected def fillPage(values: String*): Unit =
    checkSectionSummary(Section2)
}
