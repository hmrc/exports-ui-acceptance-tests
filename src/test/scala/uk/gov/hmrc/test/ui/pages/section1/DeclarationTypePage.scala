package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.{Arrived, Clearance, Common, Prelodged, Supplementary, TypeY, TypeZ}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{decType, decTypeCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{AdditionalDeclarationType, DeclarationType}

object DeclarationTypePage extends BasePage {

  override def backButtonHref: String = DeclarationChoicePage.path

  override def path: String = "/declaration/type"

  override def title: String = if(detail(DeclarationType) == Supplementary) "What type of supplementary declaration do you want to make?"
    else "Do you have to make an arrived export declaration?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(decType),
    Clearance -> Seq(decTypeCL)
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val additionalDeclarationType = values(0)
    additionalDeclarationType match {
      case Arrived => clickById(Arrived)
      case Prelodged => clickById(Prelodged)
      case TypeY => clickById(TypeY)
      case TypeZ => clickById(TypeZ)
    }
    store(AdditionalDeclarationType -> Detail(additionalDeclarationType))
  }
}
