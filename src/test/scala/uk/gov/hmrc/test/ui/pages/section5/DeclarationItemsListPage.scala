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

import uk.gov.hmrc.test.ui.pages.section4.SummarySection4Page
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.section5
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, yesNo}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{declarationItemsList, declarationItemsListCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, DetailKey}

object DeclarationItemsListPage extends BasePage {

  def backButtonHref: String = SummarySection4Page.path
  val path: String = "/declaration/declaration-items-list"

  def title: String =
    allSectionDetails(section5).groupBy { case (detailKey: DetailKey, _) => detailKey.additionalId.head }.size match {
      case 1 => "You have added 1 item"
      case n => s"You have added $n items"
    }

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(declarationItemsList),
    Clearance -> List(declarationItemsListCL)
  )

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = selectYesOrNoRadio(values(yesNo))
}
