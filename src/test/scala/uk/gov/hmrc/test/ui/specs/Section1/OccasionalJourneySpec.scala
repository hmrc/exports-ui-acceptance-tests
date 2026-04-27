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
import uk.gov.hmrc.test.ui.specs.Tags.*

class OccasionalJourneySpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Occasional Journey") {
    //Below scenario - DoYouHaveADucr:[No], Confirm-Ducr:[Yes], Link-to-Mucr:[No]//
    Scenario("Fill Section 1 for a Occasional Prelodged and Arrived Declaration",Regression,Regression1,Section1,Occasional) {
      forAll(
        Table("DecType", "prelodged", "arrived")) { DecType =>
        Given("the user clears data in cache")
        background()
        When("User enters EORI FR1234567 on Login Page and clicks submit")
        LoginPage.fillPage("FR1234567")
        LoginPage.submit()
        And("User lands on Choice page")
        ChoicePage.checkPage()
        And("User selects to create a declaration")
        ChoicePage.fillPage("create a declaration")
        And("User lands on Standard-Or-Other page")
        StandardOrOtherPage.checkPage()
        And("User selects the OTHER declaration option")
        StandardOrOtherPage.fillPage("OTHER")
        And("User clicks continue")
        CommonPage.continue()
        And("User lands on Declaration-Choice page")
        DeclarationChoicePage.checkPage()
        And("User selects the OCCASIONAL declaration")
        DeclarationChoicePage.fillPage("OCCASIONAL")
        And("User clicks continue")
        CommonPage.continue()
        And("User lands on Arrived-or-Prelodged page")
        DeclarationTypePage.checkPage()
        And(s"User selects a $DecType declaration type")
        DeclarationTypePage.fillPage(DecType)
        And("User clicks continue")
        CommonPage.continue()
        Then("User lands on Declarant-Details page")
        DeclarantDetailsPage.checkPage()
        And("User selects Yes to confirm their eori")
        DeclarantDetailsPage.fillPage("Yes")
        And("User clicks continue")
        CommonPage.continue()
        And("User lands on Do-You-Have-Ducr page")
        DoYouHaveADucrPage.checkPage()
        And("User selects No to confirm they have a ducr")
        DoYouHaveADucrPage.fillPage("No")
        And("User clicks continue")
        CommonPage.continue()
        And("User lands on Trader-Reference page")
        TraderReferencePage.checkPage()
        And("User enters trader reference as EUEORI/TEST1")
        TraderReferencePage.fillPage("EUEORI/TEST1")
        And("User clicks continue")
        CommonPage.continue()
        And("User lands on Confirm-Ducr page")
        ConfirmDucrPage.checkPage()
        And("User selects Yes to use the Ducr created by eori and reference")
        ConfirmDucrPage.fillPage("Yes")
        And("User clicks continue")
        CommonPage.continue()
        And("User  lands on Lrn page")
        LrnPage.checkPage()
        And("User enters LRN MSLRN2872100")
        LrnPage.fillPage("MSLRN2872100")
        And("User clicks continue")
        CommonPage.continue()
        And("User lands on Link-To-Mucr page")
        LinkMucrPage.checkPage()
        And("User selects No to link MUCR to DUCR")
        LinkMucrPage.fillPage("No")
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
