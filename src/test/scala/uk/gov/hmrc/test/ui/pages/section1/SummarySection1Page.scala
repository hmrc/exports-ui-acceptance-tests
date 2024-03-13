package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{Mucr, Section1}

object SummarySection1Page extends BasePage {

  override def backButtonHref: String = if (maybeDetail(Mucr).isDefined) EnterAMucrPage.path else LinkMucrPage.path

  override def path: String = "/declaration/summary-section/1"

  override def title: String = "Check your answers"

  override protected def performActionsAndStore(values: String*): Unit = {
    checkSectionSummary(Section1)
    continue()
  }

}
