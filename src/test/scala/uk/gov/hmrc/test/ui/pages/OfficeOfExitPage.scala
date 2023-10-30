/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object OfficeOfExitPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/office-of-exit"
  val officeOfExitPageTitle = "Where is the customs office of exit?"
  var officeOfExitCodeDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    AddAuthorisationRequiredPage.onPage(officeOfExitPageTitle)
  }

  def typeOfficeOfExitCode(officeOfExitCode:String): String = {
    findElement("id", "officeId").clear()
    findElement("id", "officeId").sendKeys(Keys.chord(superKey, "a"))
    val officeOfExitCodeEntered : WebElement =  findElement("id", "officeId")
    officeOfExitCodeEntered.sendKeys(officeOfExitCode)
    findElement("id", "officeId").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    officeOfExitCodeEntered.getText
  }

  def enterOfficeOfExitCodeDetails(officeOfExitCode:String): Unit = {
    val officeOfExitCodeEntered: String = typeOfficeOfExitCode(officeOfExitCode)
    officeOfExitCodeDetailsMap+=("officeOfExitCode" -> officeOfExitCodeEntered)
    submit()
  }
}
