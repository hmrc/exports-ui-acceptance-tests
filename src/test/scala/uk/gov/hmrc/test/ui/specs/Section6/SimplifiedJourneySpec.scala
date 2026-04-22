package uk.gov.hmrc.test.ui.specs.Section6

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, clearKeysFromCache}
import uk.gov.hmrc.test.ui.pages.common.SummaryPage
import uk.gov.hmrc.test.ui.pages.section5.{AdditionalProcedureCodesPage, ProcedureCodesPage}
import uk.gov.hmrc.test.ui.pages.section6.{BorderTransportPage, ContainerListPage, ContainerPage, ExpressConsignmentPage, InlandModeOfTransportPage, SealListPage, SealPage, SealYesNoPage, SummarySection6Page, SupervisingCustomsOfficePage, TransportCountryPage, TransportLeavingTheBorderPage, TransportPaymentPage, WarehousePage}
import uk.gov.hmrc.test.ui.pages.section6.SummarySection6Page.{fillAllForSections6, section6CommonJourney1, section6SimplifiedJourney1Cont}
import uk.gov.hmrc.test.ui.specs.BaseSpec

class SimplifiedJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section6 Simplified Journey") {
    /*Below scenario -
      1. if procedure code is 1042 and Additional procedure code as 000
      2. The following page is visible
          # Supervising-Customs-Office
      3 The following page is skipped
          # Departure Transport*/
    Scenario("simplified journey section-6") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for SIMPLIFIED, Prelodged declaration")
      fillAllForSections6("SIMPLIFIED", "Prelodged")
      And("User continue their journey from Transport-Leaving-The-Border page to Container-List page")
      section6CommonJourney1()
      section6SimplifiedJourney1Cont()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
      /* Below scenario -
      1. if procedure code is 1007 and Additional procedure code as 000
      2. The following pages are visible
          # Warehouse Details
          # Supervising-Customs-Office
            And landing on Inland-Or-Border page*/
      When("User clears Presenting to customs keys from cache")
      clearKeysFromCache("Presenting to customs")
      And("User navigates to Procedure codes page and lands on Procedure-codes page")
      ProcedureCodesPage.navigateToItemPage(ProcedureCodesPage.pageId)
      ProcedureCodesPage.checkPage()
      And("User selects 1007 as procedure code and continues")
      ProcedureCodesPage.fillPage("1007")
      CommonPage.continue()
      And("User selects 000 as additional procedure code on Additional-Procedure-Codes page and continues")
      AdditionalProcedureCodesPage.checkPage()
      AdditionalProcedureCodesPage.fillPage("000")
      CommonPage.continue()
      And("User navigates and lands on Transport-Leaving-The-Border page")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      And("User selects Inland waterway transport as mode of transport leaving the border and continues")
      TransportLeavingTheBorderPage.fillPage("Inland waterway transport")
      CommonPage.continue()
      And("User enters approved warehouse number on Warehouse page and continues")
      WarehousePage.checkPage()
      WarehousePage.fillPage("R1234567GB")
      CommonPage.continue()
      And("User selects GBBTH001 as the customs office code on Supervising-Customs-Office page and continues")
      SupervisingCustomsOfficePage.checkPage()
      SupervisingCustomsOfficePage.fillPage("GBBTH001")
      CommonPage.continue()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      /*For procedure codes 1007 and 3171: navigation = /transport-leaving-the-border → /warehouse-details
        For procedure code 1040: navigation = /transport-leaving-the-border → /inland-or-border
        For all other procedure codes: navigation = /transport-leaving-the-border → /supervising-customs-office
      Scenario:
        If procedure code = 1040 and additional procedure code = 000,
        skip Supervising Customs Office and Warehouse, landing directly on Inland-or-Border.
        When the procedure code changes to 1044, Warehouse is skipped, so we clear the warehouse data from cache.*/
      When("User clears Warehouse ID keys from cache")
      clearKeysFromCache("Warehouse ID")
      And("User navigates to Procedure codes page and selects 1044 as procedure code and continues")
      ProcedureCodesPage.navigateToItemPage(ProcedureCodesPage.pageId)
      ProcedureCodesPage.checkPage()
      ProcedureCodesPage.fillPage("1044")
      CommonPage.continue()
      And("User selects 1CS as additional procedure code on Additional-Procedure-Codes page and continues")
      AdditionalProcedureCodesPage.checkPage()
      AdditionalProcedureCodesPage.fillPage("1CS")
      CommonPage.continue()
      And("User selects Roll on Roll off (RoRo) as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Roll on Roll off (RoRo)")
      CommonPage.continue()
      And("User selects GBBTH001 as the customs office code on Supervising-Customs-Office page and continues")
      SupervisingCustomsOfficePage.checkPage()
      SupervisingCustomsOfficePage.fillPage("GBBTH001")
      CommonPage.continue()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
    }
     /*Scenario: If procedure code = 3171 and additional procedure code = 000,the Warehouse and Supervising
                 Customs Office pages are shown.
                - The Departure Transport page is skipped.*/
    Scenario("simplified arrived journey section-6") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for SIMPLIFIED, arrived declaration")
      fillAllForSections6("SIMPLIFIED", "arrived")
      And("User selects 3171 as procedure code on Procedure codes page and continues")
      ProcedureCodesPage.navigateToItemPage(ProcedureCodesPage.pageId)
      ProcedureCodesPage.checkPage()
      ProcedureCodesPage.fillPage("3171")
      CommonPage.continue()
      And("User selects 000 as additional procedure code on Additional-Procedure-Codes page and continues")
      AdditionalProcedureCodesPage.checkPage()
      AdditionalProcedureCodesPage.fillPage("000")
      CommonPage.continue()
      And("User selects Inland waterway transport as mode of transport leaving the border on Transport-Leaving-The-Border page and continues")
      TransportLeavingTheBorderPage.navigateToPage(TransportLeavingTheBorderPage.path)
      TransportLeavingTheBorderPage.checkPage()
      TransportLeavingTheBorderPage.fillPage("Inland waterway transport")
      CommonPage.continue()
      And("User enters approved warehouse number on Warehouse page and continues")
      WarehousePage.checkPage()
      WarehousePage.fillPage("R1234567GB")
      CommonPage.continue()
      And("User selects GBBTH001 as the customs office code on Supervising-Customs-Office page and continues")
      SupervisingCustomsOfficePage.checkPage()
      SupervisingCustomsOfficePage.fillPage("GBBTH001")
      CommonPage.continue()
      And("User selects Sea transport as mode of Inland transport on Inland-Transport-details page and continues")
      InlandModeOfTransportPage.checkPage()
      InlandModeOfTransportPage.fillPage("Sea transport")
      CommonPage.continue()
      And("User selects Flight number as the border transport on Border-Transport page and continues")
      BorderTransportPage.checkPage()
      BorderTransportPage.fillPage("Flight number")
      CommonPage.continue()
      And("User selects Macao as the transport country on Transport-Country page and continues")
      TransportCountryPage.checkPage()
      TransportCountryPage.fillPage("Macao")
      CommonPage.continue()
      And("User selects Yes to confirm consignment as express on Express-Consignment page and continues")
      ExpressConsignmentPage.checkPage()
      ExpressConsignmentPage.fillPage("Yes")
      CommonPage.continue()
      And("User selects Payment in cash as the mode of payment on Transport-Payment page and continues")
      TransportPaymentPage.checkPage()
      TransportPaymentPage.fillPage("Payment in cash")
      CommonPage.continue()
      And("User selects Yes to add Container1 as container on Container page and continues")
      ContainerPage.checkPage()
      ContainerPage.fillPage("Yes", "Container1")
      CommonPage.continue()
      And("User selects Yes to add security seal on Seal-YesNo page and continues")
      SealYesNoPage.checkPage()
      SealYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User enters Seal1 as seal on Seal page and continues")
      SealPage.checkPage()
      SealPage.fillPage("Seal1")
      CommonPage.continue()
      Then("User selects No to add another security seal on Seal-List page and continues")
      SealListPage.checkPage()
      SealListPage.fillPage("No")
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
