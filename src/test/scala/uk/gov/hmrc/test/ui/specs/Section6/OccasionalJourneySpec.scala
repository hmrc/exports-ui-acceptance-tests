package uk.gov.hmrc.test.ui.specs.Section6

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.background
import uk.gov.hmrc.test.ui.pages.common.SummaryPage
import uk.gov.hmrc.test.ui.pages.section6._
import uk.gov.hmrc.test.ui.pages.section6.SummarySection6Page.{fillAllForSections6, section6OccasionalJourney1, section6OccasionalJourney2}
import uk.gov.hmrc.test.ui.specs.BaseSpec

class OccasionalJourneySpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Section6 Occasional Journey") {
    /*Below scenario -
     1. if procedure code is 1042 and Additional procedure code as 000
     2. The following page is visible
          # Supervising-Customs-Office
          #  Inland-Or-Border
          #  Inland-Transport-details
          #  Border-Transport
          #  Transport-Country
          #  Express-Consignment
          #  Transport-Payment
          #    and all Container pages
    3. The following page is skipped
          # Departure Transport*/
    Scenario("Occasional journey section-6") {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for OCCASIONAL, prelodged declaration")
      fillAllForSections6("OCCASIONAL", "prelodged")
      And("User navigates from Transport-Leaving-The-Border page to Container-List page")
      section6OccasionalJourney1()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
     /*Below scenario -
      1. if procedure code is 1042 and Additional procedure code as 000
          and the destination country is Jersey
      2. The following page is visible
          # Inland-transport-details
          # Border Transport
          # Transport country
          # Express-consignment
          # Container pages
      3. The following page is skipped
          # Departure Transport*/

      When("User clears cache for section 6 and continues their journey from Destination Country page to Destination Country page")
      section6OccasionalJourney2()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
    }
   /* Below scenario -
      1. if procedure code is 1042 and Additional procedure code as 000
          and Inland or border as Border location
      2. The following page is visible
          # Supervising-Customs-Office
      3. The following page is skipped
          # Departure Transport
          #  Inland transport details
          #  Border transport*/
    Scenario("Occasional arrived journey section-6"){
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for OCCASIONAL, arrived declaration")
      fillAllForSections6("OCCASIONAL", "arrived")
      Then("User should land on Transport-Leaving-The-Border page")
      TransportLeavingTheBorderPage.checkPage()
      And("User selects Sea transport as mode of transport leaving the border and continues")
      TransportLeavingTheBorderPage.fillPage("Sea transport")
      CommonPage.continue()
      Then("User should land on Supervising-Customs-Office page")
      SupervisingCustomsOfficePage.checkPage()
      And("User selects GBBTH001 as the customs office code and continues")
      SupervisingCustomsOfficePage.fillPage("GBBTH001")
      CommonPage.continue()
      And("User lands on Inland-Or-Border page")
      InlandOrBorderPage.checkPage()
      And("User selects Border location for presenting the goods to customs and continues")
      InlandOrBorderPage.fillPage("Border location")
      CommonPage.continue()
      And("User lands on Transport-Country page")
      TransportCountryPage.checkPage()
      And("User selects France as the transport country and continues")
      TransportCountryPage.fillPage("France")
      CommonPage.continue()
      And("User lands on Express-Consignment page")
      ExpressConsignmentPage.checkPage()
      And("User selects Yes to confirm consignment as express and continues")
      ExpressConsignmentPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Transport-Payment page and continues")
      TransportPaymentPage.checkPage()
      And("User selects Payment by cheque as the mode of payment and continues")
      TransportPaymentPage.fillPage("Payment by cheque")
      CommonPage.continue()
      And("User lands on Container page")
      ContainerPage.checkPage()
      And("User selects Yes to add Container1 as container and continues")
      ContainerPage.fillPage("Yes", "Container1")
      CommonPage.continue()
      And("User lands on Seal-YesNo page")
      SealYesNoPage.checkPage()
      And("User selects No to add security seal and continues")
      SealYesNoPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on Container-List page")
      ContainerListPage.checkPage()
      And("User selects No to add another container and continues")
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
