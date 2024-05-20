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
import uk.gov.hmrc.test.ui.generator.SupportGenerator
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.common.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._

object CopyDeclarationPage extends BasePage {

  def backButtonHref: String = detail(DeclarationInfoPath)
  val path: String = "/copy-declaration"
  val title: String = "Copy declaration"

  override def checkExpanders(): Unit = ()

  def lrnWarning(): WebElement = findElementByCssSelector(".govuk-error-summary__list a:first-child")

  val ducr = 0
  val lrnPrefix = 1

  // ex: fillPage("8GB123456469274-101SHIP1", "Q0")
  // ex: fillPage("8GB123456469274-101SHIP1", "24")

  override def fillPage(values: String*): Unit = {

    val lrn = SupportGenerator.generateLrn(values(lrnPrefix)).toUpperCase

    fillTextBoxById("ducr_ducr", values(ducr))

    if (values(1).equals("24"))
      fillTextBoxById("lrn", detail(Lrn))
    else
      fillTextBoxById("lrn", lrn)

    store(Lrn -> Detail(lrn))
    store(Ducr -> Detail(values(ducr)))
  }
}
