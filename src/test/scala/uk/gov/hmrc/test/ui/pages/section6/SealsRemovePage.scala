package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage

object SealsRemovePage extends BasePage {

  def path: String           = removeUrl("containers", "seals")
  def title                  = s"Are you sure you want to remove this security seal for container $containerId?"
  def backButtonHref: String = ContainersListPage.path

  private val yesNo = 0

  def performActionsAndStore(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))
}
