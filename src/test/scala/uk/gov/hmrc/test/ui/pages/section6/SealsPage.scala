package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object SealsPage extends BasePage {

  val path: String           = s"/declaration/containers/${detail(Container).value}/seals"
  val title                  = s"Does container ${detail(Container).value} have any security seals?"
  val backButtonHref: String = TransportPaymentPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-7-transport-information-modes-means-and-equipment#de-718-seal-number-ex-box-d"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-7-transport-information-modes-means-and-equipment#de-718-seal-number-ex-box-d"
    )
  )

  val id = 0

  def performActionsAndStore(values: String*): Unit = {
    findElementById("id").sendKeys(values(id))
    store(AddSeals -> Detail(values(id)))
  }
}
