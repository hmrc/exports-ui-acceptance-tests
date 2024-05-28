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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{supervisingCustomsOffice, supervisingCustomsOfficeCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.{SuperVisingCustomsOffice, WarehouseHouse}

object SupervisingCustomsOfficePage extends BasePage {

  def backButtonHref: String = maybeDetail(WarehouseHouse).fold(WarehousePage.backButtonHref)(_ => WarehousePage.path)

  val path: String = "/declaration/supervising-customs-office"

  val title: String = "Where is the HMRC supervising customs office (SPOFF)?"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(supervisingCustomsOffice), Clearance -> List(supervisingCustomsOfficeCL))

  private val officeCode = 0

  // ex: fillPage("GBBTH001")

  override def fillPage(values: String*): Unit = {
    fillDropdown("supervisingCustomsOffice", values(officeCode))
    store(SuperVisingCustomsOffice -> Detail(values(officeCode)))
  }
}
