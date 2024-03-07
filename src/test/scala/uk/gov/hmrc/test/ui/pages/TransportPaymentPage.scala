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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{TransportPaymentId, TransportPaymentValue, cache}

object TransportPaymentPage extends BasePage {

  val path: String                   = "/declaration/nature-of-transaction"
  def title                         = "How did you pay for the express transport?"
  val backButtonHrefs: List[String] = List.empty
  override val expanderHrefs: List[String] = List(
    "group-4-valuation-information-and-taxes#de-42-transport-charges-method-of-payment"
  )

  def performActionsAndStore(selectOption: String*): Unit = {
    val elementId           = selectOption match {
      case "Payment in cash"                      => "cash"
      case "Payment by credit card"               => "creditCard"
      case "Payment by cheque"                    => "cheque"
      case "Other"                                => "other"
      case "Electronic funds transfer"            => "eFunds"
      case "Account holder with carrier"          => "accHolder"
      case "Not pre-paid"                         => "notPrePaid"
      case "Payment information is not available" => "notAvailable"
    }
    clickById(elementId)
    val updatedSelectOption =
      if (elementId == "other") "Other (e.g. Direct debit to cash account)"
      else selectOption.headOption.getOrElse("Other")
    store ++ (TransportPaymentId -> "Method of payment for transport", TransportPaymentValue -> updatedSelectOption)
  }
}
