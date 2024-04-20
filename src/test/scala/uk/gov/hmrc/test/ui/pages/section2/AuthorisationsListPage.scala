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

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.Constants.yesNo
import uk.gov.hmrc.test.ui.pages.section1.DeclarationChoicePage.{isClearance, isOccasional}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{AuthorisationTypeLabel, section2}

object AuthorisationsListPage extends BasePage {

  def backButtonHref: String = if(isOccasional)OtherPartiesInvolvedListPage.path
  else if(isClearance) ConsigneeDetailsPage.path
  else ProcedureChoicePage.path
  val path: String = "/declaration/authorisations-required"

  def title: String =
    allSectionDetails(section2).count(_._1.label == AuthorisationTypeLabel) match {
      case 1 => "You have added 1 authorisation"
      case n => s"You have added $n authorisations"
    }

  override def checkExpanders(): Unit = ()

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = selectYesOrNoRadio(values(yesNo))

  def removeAuthCode(index: Int): Unit = clickByCssSelector(s"#holder-table-row$index-remove_button>a")
}
