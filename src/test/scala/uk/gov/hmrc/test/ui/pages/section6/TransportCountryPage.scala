package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object TransportCountryPage extends BasePage {

  val path: String           = "declaration/transport-country"
  def title: String          =
    s"Select the country where the ${detail(TransportLeavingBorder).value.toLowerCase} is registered"
  val backButtonHref: String = BorderTransportPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-7-transport-information-modes-means-and-equipment#de-715-nationality-of-active-means-of-transport-crossing-the-border-box-21---identity-and-nationality-of-the-active-means-of-transport-crossing-the-border-nationality"
    )
  )

  val country = 0

  def performActionsAndStore(values: String*): Unit = {
    fillAutoComplete("transport-country", values(country))
    store(TransportCountry -> Detail(values(country)))
  }
}
