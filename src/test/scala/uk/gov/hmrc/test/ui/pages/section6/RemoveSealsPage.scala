package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object RemoveSealsPage extends BasePage {

  val path: String           = s"/declaration/containers/${detail(Container)}/remove"
  val title                  = "Are you sure you want to remove this container?"
  val backButtonHref: String = ContainersListPage.path

  val yesNo = 0

  def performActionsAndStore(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))
}
