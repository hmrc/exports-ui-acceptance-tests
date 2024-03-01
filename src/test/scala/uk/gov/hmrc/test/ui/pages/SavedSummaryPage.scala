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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object SavedSummaryPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/saved-summary"
  val homePageTitle = "Check your answers - Make an export declaration online - GOV.UK"
  var partiesSectionDataHashMap: Map[String, String] = HashMap[String, String]()

  val backToSelectionPageNavigationLink = "back-link"

  def clickChangeLink(changeLinkRow: String): Unit = {
       changeLink(changeLinkRow).click()
  }

  def partiesSectionElements(): Unit ={

    val obtainedDeclarationType: String = findElement("cssSelector", "div.govuk-summary-list__row.govuk-summary-list__row--no-actions.declarationType-row > dd").getText
    partiesSectionDataHashMap +=("obtainedDeclarationFromSummaryPage" -> obtainedDeclarationType)
    val obtainedDucr:String = findElement("cssSelector","div.govuk-summary-list__row.ducr-row > dd.govuk-summary-list__value").getText
    partiesSectionDataHashMap +=("obtainedDucr" -> obtainedDucr)
  }

  def validatePartiesSectionData(): Unit = {
    partiesSectionElements()
    val choicePageSelection  : String = DeclarationChoicePage.choicePageHashMap.getOrElse("choicePageSelectionDetails","None")
    val trimmedWord = choicePageSelection.replace("Declaration","")
    partiesSectionDataHashMap.getOrElse("obtainedDeclarationFromSummaryPage","None") should include (trimmedWord)
    val declarantDetailsSelection: String  = DeclarantDetailsPage.declarantDetailsMap.getOrElse("DeclarantDetails", "None")
    declarantDetailsSelection should be ("Yes")
    val enteredDucr :String = DUCRDetailsPage.ducrDetailsMap.getOrElse("DucrDetailsEntered","None")
    partiesSectionDataHashMap.getOrElse("obtainedDucr","None") should be (enteredDucr)
  }


}
