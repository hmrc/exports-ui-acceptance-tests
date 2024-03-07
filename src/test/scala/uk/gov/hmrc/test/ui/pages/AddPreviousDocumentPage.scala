/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object AddPreviousDocumentPage extends BasePage {

  val path: String                                        = "/declaration/add-previous-document"
  val title                       = "Details for each document that supports this declaration"

  val superKey: Keys                                     = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit =
    AddPreviousDocumentPage.checkUrlAndTitle(addPreviousDocumentPageTitle)

  def typeDocumentCode(documentCode: String): String = {
    findElementById("documentType").clear()
    findElementById("documentType").sendKeys(Keys.chord(superKey, "a"))
    val enteredDocumentCode: WebElement = findElementById("documentType")
    enteredDocumentCode.sendKeys(documentCode)
    findElementById("documentType").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    enteredDocumentCode.getText
  }

  def enterDocumentCodeDetails(documentCode: String): Unit = {
    val documentCodeEntered: String       = typeDocumentCode(documentCode)
    val documentCodeReference: WebElement = findElementById("documentReference")
    documentCodeReference.sendKeys("SMITH")

cache += ("DocumentCode"          -> documentCodeEntered)
cache += ("DocumentCodeReference" -> documentCodeReference.getText)
    submit()
  }
}
