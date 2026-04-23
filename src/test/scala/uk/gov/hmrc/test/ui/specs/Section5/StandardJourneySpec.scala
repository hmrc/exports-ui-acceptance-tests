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

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.*
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, clearCacheForSection, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section5.*
import uk.gov.hmrc.test.ui.pages.section5.SummarySection5Page.*
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class StandardJourneySpec
    extends AnyFeatureSpec with BaseSpec with GivenWhenThen with ShouldVerb with BeforeAndAfterAll
    with BeforeAndAfterEach with Browser with TableDrivenPropertyChecks with ScreenshotOnFailure {
  Feature("Section4 Standard Journey") {
    /*1. Check Items section with 1042 procedure code which enables Fiscal References pages
     2. Checking CusCode page is displayed after providing commodity code as 2803400090
     3. Checking remove link functionality on  Additional Fiscal References, Nact Code, Package Information, Additional Information and Additional Documents list pages
     4. skipping of documents required yes/no page
     5. Checking Additional Documents Dynamic title when Authorisation code required documents is [Yes] and isLicenseRequired is [Yes]*/
    Scenario(
      "Complete Items section on Standard Prelodged declaration journey and remove information on all list page",Regression2,Regression,Section5,Standard,Smoke
    ) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, prelodged declaration")
      fillSection1ForDeclaration("STANDARD", "prelodged")
      And("User fills section2/3/4 and continues their journey to Procedure-codes page")
      section5Journey1()
      And("User then continues their journey to Commodity-Details page")
      section5ProcedureCodesPageToCommodityDetailsPage()
      And(
        "User enters commodity details code as 28034000 and description as Old St Andrews golf ball whisky and continues"
      )
      CommodityDetailsPage.fillPage("28034000", "Old St Andrews golf ball whisky")
      CommonPage.continue()
      And("User lands on Dangerous-Goods-Code page")
      DangerousGoodsCodePage.checkPage()
      And("User selects Yes to enter the code 1234 as dangerous goods and continues")
      DangerousGoodsCodePage.fillPage("Yes", "1234")
      CommonPage.continue()
      And("User lands on Cus-Code page")
      CusCodePage.checkPage()
      And("User selects Yes to enter the code 12345678 as CUS code and continues")
      CusCodePage.fillPage("Yes", "12345678")
      CommonPage.continue()
      And("User lands on VAT-Rating page")
      VatRatingPage.checkPage()
      Then("User selects The goods are zero-rated option as goods being VAT zero-rated and continues")
      VatRatingPage.fillPage("The goods are zero-rated")
      CommonPage.continue()
      And("User lands on National-Additional-Code page")
      NationalAdditionalCodesPage.checkPage()
      And("User selects Yes and enters A123 as national additional code and continues")
      NationalAdditionalCodesPage.fillPage("Yes", "A123")
      CommonPage.continue()
      And("User lands on National-Additional-Codes-List page")
      NationalAdditionalCodesListPage.checkPage()
      And("User selects No for adding another national code and continues")
      NationalAdditionalCodesListPage.fillPage("No")
      CommonPage.continue()
      // submit statistical value page without any value//
      And("User lands on Statistical-Value page and continues")
      StatisticalValuePage.checkPage()
      CommonPage.continue()
      And("User lands on Package-Information page")
      PackageInformationPage.checkPage()
      And(
        "User enters Aerosol as package type, with 20 packages and 1234 as shipping mark for first package info and continues"
      )
      PackageInformationPage.fillPage(genSequenceId("first"), "Aerosol", "20", "1234")
      CommonPage.continue()
      And("User lands on Package-Information-List page")
      PackageInformationListPage.checkPage()
      And("User selects No on package information list page and continues")
      PackageInformationListPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Commodity-Measure page")
      CommodityMeasurePage.checkPage()
      And("User enters gross weight as 50000000.000 and net weight as 71000000.000 and continues")
      CommodityMeasurePage.fillPage("50000000.000", "71000000.000")
      CommonPage.continue()
      And("User lands on Supplementary-Units page")
      SupplementaryUnitsPage.checkPage()
      And("User selects Yes and enters 30 as supplementary units and continues")
      SupplementaryUnitsPage.fillPage("Yes", "30")
      CommonPage.continue()
      And("User lands on Additional-Information-YesNo page")
      AdditionalInformationYesNoPage.checkPage()
      And("User selects Yes to add additional information and continues")
      AdditionalInformationYesNoPage.fillPage("Yes")
      CommonPage.continue()
      And("User lands on Additional-Information page")
      AdditionalInformationPage.checkPage()
      And(
        "User enters 00400 as code and EXPORTER as required information as first additional information and continues"
      )
      AdditionalInformationPage.fillPage(genSequenceId("first"), "00400", "EXPORTER")
      CommonPage.continue()
      And("User lands on Additional-Information-List page")
      AdditionalInformationListPage.checkPage()
      And("User selects No on additional information list page and continues")
      AdditionalInformationListPage.fillPage("No")
      CommonPage.continue()
      And("User lands on Licence-Required-YesNo page")
      LicenseRequiredYesNoPage.checkPage()
      And("User selects Yes to check if the goods require a licence and continues")
      LicenseRequiredYesNoPage.fillPage("Yes")
      CommonPage.continue()
      // skipping of documents required yes/no page and landing on addition documents page//
      And("User lands on Additional-Document page")
      AdditionalDocumentPage.checkPage()
      And("User enters C501 as code and GBAEOC71757 as identifier for first additional document and continues")
      AdditionalDocumentPage.fillPage(genSequenceId("first"), "C501", "GBAEOC71757")
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
      /*remove added details on Additional Procedure code, Additional Fiscal References, Nact Code, Package Information,
       Additional Information and Additional Documents*/
      When("User navigates to Additional Fiscal References List page")
      FiscalReferencesListPage.navigateToItemPage(FiscalReferencesListPage.pageId)
      And("User clicks remove on Additional Fiscal References List page")
      FiscalReferencesListPage.removeFiscalReferences(0)
      And("User selects Yes to remove Fiscal References and continues")
      FiscalReferencesRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User lands on Fiscal-Information page")
      FiscalReferencesYesNoPage.checkPage()
      Then("User navigates to MiniCYA page for Section-5")
      SummarySection5Page.navigateToPage(SummarySection5Page.path)
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()

      When("User navigates to NACT code list page")
      NationalAdditionalCodesListPage.navigateToItemPage(NationalAdditionalCodesListPage.pageId)
      And("User clicks remove on NACT code List page")
      NationalAdditionalCodesListPage.removeNactCode(0)
      And("User selects Yes to remove National Additional Code and continues")
      NationalAdditionalCodeRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User lands on National-Additional-Code page")
      NationalAdditionalCodesPage.checkPage()
      Then("User navigates to MiniCYA page for Section-5")
      SummarySection5Page.navigateToPage(SummarySection5Page.path)
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()

      When("User navigates to Package Information list page")
      PackageInformationListPage.navigateToItemPage(PackageInformationListPage.pageId)
      And("User clicks remove on Package Information List page")
      PackageInformationListPage.removePackageInformation(0)
      And("User selects Yes to remove Package Information and continues")
      PackageInformationRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User lands on Package-Information page")
      PackageInformationPage.checkPage()
      Then("User navigates to MiniCYA page for Section-5")
      SummarySection5Page.navigateToPage(SummarySection5Page.path)
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()

      When("User navigates to Additional Information list page")
      AdditionalInformationListPage.navigateToItemPage(AdditionalInformationListPage.pageId)
      And("User clicks remove on Additional Information List page")
      AdditionalInformationListPage.removeAdditionalInformation(0)
      And("User selects Yes to remove Additional Information and continues")
      AdditionalInformationRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User lands on Additional-Information-YesNo page")
      AdditionalInformationYesNoPage.checkPage()
      Then("User navigates to MiniCYA page for Section-5")
      SummarySection5Page.navigateToPage(SummarySection5Page.path)
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()

      When("User navigates to Additional Documents list page")
      AdditionalDocumentListPage.navigateToItemPage(AdditionalDocumentListPage.pageId)
      And("User clicks remove on Additional Documents List page")
      AdditionalDocumentListPage.removeAdditionalDocuments(0)
      And("User selects Yes to remove Additional Documents and continues")
      AdditionalDocumentRemovePage.fillPage("Yes", "0")
      CommonPage.continue()
      And("User lands on Additional-Document page")
      AdditionalDocumentPage.checkPage()
      Then("User navigates to MiniCYA page for Section-5")
      SummarySection5Page.navigateToPage(SummarySection5Page.path)
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()
    }
    
    /*Below scenario -
     1. Checking Skipping of pages when procedure code is 1042 to 1040
     1. Checking Additional Documents Dynamic title when Authorisation code required documents is [Yes] and isLicenseRequired is [No]*/
    Scenario(
      "Complete Items section on Standard Prelodged declaration journey and validate different page skipping scenarios",Regression2,Regression,Section5,Standard
    ) {
      Given("the user clears data in cache")
      background()
      When("User fills Section1 for STANDARD, prelodged declaration")
      fillSection1ForDeclaration("STANDARD", "prelodged")
      And("User fills section2/3/4 and continues their journey to Procedure-codes page")
      section5Journey1()
      And("User selects 1040 as procedure code and continues")
      ProcedureCodesPage.fillPage("1040")
      CommonPage.continue()
      And("User lands on Additional-Procedure-Codes page")
      AdditionalProcedureCodesPage.checkPage()
      And("User selects 000 as additional procedure code and continues")
      AdditionalProcedureCodesPage.fillPage("000")
      CommonPage.continue()
      // validate skipping of fiscal information , additional-fiscal-references//
      And("User lands on Commodity-Details page")
      CommodityDetailsPage.checkPage()
      And("User enters commodity details code as 90034000 and description as St Andrews golf ball whisky and continues")
      CommodityDetailsPage.fillPage("90034000", "St Andrews golf ball whisky")
      CommonPage.continue()

      /**
       * skipping Cus Code Page when commodity details code doesnot end with 28,29,38 and
       * VAT rating page when nature of transcation select option is not Goods being sold or Item purchased
       */
      And("User navigates from  Nature Of Transaction page to DeclarationItemsListPage")
      section5NatureOfTransactionPageToDeclarationItemsListPage()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()
    }
    /* 1. Standard Arrived Declaration
       2. Select No option on Additional Fiscal References, DangerousGoods, CusCode, Nact Code, Supplementary units,
       Additional Information and Additional Documents pages
       3. Checking Is Additional Documents Required Page is visible*/
    Scenario(
      "Complete Items section on Standard Arrived declaration journey and with answers No on various item pages",Regression2,Regression,Section5,Standard
    ) {
      Given("the user clears data in cache")
      background()
      And("User clears cache for section 5")
      clearCacheForSection(5)
      When("User fills Section1 for STANDARD, arrived declaration")
      fillSection1ForDeclaration("STANDARD", "arrived")
      And("User fills section2/3/4 and continues adding details aand navigates to Declaration-Items-List page")
      section5Journey3()
      Then("User should land on MiniCYA-Section-5 page")
      SummarySection5Page.checkPage()
      And("User checks the MiniCYA page for Section-5")
      SummarySection5Page.fillPage()
    }
  }

}
