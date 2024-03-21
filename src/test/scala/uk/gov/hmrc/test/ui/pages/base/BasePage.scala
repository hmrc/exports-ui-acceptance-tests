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

import org.openqa.selenium.{By, WebElement}
import org.scalatest.matchers.must.Matchers.{convertToAnyMustWrapper, defined}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage._
import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.CountriesOfRouting

trait BasePage extends CacheHelper with DriverHelper with PageHelper {

  def checkPage(): Unit = {
    checkUrlAndTitle()
    checkBackButton()
    checkPageLinks()
    checkExpanders()
  }

  def fillPage(values: String*): Unit

  protected def backButtonHref: String
  protected def path: String
  protected def title: String

  protected val expanderHrefs: Map[String, Seq[String]] = Map.empty

  protected def pageLinkHrefs: Seq[String] =
    List(exitAndCompleteLater, feedbackBanner, govUkLogo, languageToggle, signOut, technicalIssue)

  protected def checkUrlAndTitle(): Unit = {
    assert((host + path).r.matches(driver.getCurrentUrl))
    val sectionHeader =
      if (elementByIdDoesNotExist("section-header")) ""
      else s" - ${findElementById("section-header").getText}"

    driver.getTitle mustBe title + sectionHeader + " - Make an export declaration online - GOV.UK"
    findElementsByTag("h1").head.getText mustBe title
  }

  protected def checkBackButton(): Unit = findElementById("back-link").getAttribute("href") mustBe host + backButtonHref

  protected def checkPageLinks(): Unit = {
    val links = findElementsByTag("a")
    pageLinkHrefs.forall(href => links.exists(_.getAttribute("href").startsWith(href)))
  }

  protected def checkExpanders(): Unit = {
    elementDoesNotExist(By.id("tariffReference")) mustBe false
    checkExpanderLinks()
  }

  protected def checkExpanderLinks(): Unit =
    maybeDetail(DeclarationType).map { declarationType =>
      // We could have link sets for a specific declaration type (e.g. Clearance or Supplementary)
      // as well as link sets "Common" to multiple declaration types
      val maybeHrefs = expanderHrefs.get(declarationType).fold(expanderHrefs.get(Common))(Some(_))
      maybeHrefs.map { hrefs =>
        val links = findElementsByTag("a")
        hrefs.forall(href => links.exists(_.getAttribute("href") == href))
      }
    }

  protected def checkSectionSummary(detailKey: DetailKey): Unit = {
    val rows = findElementsByClassName("govuk-summary-card")
      .filter(findChildByClassName(_, detailKey.id.head).getText == detailKey.label)
      .flatMap(findChildrenByClassName(_, "govuk-summary-list__row"))

    val displayedKeysAndDetails: Seq[(WebElement, WebElement)] = rows.map { webElement =>
      findChildByClassName(webElement, "govuk-summary-list__key") ->
        findChildByClassName(webElement, "govuk-summary-list__value")
    }

    val cacheDetails = allSectionDetails(detailKey.sectionId)

    cacheDetails.foreach { case (detailKey, details) =>
      if (!detailKey.skipLabelCheck) {
        val expectedRows = displayedKeysAndDetails.filter(_._1.getText == detailKey.label)
        assert(expectedRows.nonEmpty)

        if (!detailKey.skipSummaryCheck) {
          val values = details match {
            case detail: Detail  => Seq(detail.value)
            case detail: Details => detail.values
          }

          // There may be some edge cases here not accounted for, please add accordingly.
          val valuesSeparator = detailKey match {
            case CountriesOfRouting => ","
            case _                  => "\n"
          }

          assert(expectedRows.exists(_._2.getText.split(valuesSeparator).toList.map(_.trim) == values))
        }
      }
    }
  }
}

object BasePage {

  val exitAndCompleteLater = "/customs-declare-exports/declaration/draft-saved"
  val feedbackBanner = "/contact/beta-feedback-unauthenticated?"
  val govUkLogo = "https://www.gov.uk/"
  val languageToggle = "/customs-declare-exports/hmrc-frontend/language/cy"
  val signOut = "/customs-declare-exports/sign-out?"
  val technicalIssue = "/contact/report-technical-problem?"

  val host = TestConfiguration.url("exports-frontend")
}
