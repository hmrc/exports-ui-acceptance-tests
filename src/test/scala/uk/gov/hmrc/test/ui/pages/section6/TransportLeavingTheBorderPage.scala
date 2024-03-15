package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section5.SummarySection5Page
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.TransportLeavingBorder

object TransportLeavingTheBorderPage extends BasePage {

  val path: String           = "/declaration/transport-leaving-the-border"
  val title: String          = "What mode of transport will the goods leave the UK on?"
  val backButtonHref: String = SummarySection5Page.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(transportLeavingTheBorder),
    Clearance -> List(transportLeavingTheBorderCL)
  )

  private val transportType = 0

  def fillPage(values: String*): Unit = {
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
