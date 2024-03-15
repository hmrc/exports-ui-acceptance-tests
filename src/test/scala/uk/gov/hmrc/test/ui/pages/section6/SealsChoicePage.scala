package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.Seals

object SealsChoicePage extends BasePage {

  def path: String           = s"/declaration/containers/$containerId/seals"
  def title                  = s"Does container $containerId have any security seals?"
  def backButtonHref: String = ContainerPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(containersSeals),
    Clearance -> List(containersSealsCL)
  )

  private val yesNo = 0

  def fillPage(values: String*): Unit =
    if (!selectYesOrNoRadio(values(yesNo))) store(Seals(containerId) -> Details(List("No Seals")))
}
