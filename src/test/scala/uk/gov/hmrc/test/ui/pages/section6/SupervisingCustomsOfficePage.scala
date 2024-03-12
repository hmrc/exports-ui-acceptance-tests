package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{supervisingCustomsOffice, supervisingCustomsOfficeCL}
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.SuperVisingCustomsOffice

object SupervisingCustomsOfficePage extends BasePage {

  val path: String           = "/declaration/supervising-customs-office"
  def title: String          = "Where is the HMRC supervising customs office (SPOFF)?"
  val backButtonHref: String = WarehousePage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(supervisingCustomsOffice),
    Clearance -> List(supervisingCustomsOfficeCL)
  )

  val officeCode = 0

  def performActionsAndStore(values: String*): Unit = {
    fillAutoComplete("supervisingCustomsOffice", values(officeCode))
    store(SuperVisingCustomsOffice -> Detail(values(officeCode)))
  }
}
