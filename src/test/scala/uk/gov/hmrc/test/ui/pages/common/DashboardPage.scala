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
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.base.BasePage._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.common.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section1.ChoicePage
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._

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
      case _            => "Your submitted declarations"
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

  def refreshPage(): Unit =
    driver.navigate().refresh()

  def clickOnTab(tab: String): Unit =
    tab match {
      case "Submitted"           => clickById("submitted-submissions-button")
      case "Action needed"       => clickById("action-submissions-button")
      case "Rejected"            => clickById("rejected-submissions-button")
      case "Cancelled & expired" => clickById("cancelled-submissions-button")
    }

  def viewPaginationComponent(): Unit = {
    findElementByCssSelector("#submitted-submissions > div > nav").isDisplayed

    // WebDriverWait to wait for elements to be present
    val wait = new WebDriverWait(driver, Duration.ofSeconds(10))

    // Get the total number of pages from the pagination controls
    val totalPages: Int = wait
      .until(
        ExpectedConditions
          .presenceOfAllElementsLocatedBy(By.cssSelector(".ceds-pagination__controls .ceds-pagination__item"))
      )
      .size()

    for (pageNum <- 1 until totalPages - 1) {

      val paginationControls: WebElement = waitForClass("ceds-pagination__controls")

      // Locate the pagination items
      val paginationItems: List[WebElement] =
        paginationControls.findElements(By.className("ceds-pagination__link")).asScala.toList

      // Find the link for the current page number + 1 and click it
      val nextPageLink: WebElement = paginationItems
        .find(_.getText == (pageNum + 1).toString)
        .getOrElse(throw new NoSuchElementException(s"Page ${pageNum + 1} link not found"))

      // Check if the "Next" link is displayed before clicking the second page
      val nextLinkDisplayed = waitForCssSelector("li.ceds-pagination__item.ceds-pagination__item--next > a").isDisplayed

      assert(nextLinkDisplayed, "Next link displays on the first page")

      // Click the next page link
      nextPageLink.click()

      // Check if the "Previous" link is displayed from the next page
      val previousLinkDisplayed = waitForCssSelector(
        "li.ceds-pagination__item.ceds-pagination__item--prev > a"
      ).isDisplayed

      assert(previousLinkDisplayed, "Previous link displays from the next page")

      // Verify the content of the page
      val activePage: WebElement = waitForClass("ceds-pagination__item--active")
      println(s"Current Page: ${activePage.getText}")
    }
  }
}
