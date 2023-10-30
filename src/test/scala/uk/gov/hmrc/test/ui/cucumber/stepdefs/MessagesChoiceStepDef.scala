/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.MessageChoicePage

class MessagesChoiceStepDef extends BaseStepDef {

  When("""^I select export choice as (.*)""") { (choice: String) =>
    MessageChoicePage.selectMessageChoice(choice)
  }
}
