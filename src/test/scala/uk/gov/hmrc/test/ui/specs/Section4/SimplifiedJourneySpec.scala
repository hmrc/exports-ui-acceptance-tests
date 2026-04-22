package uk.gov.hmrc.test.ui.specs.Section4

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section2.ProcedureChoicePage
import uk.gov.hmrc.test.ui.pages.section4.{PreviousDocumentPage, SummarySection4Page}
import uk.gov.hmrc.test.ui.pages.section4.SummarySection4Page.{assertTitle, section4Journey1}
import uk.gov.hmrc.test.ui.specs.BaseSpec

class SimplifiedJourneySpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Section4 Simplified Journey") {
    Scenario("Complete Transactions section on Simplified Prelodged declaration journey and validate dynamic title changes on previous documents page") {
      forAll( Table("DecType", "prelodged", "arrived")) { decType =>
        Given("the user clears data in cache")
        background()
        When(s"User fills Section1 for SIMPLIFIED, $decType declaration")
        fillSection1ForDeclaration("SIMPLIFIED", decType)
        And("User fills section2/3 and continues their journey to previous documents list page")
        section4Journey1()
        Then("User should land on MiniCYA-Section-4 page")
        SummarySection4Page.checkPage()
        And("User checks the MiniCYA page for Section-4")
        SummarySection4Page.fillPage()
        And("User clicks continue on MiniCya")
        CommonPage.continueOnMiniCya()
        /*validate dynamic title change on previous documents page
        * check title on previous documents page when authorisation choice is Permanent with excise*/
        And("User navigates to Authorisation Choice page")
        ProcedureChoicePage.navigateToPage(ProcedureChoicePage.path)
        And("User selects Permanent with excise as export procedure choice and continues")
        ProcedureChoicePage.fillPage("Permanent with excise")
        CommonPage.continue()
        And("User navigates to Previous Documents page")
        PreviousDocumentPage.navigateToPage(PreviousDocumentPage.path)
        Then("User should land on Previous-Document page")
        PreviousDocumentPage.checkPage()
        assertTitle("Declare each document, including excise guarantees")
       //check title on previous documents page when authorisation choice is Temporary//
        And("User navigates to Authorisation Choice page")
        ProcedureChoicePage.navigateToPage(ProcedureChoicePage.path)
        And("User selects Temporary as export procedure choice and continues")
        ProcedureChoicePage.fillPage("Temporary")
        CommonPage.continue()
        And("User navigates to Previous Documents page")
        PreviousDocumentPage.navigateToPage(PreviousDocumentPage.path)
        Then("User should land on Previous-Document page")
        PreviousDocumentPage.checkPage()
        assertTitle("Declare each document, including previous declarations")
      }
    }
    }

}
