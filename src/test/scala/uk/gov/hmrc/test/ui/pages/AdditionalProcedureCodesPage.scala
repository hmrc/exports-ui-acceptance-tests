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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.AdditionalProcedureCodes
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail, Details}

object AdditionalProcedureCodesPage extends BasePage {

  val backButtonHref: String = ProcedureCodesPage.path
  val path: String           = itemUrl("additional-procedure-codes")
  val title: String          = "What is the procedure code for this item?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-1-message-information-including-procedure-codes#de-111-additional-procedure-code-box-37-procedure",
      "https://www.gov.uk/government/publications/4-digit-to-3-digit-procedure-to-additional-procedure-code-correlation-matrix-for-exports",
      "https://www.gov.uk/government/publications/4-digit-to-3-digit-procedure-to-additional-procedure-code-correlation-matrix-for-inventory-exports"
    ),
    Clearance -> List(
      "https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-c21-customs-clearance-request-completion-guide-inventory-exports/group-1-message-information-including-procedure-codes#de-111-additional-procedure-code-box-37-procedure"
    )
  )

  override protected def performActionsAndStore(values: String*): Unit =
    store(
      s"$itemId/$AdditionalProcedureCodes"        -> Detail("Additional procedure codes"),
      value(s"$itemId/$AdditionalProcedureCodes") -> Details(values)
    )
}
