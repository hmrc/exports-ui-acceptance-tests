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
      checkUrlAndTitle(englishTitle)
    else
      checkUrlAndTitle(welshTitle)
  }

  def backLink(): WebElement = findElement("cssSelector", ".govuk-back-link")
}
