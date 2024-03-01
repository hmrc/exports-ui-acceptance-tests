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

object DeclarationTypePage extends BasePage {

  val url: String                = TestConfiguration.url("exports-frontend") + "/declaration/type"
  val homePageTitle              = "Do you have to make an arrived export declaration? - Section 1 of 6: Declaration details - Make an export declaration online - GOV.UK"

  val arrivedDeclaration = "arrived"
  val prelodegedDeclaration = "prelodged"

  def checkPageTitle():Unit= {
    DeclarationTypePage.onPage(homePageTitle)
  }

  def selectDeclarationTypeOption(selectOption: String): Unit = {
    selectOption match {
      case "ArrivedDeclaration"   => findElement("id", "arrived" ).click()
      case "PreLodgedDeclaration" => findElement("id", "prelodged").click()
    }
    submit()
  }



}
