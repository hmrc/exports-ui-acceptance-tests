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

package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val section1 = 1
  val Section1: DetailKey = DetailKey("Section 1 of 6: Declaration details", section1, Some("references-card"))

  val CreationDate: DetailKey = DetailKey("Date created", section1, skipValueCheck = true, checkChangeLink = false)
  val ExpiryDate: DetailKey = DetailKey("Expiry date", section1, skipValueCheck = true, checkChangeLink = false)

  // /gg-sign-in
  val DeclarationEori: DetailKey = DetailKey("Your EORI number", section1, checkChangeLink = false)

  // /standard-or-other & /declaration-choice
  val DeclarationType: DetailKey = DetailKey("Declaration type", section1, checkChangeLink = false)

  // /type
  val AdditionalDeclarationType: DetailKey = DetailKey("Type of declaration", section1, checkChangeLink = false)

  // /trader-reference & /ducr-entry
  val Ducr: DetailKey = DetailKey("DUCR", section1)

  // /consignment-references
  val Mrn: DetailKey = DetailKey("MRN of simplified declaration", section1)
  val EidrDate: DetailKey = DetailKey("Date of EIDR", section1)

  // /local-reference-number
  val Lrn: DetailKey = DetailKey("Your reference (LRN)", section1)

  // /link-to-mucr
  val LinkToMucr: DetailKey = DetailKey("Link to a MUCR", section1)

  // /enter-a-mucr
  val Mucr: DetailKey = DetailKey("MUCR", section1)

  // /entry-into-declarants-records
  val Eidr: DetailKey = DetailKey("MRN On DashBoard", section1, skipValueCheck = true, checkChangeLink = false)
}
