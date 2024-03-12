package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.Container

object FirstContainerPage extends BasePage {

  val path: String           = "/declaration/container"
  val title                  = "Are the goods in a container or containers?"
  val backButtonHref: String = TransportPaymentPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-7-transport-information-modes-means-and-equipment#de-72-container-box-19-container"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-7-transport-information-modes-means-and-equipment#de-72-container-box-19-container",
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-7-transport-information-modes-means-and-equipment#de-710-container-identification-number-box-31-packages-and-description-of-goods"
    )
  )

  val yesNo = 0
  val code  = 1

  def performActionsAndStore(values: String*): Unit = {
    if (selectYesOrNoRadio(values(yesNo))) fillTextBoxById("id", values(code))
    store(Container -> Detail(values(code)))
  }
}
