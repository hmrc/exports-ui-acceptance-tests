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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{exporterAddress, exporterAddressCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{ExporterDetails, detailsHelper}

object ExporterDetailsPage extends BasePage {

  val path: String           = "/declaration/exporter-address"
  val title: String          = "What is the exporter’s name and business address?"
  val backButtonHref: String = ExporterEORINumberPage.path

  override val expanderHrefs: Map[String, Seq[String]]                 =
    Map(Common -> List(exporterAddress), Clearance -> List(exporterAddressCL))

  override def fillPage(values: String*): Unit = {
    detailsHelper(values: _*)
    store(ExporterDetails -> Details(values))
  }
}