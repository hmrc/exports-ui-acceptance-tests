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

package uk.gov.hmrc.test.ui.pages.section2

import uk.gov.hmrc.test.ui.pages.base.DetailKey
import uk.gov.hmrc.test.ui.pages.section2.CarrierAddressPage.{fillAutoComplete, fillTextBoxById}

object DetailKeys {

  def addressHelper(values: String*): Unit = {
    fillTextBoxById("details_address_fullName", values(0))
    fillTextBoxById("details_address_addressLine", values(1))
    fillTextBoxById("details_address_townOrCity", values(2))
    fillTextBoxById("details_address_postCode", values(3))
    fillAutoComplete("details_address_country", values(4))
  }

  val EORI = 1

  val section2: Int = 2
  val Section2: DetailKey = DetailKey("Section 2 of 6: Parties involved", section2, Some("parties-card"))

  val AdditionalPartiesInvolvedTypeLabel = "Other parties’s type"
  val AuthorisationTypeLabel = "Authorisation type"
  val ProcedureChoiceLabel = "Authorisation choice"

  // /are-you-the-exporter
  val ExporterYesNo: DetailKey = DetailKey("Are you the exporter?", section2)

  // /exporter-eori-number
  val ExporterEORI: DetailKey = DetailKey("Exporter’s EORI number", section2)

  // /exporter-address
  val ExporterDetails: DetailKey = DetailKey("Exporter’s details", section2)

  // /are-you-completing-this-declaration-on-behalf-of-another-agent
  val onBehalfOfOtherAgentYesNo: DetailKey = DetailKey("Hold the contract with the exporter", section2)

  // /representatives-eori-number
  val RepresentativeEORI: DetailKey = DetailKey("Representative’s EORI number", section2)

  // /representation-type-agreed
  val RepresentativeTypeAgreed: DetailKey = DetailKey("Type of representation", section2)

  // /carrier-eori-number
  val CarrierEORI: DetailKey = DetailKey("Carrier or haulier’s EORI number", section2)

  // /carrier-address
  val CarrierDetails: DetailKey = DetailKey("Carrier or haulier’s details", section2)

  // /consignee-details
  val ConsigneeDetails: DetailKey = DetailKey("Consignee’s details", section2)

  // /other-parties-involved
  val NoAdditionalPartiesInvolved: DetailKey = DetailKey("Additional parties involved", section2)

  def AdditionalPartiesInvolvedType(sequenceId: String): DetailKey = DetailKey(AdditionalPartiesInvolvedTypeLabel, section2, Some(sequenceId))
  def AdditionalPartiesInvolvedEORI(sequenceId: String): DetailKey = DetailKey("Other parties’s EORI number", section2, Some(sequenceId))

  // /authorisation-choice
  val ProcedureChoice: DetailKey = DetailKey(ProcedureChoiceLabel, section2, None, None, skipSummaryCheck = true, skipLabelCheck = true)

  // /is-authorisation-required
  val NoAuthorisationRequired: DetailKey = DetailKey("Authorisations for this declaration", section2)

  // /add-authorisation-required
  def AuthorisationType(sequenceId: String): DetailKey = DetailKey(AuthorisationTypeLabel, section2, Some(sequenceId))
  def AuthorisationHolderEORI(sequenceId: String): DetailKey = DetailKey("Authorised party’s EORI number", section2, Some(sequenceId))

  // CLEARANCE pages

  // /entry-into-declarants-records
  val EntryIntoDeclarantsRecords: DetailKey = DetailKey("Is this an EIDR?", section2)

  // /person-presenting-goods
  val PersonPresentingGoods: DetailKey =
    DetailKey("EORI number of the person presenting the goods to customs", section2)

  // /is-this-exs
  val IsThisExs: DetailKey = DetailKey("Safety and security information given", section2)

  // /consignor-eori-number
  val ConsignorEORI: DetailKey = DetailKey("Consignor’s EORI number", section2)

  // /consignor-address
  val ConsignorDetails: DetailKey = DetailKey("Consignor’s details", section2)

}
