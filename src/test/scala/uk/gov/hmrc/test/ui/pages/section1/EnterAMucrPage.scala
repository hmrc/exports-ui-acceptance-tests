package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{mucr, mucrCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Mucr

object EnterAMucrPage extends BasePage {

  override def backButtonHref: String = LinkMucrPage.path

  override def path: String = "/declaration/enter-a-mucr"

  override def title: String = "Enter the MUCR"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(mucr),
    Clearance -> Seq(mucrCL)
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val mucr = values.head
    fillTextBoxById("MUCR", mucr)
    store(Mucr -> Detail(mucr))
  }
}
