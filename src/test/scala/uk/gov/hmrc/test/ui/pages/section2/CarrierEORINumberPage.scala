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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{carrierEoriNumber, carrierEoriNumberCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{CarrierEORI, EORI, ExporterEORI, yesNo}

object CarrierEORINumberPage extends BasePage {

  val path: String           = "/declaration/carrier-eori-number"
  val title: String          = "Do you know the EORI number of your carrier or haulier?"
  def backButtonHref: String = maybeDetail(ExporterEORI) match {
    case Some(_) => AreYouTheExporterPage.path
    case None    => RepresentationTypeAgreedPage.path
  }

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(carrierEoriNumber), Clearance -> List(carrierEoriNumberCL))

  override def fillPage(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo))
    if (values.size == 2) store(CarrierEORI -> Detail(values(EORI)))
  }
}
