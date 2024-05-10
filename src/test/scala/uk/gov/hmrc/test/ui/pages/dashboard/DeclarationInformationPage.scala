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
import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.BasePage._
import uk.gov.hmrc.test.ui.pages.common.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._

object DeclarationInformationPage extends BasePage {

  def backButtonHref: String = "/dashboard?page=1"
  val path: String = timelineLink.toString()
  val title = s"Declaration status: ${detail(StatusOnDashboard)}"

  override def checkExpanders(): Unit = ()

  private val messageLink = "/messages"
  private val movementsLink = "/customs-movements"
  private val cancelLink = "/cancel-declaration"
  private val amendLink = "/amend-declaration"
  private val copyLink = "/copy-declaration"
  private val viewPrintLink = "/view"
  private val eadLink = "/ead-print-view"
  private val fileUploadLink = "/file-upload"

  override def pageLinkHrefs: Seq[String] = {
    val additionalLinks = List(
      messageLink, movementsLink, cancelLink,
      amendLink, copyLink, viewPrintLink,
      eadLink, fileUploadLink
    )

    super.pageLinkHrefs.filterNot(_ == exitAndCompleteLater) ++ additionalLinks
  }

  override def fillPage(values: String*): Unit = ()

  // validateDashboard("Submitted", "Declaration submitted")

  def validateTimelineDetails(status: String): Unit = {
    findElementByCssSelector(".submission-ducr dd").getText mustBe detail(Ducr)
    findElementByCssSelector(".submission-lrn dd").getText mustBe detail(Lrn)
    findElementByClassName("submission-mrn").getText mustBe s"MRN: ${detail(MrnOnDashboard)}"
    findElementsByTag("details").zip(statusDetailsList) foreach { case (element, status) =>
      element.getText mustBe status
    }
  }

  private val statusDetailsList = List(
    "What to upload, and when",
    "Information about ‘Re-arrivals’",
    "Status of ‘Declaration submitted’",
    "Status of ‘Declaration has errors’",
    "Status of ‘Arrived and accepted’",
    "Status of ‘Documents required’",
    "Status of ‘Query raised’",
    "Status of ‘Goods being examined’"
  )

  def mrnLink: WebElement = {
    val mrnCell = findElementByClassName("submission-tab-submitted-row0-mrn")
    findChildByClassName(mrnCell, "govuk-link")
  }
}
