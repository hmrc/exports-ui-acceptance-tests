package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage

object NotDeclarantPage extends BasePage {

  def backButtonHref: String = ChoicePage.path

  val path: String = "/declaration/not-declarant"

  val title: String = "Use a different EORI number"

  override protected def fillPage(values: String*): Unit = ()
}
