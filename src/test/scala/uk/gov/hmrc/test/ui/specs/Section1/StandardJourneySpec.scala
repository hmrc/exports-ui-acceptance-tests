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
import uk.gov.hmrc.test.ui.pages.base.CommonPage.background
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
        Table(
          "DecType",
          "prelodged",
          "arrived")
      ) { DecType =>
        Given("the user clears data in cache")
        background()
        Given("User enters EORI GB123456789006 on Login Page and clicks submit")

        Then("User should land on Choice page")

        And("User selects to create a declaration")

        Then("User should land on Standard-Or-Other page")

        And("User selects the STANDARD declaration option")

        And("User clicks continue")

        Then("User should land on Arrived-or-Prelodged page")

        And("User selects a <DecType> declaration type")

        And("User clicks continue")

        Then("User should land on Declarant-Details page")

        And("User selects Yes to confirm their eori")

        And("User clicks continue")

        Then("User should land on Do-You-Have-Ducr page")

        And("User selects Yes to confirm they have a ducr")

        And("User clicks continue")

        Then("User should land on Ducr-Entry page")

        And("User enters Ducr 3GB986007773125-INVOICE123")

        And("User clicks continue")

        Then("User should land on Lrn page")

        And("User enters LRN MSLRN2872100")

        And("User clicks continue")

        Then("User should land on Link-To-Mucr page")

        And("User selects Yes to link MUCR to DUCR")

        And("User clicks continue")

        Then("User should land on Enter-A-Mucr page")

        And("User enters Mucr as GB/AZ09-B12345")

        And("User clicks continue")

        Then("User should land on MiniCYA-Section-1 page")

        And("User checks the MiniCYA page for Section-1")

      }
    }
  }

}
