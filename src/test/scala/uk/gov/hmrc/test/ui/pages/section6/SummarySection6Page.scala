package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.{Container, Section6}

object SummarySection6Page extends BasePage {

  override def backButtonHref: String = if (maybeDetail(Container).isDefined)

  override def path: String = "/declaration/summary-section/6"

  override def title: String = "Check your answers"

  override protected def performActionsAndStore(values: String*): Unit = {
    checkSectionSummary(Section6)
    continue()
  }

}
