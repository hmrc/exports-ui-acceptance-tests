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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, enteredValue, storedValue}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{destinationCountry, destinationCountry1, destinationCountryCL, destinationCountryCL1}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.DestinationCountry
import uk.gov.hmrc.test.ui.pages.section2.SummarySection2Page

object DestinationCountryPage extends BasePage {

  def backButtonHref: String = SummarySection2Page.path
  val path: String           = "/declaration/destination-country"
  val title                  = "Where are the goods being exported to?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(destinationCountry, destinationCountry1),
    Clearance -> List(destinationCountryCL, destinationCountryCL1)
  )

  // ex: fillPage("United States of America", "The United States of America")
  // ex: fillPage("China")

  override def fillPage(values: String*): Unit = {
    fillAutoComplete("countryCode", values(enteredValue))
    store(DestinationCountry -> Detail(values(if (values.size == 2) storedValue else enteredValue)))
  }

  def isGuernseyOrJerseyDestination: Boolean =
    detail(DestinationCountry) match {
      case "Guernsey" | "Jersey" => true
      case _ => false
    }
}
