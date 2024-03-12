package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.Section5
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.WarehouseHouse

import scala.collection.mutable

object WarehousePage extends BasePage {

  val path: String           = "/declaration/warehouse-details"
  def title: String          = "What is the customs approved warehouse number?"
  val backButtonHref: String = TransportLeavingTheBorderPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(warehouseIdentification),
    Clearance -> List(warehouseIdentificationCL)
  )

  val proCodes: = allSectionDetails(Section5).filter(_._1.label == ProcedureCodeLabel).valuesIterator.exists(_.)

  val code = 0
  def performActionsAndStore(values: String*): Unit = {
    fillTextBoxById("identificationNumber", values(code))
    store(WarehouseHouse -> Detail(values(code)))
  }
}
