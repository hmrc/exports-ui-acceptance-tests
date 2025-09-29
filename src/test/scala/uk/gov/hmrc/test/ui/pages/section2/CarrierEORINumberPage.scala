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

package uk.gov.hmrc.test.ui.pages.section2

import uk.gov.hmrc.test.ui.pages.base.Constants.{yesNo, Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{carrierEoriNumber, carrierEoriNumberCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{CarrierEORI, EORI, ExporterYesNo}

object CarrierEORINumberPage extends BasePage {

  def backButtonHref: String = maybeDetail(ExporterYesNo) match {
    case Some(_) => ThirdPartyGoodsTransportationPage.path
    case None    => AreYouTheExporterPage.path
  }

  val path: String = "/declaration/carrier-eori-number"
  val title: String = "Do you know the EORI number of your carrier or haulier?"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(carrierEoriNumber), Clearance -> List(carrierEoriNumberCL))

  // No  => fillPage(no)
  // Yes => fillPage(yes, "GB121212121212")

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo), "Yes", "No")) {
      fillTextBoxById("eori", values(EORI))
      store(CarrierEORI -> Detail(values(EORI)))
    }
}
