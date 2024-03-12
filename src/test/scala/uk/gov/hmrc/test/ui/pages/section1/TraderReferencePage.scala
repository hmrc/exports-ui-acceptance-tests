package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{traderReference, traderReferenceCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{DeclarationEori, Ducr}

import java.time.{Instant, ZoneId}

object TraderReferencePage extends BasePage {

  override def backButtonHref: String = DoYouHaveADucrPage.path

  override def path: String = "/declaration/trader-reference"

  override def title: String = "Enter a reference"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(traderReference),
    Clearance -> Seq(traderReferenceCL)
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val traderReference = values.head
    val generatedDucr = generateDucr(traderReference)
    fillTextBoxById("traderReferenceInput", generatedDucr)
    store(Ducr -> Detail(generatedDucr))
  }

  private def generateDucr(traderReference: String): String = {
    val lastDigitOfYear = Instant.now.atZone(ZoneId.of("Europe/London")).getYear.toString.last
    val eori = detail(DeclarationEori).toUpperCase

    s"${lastDigitOfYear}GB${eori.dropWhile(_.isLetter)}-$traderReference"
  }

}
