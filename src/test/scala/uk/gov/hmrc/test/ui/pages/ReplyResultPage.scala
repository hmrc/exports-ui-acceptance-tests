/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.pages.base.BasePage

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
    checkUrlAndTitle(replyResultPage)
}
