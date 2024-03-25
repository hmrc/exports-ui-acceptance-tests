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

package uk.gov.hmrc.test.ui.pages.section4

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val section4 = 4

  val Section4: DetailKey = DetailKey("Section 4 of 6: About this transaction",section4,Some("transaction-card"))

  val DocumentCodeLabel = "Document type"

  // /invoices-and-exchange-rate-choice
  // /invoices-and-exchange-rate
  val TotalAmountInvoiced: DetailKey = DetailKey("Total amount invoiced", section4)
  val ExchangeRate: DetailKey = DetailKey("Rate of exchange", section4, checkChangeLink = false)

  // /total-package-quantity
  val TotalNumberOfPackages: DetailKey = DetailKey("Total number of packages", section4)

  // /nature-of-transaction
  val NatureOfTransaction: DetailKey = DetailKey("Nature of transaction", section4)

  val NoPreviousDocuments: DetailKey = DetailKey("Additional parties involved", section4)

  // /add-previous-document
  def DocumentCode(sequenceId: String): DetailKey = DetailKey(DocumentCodeLabel, section4, Some(sequenceId))
  def DocumentReference(sequenceId: String): DetailKey = DetailKey("Document reference", section4, Some(sequenceId), checkChangeLink = false)
}
