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

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{TransportCountryId, TransportCountryValue, TransportLeavingBorderValue, cache}

object TransportCountryPage extends BasePage {

  val path: String                   = "declaration/transport-country"
  def title: String                 =
    s"Select the country where the ${cache.getOrElse(TransportLeavingBorderValue, "default value").toLowerCase} is registered"
  val backButtonHrefs: List[String] = List.empty
  override val expanderHrefs: List[String] = List(
    "group-7-transport-information-modes-means-and-equipment#de-715-nationality-of-active-means-of-transport-crossing-the-border-box-21---identity-and-nationality-of-the-active-means-of-transport-crossing-the-border-nationality"
  )

  override def checkBackButton(): Unit = {}

  def performActionsAndCache(country: String*): Unit = {
    fillAutoComplete(findElementById("transport-country"), country.head)
    cache += (TransportCountryId -> "Country of registration for the transport leaving the UK border", TransportCountryValue -> country)
  }

}
