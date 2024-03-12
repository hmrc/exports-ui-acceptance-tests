package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.TransportLeavingBorder

object InlandModeOfTransportPage extends BasePage {

  val path: String           = "/declaration/inland-transport-details"
  def title: String          = "How will the goods be transported to the UK border?"
  val backButtonHref: String = InlandOrBorderPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-7-transport-information-modes-means-and-equipment#de-75-inland-mode-of-transport-box-26-inland-mode-of-transport"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-7-transport-information-modes-means-and-equipment#de-74-mode-of-transport-at-the-border-box-25-mode-of-transport-at-the-border"
    )
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
