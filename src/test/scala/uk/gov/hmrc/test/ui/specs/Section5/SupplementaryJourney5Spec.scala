package uk.gov.hmrc.test.ui.specs.Section5

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section5.*
import uk.gov.hmrc.test.ui.pages.section5.SummarySection5Page.*
import uk.gov.hmrc.test.ui.specs.BaseSpec

class SupplementaryJourney5Spec extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
  with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section5 Supplementary Journey") {
    Scenario("Complete Items section on Supplementary EIDR declaration journey") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for SUPPLEMENTARY, eidr declaration")
      fillSection1ForDeclaration("SUPPLEMENTARY", "eidr")
      And("User fills section2/3/4 and continues their journey to Procedure-codes page")
      section5Journey1()
      And("User then continues their journey to Commodity-Details page")
      section5ProcedureCodesPageToCommodityDetailsPage()
      And("User enters only description as Old St Andrews golf ball whisky on commodity details page and continues")
      CommodityDetailsPage.fillPage("Old St Andrews golf ball whisky")
      CommonPage.continue()
      And("User lands on Dangerous-Goods-Code page")
      DangerousGoodsCodePage.checkPage()
      And("User selects Yes to enter the code 1234 as dangerous goods and continues")
      DangerousGoodsCodePage.fillPage("Yes", "1234")
      CommonPage.continue()
      //skipped Vat rating page//
      When("User lands on National-Additional-Code page and continue their journey by skipping vat rating page")
      section5SkippedVATRatingPage()
      //skipping of documents required yes/no page and landing on addition documents page//
      And("User lands on Additional-Document page and continue their journey by Adding second item")
      skipDocumentsRequiresYesNoPage()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()

      //Deleting item from minicya section-5 page//
      And("User removes one item from the declaration")
      //clearKeysFromCache()
      And("User lands on Remove-Declaration-Item page")
      RemoveItemsPage.checkPage()
      And("User selects No to remove first item and continues")
      RemoveItemsPage.fillPage("No", genSequenceId("first"))
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User removes one item from the declaration")
      SummarySection5Page.removeItem()
      And("User selects Yes to remove first item and continues")
      RemoveItemsPage.fillPage("Yes", genSequenceId("Yes"))
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()

      //Deleting item from Declaration Items List page//
      And("User clicks back on MiniCya section 5")
      SummarySection5Page.back()
      And("User lands on Declaration-Items-List page")
      DeclarationItemsListPage.checkPage()
      And("User removes one item from declaration item list page")
      DeclarationItemsListPage.removeItemFromListPage()
      And("User selects Yes to remove first item and continues")
      RemoveItemsPage.fillPage("Yes", genSequenceId("first"))
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User should be displayed with a warning text to add items")
      SummarySection5Page.addItemWarning().getText should include("You need to add at least one item before submitting your declaration")
      And("User clicks on Add Item link")
      SummarySection5Page.addItem()
      And("User lands on Add-Declaration-Item-1 page")
      AddDeclarationItemPage.checkPage()
    }
    Scenario(
      "Complete Items section on Supplementary Simplified declaration journey and Validate Changing Item Details"
    ) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for SUPPLEMENTARY, simplified declaration")
      fillSection1ForDeclaration("SUPPLEMENTARY", "simplified")
      And("User fills section2/3/4 and continues their journey to Procedure-codes page")
      section5Journey1()
      And("User then continues their journey from Procedure-Codes Page to declaration items list page")
      section5section5ProcedureCodesPageToDeclarationItemsListPage()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()
    }
    
    }

}
