package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.inlandTransportDetails
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object InlandModeOfTransportPage extends BasePage {

  val path: String  = "/declaration/inland-transport-details"
  def title: String = "How will the goods be transported to the UK border?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(inlandTransportDetails)
  )

  def backButtonHref(): String =
    if (!shouldSkipInlandOrBorder && detail(InlandOrBorder) == "Border Location") {
      InlandOrBorderPage.path
    } else if (shouldSkipInlandOrBorder && isSPOFFNotNeeded) {
      TransportLeavingTheBorderPage.path
    } else {
      SupervisingCustomsOfficePage.path
    }

  private val mode = 0

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
