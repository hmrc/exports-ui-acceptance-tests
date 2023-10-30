/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object TransportLeavingTheBorderPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/transport-leaving-the-border"
  val transportLeavingTheBorderPage = "What mode of transport will the goods leave the UK on?"
  var transportLeavingTheBorderDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    TransportLeavingTheBorderPage.onPage(transportLeavingTheBorderPage)
  }

  def selectBorderModeOfTransportOption(selectOption: String): Unit = {
    selectOption match {
      case "Sea transport" => findElement("id", "Border_Sea").click()
      case "Roll on roll off (RoRo) transport" => findElement("id", "Border_Ferry").click()
      case "Rail transport" => findElement("id", "Border_Rail").click()
      case "Road transport" => findElement("id", "Border_Road").click()
      case "Air transport" => findElement("id", "Border_Air").click()
      case "Postal" => findElement("id", "Border_PostalOrMail").click()
      case "Fixed transport installation" => findElement("id", "Border_FixedTransportInstallations").click()
      case "Inland waterway transport" => findElement("id", "Border_InlandWaterway").click()
      case "Own propulsion" => findElement("id", "Border_Unknown").click()
    }
    transportLeavingTheBorderDetailsMap += ("TransportLeavingTheBorder" -> selectOption)
    submit()
  }
}
