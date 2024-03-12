package uk.gov.hmrc.test.ui.pages.base

import org.openqa.selenium.{By, Keys, WebElement}
import org.openqa.selenium.interactions.Actions
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import scala.jdk.CollectionConverters.ListHasAsScala

trait DriverHelper extends BrowserDriver {

  def changeLinkOnCYA(row: String): WebElement = driver.findElement(By.cssSelector(s".$row .govuk-link"))

  def continue(): Unit = clickByXpath("//*[@role='button']")

  def clickById(value: String): Unit          = findElementById(value).click()
  def clickByXpath(value: String): Unit       = findElementByXpath(value).click()
  def clickByLinkText(value: String): Unit    = findElementByLinkText(value).click()
  def clickByPartialLink(value: String): Unit = findElementByPartialLink(value).click()
  def clickByCssSelector(value: String): Unit = findElementByCssSelector(value).click()
  def clickByClassName(value: String): Unit   = findElementByClassName(value).click()

  def elementDoesNotExist(elementBy: By): Boolean =
    driver.findElements(elementBy).size() == 0

  def elementByIdDoesNotExist(elementId: String): Boolean =
    driver.findElements(By.id(elementId)).size() == 0

  def findElementById(value: String): WebElement          = driver.findElement(By.id(value))
  def findElementByXpath(value: String): WebElement       = driver.findElement(By.xpath(value))
  def findElementByLinkText(value: String): WebElement    = driver.findElement(By.linkText(value))
  def findElementByPartialLink(value: String): WebElement = driver.findElement(By.partialLinkText(value))
  def findElementByCssSelector(value: String): WebElement = driver.findElement(By.cssSelector(value))
  def findElementByClassName(value: String): WebElement   = driver.findElement(By.className(value))
  def findElementsByClassName(value: String): List[WebElement]   = driver.findElements(By.className(value)).asScala.toList
  def findElementsByTag(value: String): List[WebElement]   = driver.findElements(By.tagName(value)).asScala.toList

  def fillAutoComplete(elementId: String, value: String): Unit = {
    val element = findElementById(elementId)
    element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE)
    element.sendKeys(value)
    element.sendKeys(Keys.ARROW_DOWN)
    element.sendKeys(Keys.ENTER)
  }

  def fillRadioButton(elementId: String, refSelector: String, refText: String): Unit = {
    clickById(elementId)
    findElementById(refSelector).sendKeys(refText)
  }

  def fillTextBoxById(elementId: String, text: String): Unit =
    findElementById(elementId).sendKeys(text)

  def selectRadioAndClick(elementId: String): Unit = {
    val actions = new Actions(driver)
    val element = findElementById(elementId)
    actions.moveToElement(element).click().perform()
  }

  def selectYesOrNoRadio(option: String, yes: String = "code_yes", no: String = "code_no"): Boolean =
    option match {
      case "Yes" => clickById(yes); true
      case "No"  => clickById(no); false
    }

  def submit(): Unit = clickById("submit")
}
