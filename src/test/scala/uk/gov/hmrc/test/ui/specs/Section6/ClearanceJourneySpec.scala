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

package uk.gov.hmrc.test.ui.specs.Section6

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.background
import uk.gov.hmrc.test.ui.pages.common.SummaryPage
import uk.gov.hmrc.test.ui.pages.section6.SummarySection6Page
import uk.gov.hmrc.test.ui.pages.section6.SummarySection6Page.{fillAllForSections6, section6ClearanceArrivedJourney, section6ClearanceJourney1, section6ClearanceJourney2}
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class ClearanceJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section6 Clearance Journey") {
    /*Below scenario -
      1. if procedure code is 1042 and Additional procedure code as 000
      2. The following page is visible
          # Warehouse
          # Supervising-Customs-Office
     3. The following pages are skipped
         #  Inland-Transport-details
         #  Border-Transport*/
    Scenario("clearance journey section-6",Regression3,Regression,Section6,Clearance) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for CLEARANCE, prelodged declaration")
      fillAllForSections6("CLEARANCE","prelodged")
      And("User continues their journey from Transport-Leaving-The-Border page to Container-List page")
      section6ClearanceJourney1()
      Then("User should land on MiniCYA-Section-6 page")
      SummarySection6Page.checkPage()
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()

      /*Below scenario -
      1. isEidr is Yes and procedure code is 0017 with  Additional procedure code as 16M
      2. The following page is visible
          # Warehouse
          # Supervising-Customs-Office
          # Express Consignment
          # Transport-Payment
          # Containers page
     3. The following pages are skipped
         #  Inland-Transport-details
         #  Border-Transport*/
      When("User navigates from Entry Into Declarant Records page to Transport-Payment page")
      section6ClearanceJourney2()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
    }
    /* Below scenario -
     # 1. if procedure code is 1007 and Additional procedure code as 1CS
     # 2. The following page is visible
          # Warehouse
          # Supervising-Customs-Office
    # 3. The following pages are skipped
         # Transport-payment
         #  Inland-Transport-details
         #  Container/{container name}/ seals
         #  Containers/{container name}/ add-seal
         #  Containers/{container name}/ seals
         #  Containers*/
    Scenario("clearance arrived journey section-6",Regression3,Regression,Section6,Clearance) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1/2/3/4/5 for CLEARANCE, arrived declaration")
      fillAllForSections6("CLEARANCE", "arrived")
      And("User navigates to Procedure codes page to Container page")
      section6ClearanceArrivedJourney()
      Then("User navigates to MiniCYA page for Section-6")
      SummarySection6Page.navigateToPage(SummarySection6Page.path)
      And("User checks the MiniCYA page for Section-6")
      SummarySection6Page.fillPage()
      When("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      Then("User should land on Saved-Summary page")
      SummaryPage.checkPage()
    }
  }

}
