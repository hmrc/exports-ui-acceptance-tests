package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.Common
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object BorderTransportPage extends BasePage {

  val path: String           = "/declaration/border-transport"
  def title: String          =
    s"What are the details for the ${detail(TransportLeavingBorder).value.toLowerCase} transport?"
  val backButtonHref: String = DepartureTransportPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-7-transport-information-modes-means-and-equipment#de-714-identity-of-active-means-of-transport-crossing-the-border-box-21---identity-and-nationality-of-the-active-means-of-transport-crossing-the-border"
    )
  )

  val transport = 0

  def performActionsAndStore(values: String*): Unit = {
    val (radioId, textboxId, textboxValue) = values.head match {
      case "Ship or RoRo ferry IMO number"                   => ("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", "123456")
      case "Ship or RoRo ferry name"                         => ("radio_NameOfVessel", "NameOfVessel", "Seraphim")
      case "Eurotunnel or other rail details"                => ("radio_WagonNumber", "WagonNumber", "EuroTunnel")
      case "Vehicle registration number"                     => ("radio_VehicleRegistrationNumber", "VehicleRegistrationNumber", "123456")
      case "Flight number and date of flight"                => ("radio_FlightNumber", "FlightNumber", "123456")
      case "Aircraft registration number and date of flight" =>
        ("radio_AircraftRegistrationNumber", "AircraftRegistrationNumber", "123456")
      case "European vessel identification (ENI) number"     =>
        ("radio_EuropeanVesselIDNumber", "EuropeanVesselIDNumber", "123456")
      case "Inland vessel’s name"                            => ("radio_NameOfInlandWaterwayVessel", "NameOfInlandWaterwayVessel", "123456")
    }

    def displayBorderType(mode: String): String = mode match {
      case "Ship or RoRo ferry IMO number"                   => "Ship IMO number"
      case "Ship or RoRo ferry name"                         => "Ship name"
      case "Eurotunnel or other rail details"                => "Train"
      case "Vehicle registration number"                     => "Vehicle registration"
      case "Flight number and date of flight"                => "Flight number"
      case "Aircraft registration number and date of flight" => "Aircraft number"
      case "European vessel identification (ENI) number"     => "European vessel number (ENI)"
      case "Inland vessel’s name"                            => "Inland vessel’s name"
    }

    fillRadioButton(radioId, textboxId, textboxValue)
    store(BorderTransport -> Details(List(displayBorderType(values(transport)), textboxValue)))
  }
}
