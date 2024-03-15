package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage

object ContainersListPage extends BasePage {

  val path: String           = "/declaration/containers"
  def title                  = s"You have added $containerId containers"
  def backButtonHref: String =
    ContainerPage.backButtonHref // should have the same back button logic as first container page

  private val yesNo = 0

  override def fillPage(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))
}
