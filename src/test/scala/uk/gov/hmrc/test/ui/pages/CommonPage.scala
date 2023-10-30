/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper

object CommonPage extends BasePage {

  val language = ".hmrc-language-select .hmrc-language-select__list-item>span"

  def messageInBox(selector: String): WebElement =
    findElement("xpath", s"//*[@href='#$selector']")

  def errorMessage(selector: String): WebElement = findElement("id", s"$selector")

  def fileUploadServiceLink(): WebElement =
    findElement("xpath", "//*[@href='/cds-file-upload-service']")

  def errorMessageCheck(inBoxErrorSelector: String, errorSelector: String, warningMessage: String): Unit = {
    messageInBox(inBoxErrorSelector).getText.trim must include(warningMessage)
    errorMessage(errorSelector).getText.trim      must include(warningMessage)
  }

  def clickExitAndCompleteLaterLink(): Unit =
    findElement("id", "exit-and-complete-later").click()

  def viewDeclarationSummaryLink(): Unit =
    findElement("id", "view_declaration_summary").click()

  def getLanguage: WebElement =
    findElement("cssSelector", language)

  def languageSwitch(language: String): WebElement =
    findElement("cssSelector", s".hmrc-language-select__list a[lang|=$language]")

  def checkTitle(englishTitle: String, welshTitle: String): Unit = {
    val language = getLanguage.getText
    if (language.contains("English"))
      onPage(englishTitle)
    else
      onPage(welshTitle)
  }

  def backLink(): WebElement = findElement("cssSelector", ".govuk-back-link")
}
