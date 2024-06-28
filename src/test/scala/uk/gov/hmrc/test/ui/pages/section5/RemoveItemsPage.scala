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

package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.Constants.yesNo
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.common.SummaryPage
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys._

object RemoveItemsPage extends BasePage {

  def backButtonHref: String = if (isAmendmentMode) SummaryPage.path else SummarySection5Page.path
  def path: String = s"/declaration/remove-declaration-item/${details(ItemIds).head}"
  def title: String = if (isAmendmentMode) "Remove item" else "Are you sure you want to remove declaration item 1?"

  override def checkExpanders(): Unit = ()

  // The 1st parameter is the sequenceId in ItemIds of the item to remove: "0", "1", "2", ...
  // ex: fillPage("0")

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo))) {
      val itemIds = details(ItemIds)
      val itemId = itemIds(values(1).toInt)
      clear(section5, Some(itemId))
      if (itemIds.size > 1) {
        store(ItemIds -> Details(itemIds.filterNot(_ == itemId)))
      }
    }

  def displayWarning: Boolean = findElementByCssSelector("div.govuk-warning-text > strong").isDisplayed

  def clickCancelButton(): Unit = clickByXpath("//*[@role='button']")

}
