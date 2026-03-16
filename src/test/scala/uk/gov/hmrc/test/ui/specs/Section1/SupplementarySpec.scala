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
      forAll(
        Table(
          "DecType",
          "prelodged",
          "arrived")
      ) { DecType =>
        Given("the user clears data in cache")
        background()
        Given("User enters EORI GB123456789017 on Login Page and clicks submit")

        Then("User should land on Choice page")

        And("User selects to create a declaration")

        Then("User should land on Standard-Or-Other page")

        And("User selects the OTHER declaration option")

        And("User clicks continue")

        And("User should land on Declaration-Choice page")

        And("User selects the SUPPLEMENTARY declaration")

        And("User clicks continue")

        Then("User should land on Arrived-or-Prelodged page")

        And("User selects a <DecType> declaration type")

        And("User clicks continue")

        Then("User should land on Declarant-Details page")

        And("User selects Yes to confirm their eori")

        And("User clicks continue")

        Then("User should land on Consignment-References page")

        And("User enters 1GB121212121212-INVOICE123/4 as Ducr, <dateOrMrn> mrn or date and QSLRN8514100 as LRN")

        And("User clicks continue")

        Then("User should land on MiniCYA-Section-1 page")

        And("User checks the MiniCYA page for Section-1")
      }
    }
  }

}
