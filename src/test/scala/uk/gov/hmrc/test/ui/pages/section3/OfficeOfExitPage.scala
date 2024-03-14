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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{countryOfRouting, officeOfExit, officeOfExitCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.{CountriesOfRouting, DestinationCountry, OfficeOfExitCode}

object OfficeOfExitPage extends BasePage {

  val path: String = "/declaration/office-of-exit"

  def title = "Where is the customs office of exit?"

  val backButtonHref: String = LocationOfGoodsPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(officeOfExit),
    Clearance -> List(officeOfExitCL)
  )

  //performActionsAndStore("United States of America","The United States of America","China","China")
  def performActionsAndStore(values: String*): Unit = {
    val officeOfExitCodes: String = values.head
        fillAutoComplete("countryCode", officeOfExitCodes)
    store(OfficeOfExitCode -> Details(Seq(officeOfExitCodes)))
  }

}
