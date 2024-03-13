package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object DepartureTransportPage extends BasePage {

  val path: String  = "/declaration/departure-transport"
  def title: String =
    s"What are the details for the ${detail(TransportLeavingBorder).toLowerCase} transport?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(departureTransport),
    Clearance -> List(departureTransportCL)
  )

  val checkIfDecIsSupEidr: Boolean =
    detail(DeclarationType) == DeclarationTypes.Occasional && detail(DeclarationType) == DeclarationTypes.Simplified

  def backButtonHref: String =
    if (detail(DeclarationType) == DeclarationTypes.Clearance)
      SupervisingCustomsOfficePage.path
    else if (inlandOrBorderValue && !checkIfDecIsSupEidr && !shouldSkipInlandOrBorder)
      InlandOrBorderPage.path
    else
      InlandModeOfTransportPage.path

  private val departRef = 0

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
