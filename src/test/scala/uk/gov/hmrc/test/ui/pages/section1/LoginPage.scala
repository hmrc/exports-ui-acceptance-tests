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

import uk.gov.hmrc.test.ui.conf.TestConfiguration.url
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationEori

import java.time.Duration

object LoginPage extends BasePage {

  val backButtonHref: String = ""
  val path: String = "/gg-sign-in"
  val title: String = "Authority Wizard"

  override def checkBackButton(): Unit = ()

  override def checkUrlAndTitle(): Unit = ()

  override def checkPageLinks(): Unit = ()

  // ex: fillPage("GB7172755076437")

  override def fillPage(values: String*): Unit = {
    navigateToLoginPage()
    enterRedirectPage()

    fillTextBoxByName("enrolment[0].name", "HMRC-CUS-ORG")
    fillTextBoxByName("enrolment[0].taxIdentifier[0].name", "EORINumber")

    val eori = values(0)
    fillTextBoxByName("enrolment[0].taxIdentifier[0].value", eori) // EORI field
    store(DeclarationEori -> Detail(eori))
  }

  def submit(): Unit = clickById("submit-top")

  private def navigateToLoginPage(): Unit = driver.navigate().to(url("login-stub-frontend") + path)

  private def enterRedirectPage(): Unit = {
    val redirectUrl = url("exports-frontend") + ChoicePage.path
    fillTextBoxById("redirectionUrl", redirectUrl)
  }
}
