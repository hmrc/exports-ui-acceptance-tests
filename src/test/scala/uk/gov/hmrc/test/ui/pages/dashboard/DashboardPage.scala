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

package uk.gov.hmrc.test.ui.pages.dashboard

import org.openqa.selenium.WebElement
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.BasePage._
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
    findElementByClassName("submission-tab-submitted-row0-ducr").getText mustBe detail(Ducr)
    findElementByClassName("submission-tab-submitted-row0-lrn").getText mustBe detail(Lrn)

    val decStatus = findElementByClassName("submission-tab-submitted-row0-status").getText
    decStatus  mustBe status

    assert(findElementByClassName("submission-tab-submitted-row0-updatedOn").isDisplayed)
    val mrnValue = findElementByCssSelector(".submission-tab-submitted-row0-mrn span:first-child")
    assert(mrnValue.isDisplayed)

    timelineLink.matches(mrnLink.getAttribute("href"))
    store(MrnOnDashboard -> Detail(mrnValue.getText))
    store(StatusOnDashboard -> Detail(decStatus))
  }

  def mrnLink: WebElement = {
    val mrnCell = findElementByClassName("submission-tab-submitted-row0-mrn")
    findChildByClassName(mrnCell, "govuk-link")
  }
}