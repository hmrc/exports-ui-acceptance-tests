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

import org.scalatest.matchers.must.Matchers.{convertToAnyMustWrapper, defined}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail, DetailKey, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.section5

object SummarySection5Page extends BasePage {

  def backButtonHref: String = DeclarationItemsListPage.path
  val path: String           = "/declaration/summary-section/5"
  val title: String          = "Check your answers"

  override def checkExpanders(): Unit = ()

  override protected def performActionsAndStore(values: String*): Unit = {
    val items = allSectionDetails(section5).groupBy { case (detailKey: DetailKey, _) => detailKey.additionalId.head }
  }

  def checkSectionSummary(detailKey: DetailKey): Unit = {
    val rows = findElementsByClassName("govuk-summary-card")
      .filter(findChildByClassName(_, detailKey.id.head).getText == detailKey.label)
      .map(findChildByClassName(_, "govuk-summary-list__row"))

    val displayedKeysAndDetails = rows
      .map { webElement =>
        findChildByClassName(webElement, "govuk-summary-list__key") ->
          findChildByClassName(webElement, "govuk-summary-list__value")
      }

    val cacheDetails = allSectionDetails(detailKey.sectionId)

    cacheDetails.foreach { case (detailKey, details) =>
      val expectedRow = displayedKeysAndDetails.find(_._1.getText == detailKey.label)
      expectedRow mustBe defined

      val values = details match {
        case detail: Detail  => Seq(detail.value)
        case detail: Details => detail.values
      }

      // There may be some edge cases here not accounted for, please add accordingly.
      val valuesSeparator = detailKey.label match {
        case RoutingCountry => ","
        case _              => "\n"
      }

      val displayValues = expectedRow.head._2.getText.split(valuesSeparator).toList
      displayValues mustBe values
    }
  }
}
