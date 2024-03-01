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

import scala.collection.immutable.HashMap

object CountryOfRoutingPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/country-of-routing"
  val countryOfRoutingPageTitle = "Will the goods pass through any other countries before arriving in"
  var countryOfRoutingDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    CountryOfRoutingPage.onPage(countryOfRoutingPageTitle)
  }

  def selectCountryOfRoutingOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "Yes").click()
      case "No" => findElement("id", "No").click()
    }
    countryOfRoutingDetailsMap += ("CountryOfRouting" -> selectOption)
    submit()
  }
}
