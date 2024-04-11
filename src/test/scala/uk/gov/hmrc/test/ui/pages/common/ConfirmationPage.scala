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

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.BasePage.host
import uk.gov.hmrc.test.ui.pages.section1.DeclarationTypePage.isArrivedDeclaration
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{Ducr, Lrn}

import scala.util.matching.Regex

object ConfirmationPage extends BasePage {

  val backButtonHref: String = ""
  val path: String = "/declaration/confirmation"

  override def title: String =
    detail(Lrn).take(1) match {
      case "C" if isArrivedDeclaration => "Declaration accepted, goods have permission to progress"
      case "C" | "Q" | "X"             => "Your declaration is still being checked"
      case "D" | "U"                   => "Your declaration needs documents attached"
      case "R"                         => "Your declaration has been pre-lodged with HMRC"
      case _                           => "Declaration accepted"
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
      case "C" | "Q" | "X" | "D" | "U" => false
      case _                           => true
    }
    if (checkPresence) {
      val elements = findChildrenByClassName(findElementById("main-content"), "ceds-print-link")
      elements.size mustBe 1
      elements.head.getText mustBe "Print this page"
    }
  }

  private def checkPageContent(): Unit =
    detail(Lrn).take(1) match {
      case "C" if isArrivedDeclaration => checkPageWhenCleared()
      case "C" | "Q" | "X"             => checkPageWhenStillUnderCheck()
      case "D" | "U"                   => checkPageWhenDocumentsRequired()
      case "R"                         => checkPageWhenReceived()
      case _                           => checkPageWhenAccepted()
    }

  private def checkPageWhenCleared(): Unit = {
    println("\n========== Version of the Confirmation page: CLEARED ARRIVED ==========")
    checkTable()
    checkContentLinks(List(linkToMovements, linkToMovements, linkToTimeline, linkToFeedback, linkToSupport))
  }

  private def checkPageWhenStillUnderCheck(): Unit = {
    println("\n========== Version of the Confirmation page: UNDERGOING PHYSICAL CHECK ==========")
    checkContentLinks(List(linkToDashboard, linkToSupport))
  }

  private def checkPageWhenDocumentsRequired(): Unit = {
    println("\n========== Version of the Confirmation page: ADDITIONAL DOCUMENTS REQUIRED ==========")
    val elements = findChildrenByClassName(findElementById("main-content"), "govuk-warning-text")
    elements.size mustBe 1
    assert(elements.head.getText.endsWith("You need to upload documents ready for checking at customs."))

    checkContentLinks(List(linkToTimeline, linkToSupport))
  }

  private def checkPageWhenReceived(): Unit = {
    println("\n========== Version of the Confirmation page: RECEIVED ==========")
    val mrn = checkTable()
    checkContentLinks(List(
      linkToTimeline, linkToClearanceHub, linkToMovements, linkToMovements, linkToTimeline, linkToSfus(mrn), linkToFeedback, linkToSupport
    ))
  }

  private def checkPageWhenAccepted(): Unit = {
    println("\n========== Version of the Confirmation page: ACCEPTED ==========")
    checkTable()
    checkContentLinks(List(
      linkToTimeline, linkToTimeline, linkToClearanceHub, linkToMovements, linkToMovements, linkToFeedback, linkToSupport)
    )
  }

  private def checkTable(): String = {
    val table = findElementByClassName("govuk-table")
    val cells = findChildrenByClassName(table, "govuk-table__cell")
    cells(0).getText mustBe "DUCR"
    cells(1).getText mustBe detail(Ducr)
    cells(2).getText mustBe "LRN"
    cells(3).getText mustBe detail(Lrn)
    cells(4).getText mustBe "MRN"
    cells(5).getText  // MRN value
  }

  private def checkContentLinks(expectedLinks: Seq[Regex]): Unit = {
    val actualLinks = findChildrenByTag(findElementById("main-content"), "a").flatMap(link => Option(link.getAttribute("href")))
    expectedLinks.zip(actualLinks).forall { case (expectedLink, actualLink) =>
      expectedLink.matches(actualLink)
    }
  }

  private val linkToSfus = (mrn: String) => (host + s"/customs-declare-exports/file-upload?mrn=$mrn").r
  private val linkToClearanceHub = "https://www.gov.uk/government/organisations/hm-revenue-customs/contact/national-clearance-hub".r
  private val linkToDashboard = (host + "/customs-declare-exports/dashboard?page=1").r
  private val linkToFeedback = (host + "/feedback/customs-declare-exports-frontend").r
  private val linkToMovements = (host + "/customs-movements").r
  private val linkToSupport = (host + "/contact/report-technical-problem?newTab=true&service=customs-declare-exports-frontend").r
  private val linkToTimeline = (host + "/customs-declare-exports/submissions/\\w+/information").r
}
