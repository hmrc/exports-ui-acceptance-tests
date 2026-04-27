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

import org.openqa.selenium.By
import org.scalatest.matchers.must.Matchers.mustBe
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{fillSection2ForDeclaration, fillSection3ForDeclaration}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, CommonPage}
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys.Section4

object SummarySection4Page extends BasePage {

  def backButtonHref: String = PreviousDocumentListPage.path
  val path: String           = "/declaration/summary-section/4"
  val title: String          = "Check your answers"

  override def checkExpanders(): Unit = ()

  // ex: fillPage()

  override def fillPage(values: String*): Unit = checkSectionSummary(Section4)
  
  def section4Journey1():Unit={
    fillSection2ForDeclaration()
    fillSection3ForDeclaration()
    PreviousDocumentPage.checkPage()
    PreviousDocumentPage.fillPage(genSequenceId("first"), "Commercial Invoice", "9GB123456782317-BH1433A61")
    CommonPage.continue()
    PreviousDocumentListPage.checkPage()
    PreviousDocumentListPage.fillPage("No")
    CommonPage.continue()
  }

  def section4Journey2():Unit={
    fillSection2ForDeclaration()
    fillSection3ForDeclaration()
    InvoicesAndExchangeRateChoicePage.checkPage()
    InvoicesAndExchangeRateChoicePage.fillPage("No")
    CommonPage.continue()
    InvoicesAndExchangeRatePage.checkPage()
  }

  def assertTitle(expected: String): Unit = {
    val titleText = driver.findElement(By.xpath("//*[@id='title']")).getText
    titleText mustBe expected
  }
}
