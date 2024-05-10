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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.PageLinks._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsProcedureCodes, itemsProcedureCodesCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail, Details}
import uk.gov.hmrc.test.ui.pages.section2.EntryIntoDeclarantRecordsPage.isEidr
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{ItemIds, ProcedureCode, ProcedureCodeLabel}

object ProcedureCodesPage extends BasePage {

  val pageId = "procedure-codes"
  def backButtonHref: String = DeclarationItemsListPage.path
  def path: String = itemUrl("procedure-codes")
  val title: String = "What is the procedure code for this item?"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(itemsProcedureCodes), Clearance -> List(itemsProcedureCodesCL))

  override def pageLinkHrefs: Seq[String] =
    if (isEidr) super.pageLinkHrefs
    else
      super.pageLinkHrefs ++ List(
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
    fillDropdown("procedureCode", procedureCode)
    store(
      ItemIds -> Details(maybeDetails(ItemIds).fold(Seq(itemId))(addItemId)),
      ProcedureCode(itemId) -> Detail(procedureCode)
    )
  }

  private val codesRestrictingZeroVat: Seq[String] =
    List("1007", "1042", "2151", "2154", "2200", "3151", "3154", "3171", "2100", "2144", "2244", "2300", "3153")

  private val addItemId = (itemIds: Seq[String]) => {
    val id = itemId
    if (itemIds.contains(id)) itemIds else itemIds :+ id
  }

  def hasRestrictingZeroVatPC: Boolean = codesRestrictingZeroVat.contains(detail(ProcedureCode(itemId)))

  def hasPermanentExportOfUKGoodsPC: Boolean = listOfItemDetailFor(ProcedureCodeLabel).contains("1040")

  def hasSupervisingCustomsOfficePageVisiblePC: Boolean = detail(ProcedureCode(itemId)) == "1042"

  private val codesToGoToWarehouse: Seq[String] = List("07", "71", "78")

  def goToWarehouse: Boolean = {
    val procedureCode = detail(ProcedureCode(itemId))
    codesToGoToWarehouse.exists(procedureCode.endsWith)
  }
}
