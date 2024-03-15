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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{mucr, mucrCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Mucr

object EnterAMucrPage extends BasePage {

  def backButtonHref: String = LinkMucrPage.path

  val path: String = "/declaration/enter-a-mucr"

  val title: String = "Enter the MUCR"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> Seq(mucr),
    Clearance -> Seq(mucrCL)
  )

  override def fillPage(values: String*): Unit = {
    val mucr = values.head
    fillTextBoxById("MUCR", mucr)
    store(Mucr -> Detail(mucr))
  }
}
