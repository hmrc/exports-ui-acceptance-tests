/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.ReceiptPage

class ReceiptStepDef extends BaseStepDef {

  Then("""^On a successful upload i should see the receipt page$""") { () =>
    ReceiptPage.validateReceiptPage()
  }

  When("""^I click (.*) on receipt page$""") { (link: String) =>
    link match {
      case "Back To Start link"    => ReceiptPage.uploadNext().click()
      case "CDS secure inbox link" => ReceiptPage.cdsSecureInboxLink().click()
      case "Messages link"         => ReceiptPage.messagesLink().click()
      case "Upload link"           => ReceiptPage.uploadLink().click()
    }
  }
}
