package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage

object NotDeclarantPage extends BasePage {

  override def backButtonHref: String = ChoicePage.path

  override def path: String = "/declaration/not-declarant"

  override def title: String = "Use a different EORI number"

  override protected def performActionsAndStore(values: String*): Unit = ()
}
