package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object SummarySection6Page extends BasePage {

  val path: String           = "/declaration/summary-section/6"
  val title: String          = "Check your answers"
  val backButtonHref: String = ContainerPage.path

  override def fillPage(values: String*): Unit =
    checkSectionSummary(Section6)

}
