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
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{AuthorisationTypeLabel, section2}

object DetailKeys {

  val section4 = 4

  val Section4: DetailKey = DetailKey("Section 4 of 6: About this transaction",section4,Some("transaction-card"))

  val DocumentCodeLabel: DetailKey = DetailKey("Document type", section4)

  val DocumentReferenceLabel: DetailKey = DetailKey("Document reference", section4)

  val TotalAmountInvoiced: DetailKey = DetailKey("Total amount invoiced", section4)

  val InvoiceExchangeRate: DetailKey = DetailKey("Rate of exchange", section4)

  val NatureOfTransaction: DetailKey = DetailKey("Nature of transaction", section4)
  def DocumentCode(seqId: String): DetailKey = DetailKey(DocumentCodeLabel.label, section4, Some(seqId))
  def DocumentReference(seqId: String): DetailKey = DetailKey(DocumentReferenceLabel.label, section4, Some(seqId))


}
