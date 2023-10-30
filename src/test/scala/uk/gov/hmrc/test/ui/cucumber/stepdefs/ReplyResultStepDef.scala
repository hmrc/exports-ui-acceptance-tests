/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.ReplyResultPage

class ReplyResultStepDef extends BaseStepDef {

  And("""^I Validates reply result page$""") { () =>
    // top of the page
    ReplyResultPage.messagesLink().getAttribute("href") must include("/cds-file-upload-service/message-choice")
    ReplyResultPage.uploadLink().getAttribute("href")   must include("/cds-file-upload-service/mrn-entry")

    // rest of the page
    ReplyResultPage.greyBoxLink().getText              must be("Upload and attach documents to a declaration")
    ReplyResultPage.greyBoxLink().getAttribute("href") must include("/cds-file-upload-service/mrn-entry")

    ReplyResultPage.greenBoxTitle().getText   must be("Message sent")
    ReplyResultPage.greenBoxMessage().getText must be("We received your message")

    ReplyResultPage.backButton().getText must include("Back to your messages")
  }

  When("""^I clicks back to your message button$""") { () =>
    ReplyResultPage.backButton().click()
  }

  When("""^I press the Upload and attach documents link in the grey box$""") { () =>
    ReplyResultPage.greyBoxLink().click()
  }
}
