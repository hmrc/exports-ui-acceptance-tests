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

package uk.gov.hmrc.test.ui.specs.Section5

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section5.*
import uk.gov.hmrc.test.ui.pages.section5.SummarySection5Page.{section5Journey1, section5Journey2}
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class SimplifiedJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section5 Simplified Journey") {
    Scenario("Perform a Low Value Simplified Arrived Declaration",Regression2,Regression,Section5,Simplified) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for SIMPLIFIED, arrived declaration")
      fillSection1ForDeclaration("SIMPLIFIED", "arrived")
      And("User fills section2/3/4 and continues their journey to Procedure-codes page")
      section5Journey1()
      And("User selects 1040 as procedure code and continues")
      ProcedureCodesPage.fillPage("1040")
      CommonPage.continue()
      And("User lands on Additional-Procedure-Codes page")
      AdditionalProcedureCodesPage.checkPage()
      And("User selects 3LV as additional procedure code and continues")
      AdditionalProcedureCodesPage.fillPage("3LV")
      CommonPage.continue()
      And("User lands on Commodity-Details page")
      CommodityDetailsPage.checkPage()
      And("User enters commodity details code as 90034008 and description as St Andrews golf ball whisky")
      CommodityDetailsPage.fillPage("90034008", "St Andrews golf ball whisky")
      CommonPage.continue()
      And("User navigates to Dangerous Goods Code page")
      DangerousGoodsCodePage.navigateToItemPage(DangerousGoodsCodePage.pageId)
      And("User selects Yes to enter the code 1204 as dangerous goods and continues")
      DangerousGoodsCodePage.fillPage("Yes", "1204")
      CommonPage.continue()
      //skipping cus code page//
      And("User lands on VAT-Rating page")
      VatRatingPage.checkPage()
      Then("User selects A 20% VAT rate will be paid in the UK option as goods being VAT zero-rated")
      VatRatingPage.fillPage("A 20% VAT rate will be paid in the UK")
      CommonPage.continue()
      And("User lands on National-Additional-Code page")
      NationalAdditionalCodesPage.checkPage()
      And("User selects Yes and enters D193 as national additional code and continues")
      NationalAdditionalCodesPage.fillPage("Yes", "D193")
      CommonPage.continue()
      And("User lands on National-Additional-Codes-List page")
      NationalAdditionalCodesListPage.checkPage()
      And("User selects No for adding another national code and continues")
      NationalAdditionalCodesListPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Statistical-Value page")
      StatisticalValuePage.checkPage()
      And("User enters 1000 as statistical value and continues")
      StatisticalValuePage.fillPage("1000")
      CommonPage.continue()
      And("User lands on Package-Information page")
      PackageInformationPage.checkPage()
      And("User enters Aerosol as package type, with 10 packages and 1034 as shipping mark for first package info and continues")
      PackageInformationPage.fillPage(genSequenceId("first"), "Aerosol", "10", "1034")
      CommonPage.continue()
      And("User lands on Package-Information-List page")
      PackageInformationListPage.checkPage()
      And("User selects No on package information list page and continues")
      PackageInformationListPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Additional-Information-YesNo page")
      AdditionalInformationYesNoPage.checkPage()
      And("User selects No to add additional information and continues")
      AdditionalInformationYesNoPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Licence-Required-YesNo page")
      LicenseRequiredYesNoPage.checkPage()
      And("User selects Yes to check if the goods require a licence and continues")
      LicenseRequiredYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Additional-Document page")
      AdditionalDocumentPage.checkPage()
      And("User enters C676 as code and GBAEOC70057 as identifier for first additional document and continues")
      AdditionalDocumentPage.fillPage(genSequenceId("first"), "C676", "GBAEOC70057")
      CommonPage.continue()
      And("User lands on Additional-Document-List page")
      AdditionalDocumentListPage.checkPage()
      And("User selects No on additional document list page and continues")
      AdditionalDocumentListPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Declaration-Items-List page")
      DeclarationItemsListPage.checkPage()
      And("User selects No on declaration items list page and continues")
      DeclarationItemsListPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()
    }
    /* 1.Checking Skipping of pages when procedure code is 1042 to 1040 for Simplified Journey
    # 2. Skipping of Statistical page and VAT rating page when declaration is not low value
    # 4. Checking Additional Documents Dynamic title when Authorisation code required documents is [No] and isLicenseRequired is [Yes]
    # 5. Change procedure code from 1040 to 1042 to check Fiscal-Information page of simplified Journey
*/
    Scenario(
      "Complete Items section on Simplified Prelodged declaration journey when declaration is not Low Value (using 000 additional procedure code)",Regression2,Regression,Section5,Simplified
    ) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for SIMPLIFIED, prelodged declaration")
      fillSection1ForDeclaration("SIMPLIFIED", "prelodged")
      And("User fills section2/3/4 and continues their journey to Procedure-codes page")
      section5Journey2()
      //validate skipping of fiscal information , additional-fiscal-references//
      And("User lands on Commodity-Details page")
      CommodityDetailsPage.checkPage()
      And("User enters commodity details code as 28034007 and description as St Andrews golf ball whisky and continues")
      CommodityDetailsPage.fillPage("28034007", "St Andrews golf ball whisky")
      CommonPage.continue()
      And("User navigates to Dangerous Goods Code page")
      DangerousGoodsCodePage.navigateToItemPage(DangerousGoodsCodePage.pageId)
      And("User selects Yes to enter the code 1204 as dangerous goods and continues")
      DangerousGoodsCodePage.fillPage("Yes", "1204")
      CommonPage.continue()
      And("User lands on Cus-Code page")
      CusCodePage.checkPage()
      And("User selects Yes to enter the code 12345678 as CUS code and continues")
      CusCodePage.fillPage("Yes", "12345678")
      CommonPage.continue()
      //Skipping VAT rating page//
      And("User lands on National-Additional-Code page")
      NationalAdditionalCodesPage.checkPage()
      And("User selects Yes and enters A103 as national additional code and continues")
      NationalAdditionalCodesPage.fillPage("Yes", "A103")
      CommonPage.continue()
      And("User lands on National-Additional-Codes-List page")
      NationalAdditionalCodesListPage.checkPage()
      And("User selects No for adding another national code and continues")
      NationalAdditionalCodesListPage.fillPage("No")
      CommonPage.continue()
      //Skipping Statistical-Value when additional procedure code is not a low value declaration "3LV"//
      And("User lands on Package-Information page")
      PackageInformationPage.checkPage()
      And("User enters Aerosol as package type, with 10 packages and 1034 as shipping mark for first package info")
      PackageInformationPage.fillPage(genSequenceId("first"), "Aerosol", "10", "1034")
      CommonPage.continue()
      And("User lands on Package-Information-List page")
      PackageInformationListPage.checkPage()
      And("User selects No on package information list page and continues")
      PackageInformationListPage.fillPage("No")
      CommonPage.continue()
      //Skipping Commodity-Measure, Supplementary-Units//
      And("User lands on Additional-Information-YesNo page")
      AdditionalInformationYesNoPage.checkPage()
      And("User selects No to add additional information")
      AdditionalInformationYesNoPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Licence-Required-YesNo page")
      LicenseRequiredYesNoPage.checkPage()
      And("User selects Yes to check if the goods require a licence and continues")
      LicenseRequiredYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Additional-Document page")
      AdditionalDocumentPage.checkPage()
      And("User enters C676 as code and GBAEOC71750 as identifier for first additional document and continues")
      AdditionalDocumentPage.fillPage(genSequenceId("first"), "C676", "GBAEOC71750")
      CommonPage.continue()
      And("User lands on Additional-Document-List page")
      AdditionalDocumentListPage.checkPage()
      And("User selects No on additional document list page and continues")
      AdditionalDocumentListPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Declaration-Items-List page")
      DeclarationItemsListPage.checkPage()
      And("User selects No on declaration items list page and continues")
      DeclarationItemsListPage.fillPage("No")
      CommonPage.continue()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()
      //check Fiscal Reference pages when Procedure code is 1042//
      And("User navigates to Procedure codes page")
      ProcedureCodesPage.navigateToItemPage(ProcedureCodesPage.pageId)
      And("User selects 1042 as procedure code and continues")
      ProcedureCodesPage.fillPage("1042")
      CommonPage.continue()
      And("User lands on Additional-Procedure-Codes page")
      AdditionalProcedureCodesPage.checkPage()
      And("User selects F75 as additional procedure code and continues")
      AdditionalProcedureCodesPage.fillPage("F75")
      CommonPage.continue()
      And("User lands on Fiscal-Information page")
      FiscalReferencesYesNoPage.checkPage()
      And("User selects Yes for Onward supply relief and continues")
      FiscalReferencesYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Additional-Fiscal-References page")
      FiscalReferencesPage.checkPage()
      And("User selects VAT registered country as Andorra : AD and VAT number as 1234 and continues")
      FiscalReferencesPage.fillPage("Andorra", "AD", "1234")
      CommonPage.continue()
      Then("User navigate to MiniCYA-Section-5 page")
      SummarySection5Page.navigateToPage(SummarySection5Page.path)
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()
    }
  }

}
