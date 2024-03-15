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

package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, yes}
import uk.gov.hmrc.test.ui.pages.base.PageLinks._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsProcedureCodes, itemsProcedureCodesCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.EntryIntoDeclarantsRecords
import uk.gov.hmrc.test.ui.pages.section5.CommodityMeasurePage.{detail, itemId}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.ProcedureCode

object ProcedureCodesPage extends BasePage {

  def backButtonHref: String = DeclarationItemsListPage.path
  def path: String           = itemUrl("procedure-codes")
  val title: String          = "What is the procedure code for this item?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(itemsProcedureCodes),
    Clearance -> List(itemsProcedureCodesCL)
  )
  override def pageLinkHrefs: Seq[String] =
    if (detail(DeclarationType) == Clearance && detail(EntryIntoDeclarantsRecords) == yes) super.pageLinkHrefs
    else super.pageLinkHrefs ++ List(
        endUseRelief,
        inwardProcessing,
        outwardProcessing,
        onwardSupplyRelief,
        reExportFollowingSpecialProcedure,
        removalOfGoodsFromExciseWarehouse,
        temporaryExport
      )

  // ex: fillPage("1040")

  override def fillPage(values: String*): Unit = {
    val procedureCode = values.head
    fillAutoComplete("procedureCode", procedureCode)
    store(ProcedureCode(itemId) -> Detail(procedureCode))
  }

  def isExportInventoryCleansingRecord: Boolean = detail(ProcedureCode(itemId)) == "0019" // EICR procedure code
  def isOsrProcedureCode: Boolean = detail(ProcedureCode(itemId)) == "1042"
}
