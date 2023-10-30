/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object LoginStubPage extends BasePage {
  val url: String                = TestConfiguration.url("login-stub-frontend") + "/gg-sign-in"
  val redirectUrlToEnter: String = TestConfiguration.url("exports-frontend")
  val loginStubPageTitle         = "Authority Wizard"

  val redirectUrlInput = "redirectionUrl"
  val enrolmentKey     = "enrolment[0].name"
  val identifierName   = "input-0-0-name"
  val identifierValue  = "input-0-0-value"

  def loadPage: this.type = {
    driver.navigate().to(url)
    onPage(loginStubPageTitle)
    this
  }

  val rand = new scala.util.Random
  def provideLoginCredentials(eori: String): SfusHomePage.type = {
    findElement("id", redirectUrlInput).sendKeys(redirectUrlToEnter)
    findElement("id", enrolmentKey).sendKeys("HMRC-CUS-ORG")
    findElement("id", identifierName).sendKeys("EORINumber")
    findElement("id", identifierValue).sendKeys(eori)
    submit()
    SfusHomePage
  }

  def provideLoginCredentialsForExports(eori: String): ExportsHomePage.type = {
    findElement("id", redirectUrlInput).sendKeys(redirectUrlToEnter)
    findElement("id", enrolmentKey).sendKeys("HMRC-CUS-ORG")
    findElement("id", identifierName).sendKeys("EORINumber")
    findElement("id", identifierValue).sendKeys(eori)
    submit()
    ExportsHomePage
  }

  def provideKickOutPageCredentials(eori: String, enrolment: String, identifier: String): Unit = {
    findElement("id", redirectUrlInput).sendKeys(redirectUrlToEnter)
    findElement("id", enrolmentKey).sendKeys(enrolment)
    findElement("id", identifierName).sendKeys(identifier)
    findElement("id", identifierValue).sendKeys(eori)
    submit()
  }
}
