/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebDriver, WebElement}

import scala.jdk.CollectionConverters.CollectionHasAsScala

object MessagesPage extends BasePage {

  val messageTitle      = "Conversation Inbox - CDS document uploads and secure messages - GOV.UK"
  val messageRow        = "message-row"
  val welshMessageTitle = "Mewnflwch sgyrsiau - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"

  def messagesLink(): WebElement = getGovUKLinks(1)
  def uploadLink(): WebElement   = getGovUKLinks(2)

  def selectMessage(): ConversationPage.type = {
    onPage(messageTitle)
    ConversationPage
  }

  def messageEntries()(implicit driver: WebDriver): List[WebElement] =
    driver
      .findElement(By.className(messageRow))
      .findElements(By.cssSelector("a"))
      .asScala
      .filter(p => p.getAttribute("aria-hidden") != null)
      .toList

  def singleMessage(index: Int)(implicit driver: WebDriver): Option[WebElement] = messageEntries().lift(index)
}
