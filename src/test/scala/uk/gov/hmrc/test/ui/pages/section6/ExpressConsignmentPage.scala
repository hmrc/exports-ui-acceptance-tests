package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.ExpressConsignment

object ExpressConsignmentPage extends BasePage {

  val path: String           = "/declaration/express-consignment"
  def title: String          = "Is this an express consignment?"
  val backButtonHref: String = TransportCountryPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-1-message-information-including-procedure-codes#de-17-specific-circumstance-indicator"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-1-message-information-including-procedure-codes#de-17-specific-circumstance-indicator"
    )
  )

  val yesNo = 0

  def performActionsAndStore(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo))
    store(ExpressConsignment -> Detail(values(yesNo)))
  }
}
