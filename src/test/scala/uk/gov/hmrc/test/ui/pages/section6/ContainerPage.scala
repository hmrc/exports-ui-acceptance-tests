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

package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants.yesNo
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants, Detail}
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.{Container, ContainerLabel, NoContainers, section6}

object ContainerPage extends BasePage {

  def backButtonHref: String =
    if (detailForLabel(section6, ContainerLabel).nonEmpty) ContainerListPage.path
    else ContainerListPage.backButtonHref

  override def changeLink: String = ContainerListPage.path

  val path: String = "/declaration/container"

  def title: String =
    if (elementByIdDoesNotExist("code_yes")) "What is the container ID?"
    else "Are the goods in a container or containers?"

  override def checkExpanders(): Unit = ()

  private val additionalCode = 0
  private val code = 1

  // No  => fillPage(no)
  // Yes => fillPage(yes, "Container identifier")
  //        fillPage("Container identifier")

  private def storeContainer(containerId: String): Unit = {
    fillTextBoxById("id", containerId)
    store(Container(containerId) -> Detail(containerId))
  }

  override def fillPage(values: String*): Unit =
    if (elementByClassDoesNotExist("govuk-radios", 10)) storeContainer(values(additionalCode))
    else if (selectYesOrNoRadio(values(yesNo))) storeContainer(values(code))
    else store(NoContainers -> Detail(Constants.none))
}
