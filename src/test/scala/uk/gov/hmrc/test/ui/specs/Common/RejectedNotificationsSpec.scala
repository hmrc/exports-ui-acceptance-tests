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

class RejectedNotificationsSpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Validate Rejected Notifications"){
    Scenario("Fix a rejected declaration and submit the declaration"){
      Given("the user clears data in cache")
      background()
      Given("User fills section1 for STANDARD, prelodged declaration")

      And("User fills section2")

      And("User fills section3")

      And("User fills section4")

      And("User fills section5")

      And("User fills section6")

      And("User navigates to Lrn page")

      And("User enters LRN BCDSCOM02")

      And("User clicks continue")

      And("User navigates to summary page")

      Then("User should land on Saved-Summary page")

      And("User checks the section headings and clicks confirm and continue")

      Then("User should land on Submit-Your-Declaration page")

      And("User submits the declaration")

      Then("User should land on holding page and redirect to rejected notification page")

      And("User navigates to Choice page")

      And("User selects to Manage Submit Declaration")

      Then("User should land on Dashboard page")

      And("User validates declaration details on Rejected tab and checks Status is Declaration rejected")

      And("User navigates to declaration information page after clicking on mrn link")

      Then("User should land on Declaration-Information page")

      And("User validates details on declaration information page")

      And("User fixes errors on the declaration")

      And("User should land on Rejected-Notifications page")

      //validate Lrn Page

      And("User validates Lrn error details on rejected notifications")

      Then("User clicks on Lrn change link to fix error")

      And("User enters LRN MCDSCOM06")

      And("User returns back to errors page")

      And("User checks updated Lrn error details on rejected notifications")

      And("User navigates to check you answer from rejected notification page")

      Then("User should land on Saved-Summary page")

      And("User checks the section headings and clicks confirm and continue")

      Then("User should land on Submit-Your-Declaration page")

      And("User submits the declaration")

      Then("User should land on holding page and redirect to Confirmation page")

      And("User should land on Confirmation page")

      And("User navigates to Choice page")

      And("User selects to Manage Submit Declaration")

      Then("User should land on Dashboard page")

      And("User validates declaration details on Submitted tab and checks Status is Arrived and accepted")

      And("User navigates to declaration information page after clicking on mrn link")

      Then("User should land on Declaration-Information page")

      //Duplicate ducr warning messages check

      And("User clicks on copy link")

      And("User enters ducr 8GB123456469274-101SHIP1 and a rejected lrn")

      And("User clicks continue")

      And("User clicks continue on summary")

      And("User submits the declaration")

      Then("User should land on holding page and redirect to rejected notification page")

      And("User validates ducr warning on rejected notifications page")

      Then("User clicks on Ducr change link to fix error")

      And("User validates duplicate ducr warning on ducr entry page")
    }
  }

}
