package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.Common
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6.checkIfDecIsOcaOrSim
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object BorderTransportPage extends BasePage {

  val path: String  = "/declaration/border-transport"
  def title: String =
    s"What are the details for the ${detail(TransportLeavingBorder).toLowerCase} transport?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(borderTransport)
  )

  private val transport = 0

  def backButtonHref: String =
    if (checkIfDecIsOcaOrSim) {
      InlandModeOfTransportPage.path
    } else {
      DepartureTransportPage.path
    }

  case class BorderTransportData(radioId: String, textboxId: String, textboxValue: String, summaryValue: String)

  def performActionsAndStore(values: String*): Unit = {
    val data = values.head match {
      case "Ship or RoRo ferry IMO number"                   =>
        BorderTransportData("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", "123456", "Ship IMO number")
      case "Ship or RoRo ferry name"                         => BorderTransportData("radio_NameOfVessel", "NameOfVessel", "Seraphim")
      case "Eurotunnel or other rail details"                => BorderTransportData("radio_WagonNumber", "WagonNumber", "EuroTunnel")
      case "Vehicle registration number"                     =>
        BorderTransportData("radio_VehicleRegistrationNumber", "VehicleRegistrationNumber", "123456")
      case "Flight number and date of flight"                => BorderTransportData("radio_FlightNumber", "FlightNumber", "123456")
      case "Aircraft registration number and date of flight" =>
        BorderTransportData("radio_AircraftRegistrationNumber", "AircraftRegistrationNumber", "123456")
      case "European vessel identification (ENI) number"     =>
        BorderTransportData("radio_EuropeanVesselIDNumber", "EuropeanVesselIDNumber", "123456")
      case "Inland vessel’s name"                            =>
        BorderTransportData("radio_NameOfInlandWaterwayVessel", "NameOfInlandWaterwayVessel", "123456")
    }
    fillRadioButton(data.radioId, data.textboxId, data.textboxValue)
    store(BorderTransport -> Details(List(data.summaryValue, data.textboxValue)))
  }
}
