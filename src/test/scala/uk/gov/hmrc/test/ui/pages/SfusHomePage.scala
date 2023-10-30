/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object SfusHomePage extends BasePage {

  val url: String                = TestConfiguration.url("sfus-frontend") + "/what-do-you-want-to-do"
  val homePageTitle              = "What do you want to do? - CDS document uploads and secure messages - GOV.UK"
  val welshHomePageTitle         = "Beth hoffech ei wneud? - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"
  val messageRadioButton         = "MessageInbox"
  val attachDocumentsRadioButton = "DocumentUpload"
  val errorMessageText           = "Select what you would like to do"

  def selectWhatDoYouWantToDoOption(option: String): MrnEntryPage.type = {
    option match {
      case "MessageInbox"   => findElement("id", messageRadioButton).click()
      case "DocumentUpload" => findElement("id", attachDocumentsRadioButton).click()
    }
    submit()
    MrnEntryPage
  }

}
