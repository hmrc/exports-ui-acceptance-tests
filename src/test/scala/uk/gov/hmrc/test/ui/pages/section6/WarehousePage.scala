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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, yesNo}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{warehouseIdentification, warehouseIdentificationCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationChoicePage.isClearance
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.WarehouseHouse

object WarehousePage extends BasePage {

  def backButtonHref: String = TransportLeavingTheBorderPage.path

  val path: String = "/declaration/warehouse-details"

  def title: String =
    if (isClearance) "Were the goods in a customs approved warehouse?"
    else "What is the customs approved warehouse number?"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(warehouseIdentification), Clearance -> List(warehouseIdentificationCL))

  private val identifierOnNonClearance = 0

  // Non-Clearance Journey
  // ex: fillPage("R1234567GB")

  private val identifierOnClearance = 1

  // On Clearance Journey
  //   No  => fillPage(no)
  //   Yes => fillPage(yes, "R1234567GB")

  override def fillPage(values: String*): Unit =
    if (!isClearance) {
      fillTextBoxById("identificationNumber", values(identifierOnNonClearance))
      store(WarehouseHouse -> Detail(values(identifierOnNonClearance)))
    }
    else if (selectYesOrNoRadio(values(yesNo))) {
      fillTextBoxById("identificationNumber", values(identifierOnClearance))
      store(WarehouseHouse -> Detail(values(identifierOnClearance)))
    }
    else store(WarehouseHouse -> Detail(Constants.no))
}
