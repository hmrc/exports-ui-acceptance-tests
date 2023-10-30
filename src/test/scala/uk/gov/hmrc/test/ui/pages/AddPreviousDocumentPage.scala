/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddPreviousDocumentPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/add-previous-document"
  val addPreviousDocumentPageTitle = "Details for each document that supports this declaration"
  var addPreviousDocumentDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    AddPreviousDocumentPage.onPage(addPreviousDocumentPageTitle)
  }

  def typeDocumentCode(documentCode:String): String = {
    findElement("id", "documentType").clear()
    findElement("id", "documentType").sendKeys(Keys.chord(superKey, "a"))
    val enteredDocumentCode: WebElement = findElement("id", "documentType")
      enteredDocumentCode.sendKeys(documentCode)
    findElement("id", "documentType").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    enteredDocumentCode.getText
  }

  def enterDocumentCodeDetails(documentCode:String): Unit = {
    val documentCodeEntered: String = typeDocumentCode(documentCode)
    val documentCodeReference : WebElement = findElement("id","documentReference")
      documentCodeReference.sendKeys("SMITH")

    declarationDetailsMap+=("DocumentCode" -> documentCodeEntered)
    declarationDetailsMap+=("DocumentCodeReference" -> documentCodeReference.getText)
    submit()
  }
}
