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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.ProcedureCode

object ProcedureCodesPage extends BasePage {

  def backButtonHref: String = DeclarationItemsListPage.path
  val path: String           = itemUrl("procedure-codes")
  val title: String          = "What is the procedure code for this item?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List("https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-1-message-information-including-procedure-codes#de-110-procedure-box-37-procedure"),
    Clearance -> List("https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-1-message-information-including-procedure-codes#de-110-procedure-box-37-procedure")
  )
  override val pageLinkHrefs: Seq[String] = super.pageLinkHrefs ++ List(
    "https://www.gov.uk/government/publications/appendix-1-de-110-requested-and-previous-procedure-codes/requested-procedure-10-permanent-export-or-dispatch#section",
    "https://www.gov.uk/government/publications/appendix-1-de-110-requested-and-previous-procedure-codes/requested-procedure-10-permanent-export-or-dispatch#section-2",
    "https://www.gov.uk/government/publications/appendix-1-de-110-requested-and-previous-procedure-codes/requested-procedure-10-permanent-export-or-dispatch#section-3",
    "https://www.gov.uk/government/publications/appendix-1-de-110-requested-and-previous-procedure-codes/requested-procedure-11-inward-processing-prior-export-equivalence",
    "https://www.gov.uk/guidance/apply-to-pay-less-duty-on-goods-you-export-to-process-or-repair",
    "https://www.gov.uk/guidance/pay-less-import-duty-and-vat-when-re-importing-goods-to-the-uk-and-eu#claiming-relief-for-exporting-goods-using-a-duplicate-list",
    "https://www.gov.uk/guidance/moving-processed-or-repaired-goods-into-free-circulation-or-re-exporting-them"
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val procedureCode = values.head
    fillAutoComplete("procedureCode", procedureCode)
    store(ProcedureCode(itemId) -> Detail(procedureCode))
  }
}
