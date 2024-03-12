package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._
object MultipleContainerPage extends BasePage {

  val path: String           = s"/declaration/container"
  val title                  = s"What is the container ID?"
  val backButtonHref: String = TransportPaymentPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-7-transport-information-modes-means-and-equipment#de-710-container-identification-number-box-31-packages-and-description-of-goods"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-7-transport-information-modes-means-and-equipment#de-710-container-identification-number-box-31-packages-and-description-of-goods"
    )
  )

  val code = 0

  def performActionsAndStore(values: String*): Unit = {
    findElementById("id").sendKeys(values(code))
    store(Container -> Detail(values(code)))
  }
}
