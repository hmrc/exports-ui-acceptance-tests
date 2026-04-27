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

package uk.gov.hmrc.test.ui.pages.common

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.pages.base.BasePage.*
import uk.gov.hmrc.test.ui.pages.base.{BasePage, CommonPage, Detail}
import uk.gov.hmrc.test.ui.pages.common.DetailKeys.*
import org.scalatest.matchers.must.Matchers.*
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{detail, *}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Lrn
import uk.gov.hmrc.test.ui.pages.section1.{ChoicePage, LrnPage}

object RejectedNotificationPage extends BasePage {

  def backButtonHref: String = detail(DeclarationInfoPath)
  val path: String = rejectedNotificationLink.toString()
  val title = "Fix declaration errors"
  val lrnSelector = "declaration-consignmentReferences-lrn"
  val ucrSelector = "declaration-consignmentReferences-ucr"
  val savedDeclarationLink = "/saved-declarations"
  val reportProblemGuidance = "https://www.gov.uk/guidance/report-a-problem-using-the-customs-declaration-service"
  val knownError =
    "https://www.gov.uk/government/publications/known-error-workarounds-for-the-customs-declaration-service-cds"
  val serviceErrorCodes = "https://www.gov.uk/government/publications/customs-declaration-service-error-codes"

  def header(row: String): WebElement = findElementByCssSelector(s".$row > td:nth-child(1)")
  def rejectedOldValue(row: String): WebElement = findElementByCssSelector(s".$row > td:nth-child(2)")
  def rejectedNewValue(row: String): WebElement = findElementByCssSelector(s".$row > td:nth-child(3)")
  def duplicateDucrWarning(): WebElement = findElementByCssSelector(".govuk-summary-card__content div")

  def checkYourAnswer(): Unit = {
    clickById("check-your-answers")
    store(IsDeclarationRejected -> Detail("true"))
  }

  override def checkExpanders(): Unit = ()

  override def pageLinkHrefs: Seq[String] =
    super.pageLinkHrefs.filterNot(_ == exitAndCompleteLater) ++ Seq(
      savedDeclarationLink,
      reportProblemGuidance,
      knownError,
      serviceErrorCodes
    )
  override def fillPage(values: String*): Unit = ()

  def FixErrorsAndValidateWarning(link: String): Unit =
    if (link.equals("Lrn")) {
      clickByCssSelector(s".$lrnSelector a")
      assert(findElementByCssSelector(".govuk-error-summary__title").isDisplayed)
    } else {
      clickByCssSelector(s".$ucrSelector a")
    }

  def validateErrorDetails(oldValue: String): Unit = {
    header(lrnSelector).getText mustBe "LRN"
    rejectedOldValue(lrnSelector).getText mustBe oldValue
  }

  def fillAllSectionEnterLRNContinueToSummaryPage(decType: String, AdditionalDecType: String):Unit={
    fillSection1ForDeclaration(decType, AdditionalDecType)
    fillSection2ForDeclaration()
    fillSection3ForDeclaration()
    fillSection4ForDeclaration()
    fillSection5ForDeclaration()
    fillSection6ForDeclaration()
    LrnPage.navigateToPage(LrnPage.path)
    LrnPage.fillPage("BCDSCOM02")
    CommonPage.continue()
    SummaryPage.navigateToPage(SummaryPage.path)
    SummaryPage.checkPage()
  }

  def confirmAndContinueToSubmitDeclaration():Unit={
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.checkPage()
    SubmitYourDeclarationPage.fillPage()
    DeclarationHoldingPage.checkPage()
    DeclarationHoldingPage.waitForClass("govuk-warning-text__text")
  }

  def navigateFromChoicePageToDashboardPage():Unit={
    ChoicePage.navigateToPage(ChoicePage.path)
    ChoicePage.fillPage("Manage Submit Declaration")
    DashboardPage.checkPage()
  }

  def clickMRNLinkToFixErrors():Unit={
    DashboardPage.mrnLink.click()
    DeclarationInformationPage.checkPage()
    DeclarationInformationPage.validateTimelineDetails()
    DeclarationInformationPage.fixErrors()
    RejectedNotificationPage.checkPage()
  }

  def clickLRNLinkToFixErrors():Unit={
    RejectedNotificationPage.validateErrorDetails(detail(Lrn))
    RejectedNotificationPage.FixErrorsAndValidateWarning("Lrn")
    LrnPage.fillPage("MCDSCOM06")
    CommonPage.saveAndReturnToErrors()
    RejectedNotificationPage.validateUpdatedErrorDetails(detail(Lrn))
    RejectedNotificationPage.checkYourAnswer()
    SummaryPage.checkPage()
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.checkPage()
    SubmitYourDeclarationPage.fillPage()
    DeclarationHoldingPage.checkPage()
    DeclarationHoldingPage.fillPage()
    ConfirmationPage.checkPage()
    ChoicePage.navigateToPage(ChoicePage.path)
    ChoicePage.fillPage("Manage Submit Declaration")
    DashboardPage.checkPage()
  }
   def validateDeclarationDetailsLandOnDecInfoPage():Unit={
     DashboardPage.refreshPage()
     DashboardPage.validateDashboard("Submitted", "Arrived and accepted")
     DashboardPage.mrnLink.click()
     DeclarationInformationPage.checkPage()
    }
   
  def validateUpdatedErrorDetails(updatedValue: String): Unit =
    rejectedNewValue(lrnSelector).getText mustBe updatedValue.trim
}
