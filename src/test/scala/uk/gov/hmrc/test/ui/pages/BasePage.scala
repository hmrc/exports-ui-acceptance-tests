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

import org.openqa.selenium.{By, WebElement}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import scala.collection.mutable

trait BasePage extends BrowserDriver with Matchers {

  val title: String
  val url: String

  def checkUrlAndTitle(): Unit = {
    if (!driver.getCurrentUrl.contains(url))
      throw PageNotFoundException(s"Expected '$url' page, but found '${driver.getCurrentUrl}' page.")

    if (!driver.getTitle.contains(title))
      throw PageNotFoundException(s"Expected '$title' page, but found '${driver.getTitle}' page.")
  }

  def submit(): Unit = clickById("submit")

  def continue(): Unit = clickByXpath("//*[@role='button']")

  def getGovUKLinks(index: Int): WebElement =
    driver.findElements(By.className("govuk-link")).get(index)

  def changeLinkSelector(row: String): By = By.cssSelector(s".$row .govuk-link")

  def changeLink(row: String): WebElement = driver.findElement(changeLinkSelector(row))

  //Finding Elements
  def findElementById(value: String): WebElement          = driver.findElement(By.id(value))
  def findElementByXpath(value: String): WebElement       = driver.findElement(By.xpath(value))
  def findElementByLinkText(value: String): WebElement    = driver.findElement(By.linkText(value))
  def findElementByPartialLink(value: String): WebElement = driver.findElement(By.partialLinkText(value))
  def findElementByCssSelector(value: String): WebElement = driver.findElement(By.cssSelector(value))
  def findElementByClassName(value: String): WebElement   = driver.findElement(By.className(value))

  def clickById(value: String): Unit          = findElementById(value).click()
  def clickByXpath(value: String): Unit       = findElementByXpath(value).click()
  def clickByLinkText(value: String): Unit    = findElementByLinkText(value).click()
  def clickByPartialLink(value: String): Unit = findElementByPartialLink(value).click()
  def clickByCssSelector(value: String): Unit = findElementByCssSelector(value).click()
  def clickByClassName(value: String): Unit   = findElementByClassName(value).click()

  def elementDoesNotExist(elementBy: By): Boolean =
    driver.findElements(elementBy).size() == 0

  def fillRadioButton(idSelector: String, refSelector: String, refText: String): Unit = {
    clickById(idSelector)
    findElementById(refSelector).sendKeys(refText)
  }
}

case class PageNotFoundException(s: String) extends Exception(s)

object Sections {

  val declarationDetails: mutable.Map[String, String] = mutable.Map.empty[String, String]
}
