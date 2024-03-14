package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.Seals

object AdditionalSealPage extends BasePage {

  def path: String           = s"/declaration/containers/$containerId/add-seals"
  def title                  = s"What is the security seal for container $containerId"
  def backButtonHref: String = SealsChoicePage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(containersSeals),
    Clearance -> List(containersSealsCL)
  )

  private val id = 0

  def performActionsAndStore(values: String*): Unit = {
    val seal  = values(id)
    fillTextBoxById("id", seal)
    val seals = maybeDetails(Seals(containerId)).fold(Seq(seal))(_ :+ seal)
    store(Seals(containerId) -> Details(seals))
  }
}
