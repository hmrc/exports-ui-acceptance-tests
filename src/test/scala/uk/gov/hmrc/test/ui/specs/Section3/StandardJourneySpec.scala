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
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, clearKeysFromCache, fillSection1ForDeclaration, fillSection2ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section2.{AuthorisationPage, AuthorisationRemovePage, AuthorisationsListPage, AuthorisationsYesNoPage}
import uk.gov.hmrc.test.ui.pages.section3.*
import uk.gov.hmrc.test.ui.pages.section3.SummarySection3Page.completeSection3Standard
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class StandardJourneySpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Section3 Standard Journey") {
    Scenario("Complete Routes and Locations section on standard prelodged declaration journey",Regression1,Regression,Section3,Standard,Smoke) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, prelodged declaration")
      fillSection1ForDeclaration("STANDARD", "prelodged")
      And("User fills section2")
      fillSection2ForDeclaration()
      And("User continue their journey through Destination-Country page to Location-Of-Goods page")
      completeSection3Standard()
      And("User selects Yes to provide location as GBCUASDDOVAPF and continues")
      LocationOfGoodsPage.fillPage("Yes", "GBCUASDDOVAPF")
      CommonPage.continue()
      And("User lands on Office-Of-Exit page")
      OfficeOfExitPage.checkPage()
      And("User selects Aberdeen with code GB000434 as the office of exit nd continues")
      OfficeOfExitPage.fillPage("Aberdeen", "GB000434")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-3 page")
      SummarySection3Page.checkPage()
      And("User checks the MiniCYA page for Section-3")
      SummarySection3Page.fillPage()
      And("User clicks continue on MiniCya")
      CommonPage.continueOnMiniCya()
    }
    Scenario("Complete Routes and Locations section on standard arrived declaration and also validate dynamic title changes on location of goods page",Regression1,Regression,Section3,Standard) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, arrived declaration")
      fillSection1ForDeclaration("STANDARD", "arrived")
      And("User fills section2")
      fillSection2ForDeclaration()
      And("User continue their journey through Destination-Country page to Location-Of-Goods page")
      completeSection3Standard()
      And("User selects Dover as the location and continues")
      LocationOfGoodsPage.fillPage("Dover")
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

      /*change authorisation code to test dynamic title changes on location of goods page
      * check title on location of goods page when auth code is CSE*/
      When("User clears Additional Information code keys from cache")
      clearKeysFromCache("Additional Information code")
      And("User lands on authorisations required list page")
      AuthorisationsListPage.navigateToPage(AuthorisationsListPage.path)
      And("User clicks on remove link")
      AuthorisationsListPage.removeAuthCode(0)
      And("User lands on Authorisations-Remove page")
      AuthorisationRemovePage.checkPage()
      And("User selects Yes to remove authorisation and continues")
      AuthorisationRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User selects Yes to declare authorisations and continues")
      AuthorisationsYesNoPage.fillPage("Yes")
       CommonPage.continue()
      And("User lands on Authorisation-Required page")
      AuthorisationPage.checkPage()
      And("User selects first Authorisation code CSE and enters eori as GB123456789006 and continues")
      AuthorisationPage.fillPage(genSequenceId("first"), "CSE", "GB123456789006")
      CommonPage.continue()
      And("User navigates to Location Of Goods page")
      LocationOfGoodsPage.navigateToPage(LocationOfGoodsPage.path)
      And("User selects Yes to provide location as GBBUBHMLDJCSE and continue")
      LocationOfGoodsPage.fillPage("Yes", "GBBUBHMLDJCSE")
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
        /*check title on location of goods page when auth code is EXRR
        * select GVMS codes on different version of location page when auth code is EXRR and Additional Declaration type is 'Arrived'*/

      When("User navigates to authorisations required list page")
      AuthorisationsListPage.navigateToPage(AuthorisationsListPage.path)
      And("User clicks on remove link")
      AuthorisationsListPage.removeAuthCode(0)
      And("User lands on Authorisations-Remove page")
      AuthorisationRemovePage.checkPage()
      And("User selects Yes to remove authorisation and continues")
      AuthorisationRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User selects Yes to declare authorisations and continues")
      AuthorisationsYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Authorisation-Required page")
      AuthorisationPage.checkPage()
      And("User selects first Authorisation code EXRR and enters eori as GB123456789016 and continues")
      AuthorisationPage.fillPage(genSequenceId("first"), "EXRR", "GB123456789016")
      CommonPage.continue()
      And("User navigates to Location Of Goods page")
      LocationOfGoodsPage.navigateToPage(LocationOfGoodsPage.path)
      And("User lands on Location-Of-Goods page")
      LocationOfGoodsPage.checkPage()
      And("User selects Holyhead as the location and continues")
      LocationOfGoodsPage.fillPage("Holyhead")
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
     /*select GVMS codes on different version of location page when auth code is ACP and
      Additional Declaration type is 'Arrived'*/
      When("User clears Additional Information code keys from cache")
      clearKeysFromCache("Additional Information code")
      And("User navigates to authorisations required list page")
      AuthorisationsListPage.navigateToPage(AuthorisationsListPage.path)
      And("User clicks on remove link")
      AuthorisationsListPage.removeAuthCode(0)
      And("User lands on Authorisations-Remove page")
      AuthorisationRemovePage.checkPage()
      And("User selects Yes to remove authorisation and continues")
      AuthorisationRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User selects Yes to declare authorisations and continues")
      AuthorisationsYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Authorisation-Required page")
      AuthorisationPage.checkPage()
      And("User selects first Authorisation code ACP and enters eori as GB123456789206 and continues")
      AuthorisationPage.fillPage(genSequenceId("first"), "ACP", "GB123456789206")
      CommonPage.continue()
      And("User navigates to Location Of Goods page")
      LocationOfGoodsPage.navigateToPage(LocationOfGoodsPage.path)
      And("User selects User Choice to provide location as GBCUASDDOVAPF and continues")
      LocationOfGoodsPage.fillPage("User Choice", "GBCUASDDOVAPF")
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
    }
    }

}
