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

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, Keys, WebDriver, WebElement}
import uk.gov.hmrc.selenium.webdriver.Driver

import java.time.Duration
import scala.jdk.CollectionConverters.ListHasAsScala
import scala.util.{Failure, Success, Try}

trait ExpectedCondition

case object Clickable extends ExpectedCondition
case object Presence extends ExpectedCondition
case object Visible extends ExpectedCondition

trait DriverHelper {

  protected val driver: WebDriver = uk.gov.hmrc.test.ui.pages.base.DriverHelper.driver

  def changeLinkOnCYA(row: String): WebElement = driver.findElement(By.cssSelector(s".$row .govuk-link"))

  def continue(): Unit = clickById("submit")

  def continueOnMiniCya(): Unit = clickByXpath("//*[@role='button']")

  def clickById(value: String): Unit = findElementById(value).click()
  def clickByXpath(value: String): Unit = findElementByXpath(value).click()
  def clickByLinkText(value: String): Unit = findElementByLinkText(value).click()
  def clickByPartialLink(value: String): Unit = findElementByPartialLink(value).click()
  def clickByCssSelector(value: String): Unit = findElementByCssSelector(value).click()
  def clickByClassName(value: String): Unit = findElementByClassName(value).click()

  def elementByClassDoesNotExist(className: String, secondsToWaitFor: Int = 0): Boolean =
    if (secondsToWaitFor == 0) driver.findElements(By.className(className)).size() == 0
    else
      Try(waitForClass(className, Presence, secondsToWaitFor)) match {
        case Success(_) => false
        case Failure(_) => true
      }

  def elementByIdDoesNotExist(elementId: String, secondsToWaitFor: Int = 0): Boolean =
    if (secondsToWaitFor == 0) driver.findElements(By.id(elementId)).size() == 0
    else
      Try(waitForId(elementId, Presence, secondsToWaitFor)) match {
        case Success(_) => false
        case Failure(_) => true
      }

  def elementBySelectorDoesNotExist(selector: String, secondsToWaitFor: Int = 0): Boolean =
    if (secondsToWaitFor == 0) driver.findElements(By.cssSelector(selector)).size() == 0
    else
      Try(waitForClass(selector, Presence, secondsToWaitFor)) match {
        case Success(_) => false
        case Failure(_) => true
      }


  def findElementById(value: String): WebElement = driver.findElement(By.id(value))
  def findElementByXpath(value: String): WebElement = driver.findElement(By.xpath(value))
  def findElementByLinkText(value: String): WebElement = driver.findElement(By.linkText(value))
  def findElementByPartialLink(value: String): WebElement = driver.findElement(By.partialLinkText(value))
  def findElementByCssSelector(value: String): WebElement = driver.findElement(By.cssSelector(value))
  def findElementByClassName(value: String): WebElement = driver.findElement(By.className(value))
  def findElementByName(value: String): WebElement = driver.findElement(By.name(value))
  def findElementByTag(tag: String): WebElement = driver.findElement(By.tagName(tag))

  def findElementsByClassName(value: String): Seq[WebElement] = driver.findElements(By.className(value)).asScala.toList
  def findElementsByTag(tag: String): Seq[WebElement] = driver.findElements(By.tagName(tag)).asScala.toList

  def findChildByClassName(parent: WebElement, className: String): WebElement =
    parent.findElement(By.className(className))

  def findChildByCssSelector(parent: WebElement, className: String): WebElement =
    parent.findElement(By.cssSelector(className))

  def findChildByClassNameIfAny(parent: WebElement, className: String): Option[WebElement] = {
    val elements = parent.findElements(By.className(className))
    if (elements.isEmpty) None else Some(elements.get(0))
  }

  def findChildrenByClassName(parent: WebElement, className: String): Seq[WebElement] =
    parent.findElements(By.className(className)).asScala.toList

  def findChildrenByCssSelector(parent: WebElement, className: String): Seq[WebElement] =
    parent.findElements(By.cssSelector(className)).asScala.toList

  def findChildrenByTag(parent: WebElement, tag: String): Seq[WebElement] =
    parent.findElements(By.tagName(tag)).asScala.toList

  def fillDropdown(elementId: String, value: String, maybeId: Option[String] = None): String = {
    val element = waitForId(elementId)
    element.click()
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
    findElementById(refSelector).clear()
    findElementById(refSelector).sendKeys(refText)
  }

  def fillTextBoxById(elementId: String, text: String): Unit = {
    val element = waitForId(elementId)
    element.clear()
    element.sendKeys(text)
  }

  def fillTextBoxByName(name: String, text: String): Unit =
    findElementByName(name).sendKeys(text)

  def reset(elementId: String): Unit = waitForId(elementId).clear()


  def selectRadioAndClick(elementId: String): Unit = {
    val actions = new Actions(driver)
    val element = findElementById(elementId)
    actions.moveToElement(element).click().perform()
  }

  def selectYesOrNoRadio(option: String, yes: String = "code_yes", no: String = "code_no"): Boolean =
    option match {
      case Constants.yes    => waitForId(yes, Presence).click(); true
      case Constants.no | _ => waitForId(no, Presence).click(); false
    }

  def waitForClass(
    className: String,
    expectedCondition: ExpectedCondition = Visible,
    secondsToWaitFor: Int = 10
  ): WebElement =
    Try(waitFor(By.className(className), expectedCondition, secondsToWaitFor)) match {
      case Success(element) => element
      case Failure(exception) =>
        val message = s"Was waiting for an element with class($className) while on page ${driver.getCurrentUrl}"
        throw new TestFailedException(message, exception)
    }

  def waitForId(
    elementId: String,
    expectedCondition: ExpectedCondition = Visible,
    secondsToWaitFor: Int = 10
  ): WebElement =
    Try(waitFor(By.id(elementId), expectedCondition, secondsToWaitFor)) match {
      case Success(element) => element
      case Failure(exception) =>
        val message = s"Was waiting for an element with id($elementId) while on page ${driver.getCurrentUrl}"
        throw new TestFailedException(message, exception)
    }

  def waitForLinkText(
                 text: String,
                 expectedCondition: ExpectedCondition = Visible,
                 secondsToWaitFor: Int = 10
               ): WebElement =
    Try(waitFor(By.linkText(text), expectedCondition, secondsToWaitFor)) match {
      case Success(element) => element
      case Failure(exception) =>
        val message = s"Was waiting for an element with link text ($text) while on page ${driver.getCurrentUrl}"
        throw new TestFailedException(message, exception)
    }

  private def waitFor(locator: By, expectedCondition: ExpectedCondition, secondsToWaitFor: Int): WebElement = {
    val condition = expectedCondition match {
      case Clickable   => ExpectedConditions.elementToBeClickable(locator)
      case Presence    => ExpectedConditions.presenceOfElementLocated(locator)
      case Visible | _ => ExpectedConditions.visibilityOfElementLocated(locator)
    }
    new FluentWait(driver)
      .withTimeout(Duration.ofSeconds(secondsToWaitFor))
      .pollingEvery(Duration.ofMillis(500L))
      .ignoring(classOf[Exception])
      .until(condition)
  }
}

object DriverHelper extends LazyLogging {

  logger.info(
    s"Instantiating Browser: ${sys.props.getOrElse("browser", "'browser' System property not set. This is required")}"
  )
  implicit val driver: WebDriver = Driver.instance
}

class TestFailedException(message: String, cause: Throwable) extends RuntimeException(message, cause)
