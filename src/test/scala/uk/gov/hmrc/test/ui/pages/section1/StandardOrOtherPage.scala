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

package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.Constants.Standard
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType

object StandardOrOtherPage extends BasePage {

  def backButtonHref: String = ChoicePage.path
  val path: String           = "/declaration/standard-or-other"
  val title: String          = "Which type of declaration do you want to make?"

  val nonStandardDeclarationType = "NonStandardDeclarationType"

  // ex: fillPage(nonStandardDeclarationType)

  override def fillPage(values: String*): Unit = {
    clickById(values(0))
    if (values(0) == "STANDARD") store(DeclarationType -> Detail(Standard))
  }
}