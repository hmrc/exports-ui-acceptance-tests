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

package uk.gov.hmrc.test.ui.pages.section3

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{officeOfExit, officeOfExitCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.{OfficeOfExitCode, section3}

object SummarySection3Page extends BasePage {

  def backButtonHref: String = OfficeOfExitPage.path

  val path: String = "/declaration/summary-section/3"

  val title: String = "Check your answers"

  override def fillPage(values: String*): Unit = {
    checkSectionSummary(section3)
  }

}
