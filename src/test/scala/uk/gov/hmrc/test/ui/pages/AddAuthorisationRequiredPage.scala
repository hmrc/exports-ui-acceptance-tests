/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.Keys
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddAuthorisationRequiredPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/consignee-details"
  val addAuthorisationRequiredPage = "Add any authorisations for this export"
  var authorisationRequiredDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    AddAuthorisationRequiredPage.onPage(addAuthorisationRequiredPage)
  }

  def typeAuthorisationCode(authorisationCode:String): Unit = {
    findElement("id", "authorisationTypeCode").clear()
    findElement("id", "authorisationTypeCode").sendKeys(Keys.chord(superKey, "a"))
    findElement("id", "authorisationTypeCode").sendKeys(authorisationCode)
    findElement("id", "authorisationTypeCode").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
  }

  def enterAuthorisationCodeWithDetails(authorisationCode:String, whoHoldsThisAuthorisation:String): Unit = {
    whoHoldsThisAuthorisation match {
      case "UserEori" => findElement("id","UserEori").click()
      case "OtherEori" => findElement("id","OtherEori").click()
    }
    val authorisationCodeEntered: String = typeAuthorisationCode(authorisationCode).toString

    declarationDetailsMap+=("WhoHoldsAuthorisation" -> whoHoldsThisAuthorisation)
    declarationDetailsMap+=("authorisationCode" -> authorisationCodeEntered)
    submit()
  }
}
