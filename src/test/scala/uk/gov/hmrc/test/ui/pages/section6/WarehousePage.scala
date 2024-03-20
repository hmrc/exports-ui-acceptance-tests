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

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.WarehouseHouse

object WarehousePage extends BasePage {

  val path: String           = "/declaration/warehouse-details"
  val title: String          = "What is the customs approved warehouse number?"
  val backButtonHref: String = TransportLeavingTheBorderPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(warehouseIdentification),
    Clearance -> List(warehouseIdentificationCL)
  )

  private val code = 0

  override def fillPage(values: String*): Unit = {
    fillTextBoxById("identificationNumber", values(code))
    store(WarehouseHouse -> Detail(values(code)))
  }
}
