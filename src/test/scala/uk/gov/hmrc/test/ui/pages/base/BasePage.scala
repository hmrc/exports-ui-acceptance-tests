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

import org.openqa.selenium.By
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.Common

import scala.util.matching.Regex

trait BasePage extends CacheHelper with DriverHelper with Matchers {

  def backButtonHref: String
  def path: String
  def title: String

  val expanderHrefs: Map[String, Seq[String]] = Map.empty
  val pageLinkHrefs: Seq[String]              =
    List(exitAndCompleteLater, feedbackBanner, govUkLogo, languageToggle, signOut, technicalIssue)

  def checkPage(values: String*): Unit = {
    checkUrlAndTitle()
    checkBackButton()
    checkPageLinks()
    checkExpanders()
    performActionsAndStore(values: _*)
  }

  protected def checkUrlAndTitle(): Unit = {
    assert((TestConfiguration.url("exports-frontend") + path).r.matches(driver.getCurrentUrl))
    driver.getTitle mustBe title + " - Make an export declaration online - GOV.UK"
    findElementsByTag("h1").head.getText mustBe title
  }

  protected def checkBackButton(): Unit = findElementById("back-link").getAttribute("href") must be(backButtonHref)

  protected def checkPageLinks(): Unit = {
    val links = findElementsByTag("a")
    pageLinkHrefs.forall(href => links.exists(_.getAttribute("href").startsWith(href)))
  }

  protected def checkExpanders(): Unit = {
    elementDoesNotExist(By.id("tariffReference")) mustBe false

    maybeDetail(DeclarationType).map { declarationType =>
      // We could have link sets for a specific declaration type (e.g. Clearance or Supplementary)
      // as well as link sets "Common" to multiple declaration types
      val maybeHrefs = expanderHrefs.get(declarationType).fold(expanderHrefs.get(Common))(Some(_))
      maybeHrefs.map { hrefs =>
        val links = findElementsByTag("a")
        hrefs.forall(href => links.exists(_.getAttribute("href") == href))
      }
    }
  }

  // Required for multi-value pages, like "Package Information", "Additional Information", "Containers", ...
  // The page sequence must be always at zero-position in the list of values passed to "performActionsAndStore".
  val sequenceId = 0

  protected def performActionsAndStore(values: String*): Unit

  private val initPart: String  = "/declaration"
  private val elementId: String = "[\\w]+"

  private val itemIdPattern: Regex = s"/$initPart/items/($elementId)/.+".r
  protected def itemId: String     = (Option(driver.getCurrentUrl) collect { case itemIdPattern(group) => group }).head

  protected def changeUrl(partId: String): String = s"$initPart/$partId/$elementId/change"

  protected def changeUrl(partId: String, additionalPartId: String): String =
    s"$initPart/$partId/$elementId/$additionalPartId/$elementId/change"

  protected def itemUrl(partId: String): String = s"$initPart/items/$elementId/$partId"
  protected def pathUrl(partId: String): String = s"$initPart/$partId/$elementId"

  protected def removeUrl(partId: String): String = s"$initPart/$partId/$elementId/remove"

  protected def removeUrl(partId: String, additionalPartId: String): String =
    s"$initPart/$partId/$elementId/$additionalPartId/$elementId/remove"
}

case class PageNotFoundException(s: String) extends Exception(s)

object BasePage {

  val exitAndCompleteLater = "/customs-declare-exports/declaration/draft-saved"
  val feedbackBanner       = "/contact/beta-feedback-unauthenticated?"
  val govUkLogo            = "https://www.gov.uk/"
  val languageToggle       = "/customs-declare-exports/hmrc-frontend/language/cy"
  val signOut              = "/customs-declare-exports/sign-out?"
  val technicalIssue       = "/contact/report-technical-problem?"
}
