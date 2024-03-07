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
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object AdditionalDocumentationPage extends BasePage {

  val path: String                                             = "/declaration/additional-documentation"
  val additionalDocumentationPage                             = "Enter licence details, authorisation numbers and any other document details"
  var additionalDocumentationPageDetails: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    AdditionalDocumentationPage.checkUrlAndTitle(additionalDocumentationPage)

  def enterLicenceDocumentDetails(): Unit = {

    val documentCode: WebElement = findElementById("documentTypeCode")
    documentCode.sendKeys("C501")

    val documentIdentifier: WebElement = findElementById("documentIdentifier")
    documentIdentifier.sendKeys("GBAEOC717572504502801")

store += ("documentCode"       -> documentCode.getText)
store += ("documentIdentifier" -> documentIdentifier.getText)

    submit()
  }
}
