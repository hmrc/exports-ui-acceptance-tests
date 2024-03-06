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
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object TransportLeavingTheBorderPage extends BasePage {

  val path: String                                              = TestConfiguration.url("exports-frontend") + "/declaration/transport-leaving-the-border"
  val transportLeavingTheBorderPage                            = "What mode of transport will the goods leave the UK on?"
  var transportLeavingTheBorderDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    TransportLeavingTheBorderPage.checkUrlAndTitle(transportLeavingTheBorderPage)

  def selectBorderModeOfTransportOption(selectOption: String): Unit = {
    selectOption match {
      case "Sea transport"                     => findElement("id", "Border_Sea").click()
      case "Roll on roll off (RoRo) transport" => findElement("id", "Border_Ferry").click()
      case "Rail transport"                    => findElement("id", "Border_Rail").click()
      case "Road transport"                    => findElement("id", "Border_Road").click()
      case "Air transport"                     => findElement("id", "Border_Air").click()
      case "Postal"                            => findElement("id", "Border_PostalOrMail").click()
      case "Fixed transport installation"      => findElement("id", "Border_FixedTransportInstallations").click()
      case "Inland waterway transport"         => findElement("id", "Border_InlandWaterway").click()
      case "Own propulsion"                    => findElement("id", "Border_Unknown").click()
    }
    transportLeavingTheBorderDetailsMap += ("TransportLeavingTheBorder" -> selectOption)
    submit()
  }
}
