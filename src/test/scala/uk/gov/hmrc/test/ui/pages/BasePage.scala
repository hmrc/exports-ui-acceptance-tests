/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import scala.collection.immutable.HashMap

trait BasePage extends BrowserDriver with Matchers {

  def submit(): Unit = findElement("id", "submit").click()

  var declarationDetailsMap: Map[String, String] = HashMap[String, String]()
  def onPage(pageTitle: String): Unit =
    if (!driver.getTitle.contains(pageTitle))
      throw PageNotFoundException(s"Expected '$pageTitle' page, but found '${driver.getTitle}' page.")

  def getGovUKLinks(index: Int): WebElement =
    driver.findElements(By.className("govuk-link")).get(index)

  def changeLinkSelector(row: String): By = By.cssSelector(s".$row .govuk-link")

  def changeLink(row: String)(implicit driver: WebDriver): WebElement = driver.findElement(changeLinkSelector(row))

  def findElement(htmlAttribute: String, value: String): WebElement =
    htmlAttribute match {
      case "id"              => driver.findElement(By.id(value))
      case "xpath"           => driver.findElement(By.xpath(value))
      case "linkText"        => driver.findElement(By.linkText(value))
      case "partialLinkText" => driver.findElement(By.partialLinkText(value))
      case "cssSelector"     => driver.findElement(By.cssSelector(value))
      case "className"       => driver.findElement(By.className(value))
    }

  def elementDoesNotExist(elementBy: By)(implicit driver: WebDriver): Boolean =
    driver.findElements(elementBy).size() == 0
}

case class PageNotFoundException(s: String) extends Exception(s)
