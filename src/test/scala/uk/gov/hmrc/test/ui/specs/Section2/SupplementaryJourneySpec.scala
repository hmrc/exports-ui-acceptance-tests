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
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, clearKeysFromCache, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section2.*
import uk.gov.hmrc.test.ui.pages.section2.SummarySection2Page.completeSection2Supplementary
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class SupplementaryJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section2 Supplementary Journey") {
    /*Supplementary SDP and EIDR Declarations
    * Select No for exporter, no for exporter eori, No to hold the contract, no to carrier EORI
    * Third party goods transportation page is not visible in Supplementary (Simplified and EDR) journeys
    * To check the remove functionality for Authorisation choice and Other parties involved*/
    Scenario("Exports Supplementary SDP and eidr Scenarios",Regression1,Regression,Section2,Supplementary) {
      forAll(Table("DecType", "simplified", "eidr")) { decType =>
        Given("the user clears data in cache")
        background()
        When(s"User fills Section1 for SUPPLEMENTARY, $decType declaration")
        fillSection1ForDeclaration("SUPPLEMENTARY",decType)
        And("User continue their journey through Are-You-The-Exporter page to Authorisations-Required-List page")
        completeSection2Supplementary()
        Then("User should land on MiniCYA-Section-2 page")
        SummarySection2Page.checkPage()
        And("User checks the MiniCYA page for Section-2")
        SummarySection2Page.fillPage()
        And("User clicks continue on MiniCya")
        CommonPage.continueOnMiniCya()
         /*selects "Exporter-eori-number = yes"
         * the following pages are skipped
               Exporter-Eori-Number,
               Exporter-Address,
               On-Behalf-Of-Another-Agent,
               Representatives-Eori-Number,
    #          Representation-Type-Agreed*/
        When("User navigates to Are You The Exporter page")
        AreYouTheExporterPage.navigateToPage(AreYouTheExporterPage.path)
        And(
          "User clears Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation keys from cache"
        )
        clearKeysFromCache("Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation")
        And("User selects Yes to I am the Exporter and continues")
        AreYouTheExporterPage.fillPage("Yes")
        CommonPage.continue()
        And("User lands on Consignee-Details page")
        ConsigneeDetailsPage.checkPage()
        Then("User navigates to Summary Section2 page")
        SummarySection2Page.navigateToPage(SummarySection2Page.path)
        And("User checks the MiniCYA page for Section-2")
        SummarySection2Page.fillPage()
      }

    }

  }

}
