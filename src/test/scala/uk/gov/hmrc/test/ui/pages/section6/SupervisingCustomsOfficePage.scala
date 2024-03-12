package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.SuperVisingCustomsOffice

object SupervisingCustomsOfficePage extends BasePage {

  val path: String           = "/declaration/supervising-customs-office"
  def title: String          = "Where is the HMRC supervising customs office (SPOFF)?"
  val backButtonHref: String = WarehousePage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-7-transport-information-modes-means-and-equipment#de-74-mode-of-transport-at-the-border-box-25-mode-of-transport-at-the-border"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-5-dates-times-periods-places-countries-and-regions#de-527-supervising-customs-office-box-44"
    )
  )

  val officeCode = 0

  def performActionsAndStore(values: String*): Unit = {
    fillAutoComplete("supervisingCustomsOffice", values(officeCode))
    store(SuperVisingCustomsOffice -> Detail(values(officeCode)))
  }
}
