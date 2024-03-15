package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage

object ContainerRemovePage extends BasePage {

  def path: String           = removeUrl("containers")
  val title                  = "Are you sure you want to remove this container?"
  def backButtonHref: String = ContainersListPage.path

  private val yesNo = 0

  def fillPage(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))
}
