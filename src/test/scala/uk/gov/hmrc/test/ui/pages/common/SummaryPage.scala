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

package uk.gov.hmrc.test.ui.pages.common

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.base.BasePage

object SummaryPage extends BasePage {

  val backButtonHref: String = "/saved-declarations"
  val path: String = "/declaration/saved-summary"
  val title: String = "Check your answers"

  override def checkExpanders(): Unit = ()

  // ex: fillPage()

  private val titles = List(
    "Declaration details",
    "Parties involved",
    "Routes and locations",
    "About this transaction",
    "About the items",
    "Transportation of the goods"
  )

  override def fillPage(values: String*): Unit = {
    val allCards = findElementsByClassName("govuk-summary-card")
    titles.zipWithIndex.foreach { case (expectedTitle, index) =>
      val sectionTitle = s"Section ${index + 1} of 6: $expectedTitle"
      findChildByClassName(allCards(index), "govuk-summary-card__title").getText mustBe sectionTitle
    }
    findElementsByClassName("govuk-button")
      .filter(_.getText == "Confirm and continue")
      .head
      .click()
  }
}
