package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{mucr, mucrCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Mucr

object EnterAMucrPage extends BasePage {

  def backButtonHref: String = LinkMucrPage.path

  val path: String = "/declaration/enter-a-mucr"

  val title: String = "Enter the MUCR"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> Seq(mucr),
    Clearance -> Seq(mucrCL)
  )

  override protected def fillPage(values: String*): Unit = {
    val mucr = values.head
    fillTextBoxById("MUCR", mucr)
    store(Mucr -> Detail(mucr))
  }
}
