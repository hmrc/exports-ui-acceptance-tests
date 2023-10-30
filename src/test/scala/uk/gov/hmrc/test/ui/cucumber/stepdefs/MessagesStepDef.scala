/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.openqa.selenium.By
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.MessagesPage

class MessagesStepDef extends BaseStepDef {

  Then("""^User is displayed with messages page""") { () =>
    MessagesPage.selectMessage()
  }

  And("""^I click on message link""") { () =>
    MessagesPage.singleMessage(0) match {
      case Some(message) => message.click()
      case None          => fail("Message index does not exist")
    }
  }

  And("""^User validates messages in the list""") { () =>
    MessagesPage.messagesLink().getAttribute("href")                        must include("/cds-file-upload-service/message-choice")
    MessagesPage.uploadLink().getAttribute("href")                          must include("/cds-file-upload-service/mrn-entry")
    MessagesPage.elementDoesNotExist(By.className(MessagesPage.messageRow)) must be(false)
  }
}
