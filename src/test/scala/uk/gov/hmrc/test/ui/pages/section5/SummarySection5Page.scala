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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, DetailKey}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.section5

object SummarySection5Page extends BasePage {

  def backButtonHref: String = DeclarationItemsListPage.path
  val path: String           = "/declaration/summary-section/5"
  val title: String          = "Check your answers"

  override def checkExpanders(): Unit = ()

  override def fillPage(values: String*): Unit = {
    val items = allSectionDetails(section5).groupBy { case (detailKey: DetailKey, _) => detailKey.additionalId.head }
  }
}
