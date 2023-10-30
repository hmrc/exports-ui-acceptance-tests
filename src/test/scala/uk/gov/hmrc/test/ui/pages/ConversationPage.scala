/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement

object ConversationPage extends BasePage {

  val conversationTitle      = "View conversation - CDS document uploads and secure messages - GOV.UK"
  val welshConversationTitle = "Bwrw golwg dros sgwrs - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"

  def messagesLink(): WebElement = getGovUKLinks(1)

  def uploadLink(): WebElement = getGovUKLinks(2)

  // page elements - message
  def header(): WebElement = findElement("cssSelector", "h1")

  def greyBoxLink(): WebElement = getGovUKLinks(4)

  // page elements - reply
  def replyHeader(): WebElement =
    findElement("className", "govuk-form-group")
  findElement("className", "govuk-label")

  def replyForm(): WebElement = findElement("id", "reply-form")

  def sendButton(): WebElement = findElement("className", "govuk-button")

  def conversation() =
    onPage(conversationTitle)
}
