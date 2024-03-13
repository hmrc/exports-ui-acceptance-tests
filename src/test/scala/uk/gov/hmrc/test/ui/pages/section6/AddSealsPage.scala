package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object AddSealsPage extends BasePage {

  val path: String           = s"/declaration/containers/${detail(Container)}/add-seals"
  val title                  = s"What is the security seal for container ${detail(Container)}"
  val backButtonHref: String = SealsChoicePage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(containersSeals),
    Clearance -> List(containersSealsCL)
  )

  private val id = 0

  def performActionsAndStore(values: String*): Unit = {
    findElementById("id").sendKeys(values(id))
    store(AddSeals -> Detail(values(id)))
  }
}
