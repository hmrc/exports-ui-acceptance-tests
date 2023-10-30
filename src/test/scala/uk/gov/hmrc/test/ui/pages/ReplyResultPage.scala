/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement

object ReplyResultPage extends BasePage {

  val replyResultPage      = "Reply result - CDS document uploads and secure messages - GOV.UK"
  val welshReplyResultPage = "Canlyniad yr ymateb - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"

  def messagesLink(): WebElement = getGovUKLinks(1)

  def uploadLink(): WebElement = getGovUKLinks(2)

  // page elements - message
  def greyBoxLink(): WebElement = getGovUKLinks(4)

  // page elements - result
  def greenBoxTitle(): WebElement = findElement("className", "govuk-panel__title")

  def greenBoxMessage(): WebElement = findElement("className", "govuk-panel__body")

  def backButton(): WebElement = findElement("className", "govuk-button")

  def validateReplyResultPage(): Unit =
    onPage(replyResultPage)
}
