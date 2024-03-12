package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{warehouseIdentification, warehouseIdentificationCL}
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.WarehouseHouse

object WarehousePage extends BasePage {

  val path: String           = "/declaration/warehouse-details"
  def title: String          = "What is the customs approved warehouse number?"
  val backButtonHref: String = TransportLeavingTheBorderPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(warehouseIdentification),
    Clearance -> List(warehouseIdentificationCL)
  )

  val code = 0
  def performActionsAndStore(values: String*): Unit = {
    fillTextBoxById("identificationNumber", values(code))
    store(WarehouseHouse -> Detail(values(code)))
  }
}
