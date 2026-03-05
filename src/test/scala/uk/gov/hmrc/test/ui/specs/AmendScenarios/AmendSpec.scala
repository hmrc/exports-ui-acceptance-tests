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

package uk.gov.hmrc.test.ui.specs.AmendScenarios

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.*
import uk.gov.hmrc.test.ui.pages.common.*
import uk.gov.hmrc.test.ui.pages.common.AmendmentDetails.*
import uk.gov.hmrc.test.ui.pages.common.DashboardPage._
import uk.gov.hmrc.test.ui.pages.section5.*
import uk.gov.hmrc.test.ui.pages.section5.RemoveItemsPage.removeLinkForItem1
import uk.gov.hmrc.test.ui.specs.BaseSpec

class AmendSpec
  extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with TableDrivenPropertyChecks
    with ScreenshotOnFailure {

  Feature("Amend Scenarios") {
    Scenario("Full Standard Amend Journey and view declaration in submission dashboard") {
      Given("the user clears data in cache")
      background()
      When("User fills all sections of the declaration and submits the declaration to land on Saved-Summary page")
      fillAllSectionsForDeclaration("STANDARD", "prelodged")
      Then("User checks the section headings and continue to validate details on declaration information page")
      checksTheSectionHeadingsAndContinueToValidateDetails()
      And("User clicks the Amend declaration link and lands on Saved-Summary page")
      DeclarationInformationPage.amendDeclaration()
      SummaryPage.checkPage()
      Then("User validates that change links are not present for Section 1")
      val fieldsToCheck = Seq("ducr-entry", "local-reference-number", "mucr-row", "link-to-mucr")
      fieldsToCheck.foreach(SummaryPage.checkChangeLinkIsNotPresentFor)
      And("User validates that the change link is not present for Location of Goods")
      SummaryPage.checkChangeLinkIsNotPresentFor("location-of-goods")

      /*Section-2 amending Are you the exporter details*/
      When(
        "User clears 'Are you the exporter?', 'Carrier or haulier’s EORI number', and 'Authorisation type' keys from cache"
      )
      clearKeysFromCache("Are you the exporter?, Carrier or haulier’s EORI number")
      And("User clicks the change link for the Are You the Exporter page")
      clickChangeLinkForPage("Are you the exporter")
      Then("User should land on the Are-You-The-Exporter page and amend details then land on the Saved-Summary page")
      amendingAreYouTheExporterDetails()
      
      /* Removing an item on Amended Declaration is not allowed, as the item is associated with the submitted declaration
       * When the user tried to remove the item then the respective warning message is displayed*/

      When("User clicks the remove link for item 1")
      SummaryPage.removeItemLink(1).click()
      Then("User lands on the Remove-Declaration-Item page, view warning message and lands on the Saved-Summary page")
      removeLinkForItem1()
      
      // Adding an item on Amend Declaration//
      Given("User clicks on Add Item link")
      SummarySection5Page.addItem()
      When("User selects 1040 as procedure code on Procedure-codes page")
      selectProcedureCode()
      Then("User should land on Additional-Procedure-Codes page and continue amending declaration land on MiniCYA-Section-5 page")
      amendSection5Page()
      
      // And I check the MiniCYA page for Section-5 (At the moment we are able to validate one item, need to extend this to check two or more)//
      When("User clicks confirm and continue on summary page and submits the declaration")
      clicksConfirmAndContinueToSubmitDeclaration()
      And("User lands on holding page and redirect to Confirmation page")
      landOnHoldingPageAndRedirectedToConfirmationPage()
      And("User continue their journey to Dashboard page")
      continueJourneyToDashboardPage()
      Then("User validates declaration details on Submitted tab and checks Status is Declaration cleared")
      validateDashboardDeclarationCleared()
      And("User clicks view details link on timeline page to view and validates amended details by clicking on MRN link")
      validatesAmendedDetailsByClickingOnMRNLink()
      
      // Exit and come back later and resuming saved declaration functionality for Amend Declaration//
      When("User clicks back link And clicks on Amend declaration link")
      backLinkToSummaryPage()
      And("User clicks change link for Office of exit on SummaryPage and continue amending to land on MiniCYA-Section-3 page")
      clicksChangeLinkForOfficeOfExit()
      And("User clicks on Exit and comeback later link And continues to land on Saved-Declarations page")
      clicksOnExitAndComebackLaterLink()
      Then("User validates details on saved declarations page and checks status is Amendment")
      SavedDeclarationsPage.validateSavedDeclarations("Amendment")
      When("User clicks on DUCR link for amended declaration and submits the declaration")
      clicksOnDucrLinkAndSubmitDeclaration()
      And("User Continue navigating to DeclarationHoldingPage and selects Manage Submit Declaration to land on Dashboard page")
      landOnHoldingPageAndRedirectedToConfirmationPage()
      continueJourneyToDashboardPage()
      Then("Users validates declaration details on Submitted tab and check Status is Declaration cleared")
      validateDashboardDeclarationCleared()
      And("User clicks view details link on timeline page to view and validates amended details by clicking on MRN link")
      validatesAmendedDetailsByClickingOnMRNLink()

      // To verify Rejected Amendment on Timeline page//
      When("User clicks back link And clicks on Amend declaration link")
      backLinkToSummaryPage()
      And("User clicks change link for Border transport page And navigates to Confirmation page")
      clicksChangeLinkForBorderTransportPageNavigateToConfirmationPage()
      And("User continue their journey to Dashboard page")
      continueJourneyToDashboardPage()
      Then("User validates declaration details on Action needed tab and check Status is On hold")
      validateDashboardOnHold()
      And("User navigates to declaration information page And validates Amendment rejected status on timeline")
      DashboardPage.mrnLink.click()
      DeclarationInformationPage.checkStatusOnTimeLine("Amendment rejected")

      // To verify amendment cancellation on rejected amendments on Timeline page//
      When("User clicks back link And clicks on Amend declaration link to land on SummaryPage")
      backLinkToDashboardPageToSummaryPage()
      And("User clicks change link for Border transport page And navigates to Confirmation page")
      clicksChangeLinkForBorderTransportPageNavigateToConfirmationPage()
      And("User continue their journey to Dashboard page")
      continueJourneyToDashboardPage()
      Then("User validates declaration details on Action needed tab and check Status is On hold")
      validateDashboardOnHold()
      And("User navigates to declaration information page And validates Amendment rejected status on timeline")
      DashboardPage.mrnLink.click()
      DeclarationInformationPage.checkStatusOnTimeLine("Amendment rejected")
      When("User clicks on cancel link on rejected amendment And continue navigating to Confirmation page")
      clicksOnCancelLinkOnRejectedAmendment()
      And("User continues their journey to Dashboard page")
      continueJourneyToDashboardPage()
      Then("User validates declaration details on Action needed tab and check Status is On hold")
      validateDashboardOnHold()
      And("User navigates to declaration information page And validates Amendment cancelled status on timeline")
      DashboardPage.mrnLink.click()
      DeclarationInformationPage.checkStatusOnTimeLine("Amendment cancelled")

      // To verify Failed Amendment in Timeline page//
      When("User clicks back link And clicks on Amend declaration link to land on SummaryPage")
      backLinkToDashboardPageToSummaryPage()
      And("User clicks change link for Border transport page(to Ship name) and continue journey to submit the declaration")
      And("User continue their journey to Dashboard page")
      clicksChangeLinkForBorderTransportPageToShipname()
      Then("User validates declaration details on Action needed tab and check Status is On hold")
      validateDashboardOnHold()
      And("User navigates to declaration information page And validates Amendment failed status on timeline")
      DashboardPage.mrnLink.click()
      DeclarationInformationPage.checkStatusOnTimeLine("Amendment failed")

      // To verify Pending Amend declaration with Amendment requested notification on Timeline page//
      When("User clicks back link And clicks on Amend declaration link to land on SummaryPage")
      backLinkToDashboardPageToSummaryPage()
      And("User clicks change link for Border transport page(to Train) and continue journey to submit the declaration")
      clicksChangeLinkForBorderTransportPageToTrain()
      And("User lands on holding page and redirect to Confirmation page")
      landOnHoldingPageAndRedirectedToConfirmationPage()
      And("User continue their journey to Dashboard page")
      continueJourneyToDashboardPage()
      Then("User validates declaration details on Action needed tab and check Status is On hold")
      validateDashboardOnHold()
      And("User navigates to declaration information page And validates Amendment requested status on timeline")
      DashboardPage.mrnLink.click()
      DeclarationInformationPage.checkStatusOnTimeLine("Amendment requested")
    }
  }

}
