/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object DepartureTransportPage extends BasePage {

  val url: String                                                = TestConfiguration.url("exports-frontend") + "/declaration/departure-transport"
  val departureTransportPageTitle                                = "What are the details for the sea transport?"
  var departureTransportPageTitleDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    DepartureTransportPage.onPage(departureTransportPageTitle)

  def selectBorderModeOfTransportOption(selectOption: String): Unit = {
    selectOption match {
      case "Ship IMO number"                                 =>
        findElement("id", "radio_ShipOrRoroImoNumber").click()
        findElement("id", "ShipOrRoroImoNumber").sendKeys("123456")
      case "Ship name"                                       =>
        findElement("id", "radio_NameOfVessel").click()
        findElement("id", "NameOfVessel").sendKeys("Seraphim")
      case "Eurotunnel or other rail details"                =>
        findElement("id", "radio_WagonNumber").click()
        findElement("id", "WagonNumber").sendKeys("EuroTunnel")
      case "Flight number and date of flight"                =>
        findElement("id", "radio_FlightNumber").click()
        findElement("id", "FlightNumber").sendKeys("123456")
      case "Aircraft registration number and date of flight" =>
        findElement("id", "radio_AircraftRegistrationNumber").click()
        findElement("id", "AircraftRegistrationNumber").sendKeys("123456")
      case "European vessel identification (ENI) number"     =>
        findElement("id", "radio_EuropeanVesselIDNumber").click()
        findElement("id", "EuropeanVesselIDNumber").sendKeys("123456")
      case "Inland vessel’s name"                            =>
        findElement("id", "radio_NameOfInlandWaterwayVessel").click()
        findElement("id", "NameOfVessel").sendKeys("123456")
      case "Vehicle registration number"                     =>
        findElement("id", "radio_VehicleRegistrationNumber").click()
        findElement("id", "NameOfVessel").sendKeys("123456")
    }
    departureTransportPageTitleDetailsMap += ("departureTransportPageTitleDetails" -> selectOption)
    submit()
  }
}
