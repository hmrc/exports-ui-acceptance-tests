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

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.Constants.yesNo
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.Container

object ContainerRemovePage extends BasePage {

  def backButtonHref: String = ContainersListPage.path
  def path: String           = removeUrl("containers")
  val title                  = "Are you sure you want to remove this container?"

  override def checkExpanders(): Unit = ()

  val containerIdToBeRemoved = 1

  // No  => fillPage(no)
  // Yes => fillPage(yes, "ContainerId")

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo))) {
      val containerId = values(containerIdToBeRemoved)
      clear(
        Container(containerId)
        // Container's Seals, if any, to remove
      )
    }
}
