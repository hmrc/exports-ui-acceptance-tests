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

package uk.gov.hmrc.test.ui.specs.Section3

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.*
import uk.gov.hmrc.test.ui.pages.section3.{DestinationCountryPage, LocationOfGoodsPage, OfficeOfExitPage, SummarySection3Page}
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class ClearanceJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section4 Clearance Journey") {
    //No routing and countries of routing pages, LocationOfGoods: [No], Number of countries Added: [1]//
    Scenario(
      "Complete Transactions section on Clearance Prelodged declaration journey and validate dynamic title changes on previous documents page",Regression1,Regression,Section3,Clearance
    ) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for CLEARANCE, prelodged declaration")
      fillSection1ForDeclaration("CLEARANCE", "prelodged")
      And("User fills section2")
      fillSection2ForDeclaration()
      And("User lands on Destination-Country page")
      DestinationCountryPage.checkPage()
      And("User selects Ukraine as the destination country and continues")
      DestinationCountryPage.fillPage("Ukraine")
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
    //No routing and countries of routing pages, LocationOfGoods: [Yes], Number of countries Added: [1]//
    Scenario("Complete Routes and Locations section on Clearance arrived declaration journey",Regression1,Regression,Section3,Clearance) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for CLEARANCE, arrived declaration")
      fillSection1ForDeclaration("CLEARANCE", "arrived")
      And("User fills section2")
      fillSection2ForDeclaration()
      And("User lands on Destination-Country page")
      DestinationCountryPage.checkPage()
      And("User selects Ukraine as the destination country and continues")
      DestinationCountryPage.fillPage("Ukraine")
      CommonPage.continue()
      And("User lands on Location-Of-Goods page")
      LocationOfGoodsPage.checkPage()
      And("User selects Pembroke Docks as the location and continues")
      LocationOfGoodsPage.fillPage("Pembroke Docks")
      CommonPage.continue()
      And("User lands on Office-Of-Exit page")
      OfficeOfExitPage.checkPage()
      And("User selects Aberdeen with code GB000434 as the office of exit and continues")
      OfficeOfExitPage.fillPage("Aberdeen", "GB000434")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-3 page")
      SummarySection3Page.checkPage()
      And("User checks the MiniCYA page for Section-3")
      SummarySection3Page.checkPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
    }

  }

}
