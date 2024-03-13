package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object SealsChoicePage extends BasePage {

  val path: String           = s"/declaration/containers/${detail(Container)}/add-seals"
  val title                  = s"Does container ${detail(Container)} have any security seals?"
  val backButtonHref: String = FirstContainerPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(containersSeals),
    Clearance -> List(containersSealsCL)
  )

  private val yesNo = 0

  def performActionsAndStore(values: String*): Unit =
    selectRadioAndClick(values(yesNo))
}
