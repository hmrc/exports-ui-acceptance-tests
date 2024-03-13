package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{lrn, lrnCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Lrn

object LrnPage extends BasePage {

  def backButtonHref: String = DucrEntryPage.path

  val path: String = "/declaration/local-reference-number"

  val title: String = "Create a Local Reference Number (LRN)"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(lrn),
    Clearance -> Seq(lrnCL)
  )
  override protected def performActionsAndStore(values: String*): Unit = {
    val lrn = values.head
    fillTextBoxById("lrn", lrn)
    store(Lrn -> Detail(lrn))
  }
}
