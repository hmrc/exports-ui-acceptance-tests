package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{ducr, ducrCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Ducr

object DucrEntryPage extends BasePage {

  override def backButtonHref: String = DoYouHaveADucrPage.path

  override def path: String = "/declaration/ducr-entry"

  override def title: String = "Enter your Declaration Unique Consignment Reference (DUCR)"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(ducr),
    Clearance -> Seq(ducrCL)
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val ducr = values.head
    fillTextBoxById("ducr", ducr)
    store(Ducr -> Detail(ducr))
  }
}
