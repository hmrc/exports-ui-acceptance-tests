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

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.Constants.yesNo
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.AdditionalFiscalReferences

object FiscalReferencesListPage extends BasePage {

  val pageId: String = "additional-fiscal-references-list"
  def backButtonHref: String = FiscalReferencesYesNoPage.path
  def path: String = itemUrl(pageId)

  def title: String =
    details(AdditionalFiscalReferences(itemId)).size match {
      case 1 => "You have added 1 VAT number"
      case n => s"You have added $n VAT numbers"
    }

  override def checkExpanders(): Unit = ()

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = selectYesOrNoRadio(values(yesNo))

  def removeFiscalReferences(index: Int): Unit = clickByCssSelector(s"#additional_fiscal_references-row-$index-remove_button>a")
}
