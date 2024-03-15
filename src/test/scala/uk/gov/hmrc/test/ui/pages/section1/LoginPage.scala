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

package uk.gov.hmrc.test.ui.pages.section1

import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.test.ui.conf.TestConfiguration.url
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationEori

object LoginPage extends BasePage {

  def backButtonHref: String = ""
  val path: String           = "/gg-sign-in"
  val title: String          = "Authority Wizard"

  override protected def checkBackButton(): Unit  = ()
  override protected def checkUrlAndTitle(): Unit = ()
  override protected def checkPageLinks(): Unit   = ()

  // ex: performActionsAndStore("GB7172755076437")
  override def fillPage(values: String*): Unit = {
    val eori = values(0)

    navigateToLoginPage()
    enterRedirectPage()
    enterEnrolmentType("HMRC-CUS-ORG")
    enterTaxIdentifier("EORINumber")
    enterEori(eori)
    store(DeclarationEori -> Detail(eori))
  }

  override def submit: Unit = clickById("submit-top")

  private def navigateToLoginPage(): Unit             = driver.navigate().to(url("login-stub-frontend") + path)
  private def enterRedirectPage(): Unit = {
    val redirectUrl = url("exports-frontend")+ChoicePage.path
    fillTextBoxById("redirectionUrl", redirectUrl)
  }

  private def enterEnrolmentType(input: String): Unit = fillTextBoxByName("enrolment[0].name", input)
  private def enterTaxIdentifier(input: String): Unit = fillTextBoxByName("enrolment[0].taxIdentifier[0].name", input)
  private def enterEori(input: String): Unit          = fillTextBoxByName("enrolment[0].taxIdentifier[0].value", input)
}
