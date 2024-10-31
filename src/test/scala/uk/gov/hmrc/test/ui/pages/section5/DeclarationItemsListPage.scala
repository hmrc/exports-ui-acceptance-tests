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
import uk.gov.hmrc.test.ui.pages.base.{BasePage, DetailKey}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationChoicePage.isClearance
import uk.gov.hmrc.test.ui.pages.section4.SummarySection4Page
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{ProcedureCodeLabel, section5}

object DeclarationItemsListPage extends BasePage {

  def backButtonHref: String = SummarySection4Page.path
  val path: String = "/declaration/declaration-items-list"

  def title: String =
    allSectionDetails(section5).count { case (detailKey: DetailKey, _) =>
      detailKey.label == ProcedureCodeLabel
    } match {
      case 1 => "You have added 1 item"
      case n => s"You have added $n items"
    }

  override def checkExpanders(): Unit = ()

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit =
    if (!isClearance) selectYesOrNoRadio(values(yesNo))

  def changeItem(): Unit = clickById("item_0--change")
  def removeItemFromListPage(): Unit = clickById("item_0--remove")
}
