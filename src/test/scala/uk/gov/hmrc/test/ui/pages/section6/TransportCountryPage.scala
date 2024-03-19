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

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.transportCountry
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object TransportCountryPage extends BasePage {

  val path: String  = "declaration/transport-country"
  def title: String =
    s"Select the country where the ${detail(TransportLeavingBorder).toLowerCase} is registered"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(transportCountry)
  )

  private val country = 0

  def backButtonHref: String =
    if (inlandOrBorderValue && !isTransportLeavingBorderModePostalOrFixed && !shouldSkipInlandOrBorder) {
      if (checkIfDecIsOcaOrSim) InlandOrBorderPage.path
      else if (checkIfDecIsStdOrSup) DepartureTransportPage.path
      else BorderTransportPage.path
    } else {
      BorderTransportPage.path
    }

  override def fillPage(values: String*): Unit = {
    fillAutoComplete("transport-country", values(country))
    store(TransportCountry -> Detail(values(country)))
  }
}
