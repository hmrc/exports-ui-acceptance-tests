package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.Container

object FirstContainerPage extends BasePage {

  val path: String = "/declaration/container"
  val title        = "Are the goods in a container or containers?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(container),
    Clearance -> List(containerCL, containerCL1)
  )

  private def SupplementaryBackNavigation: String =
    if (
      (isInlandModeOfTransportPostalOrFixed && inlandOrBorderValue && !shouldSkipInlandOrBorder && !isGuernseyOrJersey)
      || (isGuernseyOrJersey && inlandOrBorderValue && !shouldSkipInlandOrBorder)
    )
      InlandOrBorderPage.path
    else if (
      !isInlandModeOfTransportPostalOrFixed && !isInlandModeOfTransportPostalOrFixed && !isTransportLeavingBorderModePostalOrFixedOrRail && !isGuernseyOrJersey
    )
      TransportCountryPage.path
    else if (
      !isGuernseyOrJersey && isTransportLeavingBorderModeRail && inlandOrBorderValue && !shouldSkipInlandOrBorder
    )
      DepartureTransportPage.path
    else if (
      (!isGuernseyOrJersey && isTransportLeavingBorderModeRail && !inlandOrBorderValue) ||
      (shouldSkipInlandOrBorder && isTransportLeavingBorderModeRail)
    )
      BorderTransportPage.path
    else InlandModeOfTransportPage.path

  def backButtonHref(): String =
    if (checkIfDecIsSup)
      SupplementaryBackNavigation
    else if (isExpressConsignment)
      TransportPaymentPage.path
    else
      ExpressConsignmentPage.path

  private val yesNo = 0
  private val code  = 1

  def performActionsAndStore(values: String*): Unit = {
    if (selectYesOrNoRadio(values(yesNo))) fillTextBoxById("id", values(code))
    store(Container -> Detail(values(code)))
  }
}
