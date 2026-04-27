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

package uk.gov.hmrc.test.ui.pages.section2

import uk.gov.hmrc.test.ui.pages.base.*
import uk.gov.hmrc.test.ui.pages.base.CommonPage.CommonStepPage.genSequenceId
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{clearKeysFromCache, isAmendmentMode}
import uk.gov.hmrc.test.ui.pages.section1.DeclarantDetailsPage
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{NoAuthorisationRequired, Section2}

object SummarySection2Page extends BasePage {

  def backButtonHref: String = maybeDetail(NoAuthorisationRequired).fold(AuthorisationsListPage.path)(_ => AuthorisationsYesNoPage.path)
  val path: String = "/declaration/summary-section/2"
  val title: String = "Check your answers"

  override def checkExpanders(): Unit = ()

  // ex: fillPage()

  override def fillPage(values: String*): Unit = checkSectionSummary(Section2)

  def completeSection2ClearanceEidrNo():Unit={
    EntryIntoDeclarantRecordsPage.checkPage()
    EntryIntoDeclarantRecordsPage.fillPage("No")
    CommonPage.continue()
    DeclarantDetailsPage.checkPage()
    DeclarantDetailsPage.fillPage("Yes")
    CommonPage.continue()
    AreYouTheExporterPage.checkPage()
    AreYouTheExporterPage.fillPage("No")
    CommonPage.continue()
    ExporterEORINumberPage.checkPage()
    ExporterEORINumberPage.fillPage("No")
    CommonPage.continue()
    ExporterAddressPage.checkPage()
    val address = if (isAmendmentMode) Constants.AmendedAddress else Constants.Address
    ExporterAddressPage.fillPage(address: _*)
    CommonPage.continue()
    IsThisExsPage.checkPage()
    IsThisExsPage.fillPage("Yes")
    CommonPage.continue()
    ConsignorEORINumberPage.checkPage()
    ConsignorEORINumberPage.fillPage("No")
    CommonPage.continue()
    ConsignorDetailsPage.checkPage()
    ConsignorDetailsPage.fillPage(Constants.Address: _*)
    CommonPage.continue()
    ThirdPartyGoodsTransportationPage.checkPage()
    ThirdPartyGoodsTransportationPage.fillPage("No")
    CommonPage.continue()
    ConsigneeDetailsPage.checkPage()
    ConsigneeDetailsPage.fillPage(Constants.Address: _*)
    CommonPage.continue()
    AuthorisationsYesNoPage.checkPage()
    AuthorisationsYesNoPage.fillPage("Yes")
    CommonPage.continue()
    AuthorisationPage.fillPage(genSequenceId("first"), "ACR", "GB123456789008")
    CommonPage.continue()
    AuthorisationsListPage.checkPage()
    AuthorisationsListPage.fillPage("NO")
    CommonPage.continue()
  }

  def completeSection2ClearanceEidrYes():Unit={
    EntryIntoDeclarantRecordsPage.navigateToPage(EntryIntoDeclarantRecordsPage.path)
    EntryIntoDeclarantRecordsPage.fillPage("Yes")
    CommonPage.continue()
    PersonPresentingGoodsPage.checkPage()
  }

  def clearCacheDetailsContinueToConsigneeDetailsPage():Unit={
    clearKeysFromCache("Exporter’s details, Consignor’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation, Carrier or haulier’s details, Carrier or haulier’s EORI number")
    IsThisExsPage.navigateToPage(IsThisExsPage.path)
    IsThisExsPage.fillPage("No")
    CommonPage.continue()
    OnBehalfOfAnotherAgentPage.navigateToPage(OnBehalfOfAnotherAgentPage.path)
    OnBehalfOfAnotherAgentPage.fillPage("No")
    CommonPage.continue()
    RepresentativesEORINumberPage.checkPage()
    RepresentativesEORINumberPage.fillPage("GB121012121212")
    CommonPage.continue()
    RepresentationTypeAgreedPage.checkPage()
    RepresentationTypeAgreedPage.fillPage("Direct")
    CommonPage.continue()
    ConsigneeDetailsPage.checkPage()
  }
  def clearCacheDetailsContinueToAuthorisationChoicePage():Unit={
    clearKeysFromCache("Is this an EIDR?, Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation")
    EntryIntoDeclarantRecordsPage.navigateToPage(EntryIntoDeclarantRecordsPage.path)
    EntryIntoDeclarantRecordsPage.fillPage("Yes")
    CommonPage.continue()
    PersonPresentingGoodsPage.checkPage()
    PersonPresentingGoodsPage.fillPage("GB123456789123")
    CommonPage.continue()
    ExporterEORINumberPage.checkPage()
    ExporterEORINumberPage.fillPage("Yes", "GB171357178688000")
    CommonPage.continue()
    IsThisExsPage.checkPage()
    IsThisExsPage.fillPage("Yes")
    CommonPage.continue()
    ConsignorEORINumberPage.checkPage()
    ConsignorEORINumberPage.fillPage("Yes", "GB123456789124")
    CommonPage.continue()
    ThirdPartyGoodsTransportationPage.checkPage()
    ThirdPartyGoodsTransportationPage.fillPage("No")
    CommonPage.continue()
    ConsigneeDetailsPage.checkPage()
    ConsigneeDetailsPage.fillPage(Constants.Address: _*)
    CommonPage.continue()
    ProcedureChoicePage.checkPage()
  }

  def completeSection2Standard():Unit={
    AreYouTheExporterPage.checkPage()
    AreYouTheExporterPage.fillPage("No")
    CommonPage.continue()
    ExporterEORINumberPage.checkPage()
    ExporterEORINumberPage.fillPage("No")
    CommonPage.continue()
    ExporterAddressPage.checkPage()
    val address = if (isAmendmentMode) Constants.AmendedAddress else Constants.Address
    ExporterAddressPage.fillPage(address: _*)
    CommonPage.continue()
    OnBehalfOfAnotherAgentPage.checkPage()
    OnBehalfOfAnotherAgentPage.fillPage("No")
    CommonPage.continue()
    RepresentativesEORINumberPage.checkPage()
    RepresentativesEORINumberPage.fillPage("GB121012121212")
    CommonPage.continue()
    RepresentationTypeAgreedPage.checkPage()
    RepresentationTypeAgreedPage.fillPage("Direct")
    CommonPage.continue()
    ThirdPartyGoodsTransportationPage.checkPage()
    ThirdPartyGoodsTransportationPage.fillPage("Yes")
    CommonPage.continue()
    CarrierEORINumberPage.checkPage()
    CarrierEORINumberPage.fillPage("No")
    CommonPage.continue()
    CarrierAddressPage.checkPage()
    CarrierAddressPage.fillPage(Constants.Address: _*)
    CommonPage.continue()
    ConsigneeDetailsPage.checkPage()
    ConsigneeDetailsPage.fillPage(Constants.Address: _*)
    CommonPage.continue()
    OtherPartiesInvolvedPage.checkPage()
  }
  def clearCacheDetailsThirdPartyGoodsTransportationPage():Unit={
    AreYouTheExporterPage.navigateToPage(AreYouTheExporterPage.path)
    AreYouTheExporterPage.fillPage("Yes")
    clearKeysFromCache("Exporter’s details, Hold the contract with the exporter, Representative’s EORI number, Type of representation")
    CommonPage.continue()
    ThirdPartyGoodsTransportationPage.checkPage()
  }
  def completeSection2Supplementary():Unit={
    AreYouTheExporterPage.checkPage()
    AreYouTheExporterPage.fillPage("No")
    CommonPage.continue()
    ExporterEORINumberPage.checkPage()
    ExporterEORINumberPage.fillPage("No")
    CommonPage.continue()
    ExporterAddressPage.checkPage()
    val address = if (isAmendmentMode) Constants.AmendedAddress else Constants.Address
    ExporterAddressPage.fillPage(address: _*)
    CommonPage.continue()
    OnBehalfOfAnotherAgentPage.checkPage()
    OnBehalfOfAnotherAgentPage.fillPage("No")
    CommonPage.continue()
    RepresentativesEORINumberPage.checkPage()
    RepresentativesEORINumberPage.fillPage("GB121012121212")
    CommonPage.continue()
    RepresentationTypeAgreedPage.checkPage()
    RepresentationTypeAgreedPage.fillPage("Direct")
    CommonPage.continue()
    ConsigneeDetailsPage.checkPage()
    ConsigneeDetailsPage.fillPage(Constants.Address: _*)
    CommonPage.continue()
    OtherPartiesInvolvedPage.checkPage()
    OtherPartiesInvolvedPage.fillPage(genSequenceId("first"), "Consolidator", "GB121212121212")
    CommonPage.continue()
    OtherPartiesInvolvedListPage.checkPage()
    OtherPartiesInvolvedListPage.fillPage("Yes")
    OtherPartiesInvolvedListPage.checkPage()
    OtherPartiesInvolvedListPage.removeOtherPartiesInvolvedLink(0)
    OtherPartiesInvolvedRemovePage.checkPage()
    OtherPartiesInvolvedRemovePage.fillPage("Yes", "0")
    CommonPage.continue()
    OtherPartiesInvolvedPage.checkPage()
    OtherPartiesInvolvedPage.fillPage(genSequenceId("first"), "Manufacturer", "GB121212131313")
    CommonPage.continue()
    OtherPartiesInvolvedListPage.checkPage()
    OtherPartiesInvolvedListPage.fillPage("No")
    CommonPage.continue()
    ProcedureChoicePage.checkPage()
    ProcedureChoicePage.fillPage("Permanent")
    CommonPage.continue()
    AuthorisationPage.checkPage()
    AuthorisationPage.fillPage(genSequenceId("first"), "ACR", "GB123456789008")
    CommonPage.continue()
    AuthorisationsListPage.checkPage()
    AuthorisationsListPage.removeAuthCode(0)
    AuthorisationRemovePage.checkPage()
    AuthorisationRemovePage.fillPage("Yes", "0")
    AuthorisationRemovePage.checkPage()
    AuthorisationRemovePage.fillPage("Yes", "0")
    CommonPage.continue()
    AuthorisationPage.checkPage()
    AuthorisationPage.fillPage(genSequenceId("first"), "ACP", "GB123456789009")
    CommonPage.continue()
    AuthorisationsListPage.checkPage()
    AuthorisationsListPage.fillPage("No")
    CommonPage.continue()
  }
}
