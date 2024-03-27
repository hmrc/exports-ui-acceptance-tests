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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{transportLeavingTheBorder, transportLeavingTheBorderCL}
import uk.gov.hmrc.test.ui.pages.section5.SummarySection5Page
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.TransportLeavingBorder

object TransportLeavingTheBorderPage extends BasePage {

  def backButtonHref: String = SummarySection5Page.path
  val path: String           = "/declaration/transport-leaving-the-border"
  val title: String          = "What mode of transport will the goods leave the UK on?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(transportLeavingTheBorder),
    Clearance -> List(transportLeavingTheBorderCL)
  )

  private val transportType = 0

  // ex: fillPage("Fixed transport installation")

  override def fillPage(values: String*): Unit = {
    val elementId = values(transportType) match {
      case "Sea transport"                     => "Border_Sea"
      case "Roll on roll off (RoRo) transport" => "Border_Ferry"
      case "Rail transport"                    => "Border_Rail"
      case "Road transport"                    => "Border_Road"
      case "Air transport"                     => "Border_Air"
      case "Postal"                            => "Border_PostalOrMail"
      case "Fixed transport installation"      => "Border_FixedTransportInstallations"
      case "Inland waterway transport"         => "Border_InlandWaterway"
      case "Own propulsion"                    => "Border_Unknown"
    }
    clickById(elementId)
    store(TransportLeavingBorder -> Detail(values(transportType)))
  }
}
