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
import uk.gov.hmrc.test.ui.pages.base.CommonPage.background
import uk.gov.hmrc.test.ui.specs.BaseSpec

class ClearanceJourneySpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Section2 Clearance Prelodged") {
    //Below scenario - DoYouHaveADucr:[Yes]//
    Scenario("Exports Clearance Prelodged Scenario with possible scenarios") {
      Given("the user clears data in cache")
      background()
      Given("User fills section1 for CLEARANCE, prelodged declaration")

      Then("User should land on Entry-Into-Declarant-Records page")

      And("User selects No to is this an entry into declarant records")

      And("User clicks continue")

      Then("User should land on Declarant-Details page")

      And("User selects Yes to confirm their eori")

      And("User clicks continue")

      Then("User should land on Are-You-The-Exporter page")

      And("User selects No to I am the Exporter")

      And("User clicks continue")

      Then("User should land on Exporter-Eori-Number page")

      And("User selects No on exporter eori number page")

      And("User clicks continue")

      Then("User should land on Exporter-Address page")

      And("User provides Exporter Address Details")

      And("User clicks continue")

      Then("User should land on Is-This-Exs page")

      And("User selects Yes to is this exs")

      And("User clicks continue")

      Then("User should land on Consignor-EORI-Number page")

      And("User selects No to consignor eori number")

      And("User clicks continue")

      Then("User should land on Consignor-Address page")

      And("User provides consignor details")

      And("User clicks continue")

      Then("User should land on Third-Party-Goods-Transportation page")

      And("User selects No on third party goods transportation page")

      And("User clicks continue")

      Then("User should land on Consignee-Details page")

      And("User provides consignee details")

      And("User clicks continue")

      Then("User should land on Is-Authorisation-Required page")

      And("User selects Yes to declare authorisations")

      And("User clicks continue")

      And("User selects first Authorisation code ACR and enters eori as GB123456789008")

      And("User clicks continue")

      Then("User should land on Authorisations-Required-List page")

      And("User selects No to add another authorisation")

      And("User clicks continue")

      Then("User should land on MiniCYA-Section-2 page")

      And("User checks the MiniCYA page for Section-2")

      And("User clicks continue on MiniCya")

      And("User navigates to Entry Into Declarant Records page")

      Then("User selects Yes to is this an entry into declarant records")

      And("User clicks continue")

      Then("User should land on Person-Presenting-Goods page")

      And("User enters entered eori as GB121212121212")

      And("User clicks continue")

      Then("User should land on Exporter-Eori-Number page")

      And("User navigates to Summary Section2 page")

      And("User checks the MiniCYA page for Section-2")

      And("User clears Exporter’s details, Consignor’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation, Carrier or haulier’s details, Carrier or haulier’s EORI number keys from cache")

      Then("User navigates to Is This EXS page")

      And("User selects No to is this exs")

      And("User clicks continue")

      Then("User navigates to On-Behalf-Of-Another-Agent page")

      And("User selects No to hold the contract")

      And("User clicks continue")

      Then("User should land on Representatives-Eori-Number page")

      And("User provides Representatives Eori as GB121012121212")

      And("User clicks continue")

      Then("User should land on Representation-Type-Agreed page")

      And("User selects Direct as the type of representation")

      And("User clicks continue")

      Then("User should land on Consignee-Details page")

      And("User navigates to Summary Section2 page")

      And("User checks the MiniCYA page for Section-2")

      And("User clears Is this an EIDR?, Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation keys from cache")

      And("User navigates to Entry Into Declarant Records page")

      And("User selects Yes to is this an entry into declarant records")

      And("User clicks continue")

      Then("User should land on Person-Presenting-Goods page")

      And("User enters entered eori as GB123456789123")

      And("User clicks continue")

      Then("User should land on Exporter-Eori-Number page")

      And("User selects Yes on exporter eori number page and enters eori number as GB171357178688000")

      And("User clicks continue")

      Then("User should land on Is-This-Exs page")

      And("User selects Yes to is this exs")

      And("User clicks continue")

      Then("User should land on Consignor-EORI-Number page")

      And("User selects Yes on consignor eori number page and enters eori number as GB123456789124")

      And("User clicks continue")

      Then("User should land on Third-Party-Goods-Transportation page")

      And("User selects No on third party goods transportation page")

      And("User clicks continue")

      Then("User should land on Consignee-Details page")

      And("User provides consignee details")

      And("User clicks continue")

      Then("User should land on Authorisation-Choice page")

      And("User navigates to Summary Section2 page")

      And("User checks the MiniCYA page for Section-2")

    }
    Scenario("Exports Clearance Arrived Scenario which covers maximum number of pages"){
      Given("the user clears data in cache")
      background()
      Given("User fills section1 for CLEARANCE, arrived declaration")

      Then("User should land on Entry-Into-Declarant-Records page")

      And("User selects No to is this an entry into declarant records")

      And("User clicks continue")

      Then("User should land on Declarant-Details page")

      And("User selects Yes to confirm their eori")

      And("User clicks continue")

      Then("User should land on Are-You-The-Exporter page")

      And("User selects No to I am the Exporter")

      And("User clicks continue")

      Then("User should land on Exporter-Eori-Number page")

      And("User selects No on exporter eori number page")

      And("User clicks continue")

      Then("User should land on Exporter-Address page")

      And("User provides Exporter Address Details")

      And("User clicks continue")

      Then("User should land on Is-This-Exs page")

      And("User selects Yes to is this exs")

      And("User clicks continue")

      Then("User should land on Consignor-EORI-Number page")

      And("User selects No to consignor eori number")

      And("User clicks continue")

      Then("User should land on Consignor-Address page")

      And("User provides consignor details")

      And("User clicks continue")

      Then("User should land on Third-Party-Goods-Transportation page")

      And("User selects No on third party goods transportation page")

      And("User clicks continue")

      Then("User should land on Consignee-Details page")

      And("User provides consignee details")

      And("User clicks continue")

      Then("User should land on Is-Authorisation-Required page")

      And("User selects Yes to declare authorisations")

      And("User clicks continue")

      And("User selects first Authorisation code ACR and enters eori as GB123456789008")

      And("User clicks continue")

      Then("User should land on Authorisations-Required-List page")

      And("User selects No to add another authorisation")

      And("User clicks continue")

      Then("User should land on MiniCYA-Section-2 page")

      And("User checks the MiniCYA page for Section-2")

      And("User clicks continue on MiniCya")
    }

    }

}
