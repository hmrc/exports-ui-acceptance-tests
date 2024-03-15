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

///*
// * Copyright 2023 HM Revenue & Customs
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package uk.gov.hmrc.test.ui.cucumber.stepdefs
//
//import uk.gov.hmrc.test.ui.pages._
//import uk.gov.hmrc.test.ui.pages.section5.{DeclarationItemsListPage, ProcedureCodesPage}
//
//class StandardJourneyStepDefs extends BaseStepDef {
//
//  Given(
//    """^I navigate to login stub page and provide enrolment key, eori as (.*) with exports redirect url to navigate to choice page$"""
//  ) { (eori: String) =>
//    LoginStubPage.loadPage
//    LoginStubPage.provideLoginCredentialsForExports(eori)
//  }
//
//  And("""^I select (.*) to create (.*) prelodged$""") { (CreateDeclaration: String, StandardDeclaration: String) =>
//    ChoicePage.checkPage(CreateDeclaration)
//    StandardOrOtherPage.checkPage("StandardDeclaration")
//  //DeclarationChoicePage.selectOptionToCreateWhatTypeOfDeclaration(StandardDeclaration)
//  }
//
//  And("""^I select the option No for Arrived export declaration$""") { () =>
//    DeclarationTypePage.selectDeclarationTypeOption("PreLodgedDeclaration")
//  }
//
//  And("""choose declarant details as Yes""") { () =>
//    DeclarantDetailsPage.checkPageTitle()
//    DeclarantDetailsPage.checkPage("Yes")
//  }
//  And("""I provide the ducr details""") { () =>
//    DoYouHaveDUCRPage.checkPageTitle()
//    DoYouHaveDUCRPage.selectDoYouHaveADucr("Yes")
//
//  }
//  And("""I provide the LRN details and DUCR details""") { () =>
//    DUCRDetailsPage.checkPageTitle()
//    DUCRDetailsPage.generateAndEnterRanomDucrEntry()
//    LRNDetailsPage.checkPageTitle()
//    LRNDetailsPage.generateAndEnterRanomLRNEntry()
//  }
//
//  And("""I select Yes for Link to MUCR and enter MCUR Details""") { () =>
//    LinkToMUCRPage.checkPageTitle()
//    LinkToMUCRPage.selectDoYouHaveADucr("Yes")
//    EnterMUCRPage.checkPageTitle()
//    EnterMUCRPage.generateAndEnterRanomMUCREntry()
//  }
//
//  And("""I choose Yes for the exporter details and provide the carrier and consignee details address""") { () =>
//    AreYouTheExporterPage.checkPageTitle()
//    AreYouTheExporterPage.selectAreYouAnExporterOption("Yes")
//    DoYouKnowTheCarrierEORINumberPage.checkPageTitle()
//    DoYouKnowTheCarrierEORINumberPage.selectAreYouAnExporterOption("No")
//    CarrierOrHaulierDetailsPage.checkPageTitle()
//    CarrierOrHaulierDetailsPage.enterDetailsForRegisteredBusiness()
//    ConsigneeDetailsPage.checkPageTitle()
//    ConsigneeDetailsPage.enterAddressDetailsToGetGoodsToBeDelivered()
//  }
//
//  And("""I select option for other parties involved as {string}""") { (otherPartiesInvolved: String) =>
//    OtherPartiesInvolvedPage.checkPageTitle()
//    OtherPartiesInvolvedPage.selectAreYouAnExporterOption(otherPartiesInvolved)
//  }
//
//  And("""I select authorisation choice as {string}""") { (authorisationChoice: String) =>
//    AuthorisationChoicePage.checkPageTitle()
//    AuthorisationChoicePage.selectAuthorisationChoiceOption(authorisationChoice)
//  }
//  And("""I select is_authorisation_required as Yes""") { () =>
//    IsAuthorisationRequiredPage.checkPageTitle()
//    IsAuthorisationRequiredPage.selectIsAuthorisationRequiredOption("Yes")
//  }
//  And("""^I provide the details for authorisation with (.*) and select hold the authorisation option as (.*)$""") {
//    (authorisationCode: String, userEori: String) =>
//      AddAuthorisationRequiredPage.checkPage(authorisationCode, userEori)
//  }
//  And("""^I select "(.*)" for adding another authorisation$""") { (addAnotherAuthorisation: String) =>
//    AuthorisationsRequiredPage.checkPageTitle()
//    AuthorisationsRequiredPage.selectDoYouNeedToAddAnotherAuthorisation(addAnotherAuthorisation)
//  }
//  And("""^I select the destination country as (.*)$""") { (destinationCountry: String) =>
//    DestinationCountryPage.checkPageTitle()
//    DestinationCountryPage.enterDestinationCountry(destinationCountry)
//  }
//  And("""^I select No for country of routing$""") { () =>
//    CountryOfRoutingPage.checkPageTitle()
//    CountryOfRoutingPage.selectCountryOfRoutingOption("No")
//  }
//  And("""^I select (.*) and enter location of goods as (.*)$""") {
//    (selectOption: String, locationOfGoodsCode: String) =>
//      LocationOfGoodsPage.checkPage(selectOption, locationOfGoodsCode)
//  }
//  And("""^I select office of exit as (.*)$""") { (officeOfExitCode: String) =>
//    OfficeOfExitPage.checkPageTitle()
//    OfficeOfExitPage.enterOfficeOfExitCodeDetails(officeOfExitCode)
//  }
//  And("""^I select No for invoice and exchange rate choice page$""") { () =>
//    InvoiceAndExchangeRateChoicePage.checkPageTitle()
//    InvoiceAndExchangeRateChoicePage.isTheTotalAmountInvoicedLessThan100000IValueOption("No")
//  }
//  And(
//    """^I entered currencycode as (.*) and Total amount invoiced as (.*) and opted (.*) with 1.25 for invoice or contract rate$"""
//  ) { (currencyCode: String, totalAmountInvoice: String, Yes: String) =>
//    InvoicesAndExchangeRatePage.checkPageTitle()
//    InvoicesAndExchangeRatePage.enterExchangeRateWithDetails(currencyCode, totalAmountInvoice, Yes)
//  }
//  And("""I entered the total number of packages as 10""") { () =>
//    TotalPackageQuantityPage.checkPageTitle()
//    TotalPackageQuantityPage.enterTotalPackageQuantity("10")
//  }
//  And("""^I select nature of transaction option as (.*)$""") { (selectOption: String) =>
//    NatureOfTransactionPage.checkPageTitle()
//    NatureOfTransactionPage.selectWhatSortOfExportOption(selectOption)
//  }
//  And("""I enter document code and document reference and No option for adding another document""") { () =>
//    AddPreviousDocumentPage.checkPageTitle()
//    AddPreviousDocumentPage.enterDocumentCodeDetails("380")
//    PreviousDocumentsListPage.checkPageTitle()
//    PreviousDocumentsListPage.selectDoYouNeedToAddAnotherDocumentOption("No")
//  }
//  And(
//    """^I start adding the declaration item with the procedure code as (.*) and additional procedure code as (.*)$"""
//  ) { (procedureCode: String, additionalProcedureCode: String) =>
//    AddDeclarationItemPage.checkPageTitle()
//    AddDeclarationItemPage.clickToAddItem()
//    AddProcedureCodesPage.checkPageTitle()
//    AddProcedureCodesPage.enterProcedureCode(procedureCode)
//    ProcedureCodesPage.processPage(additionalProcedureCode)
//  }
//  And("""I select the commodity code and enter the item details information""") { () =>
//    CommodityCodeDetailsPage.checkPageTitle()
//    CommodityCodeDetailsPage.enterCommodityCodeDetails()
//  }
//  And("""I select No option for undangerous goods code""") { () =>
//    UnDangerousGoodsCodePage.checkPageTitle()
//    UnDangerousGoodsCodePage.selectIsThereAUndangerousGoodsOption("No")
//  }
//  And("""I select vat rating page option as Yes""") { () =>
//    VatRatingPage.checkPageTitle()
//    VatRatingPage.selectAreTheseGoodsBeingZeroRatedOption("VATZ")
//  }
//  And("""I select No for national additional code""") { () =>
//    NationalAdditionalCodePage.checkPageTitle()
//    NationalAdditionalCodePage.selectDoYouNeedANationalAdditionalCodeOption("No")
//  }
//  And("""I provide statistical value of this item as 1000""") { () =>
//    StatisticalValuePage.checkPageTitle()
//    StatisticalValuePage.enterStatisticalValue()
//  }
//  And("""I enter the package details information and select No for adding another package details""") { () =>
//    PackageInformationPage.checkPageTitle()
//    PackageInformationPage.enterPackageDetails()
//    PackagesListPage.checkPageTitle()
//    PackagesListPage.selectDoYouNeedToAddAnotherPackageTypeOption("No")
//  }
//  And("""I provide gross and net weight""") { () =>
//    CommodityMeasurePage.checkPageTitle()
//    CommodityMeasurePage.enterGoodsWeightDetails()
//  }
//  And("""I select Yes to add supplementary units""") { () =>
//    SupplementaryUnitsPage.checkPageTitle()
//    SupplementaryUnitsPage.selectDoYouNeedToAddSupplementaryUnitsOption("Yes")
//  }
//  And("""I select No for Additional information statements""") { () =>
//    IsAdditionalInformationReqiuredPage.checkPageTitle()
//    IsAdditionalInformationReqiuredPage.selectDoYouNeedToProvideAdditionalInformationStatementsOption("No")
//  }
//  And("""I select Yes for Do you require a licence and provide the license details""") { () =>
//    IsLicenseRequiredPage.checkPageTitle()
//    IsLicenseRequiredPage.selectDoTheseGoodsRequireLicenseOption("Yes")
//    AdditionalDocumentationPage.checkPageTitle()
//    AdditionalDocumentationPage.enterLicenceDocumentDetails()
//  }
//  And("""I select No for adding another document reference""") { () =>
//    AdditioanlDocumentsListPage.checkPageTitle()
//    AdditioanlDocumentsListPage.selectDoYouNeedToAddAnotherDocumentOption("No")
//  }
//  And("""I select No for adding another item""") { () =>
//    DeclarationItemsListPage.checkPageTitle()
//    DeclarationItemsListPage.selectDoYouNeedToAddAnotherItemOption("No")
//  }
//  And("""^I select (.*) as transport leaving the border$""") { (modeOfTransport: String) =>
//    TransportLeavingTheBorderPage.checkPage(modeOfTransport)
//  }
//  And("""^I select (.*) option for inland or border page$""") { (inlandOrBorderOption: String) =>
//    InlandOrBorderPage.checkPage(inlandOrBorderOption)
//  }
//  And("""^I provide (.*) details for departure transport$""") { (departureTransportOption: String) =>
//    DepartureTransportPage.checkPage(departureTransportOption)
//  }
//  And("""^I provide the transport country details$""") { () =>
//    TransportCountryPage.checkPage()
//  }
//  And("""^I select Yes for express consignment$""") { () =>
//    ExpressConsignmentPage.checkPage("Yes")
//  }
//  And("""^I select (.*) option for transport payment$""") { (transportPaymentOption: String) =>
//    TransportPaymentPage.checkPage(transportPaymentOption)
//  }
//  And("""^I select Yes option to add the container and provide security seals details$""") { () =>
//    ContainerPage.checkPageTitle()
//    ContainerPage.selectAreTheGoodsInAContainerOrContainersOption("Yes")
//    SealsPage.checkPageTitle()
//    SealsPage.selectDoesTheContainerHaveAnySecuritySealsOption("Yes")
//    AddSecuritySealPage.checkPageTitle()
//    AddSecuritySealPage.addSecuritySealInformation()
//    AddSealsListPage.checkPageTitle()
//    AddSealsListPage.selectDoYouWantToAddAnotherSealOption("No")
//    AddContainersPage.checkPageTitle()
//    AddContainersPage.selectDoYouWantToAddAnotherContainerOption("No")
//  }
//  And("""^I validate the details entered for declaration in summary page$""") { () =>
//    CheckYourAnswersPage.validatePartiesSectionData()
//  }
//}
