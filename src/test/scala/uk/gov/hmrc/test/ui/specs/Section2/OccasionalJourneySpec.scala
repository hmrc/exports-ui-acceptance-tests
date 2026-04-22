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
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.{CommonPage, Constants}
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section2.*
import uk.gov.hmrc.test.ui.specs.BaseSpec

class OccasionalJourneySpec extends AnyFeatureSpec
  with BaseSpec 
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach 
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure {
  Feature("Section2 Occasional Journey Scenarios") {
    Scenario("Exports Occasional declaration (Prelodged and Arrived)") {
      forAll(Table ("Type", "arrived", "prelodged")) { Type =>
        Given("the user clears data in cache")
        background()
        When(s"User fills Section1 for OCCASIONAL, $Type declaration")
        fillSection1ForDeclaration("OCCASIONAL", Type)
        And("User lands on Are-You-The-Exporter page")
        AreYouTheExporterPage.checkPage()
        And("User selects No to 'I am the Exporter' and continues")
        AreYouTheExporterPage.fillPage("No")
        CommonPage.continue()
        And("User lands on Exporter-Eori-Number page")
        ExporterEORINumberPage.checkPage()
        And("User selects Yes and enters exporter EORI GB121012121214 and continues")
        ExporterEORINumberPage.fillPage("Yes", "GB121012121214")
        CommonPage.continue()
        And("User lands on On-Behalf-Of-Another-Agent page")
        OnBehalfOfAnotherAgentPage.checkPage()
        And("User selects No to hold the contract and continues")
        OnBehalfOfAnotherAgentPage.fillPage("No")
        CommonPage.continue()
        And("User lands on Representatives-Eori-Number page")
        RepresentativesEORINumberPage.checkPage()
        And("User enters Representatives EORI GB121012121212 and continues")
        RepresentativesEORINumberPage.fillPage("GB121012121212")
        CommonPage.continue()
        And("User lands on Representation-Type-Agreed page")
        RepresentationTypeAgreedPage.checkPage()
        And("User selects Direct representation and continues")
        RepresentationTypeAgreedPage.fillPage("Direct")
        CommonPage.continue()
        And("User lands on Third-Party-Goods-Transportation page")
        ThirdPartyGoodsTransportationPage.checkPage()
        And("User selects Yes and continues")
        ThirdPartyGoodsTransportationPage.fillPage("Yes")
        CommonPage.continue()
        And("User lands on Carrier-Eori-Number page")
        CarrierEORINumberPage.checkPage()
        And("User selects No and continues")
        CarrierEORINumberPage.fillPage("No")
        CommonPage.continue()
        And("User lands on Carrier-Address page")
        CarrierAddressPage.checkPage()
        And("User provides Carrier Address details and continues")
        CarrierAddressPage.fillPage(Constants.Address: _*)
        CommonPage.continue()
        And("User lands on Consignee-Details page")
        ConsigneeDetailsPage.checkPage()
        And("User provides consignee details and continues")
        ConsigneeDetailsPage.fillPage(Constants.Address: _*)
        CommonPage.continue()
        And("User lands on Other-Parties-Involved page")
        OtherPartiesInvolvedPage.checkPage()
        And("User selects Additional freight forwarder with EORI GB121212121212 and continues")
        OtherPartiesInvolvedPage.fillPage(genSequenceId("first"), "Additional freight forwarder", "GB121212121212")
        CommonPage.continue()
        And("User lands on Other-Parties-Involved-List page")
        OtherPartiesInvolvedListPage.checkPage()
        And("User selects No and continues")
        OtherPartiesInvolvedListPage.fillPage("No")
        CommonPage.continue()
        And("User lands on Is-Authorisation-Required page")
        AuthorisationsYesNoPage.checkPage()
        And("User selects Yes and continues")
        AuthorisationsYesNoPage.fillPage("Yes")
        CommonPage.continue()
        And("User lands on Authorisation-Required page")
        AuthorisationPage.checkPage()
        And("User selects first Authorisation code ACR and enter eori as GB123456789008, then continues")
        AuthorisationPage.fillPage(genSequenceId("first"), "ACR", "GB123456789008")
        CommonPage.continue()
        And("User lands on Authorisations-Required-List page")
        AuthorisationsListPage.checkPage()
        And("User selects No to adding another authorisation and continues")
        AuthorisationsListPage.fillPage("No")
        CommonPage.continue()
        Then("User should land on MiniCYA-Section-2 page")
        SummarySection2Page.checkPage()
        And("User checks the MiniCYA page for Section-2")
        SummarySection2Page.fillPage()
      }

    }

  }

}
