package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object ContainersListPage extends BasePage {

  val path: String           = s"/declaration/containers/${detail(Container)}/seals"
  val title                  = s"You have added 2 containers" // check the url again
  val backButtonHref: String = TransportPaymentPage.path

  val yesNo = 0

  def performActionsAndStore(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))
}
