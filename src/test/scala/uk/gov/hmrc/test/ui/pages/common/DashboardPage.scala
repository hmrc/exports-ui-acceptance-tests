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

import org.openqa.selenium.WebElement
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.base.BasePage._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.common.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section1.ChoicePage
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._

object DashboardPage extends BasePage {

  def backButtonHref: String = ChoicePage.path
  val path: String = "/dashboard\\?page=1"
  val title = "Your declarations"

  override def checkExpanders(): Unit = ()

  private val messageLink = "/messages"
  override def pageLinkHrefs: Seq[String] = super.pageLinkHrefs.filterNot(_ == exitAndCompleteLater) :+ messageLink

  override def fillPage(values: String*): Unit = ()

  // validateDashboard("Submitted", "Declaration submitted")

  def validateDashboard(tab: String, status: String): Unit = {
    findElementByClassName("cds-exports-tabs__list-item--selected").getText mustBe tab
    statusRefresh(status)
    findElementByCssSelector("tr:nth-child(1) > td:nth-child(2)").getText mustBe detail(Ducr)
    findElementByCssSelector("tr:nth-child(1) > td:nth-child(3)").getText mustBe detail(Lrn)

    assert(findElementByCssSelector("tr:nth-child(1) > td:nth-child(4)").isDisplayed)
    val decStatus = findElementByCssSelector("tr:nth-child(1) > td:nth-child(5)").getText
    decStatus mustBe status

    val mrnValue = findElementByCssSelector("tr:nth-child(1) > td:nth-child(1) span:first-child")
    assert(mrnValue.isDisplayed)

    timelineLink.matches(mrnLink.getAttribute("href"))
    store(MrnOnDashboard -> Detail(mrnValue.getText))
    store(StatusOnDashboard -> Detail(decStatus))
  }

  def mrnLink: WebElement = {
    val mrnCell = findElementByCssSelector("tr:nth-child(1) > td:nth-child(1)")
    findChildByClassName(mrnCell, "govuk-link")
  }

  def refreshPage(): Unit = {
    driver.navigate().refresh()
  }

  def clickOnTab(tab: String): Unit =
    tab match {
      case "Submitted"           => clickById("tab_submitted-submissions")
      case "Action needed"       => clickById("tab_action-submissions")
      case "Rejected"            => clickById("rejected-submissions")
      case "Cancelled & expired" => clickById("tab_cancelled-submissions")
    }
}
