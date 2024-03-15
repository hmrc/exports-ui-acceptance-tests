package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{mucr, mucrCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.LinkToMucr

object LinkMucrPage extends BasePage {

  def backButtonHref: String = LrnPage.path

  val path: String = "/declaration/link-to-mucr"

  val title: String = "Do you want to link this declaration’s DUCR to a Master Unique Consignment Reference (MUCR)?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> Seq(mucr),
    Clearance -> Seq(mucrCL)
  )

  override protected def fillPage(values: String*): Unit = {
    val yesNo = values.head
    selectYesOrNoRadio(yesNo)
    store(LinkToMucr -> Detail(yesNo))
  }
}
