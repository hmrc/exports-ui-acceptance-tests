package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants}
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{traderReference, traderReferenceCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Ducr

object ConfirmDucrPage extends BasePage {

  def backButtonHref: String = TraderReferencePage.path

  val path: String = "/declaration/confirm-ducr"

  val title: String = "Do you want to use this DUCR?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> Seq(traderReference),
    Clearance -> Seq(traderReferenceCL)
  )

  override protected def fillPage(values: String*): Unit = {
    val yesNo = values.head
    selectYesOrNoRadio(yesNo)
    yesNo match {
      case Constants.yes => ()
      case Constants.no  => clear(Ducr)
    }
  }
}
