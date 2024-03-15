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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{ducr, ducrCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Ducr

object DucrEntryPage extends BasePage {

  def backButtonHref: String = DoYouHaveADucrPage.path
  val path: String = "/declaration/ducr-entry"
  val title: String = "Enter your Declaration Unique Consignment Reference (DUCR)"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> Seq(ducr),
    Clearance -> Seq(ducrCL)
  )

  // ex: fillPage("8GB123456183182-101SHIP1")

  override def fillPage(values: String*): Unit = {
    val ducr = values.head
    fillTextBoxById("ducr", ducr)
    store(Ducr -> Detail(ducr))
  }
}
