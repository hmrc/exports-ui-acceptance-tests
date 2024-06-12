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

import org.openqa.selenium.WebElement
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

  def declarationStatus = maybeDetails(BorderTransport).head

  override def title: String =
    detail(Lrn).take(1) match {
      case "C" if isArrivedDeclaration => "Declaration accepted, goods have permission to progress"
      case "C" | "Q" | "X" | "I" | "J" | "L" | "K" | "P" | "N" => "Your declaration is still being checked"
      case "D" | "U"                                           => "Your declaration needs documents attached"
      case "R"                                                 => "Your declaration has been pre-lodged with HMRC"
      case _ =>
        if (isAmendmentMode) {
          if (declarationStatus.contains("REJECTED")) "Amendment request rejected"
          else if (declarationStatus.contains("DENIED")) "Amendment request failed"
          else if (declarationStatus.contains("REJECTED") && isCancelDeclaration) "Your amendment cancellation has been accepted"
          else if (declarationStatus.contains("PENDING")) "Your amendment request is still being processed"
          else "Amendment request accepted"
        } else {
          "Declaration accepted"
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

  private def checkPageContent(): Unit =
    detail(Lrn).take(1) match {
      case "C" if isArrivedDeclaration                         => checkPageWhenCleared()
      case "C" | "Q" | "X" | "I" | "J" | "L" | "K" | "P" | "N" => checkPageWhenStillUnderCheck()
      case "D" | "U"                                           => checkPageWhenDocumentsRequired()
      case "R"                                                 => checkPageWhenReceived()
      case _                                                   => checkPageWhenAccepted()
    }

  private def checkPageWhenCleared(): Unit = {
    checkTable()
    checkContentLinks(List(linkToMovements, linkToMovements, linkToTimeline, linkToFeedback, linkToSupport))
  }

  private def checkPageWhenStillUnderCheck(): Unit =
    checkContentLinks(List(linkToDashboard, linkToSupport))

  private def checkPageWhenDocumentsRequired(): Unit = {
    val elements = findChildrenByClassName(findElementById("main-content"), "govuk-warning-text")
    elements.size mustBe 1
    assert(elements.head.getText.endsWith("You need to upload documents ready for checking at customs."))

    checkContentLinks(List(linkToTimeline, linkToSupport))
  }

  private def checkPageWhenReceived(): Unit = {
    val mrn = checkTable()
    checkContentLinks(
      List(
        linkToTimeline,
        linkToClearanceHub,
        linkToMovements,
        linkToMovements,
        linkToTimeline,
        linkToSfus(mrn),
        linkToFeedback,
        linkToSupport
      )
    )
  }

  private def checkPageWhenAccepted(): Unit = {
    checkTable()
    checkContentLinks(
      List(
        linkToTimeline,
        linkToTimeline,
        linkToClearanceHub,
        linkToMovements,
        linkToMovements,
        linkToFeedback,
        linkToSupport
      )
    )
  }

  private def checkTable(): String = {
    val table = findElementByClassName("govuk-table")
    val cells = findChildrenByClassName(table, "govuk-table__cell")
    // Variable to collect the results
    val resultBuilder = new StringBuilder

    // Helper method to check a cell and append the result to the builder
    def checkCell(cell: WebElement, expectedText: String, index: Int): Unit = {
      val actualText = cell.getText
      if (actualText == expectedText) {
        resultBuilder.append(s"Cell $index check passed. Expected and found: '$expectedText'.\n")
      } else {
        resultBuilder.append(s"Cell $index check failed. Expected: '$expectedText', but found: '$actualText'.\n")
      }
    }

    // Check the contents of each cell
    if (isAmendmentMode) {
      checkCell(cells.head, "Type of declaration", 0)
      checkCell(cells(1), detail(AdditionalDeclarationType), 1)
      checkCell(cells(2), "DUCR", 2)
      checkCell(cells(3), detail(Ducr), 3)
      checkCell(cells(4), "LRN", 4)
      checkCell(cells(5), detail(Lrn), 5)
      checkCell(cells(6), "MRN", 6)
      resultBuilder.append(s"MRN value: ${cells(7).getText}\n")
    } else {
      checkCell(cells.head, "DUCR", 0)
      checkCell(cells(1), detail(Ducr), 1)
      checkCell(cells(2), "LRN", 2)
      checkCell(cells(3), detail(Lrn), 3)
      checkCell(cells(4), "MRN", 4)
      resultBuilder.append(s"MRN value: ${cells(5).getText}\n")
    }

    // Return the final result
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

  private val linkToSfus = (mrn: String) => (host + s"/customs-declare-exports/file-upload?mrn=$mrn").r
  private val linkToClearanceHub =
    "https://www.gov.uk/government/organisations/hm-revenue-customs/contact/national-clearance-hub".r
  private val linkToDashboard = (host + "/customs-declare-exports/dashboard?page=1").r
  private val linkToFeedback = (host + "/feedback/customs-declare-exports-frontend").r
  private val linkToMovements = (host + "/customs-movements").r
  private val linkToSupport =
    (host + "/contact/report-technical-problem?newTab=true&service=customs-declare-exports-frontend").r
  private val linkToTimeline = (host + "/customs-declare-exports/submissions/\\w+/information").r
}
