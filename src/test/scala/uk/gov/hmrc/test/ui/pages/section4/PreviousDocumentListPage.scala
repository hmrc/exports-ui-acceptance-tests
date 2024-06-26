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

package uk.gov.hmrc.test.ui.pages.section4

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.Constants.{Standard, Supplementary, yesNo}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section3.SummarySection3Page
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys.{DocumentCodeLabel, section4}

object PreviousDocumentListPage extends BasePage {

  def backButtonHref: String =
    detail(DeclarationType) match {
      case Standard | Supplementary => NatureOfTransactionPage.path
      case _ => SummarySection3Page.path
    }

  val path: String = "/declaration/previous-documents-list"

  def title: String =
    allSectionDetails(section4).count(_._1.label == DocumentCodeLabel) match {
      case 1 => "You’ve added details for 1 document"
      case n => s"You’ve added details for $n documents"
    }

  override def checkExpanders(): Unit = ()

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = selectYesOrNoRadio(values(yesNo))

  def removePreviousDoc(index: Int): Unit = clickByCssSelector(s"#previous-document-$index-remove_button>a")
}
