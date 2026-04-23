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

package uk.gov.hmrc.test.ui.specs.Section2

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section2.{ExporterEORINumberPage, PersonPresentingGoodsPage, SummarySection2Page}
import uk.gov.hmrc.test.ui.pages.section2.SummarySection2Page.*
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class ClearanceJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {

  Feature("Section2 Clearance Prelodged") {
    // Clearance Prelodged Declaration//
    Scenario("Exports Clearance Prelodged Scenario with possible scenarios",Regression1,Regression,Section2,Clearance,Smoke) {
      Given("the user clears data in cache")
      background()
      When("User fills section1 for CLEARANCE, prelodged declaration")
      fillSection1ForDeclaration("CLEARANCE", "prelodged")
      /* Select No for isEIDRr,Yes for my EORI, No for exporter eori, Yes to isThisExs, no to consignor EORI,
      no for third party goods transportation page and Permanent as Procedure Choice*/
      And("User continue their journey through Entry-Into-Declarant-Records to Authorisations-Required-List page")
      completeSection2ClearanceEidrNo()
      Then("User should land on MiniCYA-Section-2 page")
      SummarySection2Page.checkPage()
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      /*User is on the Entry into declarant records page, selects "isEIDR = yes", navigates to
      Person Presenting Goods page. the following pages are skipped  Declarant-Details,  Are-You-The-Exporter*/
      When("User navigates from Entry Into Declarant Records page to Person-Presenting-Goods page")
      completeSection2ClearanceEidrYes()
      And("User enters entered eori as GB121212121212")
      PersonPresentingGoodsPage.fillPage("GB121212121212")
      CommonPage.continue()
      And("User lands on Exporter-Eori-Number page")
      ExporterEORINumberPage.checkPage()
      Then("User navigates to Summary Section2 page")
      SummarySection2Page.navigateToPage(SummarySection2Page.path)
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
      /*user navigates to the following pages-->  On-Behalf-Of-Another-Agent page, representative-eori page,representative-type-agreed page.
       cache details to clear Exporter’s details, Consignor’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation, Carrier or haulier’s details, Carrier or haulier’s EORI number */
      When("User clears cache details on section2 summary page and continue journey to Consignee-Details page")
      clearCacheDetailsContinueToConsigneeDetailsPage()
      Then("User navigates to Summary Section2 page")
      SummarySection2Page.navigateToPage(SummarySection2Page.path)
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
      /*cache details to clear
       * Is this an EIDR?, Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation*/
      When("User clears cache details on section2 summary page and continue journey to Authorisation-Choice page")
      clearCacheDetailsContinueToAuthorisationChoicePage()
      Then("User navigates to Summary Section2 page")
      SummarySection2Page.navigateToPage(SummarySection2Page.path)
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
    }
    // Clearance Arrived Declaration//
    Scenario("Exports Clearance Arrived Scenario which covers maximum number of pages",Regression1,Regression,Section2,Clearance) {
      Given("the user clears data in cache")
      background()
      When("User fills section1 for CLEARANCE, arrived declaration")
      fillSection1ForDeclaration("CLEARANCE", "arrived")
      And("User continue their journey through Entry-Into-Declarant-Records to Authorisations-Required-List page")
      completeSection2ClearanceEidrNo()
      Then("User should land on MiniCYA-Section-2 page")
      SummarySection2Page.checkPage()
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
    }

  }

}
