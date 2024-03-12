package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.transportCountry
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object TransportCountryPage extends BasePage {

  val path: String           = "declaration/transport-country"
  def title: String          =
    s"Select the country where the ${detail(TransportLeavingBorder).toLowerCase} is registered"
  val backButtonHref: String = BorderTransportPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(transportCountry)
  )

  val country = 0

  def performActionsAndStore(values: String*): Unit = {
    fillAutoComplete("transport-country", values(country))
    store(TransportCountry -> Detail(values(country)))
  }
}
