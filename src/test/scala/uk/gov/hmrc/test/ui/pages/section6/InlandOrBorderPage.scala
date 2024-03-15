package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.inlandOrBorder
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.InlandOrBorder

object InlandOrBorderPage extends BasePage {

  val path: String  = "/declaration/inland-or-border"
  val title: String = "Where are you presenting your goods to customs?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(inlandOrBorder))

  def backButtonHref(): String =
    if (isSPOFFNotNeeded) {
      TransportLeavingTheBorderPage.path
    } else if (checkIfDecIsClr) {
      WarehousePage.path
    } else {
      SupervisingCustomsOfficePage.path
    }

  private val location = 0

  def fillPage(values: String*): Unit = {
    values match {
      case "Border Location"             => clickById("Border")
      case "Customs controlled location" => clickById("Inland")
    }
    store(InlandOrBorder -> Detail(values(location)))
  }
}
