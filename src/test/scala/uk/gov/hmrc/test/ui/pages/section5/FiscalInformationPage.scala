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

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.FiscalInformationYesNo

object FiscalInformationPage extends BasePage {

  def backButtonHref: String = AdditionalProcedureCodesPage.path
  val path: String           = itemUrl("fiscal-information")

  val title: String = "Do you want to claim Onward Supply Relief (OSR)?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List("https://www.gov.uk/government/publications/uk-trade-tariff-cds-volume-3-export-declaration-completion-guide/group-3-parties#de-340-additional-fiscal-references-identification-number-no-previous-reference")
  )

  override protected def performActionsAndStore(values: String*): Unit = {
    val yesNo =  values.head
    selectYesOrNoRadio(yesNo)
    store(FiscalInformationYesNo(itemId) -> Detail(yesNo))
  }
}
