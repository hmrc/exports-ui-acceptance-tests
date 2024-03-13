package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage

object ContainersListPage extends BasePage {

  val path: String           = s"/declaration/containers"
  val title                  = s"You have added 2 containers" // check the url again
  val backButtonHref: String = FirstContainerPage.backButtonHref()

  private val yesNo = 0

  def performActionsAndStore(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))
}
