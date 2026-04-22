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

package uk.gov.hmrc.test.ui.specs.Section1

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.background
import uk.gov.hmrc.test.ui.pages.section1.*
import uk.gov.hmrc.test.ui.specs.BaseSpec

class StandardJourneySpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Standard Journey") {
    //Below scenario - DoYouHaveADucr:[Yes]//
    Scenario("Fill Section 1 for a Standard Prelodged and Arrived Declaration") {
      forAll(
        Table("DecType", "prelodged", "arrived")) { DecType =>
        Given("the user clears data in cache")
        background()
        When("User enters EORI GB123456789006 on Login Page and clicks submit")
        LoginPage.fillPage("GB123456789006")
        LoginPage.submit()
        Then("User should land on Choice page")
        ChoicePage.checkPage()
        And("User selects to create a declaration")
        ChoicePage.fillPage("create a declaration")
        Then("User should land on Standard-Or-Other page")
        StandardOrOtherPage.checkPage()
        And("User selects the STANDARD declaration option")
        StandardOrOtherPage.fillPage("STANDARD")
        And("User clicks continue")
        CommonPage.continue()
        Then("User should land on Arrived-or-Prelodged page")
        DeclarationTypePage.checkPage()
        And(s"User selects a $DecType declaration type")
        DeclarationTypePage.fillPage(DecType)
        And("User clicks continue")
        CommonPage.continue()
        Then("User should land on Declarant-Details page")
        DeclarantDetailsPage.checkPage()
        And("User selects Yes to confirm their eori")
        DeclarantDetailsPage.fillPage("Yes")
        And("User clicks continue")
        CommonPage.continue()
        Then("User should land on Do-You-Have-Ducr page")
        DoYouHaveADucrPage.checkPage()
        And("User selects Yes to confirm they have a ducr")
        DoYouHaveADucrPage.fillPage("Yes")
        And("User clicks continue")
        CommonPage.continue()
        Then("User should land on Ducr-Entry page")
        DucrEntryPage.checkPage()
        And("User enters Ducr 3GB986007773125-INVOICE123")
        DucrEntryPage.fillPage("3GB986007773125-INVOICE123")
        And("User clicks continue")
        CommonPage.continue()
        Then("User should land on Lrn page")
        LrnPage.checkPage()
        And("User enters LRN MSLRN2872100")
        LrnPage.fillPage("MSLRN2872100")
        And("User clicks continue")
        CommonPage.continue()
        Then("User should land on Link-To-Mucr page")
        LinkMucrPage.checkPage()
        And("User selects Yes to link MUCR to DUCR")
        LinkMucrPage.fillPage("Yes")
        And("User clicks continue")
        CommonPage.continue()
        Then("User should land on Enter-A-Mucr page")
        EnterAMucrPage.checkPage()
        And("User enters Mucr as GB/AZ09-B12345")
        EnterAMucrPage.fillPage("GB/AZ09-B12345")
        And("User clicks continue")
        CommonPage.continue()
        Then("User should land on MiniCYA-Section-1 page")
        SummarySection1Page.checkPage()
        And("User checks the MiniCYA page for Section-1")
        SummarySection1Page.fillPage()
      }
    }
  }

}
