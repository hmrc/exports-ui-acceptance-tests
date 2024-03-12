package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{ducr, ducrCL}

object DoYouHaveADucrPage extends BasePage {
  override def backButtonHref: String = DeclarantDetailsPage.path

  override def path: String = "/declaration/do-you-have-ducr"

  override def title: String = "Do you have a Declaration Unique Consignment Reference Number (DUCR)?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(ducr),
    Clearance -> Seq(ducrCL)
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val yesNo = values.head
    selectYesOrNoRadio(yesNo)
  }

}
