/*
 * Copyright 2024 HM Revenue & Customs
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

import org.openqa.selenium.{By, WebElement}
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.BasePage.host
import uk.gov.hmrc.test.ui.pages.common.DeclarationInformationPage.isCancelDeclaration
import uk.gov.hmrc.test.ui.pages.section1.DeclarationTypePage.isArrivedDeclaration
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{AdditionalDeclarationType, Ducr, Lrn}
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.BorderTransport

import scala.util.matching.Regex

object ConfirmationPage extends BasePage {

  val backButtonHref: String = ""

  def path: String = if (isAmendmentMode) "/declaration/amendment-outcome" else "/declaration/confirmation"

  def declarationStatus: Seq[String] = maybeDetails(BorderTransport).head

  override def title: String =
    detail(Lrn).take(1) match {
      case "C" if isArrivedDeclaration => "Your declaration has been submitted"
      case "C" | "Q" | "X" | "I" | "J" | "L" | "K" | "P" | "N" => "Your submitted declaration is still being checked"
      case "D" | "U"                                           => "Your declaration has been submitted - action is required"
      case _ =>
        if (isAmendmentMode) {
          if (declarationStatus.contains("REJECTED") && !isCancelDeclaration) "Amendment request rejected"
          else if (declarationStatus.contains("DENIED")) "Amendment request failed"
          else if (declarationStatus.contains("REJECTED") && isCancelDeclaration) "Your amendment cancellation has been accepted"
          else if (declarationStatus.contains("PENDING")) "Your amendment request is still being processed"
          else "Amendment request accepted"
        } else {
          "Your declaration has been submitted"
        }
    }

  override def checkPage(): Unit = {
    checkUrlAndTitle()
    checkPageContent()
    checkPrintLinkIfAny()
  }

  // ex: fillPage()

  def fillPage(values: String*): Unit = ()

  private def checkPrintLinkIfAny(): Unit = {
    val checkPresence = detail(Lrn).take(1) match {
      case "C" | "Q" | "X" | "D" | "U" | "I" | "J" | "L" | "K" | "P" | "N" => false
      case _                                                               => true
    }
    if (checkPresence) {
      val elements = findChildrenByClassName(findElementById("main-content"), "ceds-print-link")
      elements.size mustBe 1
      elements.head.getText mustBe "Print this page"
    }
  }

  private def checkPageContent(): Unit = {
    checkSummaryList()
    checkContentLinks(List(linkToTimeline, linkToFeedback, linkToSupport))
  }

  private def checkSummaryList(): String = {
    val summaryList = findElementByClassName("govuk-summary-list")
    val rows = findChildrenByClassName(summaryList, "govuk-summary-list__row")
    val resultBuilder = new StringBuilder
    def checkRow(row: WebElement, expectedKey: String, expectedValue: String, index: Int): Unit = {
      val actualKey =
        row.findElement(By.className("govuk-summary-list__key")).getText
      val actualValue =
        row.findElement(By.className("govuk-summary-list__value")).getText

      if (actualKey == expectedKey && actualValue == expectedValue) {
        resultBuilder.append(
          s"Row $index check passed. Expected and found: '$expectedKey' -> '$expectedValue'.\n"
        )
      } else {
        resultBuilder.append(
          s"Row $index check failed. " +
            s"Expected: '$expectedKey' -> '$expectedValue', " +
            s"but found: '$actualKey' -> '$actualValue'.\n"
        )
      }
    }

    if (isAmendmentMode) {
      checkRow(rows.head, "Type of declaration", detail(AdditionalDeclarationType), 0)
      checkRow(rows(1), "DUCR", detail(Ducr), 1)
      checkRow(rows(2), "LRN", detail(Lrn), 2)
      val mrnRow = rows(3)
      val mrnValue =
        mrnRow.findElement(By.className("govuk-summary-list__value")).getText
      resultBuilder.append(s"MRN value: $mrnValue\n")
    } else {
      checkRow(rows.head, "DUCR", detail(Ducr), 0)
      checkRow(rows(1), "LRN", detail(Lrn), 1)
      val mrnRow = rows(2)
      val mrnValue =
        mrnRow.findElement(By.className("govuk-summary-list__value")).getText
      resultBuilder.append(s"MRN value: $mrnValue\n")
    }
    resultBuilder.toString()
  }


  private def checkContentLinks(expectedLinks: Seq[Regex]): Unit = {
    val actualLinks =
      findChildrenByTag(findElementById("main-content"), "a").flatMap(link => Option(link.getAttribute("href")))
    expectedLinks.zip(actualLinks).forall { case (expectedLink, actualLink) =>
      expectedLink.matches(actualLink)
    }
  }

  def clickDeclarationStatusLink(): Unit =
    clickByCssSelector("p:nth-child(5) > a")
  private val linkToFeedback = (host + "/feedback/customs-declare-exports-frontend").r
  private val linkToSupport =
    (host + "/contact/report-technical-problem?newTab=true&service=customs-declare-exports-frontend").r
  private val linkToTimeline = (host + "/customs-declare-exports/submissions/\\w+/information").r
}
