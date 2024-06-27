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

package uk.gov.hmrc.test.ui.pages.section1

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{ducr, ducrCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{DeclarationEori, Ducr}

import java.time.LocalDate

object DucrEntryPage extends BasePage {

  def backButtonHref: String =
    maybeDetail(Ducr).fold(DoYouHaveADucrPage.path) { ducr =>
      if (ducr.startsWith(ducrPrefix)) ConfirmDucrPage.path
      else DoYouHaveADucrPage.path
    }

  val path: String = "/declaration/ducr-entry"
  val title: String = "Enter your Declaration Unique Consignment Reference (DUCR)"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> Seq(ducr), Clearance -> Seq(ducrCL))

  def ducrPrefix: String = s"${LocalDate.now.getYear.toString.last}${detail(DeclarationEori).toUpperCase}-"
  def ducrWarning: WebElement = findElementByCssSelector(".govuk-error-summary__list a")

  // ex: fillPage("8GB123456183182-101SHIP1")

  override def fillPage(values: String*): Unit = {
    val ducr = values.head
    fillTextBoxById("ducr", ducr)
    store(Ducr -> Detail(ducr))
  }
}
