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
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.section6

object SealRemovePage extends BasePage {

  def path: String           = removeUrl("containers", "seals")

  def title                  = s"Are you sure you want to remove this security seal for container $containerId?"

  def backButtonHref: String = SealYesNoPage.path

  override def checkExpanders(): Unit = ()

  private val sealIdToBeRemoved = 1

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo))) {
      val sealId = values(sealIdToBeRemoved)
      clear(section6, Some(sealId))
    }
}
