package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{declarantDetails, declarantDetailsCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationEori

object DeclarantDetailsPage extends BasePage {

  override def backButtonHref: String = DeclarationTypePage.path

  override def path: String = "/declaration/declarant-details"

  override def title: String = s"Is your EORI number ${details(DeclarationEori).head}?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(declarantDetails),
    Clearance -> Seq(declarantDetailsCL)
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val isThisYourEori = values.head
    selectYesOrNoRadio(isThisYourEori)
  }
}
