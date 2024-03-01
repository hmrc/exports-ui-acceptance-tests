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

object LinkToMUCRPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/link-to-mucr"
  val homePageTitle = "Do you want to link this declaration’s DUCR to a Master Unique Consignment Reference (MUCR)?"
  var linkToMUCRDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    LinkToMUCRPage.onPage(homePageTitle)
  }

  def selectDoYouHaveADucr(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    linkToMUCRDetailsMap += ("LinkToMucrDetails" -> selectOption)
    submit()
  }

}
