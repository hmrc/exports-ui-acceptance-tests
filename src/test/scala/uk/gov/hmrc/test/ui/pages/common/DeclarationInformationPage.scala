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

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.base.BasePage._
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.cacheForAmendments
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.common.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._

object DeclarationInformationPage extends BasePage {

  def backButtonHref: String = "/dashboard?page=1"
  val path: String = timelineLink.toString()
  def title = s"Declaration status: ${detail(StatusOnDashboard)}"

  override def checkExpanders(): Unit = ()

  private val messageLink = "/messages"
  private val movementsLink = "/customs-movements"
  private val cancelLink = "/cancel-declaration"
  private val amendLink = "/amend-declaration"
  private val copyLink = "/copy-declaration"
  private val viewPrintLink = "/view"
  private val eadLink = "/ead-print-view"
  private val fileUploadLink = "/file-upload"

  private def statusDetailsList: List[String] = {
    val additionalText = "If you already uploaded files"
    val originalList = List(
      "What to upload, and when",
      "Information about ‘Re-arrivals’",
      "Status of ‘Declaration submitted’",
      "Status of ‘Declaration has errors’",
      "Status of ‘Arrived and accepted’",
      "Status of ‘Documents required’",
      "Status of ‘Query raised’",
      "Status of ‘Goods being examined’"
    )

    val modifiedList =
      if (detail(Lrn).startsWith("D") || detail(Lrn).startsWith("U")) {
        additionalText +: originalList
      } else if (detail(Lrn).startsWith("R")) {
        originalList.filterNot(_ == "Information about ‘Re-arrivals’")
      } else {
        originalList
      }

    modifiedList
  }

  override def pageLinkHrefs: Seq[String] = {
    val additionalLinks =
      List(messageLink, movementsLink, cancelLink, amendLink, copyLink, viewPrintLink, eadLink, fileUploadLink)

    super.pageLinkHrefs.filterNot(_ == exitAndCompleteLater) ++ additionalLinks
  }

  override def fillPage(values: String*): Unit = ()

  // validateDashboard("Submitted", "Declaration submitted")

  def validateTimelineDetails(): Unit = {
    findElementByCssSelector(".submission-ducr dd").getText mustBe detail(Ducr)
    findElementByCssSelector(".submission-lrn dd").getText mustBe detail(Lrn)
    findElementByClassName("submission-mrn").getText mustBe s"MRN: ${detail(MrnOnDashboard)}"
    findElementsByTag("details").zip(statusDetailsList) foreach { case (element, status) =>
      element.getText mustBe status
    }

    // checking if file upload button and hint is visible
    if (detail(Lrn).startsWith("D")) {
      assert(findElementById("upload-files-section").isDisplayed)
      assert(findElementById("upload-files-hint").isDisplayed)
    }

    // store url for checking back navigation on cancel and copy declaration
    val url = driver.getCurrentUrl
    store(DeclarationInfoPath -> Detail(driver.getCurrentUrl.substring(url.indexOf("/submissions"))))
  }

  def copyDeclaration(): Unit = {
    clickById("copy-declaration")
  }

  def amendDeclaration(): Unit = {
    clickById("amend-declaration")
    cacheForAmendments.put(AmendmentModeOnOff, Detail("true"))
  }

  def checkStatusOnTimeLine(): Unit =
    findElementByCssSelector(".hmrc-timeline__event:first-child h2").getText mustBe "Cancellation request denied"

}
