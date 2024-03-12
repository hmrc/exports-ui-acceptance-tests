package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object SealsListPage extends BasePage {

  val path: String           = s"/declaration/containers/${detail(Container).value}/seals"
  val title                  = s"You have added 1 security seal for container ${detail(Container).value}" // check the url again
  val backButtonHref: String = TransportPaymentPage.path

  val yesNo = 0

  def performActionsAndStore(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))
}
