package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object DepartureTransportPage extends BasePage {

  val path: String           = "/declaration/departure-transport"
  def title: String          =
    s"What are the details for the ${detail(TransportLeavingBorder).value.toLowerCase} transport?"
  val backButtonHref: String = InlandOrBorderPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-7-transport-information-modes-means-and-equipment#de-77-identity-of-the-means-of-transport-at-departure"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-7-transport-information-modes-means-and-equipment#de-77-identity-of-the-means-of-transport-at-departure"
    )
  )

  val departRef = 0

  def performActionsAndStore(values: String*): Unit = {
    val (radioId, textboxId, textboxValue) = values.head match {
      case "Ship IMO number"                                 => ("radio_ShipOrRoroImoNumber", "ShipOrRoroImoNumber", "123456")
      case "Ship name"                                       => ("radio_NameOfVessel", "NameOfVessel", "Seraphim")
      case "Eurotunnel or other rail details"                => ("radio_WagonNumber", "WagonNumber", "EuroTunnel")
      case "Flight number and date of flight"                => ("radio_FlightNumber", "FlightNumber", "123456")
      case "Aircraft registration number and date of flight" =>
        ("radio_AircraftRegistrationNumber", "AircraftRegistrationNumber", "123456")
      case "European vessel identification (ENI) number"     =>
        ("radio_EuropeanVesselIDNumber", "EuropeanVesselIDNumber", "123456")
      case "Inland vessel’s name"                            => ("radio_NameOfInlandWaterwayVessel", "NameOfVessel", "123456")
      case "Vehicle registration number"                     => ("radio_VehicleRegistrationNumber", "NameOfVessel", "123456")
    }

    fillRadioButton(radioId, textboxId, textboxValue)
    store(DepartureTransport -> Details(List(values(departRef), textboxValue)))
  }
}
