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
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.*
import uk.gov.hmrc.test.ui.pages.common.*
import uk.gov.hmrc.test.ui.pages.common.DashboardPage.*
import uk.gov.hmrc.test.ui.pages.section1.ChoicePage
import uk.gov.hmrc.test.ui.pages.section2.AreYouTheExporterPage
import uk.gov.hmrc.test.ui.specs.BaseSpec

class DashboardSpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Validate Dashboard and Declaration Information") {
    /* Below scenario -
    1. Check various confirmation page titles and validates information on Dashboard and Declaration information pages
    2. Validates View Print link
    3. Checks successful and unsuccessful Copy of a Declaration
    4. Checks successful and unsuccessful Cancellation of a Declaration */
    Scenario("Full Standard Journey and view declaration in submission dashboard") {
      Given("the user clears data in cache")
      background()
      When("User fills all sections of the declaration and submits the declaration to land on Saved-Summary page")
      fillAllSectionsForDeclaration("STANDARD", "prelodged")
      Then("User checks the section headings and continue to validate details on declaration information page")
      checksTheSectionHeadingsAndContinueToValidateDetails()

      /* Submit declaration with LRN starting with Q to check Query raised status and
      checks warning message of a lrn used in 24 hours*/
      When("User clicks on copy link and lands on copy declaration page")
      clickOnCopyLinkAndLandsOnCopyDeclarationPage()
      And("User enters ducr and lrn used within 24 hours to view lrn warning message")
      entersDucrAndLandsOnDashboardPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with Q9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "Q9")
      And("User continues their journey to Dashboard page")
      entersDucrAndValidateDetails()
      Then("User validates declaration details for Query raised status on Action needed tab")
      validateDashboardQueryRaised()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a Prelodged declaration with LRN starting with C to check//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with C9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "C9")
      And("User continues their journey to Dashboard page")
      entersDucrAndValidateDetails()
      Then("Users validates declaration details on Submitted tab and check Status is Declaration cleared")
      validateDashboardDeclarationCleared()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a declaration with LRN starting with X to check Goods have exited the UK status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with X9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "X9")
      And("User continues their journey to Dashboard page")
      entersDucrAndValidateDetails()
      Then("Uer validates declaration details on Submitted tab and check Status is Goods have exited the UK")
      validateDashboardGoodsHaveExitedUK()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a declaration with LRN starting with D to check Documents required status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with D9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "D9")
      And("User continues their journey to Dashboard page")
      entersDucrAndValidateDetails()
      Then("User validates declaration details on Action needed tab and check Status is Documents required")
      validateDashboardDocumentsRequired()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a declaration with LRN starting with R to check Declaration submitted status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with R9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "R9")
      And("User continues their journey to Dashboard page")
      entersDucrAndValidateDetails()
      Then("User validates declaration details on Submitted tab and check Status is Declaration submitted")
      validateDashboardDeclarationSubmitted()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a declaration with LRN starting with U to check Goods being examined//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with U9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "U9")
      And("User continues their journey to Dashboard page")
      entersDucrAndValidateDetails()
      Then("User validate declaration details on Submitted tab and check Status is Goods being examined")
      validateDashboardGoodsBeingExamined()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a arrived declaration with LRN starting with C to check Declaration cleared status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with C9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "C9")
      And("User continues their journey to Dashboard page")
      submitArrivedDeclarationNavigateToDashboardPage()
      Then("Users validates declaration details on Submitted tab and check Status is Declaration cleared")
      validateDashboardDeclarationCleared()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a arrived declaration with LRN starting with I to check Awaiting Exit Results status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with I9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "I9")
      And("User continues their journey to Dashboard page")
      submitArrivedDeclarationNavigateToDashboardPage()
      Then("User validate declaration details on Submitted tab and check Status is Awaiting exit results")
      validateDashboardAwaitingExit()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a arrived declaration with LRN starting with L to check Declaration expired on departure status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with L9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "L9")
      And("User continues their journey to Dashboard page")
      submitArrivedDeclarationNavigateToDashboardPage()
      Then(
        "User validate declaration details on Cancelled & expired tab and check Status is Declaration expired (no departure)"
      )
      validateDashboardDeclarationExpiredOnDeparture()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a arrived declaration with LRN starting with K to check Declaration expired on arrived status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with K9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "K9")
      And("User continues their journey to Dashboard page")
      submitArrivedDeclarationNavigateToDashboardPage()
      Then(
        "User validate declaration details on Cancelled & expired tab and check Status is Declaration expired (no arrival)"
      )
      validateDashboardDeclarationExpiredOnArrival()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a arrived declaration with LRN starting with P to check Pending status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with P9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "P9")
      And("User continues their journey to Dashboard page")
      submitArrivedDeclarationNavigateToDashboardPage()
      Then("User validate declaration details on Submitted tab and check Status is Pending")
      validateDashboardPending()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a arrived declaration with LRN starting with J to check Declaration Handled Externally status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with J9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "J9")
      And("User continues their journey to Dashboard page")
      submitArrivedDeclarationNavigateToDashboardPage()
      Then("User validate declaration details on Submitted tab and check Status is Declaration handled externally")
      validateDashboardDeclarationHandledExternally()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()

      // Submit a arrived declaration with LRN starting with N to check Released status//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with N9 prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "N9")
      And("User continues their journey to Dashboard page")
      submitArrivedDeclarationNavigateToDashboardPage()
      Then("User validate declaration details on Submitted tab and check Status is Released")
      validateDashboardReleased()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()
    }
    /* Below scenario -
    # 1. Validates View Print link
    # 2. Checks successful and unsuccessful Cancellation of a Declaration*/

    Scenario("check Cancellation of declaration and validate print link") {
      Given("the user clears data in cache")
      background()
      When("User fills all sections of the declaration and submits the declaration to land on Saved-Summary page")
      fillAllSectionsForDeclaration("STANDARD", "prelodged")
      Then("User checks the section headings and continue to validate details on declaration information page")
      checksTheSectionHeadingsAndContinueToValidateDetails()
      // Print and View - Validate View or Print declaration page//
      And("User clicks on print or view link")
      PrintOrViewPage.viewOrPrintLink()
      Then("User should land on print-or-view page")
      PrintOrViewPage.checkPage()
      And("User clicks back")
      CommonPage.back()
      // Cancellation - Unsuccessful cancellation.//
      And("User clicks on cancel declaration link")
      CancelDeclarationPage.cancelDeclaration()
      Then("User should land on Cancel-Declaration page")
      CancelDeclarationPage.checkPage()
      And("User selects No longer required as the reason and enters description for cancellation")
      CancelDeclarationPage.fillPage("No longer required")
      And("User clicks continue")
      CommonPage.continue()
      Then("User should land on Cancel holding page and redirect to Cancellation result page")
      CancelHoldingPage.checkPage()
      CancelHoldingPage.fillPage()
      Then("User should land on Cancel-Result page")
      CancelResultPage.checkPage()
      And("User navigates back to choice page")
      CancelResultPage.backToChoicePage()
      And("User should land on Choice page")
      ChoicePage.checkPage()
      And("User selects to Manage Submit Declaration")
      ChoicePage.fillPage("Manage Submit Declaration")
      Then("User should land on Dashboard page")
      DashboardPage.checkPage()
      Then("User validate declaration details on Submitted tab and check Status is Arrived and accepted")
      validateDashboardArrivedAndAccepted()
      And("User validate Cancellation request denied status timeline on declaration information page")
      DashboardPage.mrnLink.click()
      DeclarationInformationPage.checkStatusOnTimeLine("Cancellation request denied")
      // Cancellation - successful cancellation//
      When("User clicks on copy link and land on copy declaration page")
      DeclarationInformationPage.copyDeclaration()
      CopyDeclarationPage.checkPage()
      And("User enters ducr 8GB123456469274-101SHIP1 and lrn starting with G9S prefix")
      CopyDeclarationPage.fillPage("8GB123456469274-101SHIP1", "G9S")
      And("User continues their journey to Dashboard page")
      entersDucrAndValidateDetails()
      Then("User validates declaration details for Arrived and accepted status on Submitted tab")
      validateDashboardArrivedAndAccepted()
      And("User validate details on declaration information page")
      validateDeclarationDetailsOnDeclarationInformationPage()
      And("User clicks on cancel declaration link")
      CancelDeclarationPage.cancelDeclaration()
      Then("User should land on Cancel-Declaration page")
        CancelDeclarationPage.checkPage()
      And("User selects No longer required as the reason and enters description for cancellation")
        CancelDeclarationPage.fillPage("No longer required")
      And("User clicks continue")
         CommonPage.continue()
      Then("User should land on Cancel holding page and redirect to Cancellation result page")
        CancelHoldingPage.checkPage()
        CancelHoldingPage.fillPage()
      Then("User should land on Cancel-Result page")
        CancelResultPage.checkPage()
      And("User navigates back to choice page")
        CancelResultPage.backToChoicePage()
      And("User selects to Manage Submit Declaration")
        ChoicePage.fillPage("Manage Submit Declaration")
      Then("User should land on Dashboard page")
        DashboardPage.checkPage()
      Then("User validate declaration details on Cancelled & expired tab and check Status is Cancelled")
        validateDashboardCancelled()
      And("User validate details on declaration information page")
      DashboardPage.mrnLink.click()
      DeclarationInformationPage.checkStatusOnTimeLine("Cancelled")
    }
   /*Below scenario -
      1.Checks saved draft declaration and removal of draft declaration
      2.Checks if view declaration summary is missing and present*/
    Scenario("Check partial declarations saved on Saved Declarations and remove saved declaration") {
      Given("User fills section1 for STANDARD, prelodged declaration")
        fillSection1ForDeclaration("STANDARD", "prelodged")
      And("User validates view declaration link is missing")
       validateViewDeclarationLinkIsMissing("missing")
      And("User clicks on Exit and comeback later link")
      CommonPage.exitAndComeBackLater()
      Then("User should land on saved draft declaration page")
      DraftSavedPage.checkPage()
      And("User clicks on View Your Declaration Summary link")
      CommonPage.viewDeclarationSummary()
      And("User clicks continue to resume saved declaration")
      CommonPage.continueSavedDeclaration()
      Then("User navigates to Are You The Exporter page")
      AreYouTheExporterPage.navigateToPage(AreYouTheExporterPage.path)
      And("User validates view declaration link is present")
      validateViewDeclarationLinkIsMissing("present")
      And("User clicks on Exit and comeback later link")
      CommonPage.exitAndComeBackLater()
      And("User navigates to saved declarations")
      DraftSavedPage.viewSavedDec()
      Then("User should land on Saved-Declarations page")
      SavedDeclarationsPage.checkPage()
      And("User validates details on saved declarations page and checks status is Draft")
      SavedDeclarationsPage.validateSavedDeclarations("Draft")
      And("User removes saved Declaration")
      SavedDeclarationsPage.removeDraftDec()
      Then("User should land on Remove-Saved-Declaration page")
      RemoveSavedDeclarationsPage.checkPage()
      And("User selects No to remove saved declaration")
      RemoveSavedDeclarationsPage.fillPage("No")
      And("User clicks continue")
      CommonPage.continue()
      Then("User should land on Saved-Declarations page")
      SavedDeclarationsPage.checkPage()
      And("User removes saved Declaration")
      SavedDeclarationsPage.removeDraftDec()
      Then("User should land on Remove-Saved-Declaration page")
      RemoveSavedDeclarationsPage.checkPage()
      And("User selects Yes to remove saved declaration")
      RemoveSavedDeclarationsPage.fillPage("Yes")
      And("User clicks continue")
      CommonPage.continue()
      Then("User should land on Saved-Declarations page")
      SavedDeclarationsPage.checkPage()
    }
  }
}
