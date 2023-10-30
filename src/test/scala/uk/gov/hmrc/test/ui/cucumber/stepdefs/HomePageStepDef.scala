/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.{CommonPage, SfusHomePage}

class HomePageStepDef extends BaseStepDef {

  Given("""^I select the (.*) option and proceed the journey$""") { (option: String) =>
    SfusHomePage.selectWhatDoYouWantToDoOption(option)
  }

  When("""^I select continue with out filling the page$""") { () =>
    SfusHomePage.submit()
  }

  And("""^I click on file upload service link$""") { () =>
    CommonPage.fileUploadServiceLink().click()
  }
}
