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

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage._
import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{cache, cacheForAmendments, changeLinks}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.CountriesOfRouting
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.NationalAdditionalCodeLabel
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.SealLabel

import java.time.Duration

trait BasePage extends CacheHelper with DriverHelper with PageHelper with LazyLogging {

  logger.info(getClass.getSimpleName.dropRight(1))

  def checkPage(): Unit = {
    checkUrlAndTitle()
    checkBackButton()
    checkPageLinks()
    checkExpanders()
  }

  def fillPage(values: String*): Unit

  protected def backButtonHref: String
  protected def title: String

  protected val expanderHrefs: Map[String, Seq[String]] = Map.empty

  protected def pageLinkHrefs: Seq[String] =
    List(exitAndCompleteLater, feedbackBanner, govUkLogo, languageToggle, signOut, technicalIssue)

  protected def checkUrlAndTitle(): Unit = {
    val expectedUrl = host + path
    val actualUrl = driver.getCurrentUrl
    assert(
      expectedUrl.r.matches(actualUrl),
      s"The expected URL($expectedUrl) does not match the actual URL($actualUrl)"
    )
    val sectionHeader =
      if (elementByIdDoesNotExist("section-header")) ""
      else s" - ${findElementById("section-header").getText}"

    driver.getTitle mustBe title + sectionHeader + " - Make and manage an export declaration online - GOV.UK"
    findElementsByTag("h1").head.getText mustBe title
  }

  protected def checkBackButton(): Unit =
    findElementById("back-link").getAttribute("href") mustBe host + backButtonHref

  def saveAndReturnToSummary(): Unit = clickById("save_and_return_to_summary")

  def exitAndComeBackLater(): Unit = clickById("exit-and-complete-later")

  protected def checkPageLinks(): Unit = {
    val links = findElementsByTag("a")
    pageLinkHrefs.forall { href =>
      links.exists(link => Option(link.getAttribute("href")).fold(true)(_.startsWith(href)))
    }
  }

  protected def checkExpanders(): Unit = {
    elementByIdDoesNotExist("tariffReference") mustBe false
    checkExpanderLinks()
  }

  val viewDeclarationLink = "view_declaration_summary"

  def back(): Unit = clickById("back-link")

  def viewDeclarationSummary(): Unit = clickById(viewDeclarationLink)

  def continueSavedDeclaration(): Unit = clickById("continue-saved-declaration")

  def saveAndReturnToErrors(): Unit = clickById("save_and_return_to_errors")

  def statusRefresh(status: String): Unit = {

    val waitForStatus = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(10))

    waitForStatus
      .withMessage(() => s"waiting for notification status to be: [$status]")
      .until { implicit driver =>
        driver.navigate().refresh()
        findElementByCssSelector("tr:nth-child(1) > td:nth-child(5)").getText mustBe status
      }
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

  private case class LabelAndValueRow(label: WebElement, value: WebElement, changeLink: Option[WebElement]) {
    override def toString: String = {
      val l = s"""${label.getText}(${label.getAttribute("class")})"""
      val v = s"""${value.getText}(${value.getAttribute("class")})"""
      val c = changeLink.fold("")(cl => s"""${cl.getText}(${cl.getAttribute("class")}) -> ${cl.getAttribute("href")}""")
      s"$l, $v, $c"
    }
  }

  protected def checkSectionSummary(detailKey: DetailKey): Unit = {
    val allCardRows = findElementsByClassName("govuk-summary-card")
      .filter(findChildByClassName(_, detailKey.id.head).getText == detailKey.label)
      .flatMap(findChildrenByClassName(_, "govuk-summary-list__row"))

    val labelAndValueRows: Seq[LabelAndValueRow] =
      allCardRows.map { webElement =>
        LabelAndValueRow(
          findChildByClassName(webElement, "govuk-summary-list__key"),
          findChildByClassName(webElement, "govuk-summary-list__value"),
          findChildByClassNameIfAny(webElement, "govuk-link")
        )
      }.sortWith { case (e1, e2) =>
        val p1 = e1.label.getLocation
        val p2 = e2.label.getLocation
        p1.getY < p2.getY || p1.getY == p2.getY && p1.getX < p2.getX
      }

    val cacheDetails = allSectionDetails(detailKey.sectionId)

    cacheDetails.foldLeft(labelAndValueRows) { case (tailedLabelAndValueRows, (detailKey, details)) =>
      // Remove the row that was just tested against from the sequence of rows.
      // This is required for elements like, for instance "additional information" or
      // "additional documents", which might have two or more rows with the same label.
      val removeFromLabelAndValueRows =
        (labelAndValueRow: LabelAndValueRow) => tailedLabelAndValueRows.diff(List(labelAndValueRow))

      // To remove (or comment in) after we are done with the happy-path scenarios for the 6 sections
      print(s"\n=========== ${detailKey.label} => \n")
      tailedLabelAndValueRows.foreach(row => print(s"${row.label.getText} (${row.value.getText})\n"))

      val maybeLabelAndValueRow = tailedLabelAndValueRows.find{result =>
        result.label.getText == detailKey.label
      }

      if (detailKey.skipRowCheck) maybeLabelAndValueRow.fold(tailedLabelAndValueRows)(removeFromLabelAndValueRows)
      else {
        val labelAndValueRow = maybeLabelAndValueRow.get

        if (!detailKey.skipValueCheck) {
          val values = details match {
            case detail: Detail  => Seq(detail.value)
            case detail: Details => detail.values

            // It cannot happen. Just for silencing the compiler emitting "match may not be exhaustive".
            case ign => assert(false, s"Not a 'Detail' or 'Details' value ?? ($ign)"); List.empty
          }

          // There may be some edge cases here not accounted for, please add accordingly.
          val valuesSeparator = detailKey match {
            case CountriesOfRouting                              => ","
            case key if key.label == NationalAdditionalCodeLabel => ","
            case key if key.label == SealLabel                   => ","
            case _                                               => "\n"
          }

          val text = labelAndValueRow.value.getText
          val result = text.split(valuesSeparator).toList.map(_.trim)
          result mustBe values
        }

        if (detailKey.checkChangeLink) {
          val href = labelAndValueRow.changeLink.head.getAttribute("href")
          s"$host${changeLinks(detailKey)}" mustBe href
        }

        removeFromLabelAndValueRows(labelAndValueRow)
      }
    }
  }

  private case class LabelAndValueRowForAmend(label: WebElement, previousValue: WebElement, amendedValue: WebElement)

  protected def checkAmendedDetails(): Unit = {
    val allCardRows = findElementsByClassName("govuk-summary-card")
      .flatMap(findChildrenByCssSelector(_, ".govuk-table__body .govuk-table__row"))

    val labelAndValueRows: Seq[LabelAndValueRowForAmend] =
      allCardRows.map { webElement =>
        LabelAndValueRowForAmend(
          findChildByCssSelector(webElement, ".govuk-table__cell:nth-child(1)"),
          findChildByCssSelector(webElement, ".govuk-table__cell:nth-child(2)"),
          findChildByCssSelector(webElement, ".govuk-table__cell:nth-child(3)")
        )
      }.sortWith { case (e1, e2) =>
        val p1 = e1.label.getLocation
        val p2 = e2.label.getLocation
        p1.getY < p2.getY || p1.getY == p2.getY && p1.getX < p2.getX
      }

    labelAndValueRows.foreach { eachRow =>
      eachRow.previousValue.getText
      eachRow.amendedValue.getText

      cacheForAmendments.foreach { case (key, value) =>
        if (cache.contains(key)) {
          val actualDetail = cache(key)

          val actualValues = actualDetail match {
            case detail: Detail  => Seq(detail.value)
            case detail: Details => detail.values

            // It cannot happen. Just for silencing the compiler emitting "match may not be exhaustive".
            case ign => assert(assertion = false, s"Not a 'Detail' or 'Details' value ?? ($ign)"); List.empty
          }
          assert(assertion = true, actualValues.contains(eachRow.previousValue.getText))

          val amendValues = value match {
            case detail: Detail  => Seq(detail.value)
            case detail: Details => detail.values

            // It cannot happen. Just for silencing the compiler emitting "match may not be exhaustive".
            case ign => assert(assertion = false, s"Not a 'Detail' or 'Details' value ?? ($ign)"); List.empty
          }
          assert(assertion = true, amendValues.contains(eachRow.amendedValue.getText))
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
