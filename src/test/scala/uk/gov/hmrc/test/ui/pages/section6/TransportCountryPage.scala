package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.transportCountry
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object TransportCountryPage extends BasePage {

  val path: String  = "declaration/transport-country"
  def title: String =
    s"Select the country where the ${detail(TransportLeavingBorder).toLowerCase} is registered"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(transportCountry)
  )

  private val country = 0

  def backButtonHref: String =
    if (inlandOrBorderValue && !isTransportLeavingBorderModePostalOrFixed && !shouldSkipInlandOrBorder()) {
      if (checkIfDecIsOcaOrSim) InlandOrBorderPage.path
      else if (checkIfDecIsStdOrSup) DepartureTransportPage.path
      else BorderTransportPage.path
    } else {
      BorderTransportPage.path
    }

  def performActionsAndStore(values: String*): Unit = {
    fillAutoComplete("transport-country", values(country))
    store(TransportCountry -> Detail(values(country)))
  }
}
