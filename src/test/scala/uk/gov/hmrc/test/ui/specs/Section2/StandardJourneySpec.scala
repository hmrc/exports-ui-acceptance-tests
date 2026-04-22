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

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.base.Constants.none
import uk.gov.hmrc.test.ui.pages.section2.*
import uk.gov.hmrc.test.ui.pages.section2.SummarySection2Page._
import uk.gov.hmrc.test.ui.specs.BaseSpec

class StandardJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section2 Standard Prelodged") {
    Scenario(
      "Exports Standard Prelodged Scenario with Permanent as export procedure code choice, Consolidator and Manufacturer as other parties are involved"
    ) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, prelodged declaration")
      fillSection1ForDeclaration("STANDARD", "prelodged")
      /*Standard Prelodged Declaration
       * Select No for exporter, no for exporter eori, No to hold the contract, no to carrier EORI,
       * yes for third party goods transportation page and Permanent as Procedure Choice,
       * With the above combination the navigation through Is-Authorisation-Required page*/
      And("User continue their journey through Are-You-The-Exporter page to Other-Parties-Involved page")
      completeSection2Standard()
      And("User selects first party Consolidator with EORI GB121212121212 and continues")
      OtherPartiesInvolvedPage.fillPage(genSequenceId("first"), "Consolidator", "GB121212121212")
      CommonPage.continue()
      And("User lands on Other-Parties-Involved-List page")
      OtherPartiesInvolvedListPage.checkPage()
      And("User selects Yes on other party involved list page and continues")
      OtherPartiesInvolvedListPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Other-Parties-Involved page")
      OtherPartiesInvolvedPage.checkPage()
      And("User selects second party Manufacturer with EORI GB121212131313 and continues")
      OtherPartiesInvolvedPage.fillPage(genSequenceId("second"), "Manufacturer", "GB121212131313")
      CommonPage.continue()
      And("User lands on Other-Parties-Involved-List page")
      OtherPartiesInvolvedListPage.checkPage()
      And("User selects No on other party involved list page and continues")
      OtherPartiesInvolvedListPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Authorisation-Choice page")
      ProcedureChoicePage.checkPage()
      And("User selects Permanent as export procedure choice and continues")
      ProcedureChoicePage.fillPage("Permanent")
      CommonPage.continue()
      And("User lands on Is-Authorisation-Required page")
      AuthorisationsYesNoPage.checkPage()
      And("User selects Yes to declare authorisations and continues")
      AuthorisationsYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Authorisation-Required page")
      AuthorisationPage.checkPage()
      And("User selects first Authorisation code ACR and enters EORI GB123456789008 and continues")
      AuthorisationPage.fillPage(genSequenceId("first"), "ACR", "GB123456789008")
      CommonPage.continue()
      And("User lands on Authorisations-Required-List page")
      AuthorisationsListPage.checkPage()
      And("User selects No to add another authorisation and continues")
      AuthorisationsListPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-2 page")
      SummarySection2Page.checkPage()
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
      /*Clear cache Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation
       * selects "Third party goods transportation = Yes"*/
      When(
        "User navigates to Are You The Exporter page,selects yes clears cache and lands Third-Party-Goods-Transportation page"
      )
      clearCacheDetailsThirdPartyGoodsTransportationPage()
      And("User selects Yes on third party goods transportation page and continues")
      ThirdPartyGoodsTransportationPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Carrier-Eori-Number page")
      CarrierEORINumberPage.checkPage()
      Then("User navigates to Summary Section2 page")
      SummarySection2Page.navigateToPage(SummarySection2Page.path)
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
      /*Clear cache Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation
       * selects "Third party goods transportation = No"*/
      When(
        "User navigates to Are You The Exporter page,selects yes clears cache and lands Third-Party-Goods-Transportation page"
      )
      clearCacheDetailsThirdPartyGoodsTransportationPage()
      And("User selects No on third party goods transportation page and continues")
      ThirdPartyGoodsTransportationPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Consignee-Details page")
      ConsigneeDetailsPage.checkPage()
      Then("User navigates to Summary Section2 page")
      SummarySection2Page.navigateToPage(SummarySection2Page.path)
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
      /*Selects "Exporter-eori-number = yes" then Exporter Address page should be skipped
      Are-you-completing-this-declaration-on-behalf-of-another-agent page selects yes"
      the Representative EORI Number page should be skipped */
      When("User navigates to Are You The Exporter page")
      AreYouTheExporterPage.navigateToPage(AreYouTheExporterPage.path)
      And("User selects No to I am the Exporter and continues")
      AreYouTheExporterPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Exporter-Eori-Number page")
      ExporterEORINumberPage.checkPage()
      And("User selects Yes on exporter eori number page and enters eori number as GB123456789008 and continues")
      ExporterEORINumberPage.fillPage("Yes", "GB123456789008")
      CommonPage.continue()
      Then("User should land on On-Behalf-Of-Another-Agent page")
      OnBehalfOfAnotherAgentPage.checkPage()
      When("User selects Yes to hold the contract and continues")
      OnBehalfOfAnotherAgentPage.fillPage("Yes")
      CommonPage.continue()
      Then("User should land on Representation-Type-Agreed page")
      RepresentationTypeAgreedPage.checkPage()
    }

    Scenario(
      "Exports Standard Arrived Scenario with Temporary as export procedure code choice and No other parties are involved"
    ) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, arrived declaration")
      fillSection1ForDeclaration("STANDARD", "arrived")
      And("User continue their journey through Are-You-The-Exporter page to Other-Parties-Involved page")
      completeSection2Standard()
      And("User selects No for other parties are involved and continues")
      OtherPartiesInvolvedPage.fillPage(none)
      CommonPage.continue()
      And("User lands on Authorisation-Choice page")
      ProcedureChoicePage.checkPage()
      And("User selects Temporary as export procedure choice and continues")
      ProcedureChoicePage.fillPage("Temporary")
      CommonPage.continue()
      And("User lands on Authorisation-Required page")
      AuthorisationPage.checkPage()
      And("User selects first Authorisation code ACR and enters eori as GB123456789008 and continues")
      AuthorisationPage.fillPage(genSequenceId("first"), "ACR", "GB123456789008")
      CommonPage.continue()
      And("User lands on Authorisations-Required-List page")
      AuthorisationsListPage.checkPage()
      And("User selects No to add another authorisation and continues")
      AuthorisationsListPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-2 page")
      SummarySection2Page.checkPage()
      And("User checks the MiniCYA page for Section-2")
      SummarySection2Page.fillPage()
    }
  }

}
