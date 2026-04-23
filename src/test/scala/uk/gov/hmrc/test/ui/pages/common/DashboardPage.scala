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

package uk.gov.hmrc.test.ui.pages.common

import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebElement}
import org.scalatest.matchers.must.Matchers.*
import uk.gov.hmrc.test.ui.pages.base.BasePage.*
import uk.gov.hmrc.test.ui.pages.base.CommonPage.landOnHoldingPageAndRedirectedToConfirmationPage
import uk.gov.hmrc.test.ui.pages.base.{BasePage, CommonPage, Detail}
import uk.gov.hmrc.test.ui.pages.common.DetailKeys.*
import uk.gov.hmrc.test.ui.pages.section1.{ChoicePage, DeclarationTypePage}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.*

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

object DashboardPage extends BasePage {

  def backButtonHref: String = ChoicePage.path
  val path: String = "/dashboard\\?page=1"
  def title: String = {

    val cancelledPressed = cancelledTab.getAttribute("aria-pressed").equals("true")
    val rejectedPressed = rejectedTab.getAttribute("aria-pressed").equals("true")
    val actionNeededPressed = actionTab.getAttribute("aria-pressed").equals("true")

    (cancelledPressed, rejectedPressed, actionNeededPressed) match {
      case (true, _, _) => "Your cancelled and expired declarations"
      case (_, true, _) => "Your rejected declarations"
      case (_, _, true) => "Action needed on your declarations"
      case _ => "Your submitted declarations"
    }
  }

  override def checkExpanders(): Unit = ()

  override def pageLinkHrefs: Seq[String] = super.pageLinkHrefs.filterNot(_ == exitAndCompleteLater)

  override def fillPage(values: String*): Unit = ()

  def mrnValue: WebElement = findElementByCssSelector("tr:nth-child(1) > td:nth-child(1)")

  def rejectedTab: WebElement = findElementByCssSelector("#rejected-submissions-button")
  def submittedTab: WebElement = findElementByCssSelector("#submitted-submissions-button")
  def actionTab: WebElement = findElementByCssSelector("#action-submissions-button")
  def cancelledTab: WebElement = findElementByCssSelector("#cancelled-submissions-button")

   // ex: validateDashboard("Submitted", "Declaration submitted")

  def validateDashboard(tab: String, status: String): Unit = {
    findElementByCssSelector(".selected-status-group").getText mustBe tab
    statusRefresh(status)
    findElementByCssSelector("tr:nth-child(1) > td:nth-child(2)").getText mustBe detail(Ducr)
    findElementByCssSelector("tr:nth-child(1) > td:nth-child(3)").getText mustBe detail(Lrn)

    assert(findElementByCssSelector("tr:nth-child(1) > td:nth-child(4)").isDisplayed)
    val decStatus = findElementByCssSelector("tr:nth-child(1) > td:nth-child(5)").getText
//    decStatus mustBe status   // uncomment this line when CEDS-5922 is fixed

    assert(mrnValue.isDisplayed)

    timelineLink.matches(mrnLink.getAttribute("href"))
    store(MrnOnDashboard -> Detail(mrnValue.getText))
    store(StatusOnDashboard -> Detail(decStatus))
  }

  def mrnLink: WebElement = {
    val mrnCell = findElementByCssSelector("tr:nth-child(1) > td:nth-child(1)")
    findChildByClassName(mrnCell, "govuk-link")
    waitForLinkText(mrnCell.getText)
  }

  def refreshPage(): Unit = {
    driver.navigate().refresh()
  }

  def clickOnTab(tab: String): Unit =
    tab match {
      case "Submitted" => clickById("submitted-submissions-button")
      case "Action needed" => clickById("action-submissions-button")
      case "Rejected" => clickById("rejected-submissions-button")
      case "Cancelled & expired" => clickById("cancelled-submissions-button")
    }

  def viewPaginationComponent(): Unit = {
    findElementByCssSelector("#submitted-submissions").isDisplayed

      // WebDriverWait to wait for elements to be present
      val wait = new WebDriverWait(driver, Duration.ofSeconds(10))

      // Get the total number of pages from the pagination controls
      // Get total pages from pagination items
      val pageNumbers = wait.until(
        ExpectedConditions.presenceOfAllElementsLocatedBy(
          By.cssSelector(".govuk-pagination__item a")
        )).asScala.toList

    val totalPages = pageNumbers.flatMap(e => e.getText.trim.toIntOption).max

    for (pageNum <- 1 until totalPages) {

      val paginationItems = wait.until(
        ExpectedConditions.presenceOfElementLocated(By.cssSelector(".govuk-pagination"))
      )


      val items = paginationItems.findElements(By.cssSelector(".govuk-pagination__item a, .govuk-pagination__item span")).asScala.toList

      // Click next page number
      val nextPage = items.find(_.getText == (pageNum + 1).toString)
        .getOrElse(throw new NoSuchElementException(s"Page ${pageNum + 1} not found"))

      // Validate NEXT link on first page
      if (pageNum == 1) {
        val nextLink = driver.findElement(By.cssSelector(".govuk-pagination__next a"))
        assert(nextLink.isDisplayed, "Next link should be visible on page 1")
      }

      nextPage.click()

      // Validate PREVIOUS link appears after page 1
      if (pageNum >= 1) {
        val prevLink = wait.until(
          ExpectedConditions.presenceOfElementLocated(By.cssSelector(".govuk-pagination__prev a"))
        )
        assert(prevLink.isDisplayed, "Previous link should be visible after page 1")
      }

      // Validate active page
      val activePage = wait.until(
        ExpectedConditions.presenceOfElementLocated(By.cssSelector(".govuk-pagination__item--current"))
      )

      println(s"Current Page: ${activePage.getText}")
    }
    }

  def entersDucrAndValidateDetails():Unit={
    CommonPage.continue()
    SummaryPage.checkPage()
    SummaryPage.clickContinueOnSummary()
    SubmitYourDeclarationPage.checkPage()
    SubmitYourDeclarationPage.fillPage()
    landOnHoldingPageAndRedirectedToConfirmationPage()
    ConfirmationPage.checkPage()
    ChoicePage.navigateToPage(ChoicePage.path)
    ChoicePage.fillPage("Manage Submit Declaration")
    DashboardPage.checkPage()
  }
  def submitArrivedDeclarationNavigateToDashboardPage():Unit={
    CommonPage.continue()
    SummaryPage.checkPage()
    DeclarationTypePage.navigateToPage(DeclarationTypePage.path)
    DeclarationTypePage.fillPage("arrived")
    CommonPage.continue()
    SummaryPage.navigateToPage(SummaryPage.path)
    SummaryPage.clickContinueOnSummary()
    SubmitYourDeclarationPage.checkPage()
    SubmitYourDeclarationPage.fillPage()
    DeclarationHoldingPage.checkPage()
    DeclarationHoldingPage.fillPage()
    ConfirmationPage.checkPage()
    ChoicePage.navigateToPage(ChoicePage.path)
    ChoicePage.fillPage("Manage Submit Declaration")
    DashboardPage.checkPage()
  }

  def validateDashboardQueryRaised():Unit={
    DashboardPage.clickOnTab("Action needed")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Action needed", "Query raised")
  }

  def validateDashboardDeclarationCleared(): Unit = {
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Declaration cleared")
  }

  def validateDashboardGoodsHaveExitedUK(): Unit = {
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted","Goods have exited the UK")
  }

  def validateDashboardDocumentsRequired(): Unit = {
    DashboardPage.clickOnTab("Action needed")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Action needed","Documents required")
  }

  def validateDashboardDeclarationSubmitted(): Unit = {
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted","Declaration submitted")
  }

  def validateDashboardOnHold(): Unit = {
    DashboardPage.clickOnTab("Action needed")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Action needed", "On hold")
  }

  def validateDashboardGoodsBeingExamined():Unit={
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Goods being examined")
  }

  def validateDashboardAwaitingExit(): Unit = {
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Awaiting exit results")
  }

  def validateDashboardDeclarationExpiredOnDeparture():Unit={
    DashboardPage.clickOnTab("Cancelled & expired")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Cancelled & expired", "Declaration expired (no departure)")
  }
  def validateDashboardDeclarationExpiredOnArrival(): Unit = {
    DashboardPage.clickOnTab("Cancelled & expired")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Cancelled & expired", "Declaration expired (no arrival)")
  }

  def validateDashboardPending():Unit={
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Pending")
  }
  
  def validateDashboardArrivedAndAccepted():Unit={
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Arrived and accepted")
  }
  def validateDashboardDeclarationHandledExternally():Unit={
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Declaration handled externally")
  }
  
  def validateDashboardReleased():Unit={
    DashboardPage.clickOnTab("Submitted")
    DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Submitted", "Released")
  }
  
  def validateDashboardCancelled():Unit={
    DashboardPage.clickOnTab("Cancelled & expired")
     DashboardPage.refreshPage()
    DashboardPage.validateDashboard("Cancelled & expired", "Cancelled")
  }
  
  def validateDeclarationDetailsOnDeclarationInformationPage():Unit={
    DashboardPage.mrnLink.click()
    DeclarationInformationPage.checkPage()
    DeclarationInformationPage.validateTimelineDetails()
  }
  
  def validateViewDeclarationLinkIsMissing(linkPresent: String):Unit={
    if (linkPresent.equals("missing"))
      elementByIdDoesNotExist(viewDeclarationLink)
    else
      CommonPage.findElementById(viewDeclarationLink).isDisplayed
  }

}