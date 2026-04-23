/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specs.Common

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.must.Matchers.must
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.*
import uk.gov.hmrc.test.ui.pages.common.{CopyDeclarationPage, DashboardPage, DeclarationHoldingPage, DeclarationInformationPage, RejectedNotificationPage, SubmitYourDeclarationPage, SummaryPage}
import uk.gov.hmrc.test.ui.pages.common.RejectedNotificationPage.*
import uk.gov.hmrc.test.ui.pages.section1.DucrEntryPage
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class RejectedNotificationsSpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Validate Rejected Notifications"){
    Scenario("Fix a rejected declaration and submit the declaration",Regression3,Smoke,Regression){
      Given("the user clears data in cache")
      background()
      When("User fills all sections of the declaration and submits the declaration to land on Saved-Summary page")
      fillAllSectionEnterLRNContinueToSummaryPage("STANDARD", "prelodged")
      And("User checks the section headings and continue to submit declaration")
      confirmAndContinueToSubmitDeclaration()
      And("User navigates to Choice page to Dashboard page")
      navigateFromChoicePageToDashboardPage()
      Then("User validates declaration details on Rejected tab and checks Status is Declaration rejected")
      DashboardPage.refreshPage()
      DashboardPage.validateDashboard("Rejected", "Declaration rejected")
      When("User navigates to declaration information page after clicking on mrn link to fix errors on the declaration")
      clickMRNLinkToFixErrors()
      And("User clicks on Lrn change link to fix error and submits the declaration then land on Dashboard page")
      clickLRNLinkToFixErrors()
      Then("User validates declaration details on Submitted tab and checks Status is Arrived and accepted then lands on Declaration-Information page")
      validateDeclarationDetailsLandOnDecInfoPage()
      //Duplicate ducr warning messages check

      When("User clicks on copy link and continues by entering ducr 8GB123456469274-101SHIP1 and a rejected lrn")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "rejected")
      CommonPage.continue()
      SummaryPage.clickContinueOnSummary()
      And("User submits the declaration and land on holding page and redirect to rejected notification page")
      SubmitYourDeclarationPage.fillPage()
      DeclarationHoldingPage.checkPage()
      DeclarationHoldingPage.waitForClass("govuk-warning-text__text")
      Then("User validates ducr warning on rejected notifications page")
      RejectedNotificationPage.duplicateDucrWarning().getText must include("DUCR previously used within the last 12 months.")
      When("User clicks on Ducr change link to fix error")
      RejectedNotificationPage.FixErrorsAndValidateWarning("Ducr")
      Then("User validates duplicate ducr warning on ducr entry page")
      DucrEntryPage.ducrWarning.getText must be("DUCR reference is a duplication or is invalid")
    }
  }

}
