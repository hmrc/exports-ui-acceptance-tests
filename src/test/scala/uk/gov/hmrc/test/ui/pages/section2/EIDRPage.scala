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

package uk.gov.hmrc.test.ui.pages.section2

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.SummarySection1Page
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{EntryIntoDeclarantsRecords, yesNo}

object EIDRPage extends BasePage {

  val path: String           = "/declaration/entry-into-declarants-records"
  val title: String          = "Is this an entry into declarant’s records (EIDR)?"
  val backButtonHref: String = SummarySection1Page.path

  override def fillPage(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo), "answer_yes", "answer_no")
    store(EntryIntoDeclarantsRecords -> Detail(values(yesNo)))
  }
}
