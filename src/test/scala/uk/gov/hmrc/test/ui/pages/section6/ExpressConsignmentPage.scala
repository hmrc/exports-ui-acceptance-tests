package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{expressConsignment, expressConsignmentCL}
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.ExpressConsignment

object ExpressConsignmentPage extends BasePage {

  val path: String           = "/declaration/express-consignment"
  def title: String          = "Is this an express consignment?"
  val backButtonHref: String = TransportCountryPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(expressConsignment),
    Clearance -> List(expressConsignmentCL)
  )

  val yesNo = 0

  def performActionsAndStore(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo))
    store(ExpressConsignment -> Detail(values(yesNo)))
  }
}
