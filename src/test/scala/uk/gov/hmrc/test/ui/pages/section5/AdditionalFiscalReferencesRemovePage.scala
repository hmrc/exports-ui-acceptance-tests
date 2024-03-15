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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.AdditionalFiscalReferences

object AdditionalFiscalReferencesRemovePage extends BasePage {

  def backButtonHref: String = AdditionalFiscalReferencesListPage.path
  def path: String           = removeUrl("items", "additional-fiscal-references")
  val title: String          = "Are you sure you want to remove these VAT details?"

  override def checkExpanders(): Unit = ()

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values.head)) {
      val detailKey          = AdditionalFiscalReferences(itemId)
      val vatDetailsToRemove = values.head
      val result             = details(detailKey).filterNot(_ == vatDetailsToRemove)
      if (result.isEmpty) clear(detailKey) else store(detailKey -> Details(result))
    }
}
