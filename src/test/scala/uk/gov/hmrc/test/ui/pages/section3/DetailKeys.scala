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

  val section3  = 3
  val Section3: DetailKey = DetailKey("Section 3 of 6: Routes and locations", section3, Some("routes-and-locations-card"))

  // /destination-country
  val DestinationCountry: DetailKey = DetailKey("Destination country", section3)

  // /country-of-routing
  // /countries-of-routing
  val CountriesOfRouting: DetailKey = DetailKey("Routing countries", section3)

  // /location-of-goods
  val LocationOfGoods: DetailKey = DetailKey("Goods location code", section3)
  val RRS01: DetailKey = DetailKey("Additional Information code", section3, checkChangeLink = false)

  // /office-of-exit
  val OfficeOfExit : DetailKey = DetailKey("Office of exit", section3)
}
