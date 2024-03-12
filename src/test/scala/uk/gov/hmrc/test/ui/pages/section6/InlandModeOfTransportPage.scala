package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{container, containerCL, containerCL1, inlandTransportDetails}
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.TransportLeavingBorder

object InlandModeOfTransportPage extends BasePage {

  val path: String           = "/declaration/inland-transport-details"
  def title: String          = "How will the goods be transported to the UK border?"
  val backButtonHref: String = InlandOrBorderPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(container),
    Clearance -> List(containerCL, containerCL1)
  )

  val mode = 0

  def performActionsAndStore(values: String*): Unit = {
    val elementId = values(mode) match {
      case "Road transport"                           => "Inland_Road"
      case "Rail transport"                           => "Inland_Rail"
      case "Sea transport"                            => "Inland_Sea"
      case "Air transport"                            => "Inland_Air"
      case "Postal or mail"                           => "Inland_PostalOrMail"
      case "Fixed transport installations"            => "Inland_FixedTransportInstallations"
      case "Inland waterway transport"                => "Inland_InlandWaterway"
      case "Mode unknown, for example own propulsion" => "Inland_Unknown"
    }
    clickById(elementId)
    store(TransportLeavingBorder -> Detail(values(mode)))
  }
}
