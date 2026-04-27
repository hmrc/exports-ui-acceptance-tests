/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.common

import uk.gov.hmrc.test.ui.pages.base.CommonPage.{clickChangeLinkForPage, landOnHoldingPageAndRedirectedToConfirmationPage}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, CommonPage, Constants}
import uk.gov.hmrc.test.ui.pages.common.DetailKeys.DeclarationInfoPath
import uk.gov.hmrc.test.ui.pages.section1.ChoicePage
import uk.gov.hmrc.test.ui.pages.section2.{AreYouTheExporterPage, AuthorisationPage, AuthorisationRemovePage, AuthorisationsListPage, CarrierEORINumberPage, ConsigneeDetailsPage, OtherPartiesInvolvedListPage, ProcedureChoicePage, SummarySection2Page, ThirdPartyGoodsTransportationPage}
import uk.gov.hmrc.test.ui.pages.section3.{OfficeOfExitPage, SummarySection3Page}
import uk.gov.hmrc.test.ui.pages.section5.AdditionalDocumentPage.fillAdditionalDocument
import uk.gov.hmrc.test.ui.pages.section5.PackageInformationPage.enterPackageInfo
import uk.gov.hmrc.test.ui.pages.section5.{AdditionalDocumentListPage, AdditionalDocumentPage, AdditionalDocumentsYesNoPage, AdditionalInformationYesNoPage, AdditionalProcedureCodesPage, CommodityDetailsPage, CommodityMeasurePage, CusCodePage, DangerousGoodsCodePage, DeclarationItemsListPage, LicenseRequiredYesNoPage, NationalAdditionalCodesPage, PackageInformationListPage, PackageInformationPage, ProcedureCodesPage, StatisticalValuePage, SummarySection5Page, SupplementaryUnitsPage, VatRatingPage}
import uk.gov.hmrc.test.ui.pages.section6.BorderTransportPage

object AmendmentDetails extends BasePage {

  def backButtonHref: String = ""
  val path: String = detail(DeclarationInfoPath)
  val title: String = "Amendment details"

  override def checkExpanders(): Unit = ()

  // ex: fillPage()

  override def fillPage(values: String*): Unit = {
    checkAmendedDetails()
  }

  def clickViewDetailsLink(): Unit = {
    val amendSelector = "a[href*='amendment-details']"
    waitForCssSelector(amendSelector)
    clickByCssSelector(amendSelector)
  }
  def backLinkToSummaryPage():Unit={
    CommonPage.back()
    DeclarationInformationPage.amendDeclaration()
    SummaryPage.checkPage()
  }

  def backLinkToDashboardPageToSummaryPage(): Unit = {
    CommonPage.back()
    DashboardPage.mrnLink.click()
    DeclarationInformationPage.amendDeclaration()
    SummaryPage.checkPage()
  }

  def clicksOnCancelLinkOnRejectedAmendment():Unit={
    DeclarationInformationPage.clickCancelLinkOnRejectedAmendment()
    CancelDeclarationPage.checkPage()
    CancelDeclarationPage.fillPage("No longer required", "Cancellation of the amendment")
    CommonPage.continue()
    landOnHoldingPageAndRedirectedToConfirmationPage()
  }

  def amendingAreYouTheExporterDetails(): Unit = {
    AreYouTheExporterPage.checkPage()
    AreYouTheExporterPage.fillPage("Yes")
    CommonPage.continue()
    ThirdPartyGoodsTransportationPage.checkPage()
    ThirdPartyGoodsTransportationPage.fillPage("Yes")
    CommonPage.continue()
    CarrierEORINumberPage.checkPage()
    CarrierEORINumberPage.fillPage("Yes", "GB121212121212")
    CommonPage.continue()
    ConsigneeDetailsPage.checkPage()
    ConsigneeDetailsPage.fillPage(Constants.AmendedAddress: _*)
    CommonPage.continue()
    OtherPartiesInvolvedListPage.checkPage()
    OtherPartiesInvolvedListPage.fillPage("No")
    CommonPage.continue()
    ProcedureChoicePage.checkPage()
    ProcedureChoicePage.fillPage("Permanent with excise")
    CommonPage.continue()
    AuthorisationsListPage.checkPage()
    AuthorisationPage.removeAuthorisation(0)
    AuthorisationRemovePage.checkPage()
    AuthorisationRemovePage.fillPage("Yes", "0")
    CommonPage.continue()
    AuthorisationPage.checkPage()
    AuthorisationPage.fillPage("first", "ACR", "GB123456789008")
    CommonPage.continue()
    AuthorisationsListPage.checkPage()
    AuthorisationsListPage.fillPage("No")
    CommonPage.continue()
    SummarySection2Page.checkPage()
    SummaryPage.navigateToPage(SummaryPage.path)
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.checkPage()
    SubmitYourDeclarationPage.fillPage()
    landOnHoldingPageAndRedirectedToConfirmationPage()
    ConfirmationPage.checkPage()
    ChoicePage.navigateToPage(ChoicePage.path)
    ChoicePage.fillPage("Manage Submit Declaration")
    DashboardPage.checkPage()
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Declaration cleared")
    DashboardPage.mrnLink.click()
    AmendmentDetails.clickViewDetailsLink()
    AmendmentDetails.fillPage()
    CommonPage.back()
    DeclarationInformationPage.amendDeclaration()
    SummaryPage.checkPage()
  }

  def selectProcedureCode(): Unit = {
    ProcedureCodesPage.checkPage()
    ProcedureCodesPage.fillPage("1040")
    CommonPage.continue()
  }

  def amendSection5Page(): Unit = {
    AdditionalProcedureCodesPage.checkPage()
    AdditionalProcedureCodesPage.fillPage("000")
    CommonPage.continue()
    CommodityDetailsPage.checkPage()
    CommodityDetailsPage.fillPage("28034001", "St Andrews Whisky")
    CommonPage.continue()
    DangerousGoodsCodePage.checkPage()
    DangerousGoodsCodePage.fillPage("No")
    CommonPage.continue()
    CusCodePage.checkPage()
    CusCodePage.fillPage("No")
    CommonPage.continue()
    VatRatingPage.checkPage()
    VatRatingPage.fillPage("The goods are VAT exempt in the UK")
    CommonPage.continue()
    NationalAdditionalCodesPage.checkPage()
    NationalAdditionalCodesPage.fillPage("No")
    CommonPage.continue()
    StatisticalValuePage.checkPage()
    StatisticalValuePage.fillPage("8000")
    CommonPage.continue()
    PackageInformationPage.checkPage()
    enterPackageInfo("Barrel", "122", "1305", "first")
    CommonPage.continue()
    PackageInformationListPage.checkPage()
    PackageInformationListPage.fillPage("No")
    CommonPage.continue()
    CommodityMeasurePage.checkPage()
    CommodityMeasurePage.fillPage("500", "900")
    CommonPage.continue()
    SupplementaryUnitsPage.checkPage()
    SupplementaryUnitsPage.fillPage("No")
    CommonPage.continue()
    AdditionalInformationYesNoPage.checkPage()
    AdditionalInformationYesNoPage.fillPage("No")
    CommonPage.continue()
    LicenseRequiredYesNoPage.checkPage()
    LicenseRequiredYesNoPage.fillPage("No")
    CommonPage.continue()
    AdditionalDocumentPage.checkPage()
    fillAdditionalDocument("C501", "GBAEOC71757", "first")
    CommonPage.continue()
    AdditionalDocumentListPage.checkPage()
    AdditionalDocumentsYesNoPage.fillPage("No")
    CommonPage.continue()
    DeclarationItemsListPage.checkPage()
    DeclarationItemsListPage.fillPage("No")
    CommonPage.continue()
    SummarySection5Page.checkPage()
  }


  def validatesAmendedDetailsByClickingOnMRNLink():Unit={
    DashboardPage.mrnLink.click()
    AmendmentDetails.clickViewDetailsLink()
    AmendmentDetails.fillPage()
  }
  def clicksConfirmAndContinueToSubmitDeclaration():Unit={
    SummaryPage.navigateToPage(SummaryPage.path)
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.fillPage()
  }
  def continueJourneyToDashboardPage():Unit={
    ConfirmationPage.checkPage()
    ChoicePage.navigateToPage(ChoicePage.path)
    ChoicePage.fillPage("Manage Submit Declaration")
    DashboardPage.checkPage()
  }

  def clicksChangeLinkForOfficeOfExit(): Unit = {
    clickChangeLinkForPage("Office of exit")
    OfficeOfExitPage.checkPage()
    OfficeOfExitPage.fillPage("Barrow in Furness", "GB003010")
    CommonPage.continue()
    SummarySection3Page.checkPage()
  }

  def clicksOnExitAndComebackLaterLink(): Unit = {
    SummarySection3Page.exitAndComeBackLater()
    DraftSavedPage.checkPage()
    DraftSavedPage.viewSavedDec()
    SavedDeclarationsPage.checkPage()
  }

  def clicksOnDucrLinkAndSubmitDeclaration(): Unit = {
    SavedDeclarationsPage.clickDUCRLinkForAmendedDeclaration()
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.fillPage()
  }
  
  def clicksChangeLinkForBorderTransportPageNavigateToConfirmationPage():Unit={
    clickChangeLinkForPage("Border transport")
    BorderTransportPage.checkPage()
    BorderTransportPage.fillPage("Ship IMO number")
    BorderTransportPage.saveAndReturnToSummary()
    SummaryPage.checkPage()
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.fillPage()
    landOnHoldingPageAndRedirectedToConfirmationPage()
  }

  def clicksChangeLinkForBorderTransportPageToShipname():Unit={
    clickChangeLinkForPage("Border transport")
    BorderTransportPage.checkPage()
    BorderTransportPage.fillPage("Ship name")
    BorderTransportPage.saveAndReturnToSummary()
    SummaryPage.checkPage()
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.fillPage()
    landOnHoldingPageAndRedirectedToConfirmationPage()
    continueJourneyToDashboardPage()
  }

  def clicksChangeLinkForBorderTransportPageToTrain(): Unit = {
    clickChangeLinkForPage("Border transport")
    BorderTransportPage.checkPage()
    BorderTransportPage.fillPage("Train")
    BorderTransportPage.saveAndReturnToSummary()
    SummaryPage.checkPage()
    SummaryPage.fillPage()
    SubmitYourDeclarationPage.fillPage()
  }
}
