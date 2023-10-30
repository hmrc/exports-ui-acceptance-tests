/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.ContactDetailsPage

class ContactDetailsStepDef extends BaseStepDef {

  Given("""^I fill contact details$""") { () =>
    ContactDetailsPage.enterAddress()
  }

  When("""^I submit contact details page with empty data$""") { () =>
    ContactDetailsPage.clearContactDetails()
    ContactDetailsPage.submit()
  }

  And("""^I fill contact details with (.*) phone number$""") { (value: String) =>
    value match {
      case "invalid" => ContactDetailsPage.enterPhoneNumber("********")
      case _         => ContactDetailsPage.enterPhoneNumber("7676867890987654")
    }
  }
}
