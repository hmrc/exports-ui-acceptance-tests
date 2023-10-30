/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages._

class CommonStepDef extends BaseStepDef {

  Then("""^I switches language to (.*)$""") { (language: String) =>
    if (language.contains("welsh"))
      CommonPage.languageSwitch("cy").click()
    else
      CommonPage.languageSwitch("en").click()
  }

  Then("""^I clicks back on (.*) page$""") { (page: String) =>
    CommonPage.backLink().click()
  }

  Then("""^I validate language change to (.*) on (.*)$""") { (language: String, page: String) =>
    page match {
      case "Messages page"                             => CommonPage.checkTitle(MessagesPage.messageTitle, MessagesPage.welshMessageTitle)
      case "Conversation page"                         =>
        CommonPage.checkTitle(ConversationPage.conversationTitle, ConversationPage.welshConversationTitle)
      case "Message Choice page"                       =>
        CommonPage.checkTitle(MessageChoicePage.messageChoiceTitle, MessageChoicePage.welshMessageChoiceTitle)
      case "What Do You Want To Do page"               =>
        CommonPage.checkTitle(SfusHomePage.homePageTitle, SfusHomePage.welshHomePageTitle)
      case "MRN page"                                  => CommonPage.checkTitle(MrnEntryPage.mrnEntryPageTitle, MrnEntryPage.welshMrnTitle)
      case "Reply Results page"                        =>
        CommonPage.checkTitle(ReplyResultPage.replyResultPage, ReplyResultPage.welshReplyResultPage)
      case "Upload page"                               =>
        CommonPage.checkTitle(UploadFilesPage.uploadFileTitle, UploadFilesPage.welshUploadFileTitle)
      case "Contact Details page"                      =>
        CommonPage.checkTitle(
          ContactDetailsPage.contactDetailsPageTitle,
          ContactDetailsPage.welshContactDetailsTitle
        )
      case "Receipt page"                              => CommonPage.checkTitle(ReceiptPage.receiptPageTitle, ReceiptPage.welshReceiptPageTitle)
      case "How Many files Do You Need To Upload page" =>
        CommonPage.checkTitle(
          HowManyFilesUploadPage.howManyFilesUploadPageTitle,
          HowManyFilesUploadPage.welshHowManyFilesUploadTitle
        )
      case _                                           => "No match case"
    }
  }

  Then("""^I am displayed with a error message on (.*)$""") { (page: String) =>
    page match {
      case "What Do You Want To Do page"                                   =>
        CommonPage.errorMessageCheck("MessageInbox", "choice-error", SfusHomePage.errorMessageText)
      case "MRN page for submitting with empty data"                       =>
        CommonPage.errorMessageCheck("value", "value-error", MrnEntryPage.mrnWarningEmptyData)
      case "MRN page for submitting with invalid data"                     =>
        CommonPage.errorMessageCheck("value", "value-error", MrnEntryPage.mrnWarningWithInvalidData)
      case "Message Choice page for submitting with empty data"            =>
        CommonPage.errorMessageCheck(
          "ExportMessages",
          "choice-error",
          MessageChoicePage.messageChoiceWarningMessage
        )
      case "Contact Details page for submitting with empty data"           =>
        CommonPage.errorMessageCheck("name", "name-error", ContactDetailsPage.fullNameWarningMessage)
        CommonPage.errorMessageCheck(
          "companyName",
          "companyName-error",
          ContactDetailsPage.companyNameWarningMessage
        )
        CommonPage.errorMessageCheck(
          "phoneNumber",
          "phoneNumber-error",
          ContactDetailsPage.phoneNumberWarningMessage
        )
      case "Contact Details page for submitting with invalid phone number" =>
        CommonPage.errorMessageCheck(
          "phoneNumber",
          "phoneNumber-error",
          ContactDetailsPage.invalidPhoneNumberWarningMessage
        )
      case "Contact Details page for submitting with 16 digit number"      =>
        CommonPage.errorMessageCheck(
          "phoneNumber",
          "phoneNumber-error",
          ContactDetailsPage.longerPhoneNumberWarningMessage
        )
      case "file to upload page for submitting with empty data"            =>
        CommonPage.errorMessageCheck(
          "value",
          "value-error",
          HowManyFilesUploadPage.fileToUploadEmptyDataWarning
        )
      case "file to upload page for submitting with invalid data"          =>
        CommonPage.errorMessageCheck(
          "value",
          "value-error",
          HowManyFilesUploadPage.fileToUploadInvalidDataWarning
        )
      case _                                                               => "No match case"
    }
  }

  Then("""^I am navigated to (.*)$""") { (page: String) =>
    page match {
      case "Messages page"                             => MessagesPage.onPage(MessagesPage.messageTitle)
      case "Conversation page"                         => ConversationPage.onPage(ConversationPage.conversationTitle)
      case "Unverified email page"                     => UnVerifiedEmailPage.onPage(UnVerifiedEmailPage.unAuthorisedPageTitle)
      case "Message Choice page"                       => MessageChoicePage.onPage(MessageChoicePage.messageChoiceTitle)
      case "What Do You Want To Do page"               => SfusHomePage.onPage(SfusHomePage.homePageTitle)
      case "MRN page"                                  => MrnEntryPage.onPage(MrnEntryPage.mrnEntryPageTitle)
      case "Unauthorised page"                         => UnAuthorisedPage.onPage(UnAuthorisedPage.unAuthorisedPageTitle)
      case "Reply Results page"                        => ReplyResultPage.onPage(ReplyResultPage.replyResultPage)
      case "Upload page"                               => UploadFilesPage.onPage(UploadFilesPage.uploadFileTitle)
      case "Contact Details page"                      => ContactDetailsPage.onPage(ContactDetailsPage.contactDetailsPageTitle)
      case "How Many files Do You Need To Upload page" =>
        HowManyFilesUploadPage.onPage(HowManyFilesUploadPage.howManyFilesUploadPageTitle)
      case _                                           => "No match case"
    }
  }
}
