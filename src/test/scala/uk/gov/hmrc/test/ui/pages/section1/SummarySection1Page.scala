package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{Mucr, Section1}

object SummarySection1Page extends BasePage {

  def backButtonHref: String = if (maybeDetail(Mucr).isDefined) EnterAMucrPage.path else LinkMucrPage.path

  val path: String = "/declaration/summary-section/1"

  val title: String = "Check your answers"

  override protected def fillPage(values: String*): Unit =
    checkSectionSummary(Section1)

}
