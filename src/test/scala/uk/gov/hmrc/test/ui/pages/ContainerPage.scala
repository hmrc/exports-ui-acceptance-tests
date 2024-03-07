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
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object ContainerPage extends BasePage {

  val path: String                                  = "/declaration/container"
  val title                           = "Are the goods in a container or containers?"


  def checkPageTitle(): Unit =
    ContainerPage.checkUrlAndTitle(containerPageTitle)

  def selectAreTheGoodsInAContainerOrContainersOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" =>
        findElementById("code_yes").click()
        findElementById("id").sendKeys("Container1")
      case "No"  => findElementById("code_no").click()
    }
store += ("containerDetails" -> selectOption)
    submit()
  }
}
