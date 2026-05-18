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
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object SealListPage extends BasePage {

  def backButtonHref: String = ContainerListPage.path
  def path: String = s"/declaration/containers/$containerId/seals"

  def title: String =
    details(Seals(containerId)).size match {
      case 1 => s"You have added 1 security seal for container $containerId"
      case n => s"You have added $n security seals for container $containerId"
    }

  override def checkExpanders(): Unit = ()

  private val yesNo = 0

  override def fillPage(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))

  def selectSealToRemove(index: Int): Unit = clickByCssSelector(s"#removable_elements-row$index-remove_button > a")
}
