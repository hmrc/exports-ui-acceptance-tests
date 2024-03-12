package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.WarehouseHouse

object WarehousePage extends BasePage {

  val path: String           = "/declaration/warehouse-details"
  def title: String          = "What is the customs approved warehouse number?"
  val backButtonHref: String = TransportLeavingTheBorderPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-7-transport-information-modes-means-and-equipment#de-74-mode-of-transport-at-the-border-box-25-mode-of-transport-at-the-border"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-2-references-of-messages-document-certificates-and-authorisations#de-27-identification-of-warehouse-box-49-warehouse-id"
    )
  )

  val code = 0
  def performActionsAndStore(values: String*): Unit = {
    fillTextBoxById("identificationNumber", values(code))
    store(WarehouseHouse -> Detail(values(code)))
  }
}
