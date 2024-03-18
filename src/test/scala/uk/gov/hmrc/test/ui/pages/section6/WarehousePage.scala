package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.WarehouseHouse

object WarehousePage extends BasePage {

  val path: String           = "/declaration/warehouse-details"
  val title: String          = "What is the customs approved warehouse number?"
  val backButtonHref: String = TransportLeavingTheBorderPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(warehouseIdentification),
    Clearance -> List(warehouseIdentificationCL)
  )

  private val code = 0

  override def fillPage(values: String*): Unit = {
    fillTextBoxById("identificationNumber", values(code))
    store(WarehouseHouse -> Detail(values(code)))
  }
}
