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

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.{By, WebElement}
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.openqa.selenium.Keys
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.DeclarationDetails.TransportLeavingBorderValue
import uk.gov.hmrc.test.ui.pages.PageConstants.{feedbackBanner, govUkLogo, languageToggle, signOut, technicalIssue}

import scala.jdk.CollectionConverters.ListHasAsScala

trait BasePage extends BrowserDriver with Matchers {

  def title: String
  val url: String
  val backButtonHrefs: List[String]
  val pageLinkHrefs: List[String] = List(languageToggle, signOut, technicalIssue, govUkLogo, feedbackBanner)
  val expanderHrefs: List[String] = List.empty

  def checkUrlAndTitle(): Unit = {
    if (!driver.getCurrentUrl.contains(url))
      throw PageNotFoundException(s"Expected '$url' page, but found '${driver.getCurrentUrl}' page.")

    if (!driver.getTitle.contains(title))
      throw PageNotFoundException(s"Expected '$title' page, but found '${driver.getTitle}' page.")
  }

  def checkPage(values: String*): Unit = {
    checkUrlAndTitle()
    checkBackButton()
    checkPageLinks()
    checkExpanders()
    performActionsAndCache(values: _*)
  }

  protected def performActionsAndCache(values: String*): Unit

  protected def checkPageLinks(): Unit =
    pageLinkHrefs.forall(href => findElementsByTag("a").exists(_.getAttribute("href").startsWith(href)))

  protected def checkExpanders(): Unit = {
    val baseUrl =
      if (DeclarationDetails.cache.getOrElse(TransportLeavingBorderValue, "default value").contains("Clearance")) {
        "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/"
      } else {
        "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/"
      }
    elementDoesNotExist(By.id("tariffReference")) mustBe false
    expanderHrefs.forall(href => findElementsByTag("a").exists(_.getAttribute("href") == baseUrl + href))
  }

  def checkBackButton(): Unit = findElementById("back-link").getAttribute("href") must be(backButtonHrefs.head)

  private def submit(): Unit = clickById("submit")

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
  def findElementsByTag(value: String): List[WebElement]  = driver.findElements(By.tagName(value)).asScala.toList

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

  def fillTextBoxById(idSelector: String, text: String): Unit =
    findElementById(idSelector).sendKeys(text)

  def selectRadioAndClick(element: WebElement): Unit = {
    val actions = new Actions(driver)
    actions.moveToElement(element).click().perform()
  }

  def fillAutoComplete(element: WebElement, value: String): Unit = {
    element.clear()
    element.sendKeys(value)
    element.sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
  }

}

case class PageNotFoundException(s: String) extends Exception(s)

object PageConstants {
  val languageToggle = "/customs-declare-exports/hmrc-frontend/language/cy"
  val feedbackBanner = "/contact/beta-feedback-unauthenticated?"
  val technicalIssue = "/contact/report-technical-problem?"
  val govUkLogo      = "https://www.gov.uk/"
  val signOut        = "/customs-declare-exports/sign-out?"
}
