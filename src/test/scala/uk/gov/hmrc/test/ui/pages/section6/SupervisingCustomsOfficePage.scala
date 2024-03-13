package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6.hasEndingCodes
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.SuperVisingCustomsOffice

object SupervisingCustomsOfficePage extends BasePage {

  val path: String  = "/declaration/supervising-customs-office"
  def title: String = "Where is the HMRC supervising customs office (SPOFF)?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(supervisingCustomsOffice),
    Clearance -> List(supervisingCustomsOfficeCL)
  )

  def backButtonHref(): String =
    if (hasEndingCodes) WarehousePage.path
    else TransportLeavingTheBorderPage.path

  private val officeCode = 0

  def performActionsAndStore(values: String*): Unit = {
    fillAutoComplete("supervisingCustomsOffice", values(officeCode))
    store(SuperVisingCustomsOffice -> Detail(values(officeCode)))
  }
}
