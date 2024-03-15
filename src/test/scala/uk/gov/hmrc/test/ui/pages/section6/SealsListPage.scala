package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object SealsListPage extends BasePage {

  def path: String           = s"/declaration/containers/$containerId/seals"
  def backButtonHref: String = TransportPaymentPage.path

  def title: String =
    details(Seals(containerId)).size match {
      case 1 => s"You have added 1 security seal for container $containerId"
      case n => s"You have added $n security seal for container $containerId"
    }

  private val yesNo = 0

  def fillPage(values: String*): Unit =
    selectYesOrNoRadio(values(yesNo))
}
