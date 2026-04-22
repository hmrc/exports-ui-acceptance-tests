package uk.gov.hmrc.test.ui.specs.Section3

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.*
import uk.gov.hmrc.test.ui.pages.section3.{CountryOfRoutingPage, DestinationCountryPage, LocationOfGoodsPage, OfficeOfExitPage, SummarySection3Page}
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
  Feature("Simplified Journey Section 3") {
    Scenario("Complete Routes and Locations section on Simplified declaration journey") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, prelodged declaration")
      fillSection1ForDeclaration("STANDARD", "prelodged")
      And("User fills section2")
      fillSection2ForDeclaration()
      And("User lands on Destination-Country page")
      DestinationCountryPage.checkPage()
      And("User selects Ukraine as the destination country and continues")
      DestinationCountryPage.fillPage("Ukraine")
      CommonPage.continue()
      And("User lands on Country-Of-Routing page")
      CountryOfRoutingPage.checkPage()
      And("User selects No to provide routing countries and continues")
      CountryOfRoutingPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Location-Of-Goods page")
      LocationOfGoodsPage.checkPage()
      And("User selects No to provide location as GBCUASDDOVAPF and continues")
      LocationOfGoodsPage.fillPage("No", "GBCUASDDOVAPF")
      CommonPage.continue()
      And("User lands on Office-Of-Exit page")
      OfficeOfExitPage.checkPage()
      And("User selects Aberdeen with code GB000434 as the office of exit and continues")
      OfficeOfExitPage.fillPage("Aberdeen", "GB000434")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-3 page")
      SummarySection3Page.checkPage()
      And("User checks the MiniCYA page for Section-3")
      SummarySection3Page.fillPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
    }

    Scenario("Complete Routes and Locations section on Simplified Arrived declaration journey") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for SIMPLIFIED, arrived declaration")
      fillSection1ForDeclaration("SIMPLIFIED", "arrived")
      And("User fills section2")
      fillSection2ForDeclaration()
      And("User lands on Destination-Country page")
      DestinationCountryPage.checkPage()
      And("User selects Ukraine as the destination country and continues")
      DestinationCountryPage.fillPage("Ukraine")
      CommonPage.continue()
      And("User lands on Country-Of-Routing page")
      CountryOfRoutingPage.checkPage()
      And("User selects No to provide routing countries and continues")
      CountryOfRoutingPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Location-Of-Goods page")
      LocationOfGoodsPage.checkPage()
      And("User selects Heysham as the location and continues")
      LocationOfGoodsPage.fillPage("Heysham")
      CommonPage.continue()
      And("User lands on Office-Of-Exit page")
      OfficeOfExitPage.checkPage()
      And("User selects Aberdeen with code GB000434 as the office of exit and continues")
      OfficeOfExitPage.fillPage("Aberdeen", "GB000434")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-3 page")
      SummarySection3Page.checkPage()
      And("User checks the MiniCYA page for Section-3")
      SummarySection3Page.fillPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
    }
    }

}
