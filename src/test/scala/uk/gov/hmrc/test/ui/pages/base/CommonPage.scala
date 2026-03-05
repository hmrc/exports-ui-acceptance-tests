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

package uk.gov.hmrc.test.ui.pages.base

import org.scalatest.matchers.must.Matchers.mustBe
import uk.gov.hmrc.test.ui.generator.SupportGenerator.generateEORI
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.Constants.yes
import uk.gov.hmrc.test.ui.pages.common.DashboardPage.validateDeclarationDetailsOnDeclarationInformationPage
import uk.gov.hmrc.test.ui.pages.common.{ConfirmationPage, CopyDeclarationPage, DashboardPage, DeclarationHoldingPage, DeclarationInformationPage, SubmitYourDeclarationPage, SummaryPage}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationChoicePage.{isClearance, isOccasional, isSimplified, isSupplementary}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationTypePage.isArrivedDeclaration
import uk.gov.hmrc.test.ui.pages.section1.*
import uk.gov.hmrc.test.ui.pages.section1.StandardOrOtherPage.isStandard
import uk.gov.hmrc.test.ui.pages.section2.AreYouTheExporterPage.isExporter
import uk.gov.hmrc.test.ui.pages.section2.IsThisExsPage.isThisExs
import uk.gov.hmrc.test.ui.pages.section2.{AreYouTheExporterPage, AuthorisationPage, AuthorisationsListPage, AuthorisationsYesNoPage, CarrierAddressPage, CarrierEORINumberPage, ConsigneeDetailsPage, EntryIntoDeclarantRecordsPage, ExporterAddressPage, ExporterEORINumberPage, IsThisExsPage, OnBehalfOfAnotherAgentPage, OtherPartiesInvolvedListPage, OtherPartiesInvolvedPage, PersonPresentingGoodsPage, ProcedureChoicePage, RepresentationTypeAgreedPage, RepresentativesEORINumberPage, ThirdPartyGoodsTransportationPage}
import uk.gov.hmrc.test.ui.pages.section3.LocationOfGoodsPage.hasAuthorisationType
import uk.gov.hmrc.test.ui.pages.section3.{CountryOfRoutingPage, DestinationCountryPage, LocationOfGoodsPage, OfficeOfExitPage}
import uk.gov.hmrc.test.ui.pages.section4.{InvoicesAndExchangeRateChoicePage, InvoicesAndExchangeRatePage, NatureOfTransactionPage, PreviousDocumentListPage, PreviousDocumentPage, TotalPackageQuantityPage}
import uk.gov.hmrc.test.ui.pages.section5.ProcedureCodesPage.{goToWarehouse, hasSupervisingCustomsOfficePageVisiblePC}
import uk.gov.hmrc.test.ui.pages.section5.{AddDeclarationItemPage, AdditionalDocumentListPage, AdditionalDocumentPage, AdditionalInformationYesNoPage, AdditionalProcedureCodesPage, CommodityDetailsPage, CommodityMeasurePage, DangerousGoodsCodePage, DeclarationItemsListPage, FiscalReferencesYesNoPage, LicenseRequiredYesNoPage, NationalAdditionalCodesPage, PackageInformationListPage, PackageInformationPage, ProcedureCodesPage, StatisticalValuePage, SupplementaryUnitsPage, VatRatingPage}
import uk.gov.hmrc.test.ui.pages.section6.InlandModeOfTransportPage.{isFixedTransport, isPostalOrMail}
import uk.gov.hmrc.test.ui.pages.section6.{BorderTransportPage, ContainerListPage, ContainerPage, DepartureTransportPage, ExpressConsignmentPage, InlandModeOfTransportPage, InlandOrBorderPage, SealYesNoPage, SupervisingCustomsOfficePage, TransportCountryPage, TransportLeavingTheBorderPage, TransportPaymentPage, WarehousePage}

object CommonPage extends BasePage {

  val backButtonHref: String = ""
  val path: String           = ""
  val title                  = ""

  override def checkBackButton(): Unit = ()

  override def checkExpanders(): Unit = ()

  override def fillPage(values: String*): Unit = ()
  
  def fillAllSectionsForDeclaration(decType: String, AdditionalDecType: String): Unit = {
    fillSection1ForDeclaration(decType, AdditionalDecType)
    fillSection2ForDeclaration()
    fillSection3ForDeclaration()
    fillSection4ForDeclaration()
    fillSection5ForDeclaration()
    fillSection6ForDeclaration()
    SummaryPage.checkPage()
  }

  def submitsTheDeclarationLandOnChoicePage():Unit={
    SubmitYourDeclarationPage.fillPage()
    DeclarationHoldingPage.checkPage()
    DeclarationHoldingPage.fillPage()
    ConfirmationPage.checkPage()
    ChoicePage.navigateToPage(ChoicePage.path)
    ChoicePage.fillPage("Manage Submit Declaration")
    DashboardPage.checkPage()
  }
  def checksTheSectionHeadingsAndContinueToValidateDetails():Unit={
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.checkPage()
    submitsTheDeclarationLandOnChoicePage()
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Arrived and accepted")
    validateDeclarationDetailsOnDeclarationInformationPage()
  }
  def fillSection1ForDeclaration(decType: String, AdditionalDecType: String): Unit = {
    // Fill login page and continue
    LoginPage.fillPage(generateEORI);
    continue()
    // Fill choice page to create a declaration
    ChoicePage.fillPage("create a declaration")
    // Fill standard or other page based on decType
    if (decType == "STANDARD") {
      StandardOrOtherPage.fillPage(decType)
    } else {
      StandardOrOtherPage.fillPage("OTHER")
    }
    continue()
    // Fill Declaration Choice Page if not standard
    if (decType != "STANDARD") {
      DeclarationChoicePage.fillPage(decType);
      continue()
    }
    // Fill Declaration Type Page
    DeclarationTypePage.fillPage(AdditionalDecType);
    continue()
    // Fill Declarant Details Page if not "CLEARANCE"
    if (!decType.equals("CLEARANCE")) {
      DeclarantDetailsPage.fillPage(yes);
      continue()
    }
    if (!isSupplementary) {
      // Fill Ducr, Lrn details
      DoYouHaveADucrPage.fillPage(yes);
      continue()
      DucrEntryPage.fillPage("3GB986007773125-INVOICE123");
      continue()
      LrnPage.fillPage("M9LRN813111");
      continue()
      LinkMucrPage.fillPage(yes);
      continue()
      EnterAMucrPage.fillPage("GB/AZ09-B12345");
      continue()
    }
    // Fill Consignment References Page
    if (isSupplementary) {
      if (AdditionalDecType == "simplified") {
        ConsignmentReferencesPage.fillPage("3GB986007773125-INVOICE123", "20GB46J8TMJ4RF1207", "M9LRN813111")
        continue()
      } else {
        ConsignmentReferencesPage.fillPage("3GB986007773125-INVOICE123", "20230401", "M9LRN813112")
        continue()
      }
    }

    continueOnMiniCya()

  }

  def fillSection2ForDeclaration(): Unit = {
    if (isClearance) {
      EntryIntoDeclarantRecordsPage.fillPage("Yes");
      continue()
      PersonPresentingGoodsPage.fillPage("GB11234567890987");
      continue()
    }

    if (!isClearance) {
      AreYouTheExporterPage.fillPage(Constants.no);
      continue()
    }

    ExporterEORINumberPage.fillPage(Constants.no);
    continue()
    ExporterAddressPage.fillPage(Constants.Address: _*);
    continue()

    if (isClearance) {
      IsThisExsPage.fillPage("No");
      continue()
    }

    OnBehalfOfAnotherAgentPage.fillPage(Constants.no);
    continue()
    RepresentativesEORINumberPage.fillPage("GB121012121212");
    continue()
    RepresentationTypeAgreedPage.fillPage("Direct");
    continue()

    if ((isStandard || isOccasional || isSimplified) && !isExporter) {
      ThirdPartyGoodsTransportationPage.fillPage("Yes");
      continue()
    }

    if (isStandard || isOccasional || isSimplified) {
      CarrierEORINumberPage.fillPage(Constants.no);
      continue()
      CarrierAddressPage.fillPage(Constants.Address: _*);
      continue()
    }

    ConsigneeDetailsPage.fillPage(Constants.Address: _*);
    continue()

    if (!isClearance) {
      OtherPartiesInvolvedPage.fillPage(genSequenceId("first"), "Consolidator", "GB121212121212");
      continue()
      OtherPartiesInvolvedListPage.fillPage(Constants.no);
      continue()
    }

    if (!isOccasional) {
      ProcedureChoicePage.fillPage("Permanent");
      continue()
    }

    if (isStandard || isOccasional || isClearance) {
      AuthorisationsYesNoPage.fillPage(yes)
      continue()
    }

    AuthorisationPage.fillPage(genSequenceId("first"), "ACR", "GB123456789008");
    continue()
    AuthorisationsListPage.fillPage(Constants.no);
    continue()
    continueOnMiniCya()
  }

  def fillSection3ForDeclaration(): Unit = {
    DestinationCountryPage.fillPage("Ukraine");
    continue()

    if (isStandard || isSimplified || isOccasional) {
      CountryOfRoutingPage.fillPage(Constants.no);
      continue()
    }

    if (isArrivedDeclaration && !(hasAuthorisationType("MIB") && hasAuthorisationType("CSE")) && !isSupplementary) {
      LocationOfGoodsPage.fillPage("User Choice", "GBCUASDDOVAPF")
      continue()
    } else {
      LocationOfGoodsPage.fillPage(Constants.no, "GBAUNHVNHVNHVVVM");
      continue()
    }

    OfficeOfExitPage.fillPage("Folkestone", "GB000041");
    continue()
    continueOnMiniCya()
  }

  def fillSection4ForDeclaration(): Unit = {
    if (isStandard || isSupplementary) {
      InvoicesAndExchangeRateChoicePage.fillPage(Constants.no);
      continue()
      InvoicesAndExchangeRatePage.fillPage("GBP", "567640", "1.25");
      continue()
      TotalPackageQuantityPage.fillPage("4");
      continue()
      NatureOfTransactionPage.fillPage("Goods being sold");
      continue()
    }
    PreviousDocumentPage.fillPage("first", "Commercial Invoice", "9GB123456782317-BH1433A61");
    continue()
    PreviousDocumentListPage.fillPage(Constants.no);
    continue()
    continueOnMiniCya()
  }

  def fillSection5ForDeclaration(): Unit = {
    AddDeclarationItemPage.fillPage()
    ProcedureCodesPage.fillPage("1042");
    continue()
    AdditionalProcedureCodesPage.fillPage("F75");
    continue()
    if (hasSupervisingCustomsOfficePageVisiblePC) {
      FiscalReferencesYesNoPage.fillPage(Constants.no);
      continue()
    }
    CommodityDetailsPage.fillPage("42034000", "Straw for bottles");
    continue()
    if (!isClearance || isThisExs) {
      DangerousGoodsCodePage.fillPage(Constants.no);
      continue()
    }
    if (isStandard) {
      VatRatingPage.fillPage("The goods are zero-rated");
      continue()
    }
    if (!isClearance) {
      NationalAdditionalCodesPage.fillPage(Constants.no);
      continue()
    }
    if (isStandard || isSupplementary) {
      StatisticalValuePage.fillPage("1000");
      continue()
    }
    PackageInformationPage.fillPage("1", "Aerosol", "20", "No shipping mark");
    continue()
    PackageInformationListPage.fillPage(Constants.no);
    continue()
    if (isStandard || isSupplementary || isClearance) {
      CommodityMeasurePage.fillPage("500", "700");
      continue()
    }
    if (isStandard || isSupplementary) {
      SupplementaryUnitsPage.fillPage(Constants.yes, "12");
      continue()
    }
    AdditionalInformationYesNoPage.fillPage(Constants.no);
    continue()
    if (!isClearance) {
      LicenseRequiredYesNoPage.fillPage(Constants.yes);
      continue()
    }
    AdditionalDocumentPage.fillPage("1", "C501", "GBAEOC717572504502801");
    continue()
    AdditionalDocumentListPage.fillPage(Constants.no);
    continue()
    DeclarationItemsListPage.fillPage(Constants.no);
    continue()
    continueOnMiniCya()
  }

  def fillSection6ForDeclaration(): Unit = {
    TransportLeavingTheBorderPage.fillPage("Sea transport")
    continue()
    if (isClearance || goToWarehouse) {
      WarehousePage.fillPage("yes", "R1234567GB");
    }

    if (hasSupervisingCustomsOfficePageVisiblePC)
      SupervisingCustomsOfficePage.fillPage("GBBTH001");
      continue()

    InlandOrBorderPage.fillPage("Customs controlled location")
    continue()
    InlandModeOfTransportPage.fillPage("Road transport");
    continue()

    if ((!isSupplementary) && (!isFixedTransport && !isPostalOrMail)) {
      DepartureTransportPage.fillPage("Flight number");
      continue()
    }
    if (!isOccasional) {
      BorderTransportPage.fillPage("Ship IMO number");
      continue()
    }
    if (!isClearance && (!isFixedTransport || !isPostalOrMail)) {
      TransportCountryPage.fillPage("Desirade - GP");
      continue()
    }
    ExpressConsignmentPage.fillPage("Yes");
    continue()
    TransportPaymentPage.fillPage("Payment in cash");
    continue()
    ContainerPage.fillPage("Yes", "Container1");
    continue()
    SealYesNoPage.fillPage("No");
    continue()
    ContainerListPage.fillPage("No");
    continue()
    continueOnMiniCya()
  }
  
  def clearKeysFromCache(cacheKeysToDelete: String): Unit = {
    val keys = cacheKeysToDelete.split(", ").toList
    clear(detailKeys(keys: _*): _*)
  }
  
  def clickChangeLinkForPage(pageName: String): Unit={
    val changeLinkMap: Map[String, String] = Map(
      "LRN" -> "lrn",
      "Authorisation Type" -> "authorisation-holder-1-type",
      "Are you the exporter" -> "declarant-is-exporter",
      "Exporter’s details" -> "exporter-address",
      "Office of exit" -> "office-of-exit",
      "Border transport" -> "active-transport-type"
    )

    CommonPage.changeLinkOnCYA(changeLinkMap(pageName)).click()
  }

  object CommonStepPage {
    def genSequenceId(seqId: String): String =
      seqId match {
        case "first" => "0"
        case "second" => "1"
        case "third" => "2"
      }
  }

  def clickOnCopyLinkAndLandsOnCopyDeclarationPage():Unit={
    DeclarationInformationPage.copyDeclaration()
    CopyDeclarationPage.checkPage()
  }
  
  def entersDucrAndLandsOnDashboardPage():Unit={ 
    val expectedText="You already submitted a declaration with this LRN in the past 48 hours. If you are resubmitting after correcting an error or updating information, add a version number at the end."
    CopyDeclarationPage.fillPage("8GB123406469274-101SHIP1","24")
    CommonPage.continue()
    CopyDeclarationPage.lrnWarning().getText mustBe expectedText
  }
  
  
  
  def landOnHoldingPageAndRedirectedToConfirmationPage():Unit={
    DeclarationHoldingPage.checkPage()
    DeclarationHoldingPage.fillPage()
  }

  def background(): Unit = {
    clearAllCache()
  }
}
