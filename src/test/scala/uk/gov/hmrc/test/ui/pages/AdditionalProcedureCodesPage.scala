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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail, Details}
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{AdditionalProcedureCodes, cache}

object AdditionalProcedureCodesPage extends BasePage {

  def backButtonHref: String = itemUrl("procedure-codes")
  def path: String           = itemUrl("additional-procedure-codes")
  val title: String          = "What is the procedure code for this item?"

  override protected def performActionsAndCache(values: String*): Unit = {
    cache += (s"$itemId/$AdditionalProcedureCodes" -> Detail(""))
    cache += (value(s"$itemId/$AdditionalProcedureCodes") -> Details(values))
  }
}
