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

package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.inlandOrBorder
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.{InlandOrBorder, SuperVisingCustomsOffice}

object InlandOrBorderPage extends BasePage {

  def backButtonHref: String =
    maybeDetail(SuperVisingCustomsOffice).fold(SupervisingCustomsOfficePage.backButtonHref)(_ => SupervisingCustomsOfficePage.path)

  val path: String  = "/declaration/inland-or-border"
  val title: String = "Where are you presenting your goods to customs?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(inlandOrBorder))

  private val location = 0

  // ex: fillPage("Customs controlled location")

  override def fillPage(values: String*): Unit = {
    values(location) match {
      case "Border Location"             => clickById("Border")
      case "Customs controlled location" => clickById("Inland")
    }
    store(InlandOrBorder -> Detail(values(location)))
  }
}
