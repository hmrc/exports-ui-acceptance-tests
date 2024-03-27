/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.base

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, Keys, WebElement}
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import java.time.Duration
import scala.jdk.CollectionConverters.ListHasAsScala

trait DriverHelper extends BrowserDriver {

  def changeLinkOnCYA(row: String): WebElement = driver.findElement(By.cssSelector(s".$row .govuk-link"))

  def continue(): Unit = clickById("submit")

  def continueOnMiniCya(): Unit = clickByXpath("//*[@role='button']")

  def clickById(value: String): Unit = findElementById(value).click()
  def clickByXpath(value: String): Unit = findElementByXpath(value).click()
  def clickByLinkText(value: String): Unit = findElementByLinkText(value).click()
  def clickByPartialLink(value: String): Unit = findElementByPartialLink(value).click()
  def clickByCssSelector(value: String): Unit = findElementByCssSelector(value).click()
  def clickByClassName(value: String): Unit = findElementByClassName(value).click()

  def elementDoesNotExist(elementBy: By): Boolean =
    driver.findElements(elementBy).size() == 0

  def elementByIdDoesNotExist(elementId: String): Boolean =
    driver.findElements(By.id(elementId)).size() == 0

  def findElementById(value: String): WebElement = driver.findElement(By.id(value))
  def findElementByXpath(value: String): WebElement = driver.findElement(By.xpath(value))
  def findElementByLinkText(value: String): WebElement = driver.findElement(By.linkText(value))
  def findElementByPartialLink(value: String): WebElement = driver.findElement(By.partialLinkText(value))
  def findElementByCssSelector(value: String): WebElement = driver.findElement(By.cssSelector(value))
  def findElementByClassName(value: String): WebElement = driver.findElement(By.className(value))
  def findElementByName(value: String): WebElement = driver.findElement(By.name(value))
  def findElementByTag(value: String): WebElement = driver.findElement(By.tagName(value))

  def findElementsByClassName(value: String): Seq[WebElement] = driver.findElements(By.className(value)).asScala.toList
  def findElementsByTag(value: String): Seq[WebElement] = driver.findElements(By.tagName(value)).asScala.toList

  def findChildByClassName(parent: WebElement, className: String): WebElement =
    parent.findElement(By.className(className))

  def findChildByClassNameIfAny(parent: WebElement, className: String): Option[WebElement] = {
    val elements = parent.findElements(By.className(className))
    if (elements.isEmpty) None else Some(elements.get(0))
  }

  def findChildrenByClassName(parent: WebElement, className: String): Seq[WebElement] =
    parent.findElements(By.className(className)).asScala.toList

  def fillDropdown(elementId: String, value: String, maybeId: Option[String] = None): String = {
    val element = waitFor(elementId)
    element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE)
    element.sendKeys(value)
    val selection = maybeId.fold("") { id =>
      val text = findElementById(id).getText
      assert(text.nonEmpty, s"Option not retrieved for the dropdown $elementId($id)")
      text
    }
    element.sendKeys(Keys.ARROW_DOWN)
    element.sendKeys(Keys.TAB)
    selection
  }

  def fillRadioButton(elementId: String, refSelector: String, refText: String): Unit = {
    clickById(elementId)
    findElementById(refSelector).sendKeys(refText)
  }

  def fillTextBoxById(elementId: String, text: String): Unit =
    waitFor(elementId).sendKeys(text)

  def fillTextBoxByName(name: String, text: String): Unit =
    findElementByName(name).sendKeys(text)

  def selectRadioAndClick(elementId: String): Unit = {
    val actions = new Actions(driver)
    val element = findElementById(elementId)
    actions.moveToElement(element).click().perform()
  }

  def selectYesOrNoRadio(option: String, yes: String = "code_yes", no: String = "code_no"): Boolean =
    option match {
      case Constants.yes => clickById(yes); true
      case Constants.no  => clickById(no); false
    }

  private def waitFor(elementId: String): WebElement =
    new FluentWait(driver)
      .withTimeout(Duration.ofSeconds(10L))
      .pollingEvery(Duration.ofMillis(500L))
      .ignoring(classOf[Exception])
      .until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)))
}
