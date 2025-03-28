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

package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.TransportPayment

object TransportPaymentPage extends BasePage {

  def backButtonHref: String = ExpressConsignmentPage.path
  val path: String           = "/declaration/transport-payment"
  val title                  = "How did you pay for the express transport?"

  override def checkExpanders(): Unit = ()

  private val paymentType = 0

  // ex: fillPage("Electronic funds transfer")

  override def fillPage(values: String*): Unit = {
    val elementId = values(paymentType) match {
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

    val updatedSelectOption = if (elementId == "other") "Other (e.g. Direct debit to cash account)" else values(paymentType)
    store(TransportPayment -> Detail(updatedSelectOption))
  }
}
