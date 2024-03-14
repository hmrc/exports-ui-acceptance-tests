package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._

object DeclarationTypePage extends BasePage {

  def backButtonHref: String = DeclarationChoicePage.path

  val path: String = "/declaration/type"

  def title: String = if (detail(DeclarationType) == Supplementary)
    "What type of supplementary declaration do you want to make?"
  else "Do you have to make an arrived export declaration?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> Seq(decType),
    Clearance -> Seq(decTypeCL)
  )

  override def fillPage(values: String*): Unit = {

    val additionalDeclarationType =
      (detail(DeclarationType), values(0)) match {
        case (Supplementary, NonEidr) => clickById(NonEidr); "Simplified - type Y"
        case (Supplementary, Eidr)    => clickById(Eidr); "EIDR - type Z"
        case (Standard, Arrived)      => clickById(Arrived); "Arrived - type A"
        case (Standard, Prelodged)    => clickById(Prelodged); "Pre-lodged - type D"
        case (Simplified, Arrived)    => clickById(Arrived); "Arrived - type C"
        case (Simplified, Prelodged)  => clickById(Prelodged); "Pre-lodged - type F"
        case (Occasional, Arrived)    => clickById(Arrived); "Arrived - type B"
        case (Occasional, Prelodged)  => clickById(Prelodged); "Pre-lodged - type E"
        case (Clearance, Arrived)     => clickById(Arrived); "Arrived - type J"
        case (Clearance, Prelodged)   => clickById(Prelodged); "Pre-lodged - type K"
      }
    store(AdditionalDeclarationType -> Detail(additionalDeclarationType))
  }

}
