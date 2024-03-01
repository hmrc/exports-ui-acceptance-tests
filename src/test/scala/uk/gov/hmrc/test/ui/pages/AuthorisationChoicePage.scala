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

import scala.collection.immutable.HashMap

object AuthorisationChoicePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/authorisation-choice"
  val authorisationChoicePageTitle = "Which export procedure are you using?"
  var authorisationChoiceDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AuthorisationChoicePage.onPage(authorisationChoicePageTitle)
  }

  def selectAuthorisationChoiceOption(selectOption: String): Unit = {
    selectOption match {
      case "Permanent_export_of_UK_goods" => findElement("id", "Code1040").click()
      case "Permanent_export_of_excise_goods " => findElement("id", "Code1007").click()
      case "Temporary_exports" => findElement("id", "CodeOther").click()
    }
    declarationDetailsMap += ("AuthorisationChoice" -> selectOption)
    submit()
  }
}
