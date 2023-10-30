/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.{ExportsHomePage, LoginStubPage, SavedDeclarationsPage}

class LoginStepDef extends BaseStepDef {

  Given("""^I navigate to login stub page$""") { () =>
    LoginStubPage.loadPage
  }

  When("""^I enter the user enrolment key, (.*) number and identifier value with the sfus redirect url$""") {
    (eori: String) =>
      LoginStubPage.provideLoginCredentials(eori)
  }

  When("""^I open the draft declaration with (.*) with logged in (.*)$""") { (ducr: String, eori: String) =>
    LoginStubPage.loadPage
    LoginStubPage.provideLoginCredentialsForExports(eori)
    ExportsHomePage.selectOptionToMakeAndManageDeclaration("ManageDraftDeclaration")
    SavedDeclarationsPage.clickDraftDeclarationByUsingDUCR(ducr)
  }

  When("""^I provide (.*) key, (.*) number and (.*) value to login$""") {
    (enrolment: String, eori: String, identifier: String) =>
      LoginStubPage.provideKickOutPageCredentials(enrolment, eori, identifier)
  }
}
