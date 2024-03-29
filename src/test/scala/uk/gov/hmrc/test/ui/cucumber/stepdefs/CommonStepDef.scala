/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.cucumber.stepdefs.CommonStepDef.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{continue, continueOnMiniCya}
import uk.gov.hmrc.test.ui.pages.base.Constants.yes
import uk.gov.hmrc.test.ui.pages.base.{CommonPage, Constants}
import uk.gov.hmrc.test.ui.pages.section1._
import uk.gov.hmrc.test.ui.pages.section2._
import uk.gov.hmrc.test.ui.pages.section3._
import uk.gov.hmrc.test.ui.pages.section4._
import uk.gov.hmrc.test.ui.pages.section5._
import uk.gov.hmrc.test.ui.pages.section6.{ContainerListPage, ContainerPage, ExpressConsignmentPage, InlandModeOfTransportPage, InlandOrBorderPage, SealYesNoPage, SupervisingCustomsOfficePage, TransportLeavingTheBorderPage, TransportPaymentPage}

class CommonStepDef extends BaseStepDef {

  And("""^I click continue""")(() => CommonPage.continue())

  And("""^I click continue on MiniCya""")(() => CommonPage.continueOnMiniCya())

  And("""^I fill section1""") { () =>
    LoginPage.fillPage("GB123456789000"); continue()
    ChoicePage.fillPage("create a declaration")
    StandardOrOtherPage.fillPage("STANDARD"); continue()
    DeclarationTypePage.fillPage("prelodged"); continue()
    DeclarantDetailsPage.fillPage(yes); continue()
    DoYouHaveADucrPage.fillPage(yes); continue()
    DucrEntryPage.fillPage("3GB986007773125-INVOICE123"); continue()
    LrnPage.fillPage("MSLRN2872100"); continue()
    LinkMucrPage.fillPage(yes); continue()
    EnterAMucrPage.fillPage("GB/AZ09-B12345"); continue()
    continueOnMiniCya()
  }

  And("""^I fill section2""") { () =>
    AreYouTheExporterPage.fillPage(Constants.no); continue()
    ExporterEORINumberPage.fillPage(Constants.no); continue()
    ExporterAddressPage.fillPage(Constants.Address: _*); continue()
    OnBehalfOfAnotherAgentPage.fillPage(Constants.no); continue()
    RepresentativesEORINumberPage.fillPage("GB121012121212"); continue()
    RepresentationTypeAgreedPage.fillPage("Direct"); continue()
    CarrierEORINumberPage.fillPage(Constants.no); continue()
    CarrierAddressPage.fillPage(Constants.Address: _*); continue()
    ConsigneeDetailsPage.fillPage(Constants.Address: _*); continue()
    OtherPartiesInvolvedPage.fillPage(genSequenceId("first"), "Consolidator", "GB121212121212"); continue()
    OtherPartiesInvolvedListPage.fillPage(Constants.no); continue()
    ProcedureChoicePage.fillPage("Permanent"); continue()
    AuthorisationsYesNoPage.fillPage(yes); continue()
    AuthorisationPage.fillPage(genSequenceId("first"), "ACR", "GB123456789008"); continue()
    AuthorisationsListPage.fillPage(Constants.no); continue()
    continueOnMiniCya()
  }

  And("""^I fill section3""") { () =>
    DestinationCountryPage.fillPage("China"); continue()
    CountryOfRoutingPage.fillPage(Constants.no); continue()
    LocationOfGoodsPage.fillPage(Constants.no, "GBAUNHVNHVNHVVVM"); continue()
    OfficeOfExitPage.fillPage("Folkestone", "GB000041"); continue()
    continueOnMiniCya()
  }

  And("""^I fill section4""") { () =>
    InvoicesAndExchangeRateChoicePage.fillPage(Constants.no); continue()
    InvoicesAndExchangeRatePage.fillPage("GBP", "567640", "1.25"); continue()
    TotalPackageQuantityPage.fillPage("4"); continue()
    NatureOfTransactionPage.fillPage("Goods being sol"); continue()
    PreviousDocumentPage.fillPage("first", "Commercial Invoice", "9GB123456782317-BH1433A61"); continue()
    PreviousDocumentListPage.fillPage(Constants.no); continue()
    continueOnMiniCya()
  }

  And("""^I fill section5""") { () =>
    AddDeclarationItemPage.fillPage()
    ProcedureCodesPage.fillPage("1042"); continue()
    AdditionalProcedureCodesPage.fillPage("F75"); continue()
    FiscalReferencesYesNoPage.fillPage(Constants.no); continue()
    CommodityDetailsPage.fillPage("4203400090", "Straw for bottles"); continue()
    DangerousGoodsCodePage.fillPage(Constants.no); continue()
    NationalAdditionalCodesPage.fillPage(Constants.no); continue()
    StatisticalValuePage.fillPage("1000"); continue()
    PackageInformationPage.fillPage("1", "Aerosol", "20", "No shipping mark"); continue()
    PackageInformationListPage.fillPage(Constants.no); continue()
    CommodityMeasurePage.fillPage("500", "700"); continue()
    SupplementaryUnitsPage.fillPage(Constants.yes, "12"); continue()
    AdditionalInformationYesNoPage.fillPage(Constants.no); continue()
    LicenseRequiredYesNoPage.fillPage(Constants.yes); continue()
    AdditionalDocumentPage.fillPage("1", "C501", "GBAEOC717572504502801"); continue()
    AdditionalDocumentListPage.fillPage(Constants.no); continue()
    DeclarationItemsListPage.fillPage(Constants.no); continue()
    continueOnMiniCya()
  }


  And("""^I fill section6""") { () =>
    TransportLeavingTheBorderPage.fillPage("Sea transport"); continue()
    SupervisingCustomsOfficePage.fillPage("GBBTH001"); continue()
    InlandOrBorderPage.fillPage("Customs controlled location"); continue()
    InlandModeOfTransportPage.fillPage("Postal or mail"); continue()
    ExpressConsignmentPage.fillPage("Yes"); continue()
    TransportPaymentPage.fillPage("Payment in cash"); continue()
    ContainerPage.fillPage("Yes", "Container1"); continue()
    SealYesNoPage.fillPage("No"); continue()
    ContainerListPage.fillPage("No"); continue()
    continueOnMiniCya()
  }
}

object CommonStepDef {
  def genSequenceId(seqId: String): String =
    seqId match {
      case "first"  => "0"
      case "second" => "1"
      case "third"  => "2"
    }
}
