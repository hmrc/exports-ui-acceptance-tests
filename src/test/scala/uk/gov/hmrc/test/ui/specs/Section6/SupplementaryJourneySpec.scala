package uk.gov.hmrc.test.ui.specs.Section6

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, clearKeysFromCache}
import uk.gov.hmrc.test.ui.pages.common.SummaryPage
import uk.gov.hmrc.test.ui.pages.section2.{AuthorisationPage, AuthorisationRemovePage, AuthorisationsListPage, ProcedureChoicePage}
import uk.gov.hmrc.test.ui.pages.section3.DestinationCountryPage
import uk.gov.hmrc.test.ui.pages.section5.{AdditionalProcedureCodesPage, ProcedureCodesPage}
import uk.gov.hmrc.test.ui.pages.section6.{BorderTransportPage, ContainerListPage, ContainerPage, DepartureTransportPage, InlandModeOfTransportPage, InlandOrBorderPage, SealListPage, SealPage, SealYesNoPage, SummarySection6Page, SupervisingCustomsOfficePage, TransportCountryPage, TransportLeavingTheBorderPage, WarehousePage}
import uk.gov.hmrc.test.ui.pages.section6.SummarySection6Page.*
import uk.gov.hmrc.test.ui.specs.BaseSpec

class SupplementaryJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section5 Supplementary Journey") {
    /*Scenario:- If procedure code = 1042 and additional procedure code = 000, the Supervising Customs Office page is shown.
     - The following pages are skipped:
     • Inland-or-Border
     • Express-Consignment
     • Transport-Payment*/
    Scenario("Complete Items section on Supplementary EIDR declaration journey") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for SUPPLEMENTARY, eidr declaration")
      fillAllForSections6("SUPPLEMENTARY", "eidr")
      And("User continue their journey from Transport-Leaving-The-Border to Container-List page")
      section6SupplementaryJourney1()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
      /* Scenario: - If the authorisation code = EXRR, and the user selects Postal or Email in both Transport Leaving
      the Borderand Mode of Inland Transport,the flow lands on the Supervising Customs Office page.
      - From there it navigates to the Container page.
      - The following pages are skipped:
        • Departure Transport
        • Transport Country*/
      When(
        "User clears Country of registration for the transport leaving the UK border, Transport leaving the border, Transport details at the border keys from cache"
      )
      clearKeysFromCache("Country of registration for the transport leaving the UK border, Transport leaving the border, Transport details at the border")
      And("User selects Permanent as export procedure choice on Authorisation Choice page and continues")
      ProcedureChoicePage.navigateToPage(ProcedureChoicePage.path)
      ProcedureChoicePage.fillPage("Permanent")
      CommonPage.continue()
      And("User clicks on remove link on Authorisations-Required-List page")
      AuthorisationsListPage.checkPage()
      AuthorisationsListPage.removeAuthCode(0)
      And("User selects Yes to remove authorisation on Authorisations-Remove page and continues")
      AuthorisationRemovePage.checkPage()
      AuthorisationRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User selects first Authorisation code EXRR and enters eori as GB744638982000 on Authorisation-Required page and continues")
      AuthorisationPage.checkPage()
      AuthorisationPage.fillPage(genSequenceId("first"), "EXRR", "GB744638982000")
      CommonPage.continue()
      And("User selects No to add another authorisation on Authorisations-Required-List page and continues")
      AuthorisationsListPage.checkPage()
      AuthorisationsListPage.fillPage("No")
      CommonPage.continue()
      And("User selects Postal or mail as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Postal or mail")
      CommonPage.continue()
      And("User selects GBABD001 as the customs office code on Supervising-Customs-Office page and continues")
      SupervisingCustomsOfficePage.checkPage()
      SupervisingCustomsOfficePage.fillPage("GBABD001")
      CommonPage.continue()
      And("User selects Postal or mail as mode of Inland transport on Inland-Transport-details page and continues")
      InlandModeOfTransportPage.checkPage()
      InlandModeOfTransportPage.fillPage("Postal or mail")
      CommonPage.continue()
      And("User selects No to add another container on Container-List page and continues")
      ContainerListPage.checkPage()
      ContainerListPage.fillPage("No")
      CommonPage.continue()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      And("User should land on Saved-Summary page")
      SummaryPage.checkPage()
    }
    /*Scenario:If procedure code = 1040 and additional procedure code = 000,
     the following pages are skipped:
     • Supervising Customs Office
     • Express Consignment
     • Transport Payment*/
    Scenario("supplementary journey simplified section-6") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for SUPPLEMENTARY, simplified declaration")
      fillAllForSections6("SUPPLEMENTARY", "simplified")
      And("User selects 1040 as procedure code on Procedure codes page and continues")
      ProcedureCodesPage.navigateToItemPage(ProcedureCodesPage.pageId)
      ProcedureCodesPage.checkPage()
      ProcedureCodesPage.fillPage("1040")
      CommonPage.continue()
      And("User selects 000 as additional procedure code on Additional-Procedure-Codes page and continues")
      AdditionalProcedureCodesPage.checkPage()
      AdditionalProcedureCodesPage.fillPage("000")
      CommonPage.continue()
      And("User selects Rail transport as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Rail transport")
      CommonPage.continue()
      Then("User selects Customs controlled location for presenting the goods to customs on Inland-Or-Border page and continues")
      InlandOrBorderPage.checkPage()
      InlandOrBorderPage.fillPage("Customs controlled location")
      CommonPage.continue()
      And("User selects Air transport as mode of Inland transport on Inland-Transport-details page and continues")
      InlandModeOfTransportPage.checkPage()
      InlandModeOfTransportPage.fillPage("Air transport")
      CommonPage.continue()
      And("User selects Flight number as the departure transport on Departure-Transport page and continues")
      DepartureTransportPage.checkPage()
      DepartureTransportPage.fillPage("Flight number")
      CommonPage.continue()
      And("User selects Vehicle registration as the border transport on Border-Transport page and continues")
      BorderTransportPage.checkPage()
      BorderTransportPage.fillPage("Vehicle registration")
      CommonPage.continue()
      And("User selects No to add containers on Container page and continues")
      ContainerPage.checkPage()
      ContainerPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
     /*Scenario:- If procedure code = 1040 and additional procedure code = 000, with RoRo selected for Transport Leaving the Border
      and Postal or Mail selected for Inland Transport,the following pages are skipped:
     • Supervising Customs Office
     • Inland-or-Border
     • Departure Transport
     • Border Transport
     • Transport Country
     • Express Consignment
     • Transport Payment*/
      When("User clears Presenting to customs, Transport details at the border, Transport leaving the border keys from cache")
      clearKeysFromCache("Presenting to customs, Transport details at the border, Transport leaving the border")
      And("User Roll on Roll off (RoRo) as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Roll on Roll off (RoRo)")
      CommonPage.continue()
      And("User selects Postal or mail as mode of Inland transport on Inland-Transport-details page and continues")
      InlandModeOfTransportPage.checkPage()
      InlandModeOfTransportPage.fillPage("Postal or mail")
      CommonPage.continue()
      Then("User selects No to add another container on Container page and continues")
      ContainerPage.checkPage()
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
    }
    
    /*Scenario: - If procedure code = 1042 and additional procedure code = 000, the Supervising Customs Office page is shown.
     - The following pages are skipped:
     • Express Consignment
     • Transport Payment*/
    
    Scenario("supplementary simplified journey section-6") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for SUPPLEMENTARY, simplified declaration")
      fillAllForSections6("SUPPLEMENTARY", "simplified")
      And("User continue their journey from Transport-Leaving-The-Border page to Container-List page")
      section6CommonJourney1()
      And("User selects Ship IMO number as the departure transport on Departure-Transport page and continues")
      DepartureTransportPage.checkPage()
      DepartureTransportPage.fillPage("Ship IMO number")
      CommonPage.continue()
      And("User selects European vessel number (ENI) as the border transport on Border-Transport page and continues")
      BorderTransportPage.checkPage()
      BorderTransportPage.fillPage("European vessel number (ENI)")
      CommonPage.continue()
      And("User selects Macao as the transport country on Transport-Country page and continues")
      TransportCountryPage.checkPage()
      TransportCountryPage.fillPage("Macao")
      CommonPage.continue()
      And("User selects Yes to add Container1 as container on Container page and continues")
      ContainerPage.checkPage()
      ContainerPage.fillPage("Yes", "Container1")
      CommonPage.continue()
      And("User selects Yes to add security seal on Seal-YesNo page and continue")
      SealYesNoPage.checkPage()
      SealYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User enters Seal1 as seal on Seal page and continues")
      SealPage.checkPage()
      SealPage.fillPage("Seal1")
      CommonPage.continue()
      And("User selects No to add another security seal on Seal-List page and continues")
      SealListPage.checkPage()
      SealListPage.fillPage("No")
      CommonPage.continue()
      And("User selects No to add another container on Container-List page and continue")
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
      /*When Authorisation Code = FP, Destination Country = Guernsey,Procedure Code = 3171, and Additional Procedure Code = 1CS:
       - The following pages must be shown: Warehouse, Supervising Customs Office,Inland Transport Details, Container.
       - The following pages must be skipped: Inland or Border, Departure Transport,Transport Country, Express Consignment, Transport Payment.*/
      When(
        "User clears Presenting to customs, Transport details at the border, Transport leaving the border, Country of registration for the transport leaving the UK border keys from cache"
      )
      clearKeysFromCache("Presenting to customs, Transport details at the border, Transport leaving the border, Country of registration for the transport leaving the UK border")
      And("User selects Permanent as export procedure choice on Authorisation Choice page and continues")
      ProcedureChoicePage.navigateToPage(ProcedureChoicePage.path)
      ProcedureChoicePage.fillPage("Permanent")
      CommonPage.continue()
      And("User clicks on remove link on Authorisations-Required-List page")
      AuthorisationsListPage.checkPage()
      AuthorisationsListPage.removeAuthCode(0)
      And("User then selects Yes to remove authorisation on Authorisations-Remove page and continues")
      AuthorisationRemovePage.checkPage()
      AuthorisationRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User selects first Authorisation code FP and enters eori as GB744638982000 on Authorisation-Required page and continues")
      AuthorisationPage.checkPage()
      AuthorisationPage.fillPage(genSequenceId("first"), "FP", "GB744638982000")
      CommonPage.continue()
      And("User selects No to add another authorisation on Authorisations-Required-List page and continues")
      AuthorisationsListPage.checkPage()
      AuthorisationsListPage.fillPage("No")
      CommonPage.continue()
      And("User selects Guernsey as the destination country on Destination Country page and continue")
      DestinationCountryPage.navigateToPage(DestinationCountryPage.path)
      DestinationCountryPage.checkPage()
      DestinationCountryPage.fillPage("Guernsey")
      CommonPage.continue()
      And("User selects 3171 as procedure code on Procedure codes page and continues")
      ProcedureCodesPage.navigateToItemPage(ProcedureCodesPage.pageId)
      ProcedureCodesPage.checkPage()
      ProcedureCodesPage.fillPage("3171")
      CommonPage.continue()
      And("User selects 1CS as additional procedure code on Additional-Procedure-Codes page and continues")
      AdditionalProcedureCodesPage.checkPage()
      AdditionalProcedureCodesPage.fillPage("1CS")
      CommonPage.continue()
      And("User selects Sea transport as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Sea transport")
      CommonPage.continue()
      And("User enters approved warehouse number on Warehouse page and continues")
      WarehousePage.checkPage()
      WarehousePage.fillPage("R1234567GB")
      CommonPage.continue()
      And("User selects GBABD001 as the customs office code on Supervising-Customs-Office page and continues")
      SupervisingCustomsOfficePage.checkPage()
      SupervisingCustomsOfficePage.fillPage("GBABD001")
      CommonPage.continue()
      And("User selects Postal or mail as mode of Inland transport on Inland-Transport-details page and continues")
      InlandModeOfTransportPage.checkPage()
      InlandModeOfTransportPage.fillPage("Postal or mail")
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
    }
  }
}
