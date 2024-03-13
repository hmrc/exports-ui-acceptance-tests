package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{containerChange, containerChangeCL}
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._
object MultipleContainerPage extends BasePage {

  val path: String           = s"/declaration/container"
  val title                  = s"What is the container ID?"
  val backButtonHref: String = TransportPaymentPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(containerChange),
    Clearance -> List(containerChangeCL)
  )

  private val code = 0

  def performActionsAndStore(values: String*): Unit = {
    findElementById("id").sendKeys(values(code))
    store(Container -> Detail(values(code)))
  }
}
