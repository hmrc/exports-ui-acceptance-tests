package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.BasePage._

object StartPage extends BasePage {

  def backButtonHref: String              = ""
  val path: String                        = "/start"
  val title: String                       = "Declare your goods for export from the UK to other countries"
  override val pageLinkHrefs: Seq[String] =
    List(feedbackBanner, govUkLogo, languageToggle, signOut, technicalIssue)

  override protected def checkBackButton(): Unit = ()

  override protected def fillPage(values: String*): Unit = ()
}
