package uk.gov.hmrc.test.ui.pages.section1

import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.test.ui.conf.TestConfiguration.url
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationEori

object LoginPage extends BasePage {

  def backButtonHref: String = ""
  val path: String           = "/gg-sign-in"
  val title: String          = "Authority Wizard"

  override protected def checkBackButton(): Unit  = ()
  override protected def checkUrlAndTitle(): Unit = ()
  override protected def checkPageLinks(): Unit   = ()

  // ex: performActionsAndStore("Organisation", "HMRC-CUS-ORG", "EORINumber", "GB7172755076437")
  override protected def fillPage(values: String*): Unit = {
    val affinity      = values(0)
    val enrolmentKey  = values(1)
    val taxIdentifier = values(2)
    val eori          = values(3)

    navigateToLoginPage()
    enterRedirectPage()
    selectAffinity(affinity)
    enterEnrolmentType(enrolmentKey)
    enterTaxIdentifier(taxIdentifier)
    enterEori(eori)
    store(DeclarationEori -> Detail(eori))
  }

  private def navigateToLoginPage(): Unit             = driver.navigate().to(url("login-stub-frontend") + path)
  private def enterRedirectPage(): Unit = {
    val redirectUrl = url("exports-frontend") + StartPage.path
    fillTextBoxById("redirectionUrl", redirectUrl)
  }
  private def selectAffinity(option: String): Unit = {
    val affinity = findElementById("affinityGroupSelect")
    new Select(affinity).selectByValue(option)
  }
  private def enterEnrolmentType(input: String): Unit = fillTextBoxById("enrolment[0].name", input)
  private def enterTaxIdentifier(input: String): Unit = fillTextBoxById("enrolment[0].taxIdentifier[0].name", input)
  private def enterEori(input: String): Unit          = fillTextBoxById("enrolment[0].taxIdentifier[0].value", input)
}
