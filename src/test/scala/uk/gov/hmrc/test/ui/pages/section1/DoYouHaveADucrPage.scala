package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{ducr, ducrCL}

object DoYouHaveADucrPage extends BasePage {
  def backButtonHref: String = DeclarantDetailsPage.path

  val path: String = "/declaration/do-you-have-ducr"

  val title: String = "Do you have a Declaration Unique Consignment Reference Number (DUCR)?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> Seq(ducr),
    Clearance -> Seq(ducrCL)
  )

  override protected def fillPage(values: String*): Unit = {
    val yesNo = values.head
    selectYesOrNoRadio(yesNo)
  }

}
