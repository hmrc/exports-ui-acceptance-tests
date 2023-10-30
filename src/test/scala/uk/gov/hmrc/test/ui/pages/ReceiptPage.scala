/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement

object ReceiptPage extends BasePage {

  val receiptPageTitle      = "Files uploaded - CDS document uploads and secure messages - GOV.UK"
  val welshReceiptPageTitle =
    "Ffeiliau wedi’u huwchlwytho - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"

  def messagesLink(): WebElement = getGovUKLinks(1)

  def uploadLink(): WebElement = getGovUKLinks(2)

  def uploadNext(): WebElement = findElement("className", "govuk-button")

  def printLink(): WebElement = getGovUKLinks(3)

  def userEmail(): WebElement = findElement("id", "verifiedEmail")

  def cdsSecureInboxLink(): WebElement = getGovUKLinks(4)

  def replyToTheMessageLink(): WebElement = getGovUKLinks(5)

  def nchMailLink(): WebElement = getGovUKLinks(6)

  def mrnConfirmation(): WebElement = findElement("className", "govuk-panel__body")

  def validateReceiptPage(): Unit =
    onPage(receiptPageTitle)
}
