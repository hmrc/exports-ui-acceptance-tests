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

package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{DeclarationEori, Ducr}

import java.time.LocalDate

object TraderReferencePage extends BasePage {

  def backButtonHref: String = DoYouHaveADucrPage.path
  override def changeLink: String = DucrEntryPage.path
  val path: String = "/declaration/trader-reference"
  val title: String = "Enter a trader reference"

  override def checkExpanders(): Unit = ()

  // ex: fillPage("101SHIP1")

  override def fillPage(values: String*): Unit = {
    val traderReference = values.head
    val generatedDucr = generateDucr(traderReference)
    fillTextBoxById("traderReferenceInput", traderReference)
    store(Ducr -> Detail(generatedDucr))
  }

  private def generateDucr(traderReference: String): String = {
    val lastDigitOfYear = LocalDate.now.getYear.toString.last
    val eori = detail(DeclarationEori).toUpperCase

    s"$lastDigitOfYear$eori-$traderReference"
  }
}
