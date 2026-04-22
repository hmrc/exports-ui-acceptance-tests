package uk.gov.hmrc.test.ui.specs.Section6

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, clearKeysFromCache, clickChangeLinkForPage}
import uk.gov.hmrc.test.ui.pages.common.{ConfirmationPage, DashboardPage, DeclarationHoldingPage, DeclarationInformationPage, SubmitYourDeclarationPage, SummaryPage}
import uk.gov.hmrc.test.ui.pages.section1.{ChoicePage, LrnPage}
import uk.gov.hmrc.test.ui.pages.section5.{AdditionalProcedureCodesPage, ProcedureCodesPage}
import uk.gov.hmrc.test.ui.pages.section6.*
import uk.gov.hmrc.test.ui.pages.section6.SummarySection6Page.{fillAllForSections6, section6CommonJourney1, section6StandardJourney1}
import uk.gov.hmrc.test.ui.specs.BaseSpec

class StandardJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section6 Standard Journey") {
    Scenario("standard journey section-6") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for STANDARD, prelodged declaration")
      fillAllForSections6("STANDARD", "prelodged")
      And("User continue their journey from  Transport-Leaving-The-Border page to Inland-Transport-details page")
      section6CommonJourney1()
      And("User then continue their journey from Departure-Transport page to Seal page")
      section6StandardJourney1()
      And("User selects Yes to add another security seal on Seal-List page and continues")
      SealListPage.checkPage()
      SealListPage.fillPage("Yes")
      CommonPage.continue()
      And("User enters Seal2 as seal on Seal page and continues")
      SealPage.checkPage()
      SealPage.fillPage("Seal2")
      CommonPage.continue()
      And("User selects No to add another security seal on Seal-List page and continues")
      SealListPage.checkPage()
      SealListPage.fillPage("No")
      CommonPage.continue()
      And("User selects Yes to add another container on Container-List page and continues")
      ContainerListPage.checkPage()
      ContainerListPage.fillPage("Yes")
      CommonPage.continue()
      ContainerPage.fillPage("Container2")
      CommonPage.continue()
      And("User selects No to add security seal on Seal-YesNo page and continues")
      SealYesNoPage.checkPage()
      SealYesNoPage.fillPage("No")
      CommonPage.continue()
      And("User selects No to add another container on Container-List page and continues")
      ContainerListPage.checkPage()
      ContainerListPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
     /*// Scenario: - If procedure code = 1040 and additional procedure code = 000,the Supervising Customs Office page
          is skipped,and the user lands directly on the Inland-or-Border page.*/
      When("User clears Presenting to customs, Customs supervising office keys from cache")
      clearKeysFromCache("Presenting to customs, Customs supervising office")
      And("User selects 1040 as procedure code on Procedure codes page and continues")
      ProcedureCodesPage.navigateToItemPage(ProcedureCodesPage.pageId)
      ProcedureCodesPage.checkPage()
      ProcedureCodesPage.fillPage("1040")
      CommonPage.continue()
      And("User selects 000 as additional procedure code on Additional-Procedure-Codes page and continues")
      AdditionalProcedureCodesPage.checkPage()
      AdditionalProcedureCodesPage.fillPage("000")
      CommonPage.continue()
      And("User selects Sea transport as mode of transport leaving the border  on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Sea transport")
      CommonPage.continue()
      And("User should land on Inland-Or-Border page")
      InlandOrBorderPage.checkPage()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      /*Scenario:If procedure code = 1040 and additional procedure code = 000 with RoRo as the transport leaving the border,
        the Inland-or-Border page is skipped, and the user lands directly on the Inland-Transport-Details page.*/
      When("User clears Presenting to customs keys from cache")
      clearKeysFromCache("Presenting to customs")
      And("User selects Roll on Roll off (RoRo) as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Roll on Roll off (RoRo)")
      CommonPage.continue()
      And("User should land on Inland-Or-Border page")
      InlandModeOfTransportPage.checkPage()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      /*Scenario:- If procedure code = 1040 and additional procedure code = 000, and the Inland-or-Border answer is "border",
        the Inland-Transport-Details page is skipped, and the user lands on the Departure-Transport page.*/
      And(
        "User clears Inland mode of transport, Transport leaving the border, Country of registration for the transport leaving the UK border keys from cache"
      )
      clearKeysFromCache("Inland mode of transport, Transport leaving the border, Country of registration for the transport leaving the UK border")
      And("User selects Rail transport as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Rail transport")
      CommonPage.continue()
      And("User selects Border location for presenting the goods to customs on Inland-Or-Border page and continues")
      InlandOrBorderPage.checkPage()
      InlandOrBorderPage.fillPage("Border location")
      CommonPage.continue()
      And("User should land on Departure-Transport page")
      DepartureTransportPage.checkPage()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      /*Scenario:If procedure code = 1040 and additional procedure code = 000,and the user selects
       Fixed Transport Installation as the transport leaving the border,the flow lands on the Inland-or-Border page.
      - From there it navigates to the Express-Consignment page.
      - The following pages are skipped:
        • Departure Transport
        • Transport Country
        • Border Transport
        • Container Security Seals (/containers/test/seals)
        • Add Security Seals
        • You Have Added Security Seals (/containers/test/seals)
        • You Have Added Container (/containers)*/

      When(
        "User clears Presenting to customs, Transport details at the border, Method of payment for transport, Security seals keys from cache"
      )
      clearKeysFromCache("Presenting to customs, Transport details at the border, Method of payment for transport, Security seals")
      And("User selects Fixed transport installations as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Fixed transport installations")
      CommonPage.continue()
      And("User selects Border location for presenting the goods to customs on Inland-Or-Border page and continues")
      InlandOrBorderPage.checkPage()
      InlandOrBorderPage.fillPage("Border location")
      CommonPage.continue()
      Then("User selects No to confirm consignment as express on Express-Consignment page and continues")
      ExpressConsignmentPage.checkPage()
      ExpressConsignmentPage.fillPage("No")
      CommonPage.continue()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      //Remove the container//
      When("User clicks remove Container 0 and remove Container1 on Container List page and continues")
      ContainerListPage.navigateToPage(ContainerListPage.path)
      ContainerListPage.checkPage()
      ContainerListPage.selectContainerToRemove(0)
      ContainerRemovePage.checkPage()
      ContainerRemovePage.fillPage("Yes", "Container1")
      CommonPage.continue()
      And("User clicks remove Container 0  and remove Container2 on Container List page and continues")
      ContainerListPage.selectContainerToRemove(0)
      ContainerRemovePage.checkPage()
      ContainerRemovePage.fillPage("Yes", "Container2")
      CommonPage.continue()
      And("User selects No to add containers on Container page and continues")
      ContainerPage.checkPage()
      ContainerPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
    }
    /*Scenario:- If procedure code = 1042 and additional procedure code = 000, the Supervising Customs Office page is shown.
      -This is a full arrived‑journey flow, covering all pages,including adding a seal to the container and then removing the seal.*/
    
    Scenario("standard arrived journey section-6") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for STANDARD, arrived declaration")
      fillAllForSections6("STANDARD", "arrived")
      And("User continue their journey from Transport-Leaving-The-Border page to to Inland-Transport-details page")
      section6CommonJourney1()
      And("User then continue their journey from Departure-Transport page to Seal page")
      section6StandardJourney1()
      And("User User clicks on remove Seal 0 on Seal-List page")
      SealListPage.checkPage()
      SealListPage.selectSealToRemove(0)
      And("User selects Yes to remove seal Seal1 on Remove-This-Seal page and continues")
      SealRemovePage.checkPage()
      SealRemovePage.fillPage("Yes", "Seal1")
      CommonPage.continue()
      Then("User selects No to add security seal on Seal-YesNo page and continues")
      SealYesNoPage.checkPage()
      SealYesNoPage.fillPage("No")
      CommonPage.continue()
      ContainerListPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
      When("User clicks change link for LRN page and enters LRN U0LRN813131")
      clickChangeLinkForPage("LRN")
      LrnPage.checkPage()
      LrnPage.fillPage("U0LRN813131")
      And("User clicks save and checks the section headings and clicks confirm and continue")
      CommonPage.saveAndReturnToSummary()
      SummaryPage.fillPage()
      SubmitYourDeclarationPage.checkPage()
      And("User submits the declaration")
      SubmitYourDeclarationPage.fillPage()
      And("User lands on holding page and redirect to Confirmation page")
      DeclarationHoldingPage.checkPage()
      DeclarationHoldingPage.fillPage()
      And("User lands on Confirmation page and navigates to Choice page")
      ConfirmationPage.checkPage()
      ChoicePage.navigateToPage(ChoicePage.path)
      And("User selects to Manage Submit Declaration and land on Dashboard page")
      ChoicePage.fillPage("Manage Submit Declaration")
      DashboardPage.checkPage()
      Then("User validates declaration details on Submitted tab and checks Status is Goods being examined")
      DashboardPage.refreshPage()
      DashboardPage.validateDashboard("Submitted", "Goods being examined")
      And("User navigates to declaration information page after clicking on mrn link")
      DashboardPage.mrnLink.click()
      And("User should land on Declaration-Information page")
      DeclarationInformationPage.checkPage()
      And("User validates details on declaration information page")
      DeclarationInformationPage.validateTimelineDetails()
      //validate amend and copy declaration link are visible for External amend declaration//
      And("User validates that the Amend declaration link and Copy declaration link is displayed")
      DeclarationInformationPage.validateCopyAndAmendDeclarationLinks()
    }
  }
}
