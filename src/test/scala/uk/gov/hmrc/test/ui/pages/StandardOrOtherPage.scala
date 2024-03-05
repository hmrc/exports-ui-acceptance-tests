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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object StandardOrOtherPage extends BasePage {

  val url: String   = TestConfiguration.url("exports-frontend") + "/standard-or-other"
  val homePageTitle = "Make and manage export declarations - Make an export declaration online - GOV.UK"

  def checkTitle(): Unit =
    ExportsHomePage.checkUrlAndTitle(homePageTitle)

  def selectOptionToProgressWith(selectOption: String): Unit = {
    selectOption match {
      case "StandardDeclaration" => findElement("id", "STANDARD").click()
      case "OtherDeclaration"    => findElement("id", "NonStandardDeclarationType").click()
    }
    submit()
  }

}
