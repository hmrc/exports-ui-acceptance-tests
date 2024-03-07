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

package uk.gov.hmrc.test.ui.pages.base

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.base.BasePage._
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.cache
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.Clearance

import scala.jdk.CollectionConverters.ListHasAsScala

trait BasePage extends BrowserDriver with Matchers {

  def title: String
  def path: String
  def backButtonHref: String

  val pageLinkHrefs: List[String] = List(languageToggle, signOut, technicalIssue, govUkLogo, feedbackBanner)
  val expanderHrefs: List[String] = List.empty

  def value(id: String): String = s"${id}Value"

  def checkPage(values: String*): Unit = {
    checkUrlAndTitle()
    checkBackButton()
    checkPageLinks()
    checkExpanders()
    performActionsAndCache(values: _*)
  }

  protected def checkUrlAndTitle(): Unit = {
    assert(driver.getCurrentUrl.startsWith(TestConfiguration.url("exports-frontend") + path))
    driver.getTitle mustBe title +  " - Make an export declaration online - GOV.UK"
    findElementsByTag("h1").head.getText mustBe title
  }

  protected def checkBackButton(): Unit = findElementById("back-link").getAttribute("href") must be(backButtonHref)

  protected def checkPageLinks(): Unit = {
    val links = findElementsByTag("a")
    pageLinkHrefs.forall(href => links.exists(_.getAttribute("href").startsWith(href)))
  }

  protected def checkExpanders(): Unit = {
    val baseUrl = if (cache.getOrElse(???, ???).contains(Clearance))
        "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/"
       else {
        "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/"
       }
    elementDoesNotExist(By.id("tariffReference")) mustBe false
    val links = findElementsByTag("a")
    expanderHrefs.forall(href => links.exists(_.getAttribute("href") == baseUrl + href))
  }

  protected def performActionsAndCache(values: String*): Unit

  val itemsPathBase: String = "/declaration/items"
  val itemPathBase: String = itemsPathBase + "/([\\w]+)"
  private val itemPathBasePattern = (itemPathBase + "/.+").r

  protected def itemId: String = (Option(driver.getCurrentUrl) collect { case itemPathBasePattern(group) => group }).head
  protected def itemUrl(page: String) =  s"$itemsPathBase/$itemId/$page"

  def changeLinkOnCYA(row: String): WebElement = driver.findElement(By.cssSelector(s".$row .govuk-link"))

  def findElementById(value: String): WebElement          = driver.findElement(By.id(value))
  def findElementByXpath(value: String): WebElement       = driver.findElement(By.xpath(value))
  def findElementByLinkText(value: String): WebElement    = driver.findElement(By.linkText(value))
  def findElementByPartialLink(value: String): WebElement = driver.findElement(By.partialLinkText(value))
  def findElementByCssSelector(value: String): WebElement = driver.findElement(By.cssSelector(value))
  def findElementByClassName(value: String): WebElement   = driver.findElement(By.className(value))
  def findElementsByTag(value: String): List[WebElement]   = driver.findElements(By.tagName(value)).asScala.toList

  def clickById(value: String): Unit          = findElementById(value).click()
  def clickByXpath(value: String): Unit       = findElementByXpath(value).click()
  def clickByLinkText(value: String): Unit    = findElementByLinkText(value).click()
  def clickByPartialLink(value: String): Unit = findElementByPartialLink(value).click()
  def clickByCssSelector(value: String): Unit = findElementByCssSelector(value).click()
  def clickByClassName(value: String): Unit   = findElementByClassName(value).click()

  def elementDoesNotExist(elementBy: By): Boolean =
    driver.findElements(elementBy).size() == 0

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

  def selectYesOrNoRadio(option: String): Unit =
    option match {
      case "Yes" => clickById("code_yes")
      case "No"  => clickById("code_no")
    }

  def submit(): Unit = clickById("submit")

  def continue(): Unit = clickByXpath("//*[@role='button']")
}

case class PageNotFoundException(s: String) extends Exception(s)

object BasePage {

  val languageToggle = "/customs-declare-exports/hmrc-frontend/language/cy"
  val feedbackBanner = "/contact/beta-feedback-unauthenticated?"
  val technicalIssue = "/contact/report-technical-problem?"
  val govUkLogo = "https://www.gov.uk/"
  val signOut = "/customs-declare-exports/sign-out?"
}
