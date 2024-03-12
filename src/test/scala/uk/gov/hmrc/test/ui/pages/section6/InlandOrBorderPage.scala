package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.Common
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.inlandOrBorder
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.InlandOrBorder

object InlandOrBorderPage extends BasePage {

  val path: String           = "/declaration/inland-or-border"
  def title: String          = "Where are you presenting your goods to customs?"
  val backButtonHref: String = SupervisingCustomsOfficePage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(inlandOrBorder))

  val location = 0
  def performActionsAndStore(values: String*): Unit = {
    values match {
      case "Border Location"             => clickById("Border")
      case "Customs controlled location" => clickById("Inland")
    }
    store(InlandOrBorder -> Detail(values(location)))
  }
}
