package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{traderReference, traderReferenceCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Ducr

object ConfirmDucrPage extends BasePage {

  override def backButtonHref: String = TraderReferencePage.path

  override def path: String = "/declaration/confirm-ducr"

  override def title: String = "Do you want to use this DUCR?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(traderReference),
    Clearance -> Seq(traderReferenceCL)
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val yesNo = values.head
    selectYesOrNoRadio(yesNo)
    yesNo match {
      case "Yes" => ()
      case "No" => clear(Ducr)
    }
  }
}
