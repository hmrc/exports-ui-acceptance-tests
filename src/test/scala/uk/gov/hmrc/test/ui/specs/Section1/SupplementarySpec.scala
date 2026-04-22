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

class SupplementarySpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Supplementary Journey") {
    //Below scenario - DoYouHaveADucr:[Yes]//
    Scenario("Fill Section 1 for a Supplementary Non Eidr and Eidr") {
      val examples =
        Table(
          ("DecType", "dateOrMrn"),
          ("eidr", "20230401"),
          ("simplified", "20GB46J8TMJ4RF1207")
        )
      forAll(examples)
         { (DecType:String, dateOrMrn:String) =>
        Given("the user clears data in cache")
        background()
        Given("User enters EORI GB123456789017 on Login Page and clicks submit")
        LoginPage.fillPage("GB123456789017")
        LoginPage.submit()
        Then("User should land on Choice page")
        ChoicePage.checkPage()
        And("User selects to create a declaration")
        ChoicePage.fillPage("create a declaration")
        Then("User should land on Standard-Or-Other page")
        StandardOrOtherPage.checkPage()
        And("User selects the OTHER declaration option")
        StandardOrOtherPage.fillPage("STANDARD")
        And("User clicks continue")
        CommonPage.continue()
        And("User should land on Declaration-Choice page")
        DeclarationChoicePage.checkPage()
        And("User selects the SUPPLEMENTARY declaration")
        DeclarationChoicePage.fillPage("SUPPLEMENTARY")
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
        Then("User should land on Consignment-References page")
        ConsignmentReferencesPage.checkPage()
        And(s"User enters 1GB121212121212-INVOICE123/4 as Ducr, $dateOrMrn mrn or date and QSLRN8514100 as LRN")
        ConsignmentReferencesPage.fillPage("1GB121212121212-INVOICE123/4", dateOrMrn, "QSLRN8514100")
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
