/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.ConversationPage

class ConversationStepDefs extends BaseStepDef {

  Then("""I validate conversation page""") { () =>
    // top of the page
    ConversationPage.messagesLink().getAttribute("href") must include("/cds-file-upload-service/message-choice")
    ConversationPage.uploadLink().getAttribute("href")   must include("/cds-file-upload-service/mrn-entry")

    // rest of the page
    ConversationPage.header().getText must not be empty

    ConversationPage.greyBoxLink().getText              must be("Upload and attach documents to a declaration")
    ConversationPage.greyBoxLink().getAttribute("href") must include("/cds-file-upload-service/mrn-entry")

    // reply part
    ConversationPage.replyHeader().getText must include("Reply to this message")
    ConversationPage.sendButton().getText  must be("Send")
  }

  And("""I submit a reply on conversation page""") { () =>
    ConversationPage.replyForm().sendKeys("SFUS FILE UPLOAD")
    ConversationPage.sendButton().click()
  }

}
