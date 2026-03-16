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

package uk.gov.hmrc.test.ui.specs.Common

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage._
import uk.gov.hmrc.test.ui.specs.BaseSpec

class PaginationTestSpec  extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure {
Feature("Validate Dashboard and Declaration Information"){
  /*Below scenario -
  1. creates the number of declarations that we want by passing the number from step def
  2. Submit the created declarations and validates the pagination component is present
   */
  Scenario("Full Standard Journey and view declaration in submission dashboard"){
    Given("the user clears data in cache")
    background()
    Given("User fills Section 1 for STANDARD with a pre-lodged declaration")

    Given("User fills Section 2")

    Given("User fills Section 3")

    Given("User fills Section 4")

    Given("User fills Section 5")

    Given("User fills Section 6")

    Then("User should land on the Saved Summary page")

    Then("User verifies the section headings and selects Confirm and Continue")

    Then("User should land on the Submit Your Declaration page")

    Given("User submits the declaration")

    Then("User should land on the holding page and be redirected to the Confirmation page")

    Then("User should land on the Confirmation page")

    Given("User navigates to the Choice page")

    Given("User selects Manage Submitted Declarations")

    Then("User should land on the Dashboard page")

    Then("User validates the declaration details in the Submitted tab and checks the status is \"Arrived and accepted\"")

    Given("User navigates to the Declaration Information page by clicking the MRN link")

    Then("User should land on the Declaration Information page")

    Given("User creates 30 draft declarations")

    Given("User clicks the Back to Your Declarations link")

    Then("User validates the functionality of the pagination component")
  }
}
}
