package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{containersSeals, containersSealsCL}
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object SealsPage extends BasePage {

  val path: String           = s"/declaration/containers/${detail(Container).value}/seals"
  val title                  = s"Does container ${detail(Container).value} have any security seals?"
  val backButtonHref: String = TransportPaymentPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(containersSeals),
    Clearance -> List(containersSealsCL)
  )

  val id = 0

  def performActionsAndStore(values: String*): Unit = {
    findElementById("id").sendKeys(values(id))
    store(AddSeals -> Detail(values(id)))
  }
}
