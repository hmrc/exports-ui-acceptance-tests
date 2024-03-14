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

package uk.gov.hmrc.test.ui.pages.section3

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val Section3                      = 3
  val DestinationCountry: DetailKey = DetailKey("Destination country", Section3)
  val CountriesOfRouting: DetailKey   = DetailKey("Routing countries", Section3)
  val LocationOfGoodsCode: DetailKey   = DetailKey("Goods location code", Section3)
  val OfficeOfExitCode : DetailKey = DetailKey("Office of exit",Section3)
  val TotalAmountInvoiced : DetailKey = DetailKey("Total amount invoiced",Section3)
  val InvoiceExchangeRate: DetailKey = DetailKey("Rate of exchange",Section3)



}
