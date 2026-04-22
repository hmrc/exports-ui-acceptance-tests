package uk.gov.hmrc.test.ui.specs.Section4

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section3.DestinationCountryPage
import uk.gov.hmrc.test.ui.pages.section4.*
import uk.gov.hmrc.test.ui.pages.section4.SummarySection4Page.section4Journey2
import uk.gov.hmrc.test.ui.specs.BaseSpec

class StandardJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section4 Standard Journey") {
    Scenario(
      "Complete Transactions section on standard prelodged declaration journey and validate dynamic title changes on previous documents page"
    ) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, prelodged declaration")
      fillSection1ForDeclaration("STANDARD", "prelodged")
      And("User fills section2/3 and continues their journey to Invoices-And-Exchange-Rate page")
      section4Journey2()
      And("User selects currency code as GBP and Total amount as 567640 with an exchange rate as 1.25 and continues")
      InvoicesAndExchangeRatePage.fillPage("GBP", "567640", "1.25")
      CommonPage.continue()
      Then("User should land on Total-Package-Quantity page")
      TotalPackageQuantityPage.checkPage()
      And("User selects 4 for the total number of packages and continues")
      TotalPackageQuantityPage.fillPage("4")
      CommonPage.continue()
      Then("User should land on Nature-Of-Transaction page")
      NatureOfTransactionPage.checkPage()
      And("User selects option as Goods being sol")
      NatureOfTransactionPage.fillPage("Goods being sol")
      CommonPage.continue()
      Then("User should land on Previous-Document page")
      PreviousDocumentPage.checkPage()
      And("User selects as first Document Commercial Invoice as code and 9GB123456782317-BH1433A61 as reference")
      PreviousDocumentPage.fillPage(genSequenceId("first"), "Commercial Invoice", "9GB123456782317-BH1433A61")
      CommonPage.continue()
      Then("User should land on Previous-Documents-list page")
      PreviousDocumentListPage.checkPage()
      And("User selects Yes on previous documents list page and continues")
      PreviousDocumentListPage.fillPage("Yes")
      CommonPage.continue()
      And("User selects as second Document Packing List as code and 9GB12345678899 as reference and continues")
      PreviousDocumentPage.fillPage(genSequenceId("second"), "Packing List", "9GB12345678899")
      CommonPage.continue()
      Then("User should land on Previous-Documents-list page")
      PreviousDocumentListPage.checkPage()
      And("User selects No on previous documents list page and continues")
      PreviousDocumentListPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-4 page")
      SummarySection4Page.checkPage()
      And("User checks the MiniCYA page for Section-4")
      SummarySection4Page.fillPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
     
      /*validate skipping Total-Package-Quantity page when destination country is Guernsey and
       Invoice and exchange rate choice is No*/
      When("User navigates to Destination Country page")
      DestinationCountryPage.navigateToPage(DestinationCountryPage.path)
      And("User selects Guernsey as the destination country and continues")
      DestinationCountryPage.fillPage("Guernsey")
      CommonPage.continue()
      And("User navigates to Nature Of Transaction page")
      NatureOfTransactionPage.navigateToPage(NatureOfTransactionPage.path)
      Then("User should land on Nature-Of-Transaction page")
      NatureOfTransactionPage.checkPage()
      //validate skipping Total-Package-Quantity page when destination country is Jersey and Invoice and exchange rate choice is Yes//
      When("User navigates to Destination Country page")
      DestinationCountryPage.navigateToPage(DestinationCountryPage.path)
      And("User selects Guernsey as the destination country and continues")
      DestinationCountryPage.fillPage("Jersey")
      CommonPage.continue()
      And("User navigates to Invoices And Exchange Rate Choice page")
      InvoicesAndExchangeRateChoicePage.navigateToPage(InvoicesAndExchangeRateChoicePage.path)
      And("User selects Yes on invoices and exchange rate choice page and continues")
      InvoicesAndExchangeRateChoicePage.fillPage("Yes")
      CommonPage.continue()
      Then("User should land on Nature-Of-Transaction page")
      NatureOfTransactionPage.checkPage()
    }

    Scenario("Complete Transactions section on standard arrived declaration journey") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, arrived declaration")
      fillSection1ForDeclaration("STANDARD", "arrived")
      And("User fills section2/3 and continues their journey to Invoices-And-Exchange-Rate page")
      section4Journey2()
      And("User selects currency code as GBP and Total amount as 567640 with an exchange rate as No and continues")
      InvoicesAndExchangeRatePage.fillPage("GBP", "567640", "No")
      CommonPage.continue()
      And("User lands on Total-Package-Quantity page")
      TotalPackageQuantityPage.checkPage()
      And("User selects 2 for the total number of packages and continues")
      TotalPackageQuantityPage.fillPage("2")
      CommonPage.continue()
      And("User lands on Nature-Of-Transaction page")
      NatureOfTransactionPage.checkPage()
      And("User selects option as Goods being sol and continues")
      NatureOfTransactionPage.fillPage("Goods being sol")
      CommonPage.continue()
      And("User lands on Previous-Document page")
      PreviousDocumentPage.checkPage()
      And("User selects as first Document Commercial Invoice as code and 9GB123456782317-BH1433A61 as reference and continues")
      PreviousDocumentPage.fillPage(genSequenceId("first"), "Commercial Invoice", "9GB123456782317-BH1433A61")
      CommonPage.continue()
      And("User lands on Previous-Documents-list page")
      PreviousDocumentListPage.checkPage()
      And("User selects No on previous documents list page and continues")
      PreviousDocumentListPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-4 page")
      SummarySection4Page.checkPage()
      And("User checks the MiniCYA page for Section-4")
      SummarySection4Page.fillPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      //remove previous documents//
      When("User navigates to Previous Documents List page")
      PreviousDocumentListPage.navigateToPage(PreviousDocumentListPage.path)
      And("User removes previous document")
      PreviousDocumentListPage.removePreviousDoc(0)
      And("User lands on Previous-Documents-Remove page")
      PreviousDocumentRemovePage.checkPage()
      And("User selects Yes to remove Previous Documents and continues")
      PreviousDocumentRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      Then("User should land on Previous-Document page")
      PreviousDocumentPage.checkPage()
      //validate skipping Total-Package-Quantity page when destination country is Jersey and Invoice and exchange rate choice is Yes//
      When("User navigates to Destination Country page")
      DestinationCountryPage.navigateToPage(DestinationCountryPage.path)
      And("User selects Jersey as the destination country and continues")
      DestinationCountryPage.fillPage("Jersey")
      CommonPage.continue()
      And("User navigates to Invoices And Exchange Rate Choice page")
      InvoicesAndExchangeRateChoicePage.navigateToPage(InvoicesAndExchangeRateChoicePage.path)
      And("User selects Yes on invoices and exchange rate choice page")
      InvoicesAndExchangeRateChoicePage.fillPage("Yes")
      CommonPage.continue()
      Then("User should land on Nature-Of-Transaction page")
      NatureOfTransactionPage.checkPage()
    }
  }

}
