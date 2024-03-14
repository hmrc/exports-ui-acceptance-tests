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

package uk.gov.hmrc.test.ui.pages.section3

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.countryOfRouting
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.{CountriesOfRouting, DestinationCountry}

object CountryOfRoutingPage extends BasePage {

  val path: String           = "/declaration/country-of-routing"
  def title                  = s"Will the goods pass through any other countries before arriving in ${detail(DestinationCountry)}"
  val backButtonHref: String = DestinationCountryPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(countryOfRouting)
  )

  def performActionsAndStore(values: String*): Unit =
    if (!selectYesOrNoRadio(values.head, "Yes", "No")) store(CountriesOfRouting -> Details(List("None")))
}
