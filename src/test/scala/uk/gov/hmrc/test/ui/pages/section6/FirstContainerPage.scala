package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.Container

object FirstContainerPage extends BasePage {

  val path: String           = "/declaration/container"
  val title                  = "Are the goods in a container or containers?"
  val backButtonHref: String = TransportPaymentPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(container),
    Clearance -> List(containerCL, containerCL1)
  )

  val yesNo = 0
  val code  = 1

  def performActionsAndStore(values: String*): Unit = {
    if (selectYesOrNoRadio(values(yesNo))) fillTextBoxById("id", values(code))
    store(Container -> Detail(values(code)))
  }
}
