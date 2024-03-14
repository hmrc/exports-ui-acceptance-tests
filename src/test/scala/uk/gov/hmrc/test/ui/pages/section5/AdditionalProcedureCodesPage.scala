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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{
  itemsAdditionalProcedureCodes,
  itemsAdditionalProcedureCodes1,
  itemsAdditionalProcedureCodes2,
  itemsAdditionalProcedureCodesCL
}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{AdditionalProcedureCodes, ProcedureCode}

object AdditionalProcedureCodesPage extends BasePage {

  val lowValueDeclaration = "3LV"

  def backButtonHref: String = ProcedureCodesPage.path
  def path: String           = itemUrl("additional-procedure-codes")
  def title: String          = s"Add any additional procedure codes to ${detail(ProcedureCode(itemId))}"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(itemsAdditionalProcedureCodes, itemsAdditionalProcedureCodes1, itemsAdditionalProcedureCodes2),
    Clearance -> List(itemsAdditionalProcedureCodesCL, itemsAdditionalProcedureCodes1, itemsAdditionalProcedureCodes2)
  )

  // ex: performActionsAndStore("1CS")

  override protected def performActionsAndStore(values: String*): Unit = {
    values.foreach { value =>
      fillAutoComplete("additionalProcedureCode", value)
      clickById("add")
    }
    store(AdditionalProcedureCodes(itemId) -> Details(values))
  }
}
