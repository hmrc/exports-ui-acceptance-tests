/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.common

import org.openqa.selenium.WebElement
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.base.BasePage.exitAndCompleteLater
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.common.DetailKeys.RemoveSavedDecLink
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._

object SavedDeclarationsPage extends BasePage {

  val backButtonHref: String = "/choice"
  val path: String = "/saved-declarations"
  def title: String = if(isAmendmentMode) "Your saved declarations and amendments" else "Your saved declarations"

  override def checkExpanders(): Unit = ()

  override def pageLinkHrefs: Seq[String] = {
    super.pageLinkHrefs.filterNot(_ == exitAndCompleteLater)
  }

  override def fillPage(values: String*): Unit = ()

  def removeLink(): WebElement = findElementByCssSelector("tr:nth-child(1)>td:nth-child(4)>a")

  def dUCRLink(): WebElement = findElementByCssSelector("tr:nth-child(1)>td:nth-child(2)>a")

  def validateSavedDeclarations(status: String): Unit = {
    assert(findElementByCssSelector("tr:nth-child(1)>td:nth-child(1)").isDisplayed)
    findElementByCssSelector("tr:nth-child(1)>td:nth-child(2) span:first-child").getText mustBe detail(Ducr)
    findElementByCssSelector("tr:nth-child(1)>td:nth-child(3)").getText mustBe status
    store(RemoveSavedDecLink -> Detail(removeLink().getAttribute("href")))
  }

  def removeDraftDec(): Unit = removeLink().click()

  def clickDUCRLinkForAmendedDeclaration(): Unit = dUCRLink().click()
}