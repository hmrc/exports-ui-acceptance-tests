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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, yesNo}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{expressConsignment, expressConsignmentCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationChoicePage.isClearance
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.{DepartureTransport, ExpressConsignment, TransportCountry}

object ExpressConsignmentPage extends BasePage {

  def backButtonHref: String = {
    if (isClearance) {
      if (maybeDetails(DepartureTransport).isEmpty) SupervisingCustomsOfficePage.path
      else DepartureTransportPage.path
    }
    else maybeDetail(TransportCountry).fold(TransportCountryPage.backButtonHref)(_ => TransportCountryPage.path)
  }

  val path: String = "/declaration/express-consignment"

  val title: String = "Is this an express consignment?"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(expressConsignment), Clearance -> List(expressConsignmentCL))

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo))
    store(ExpressConsignment -> Detail(values(yesNo)))
  }
}
