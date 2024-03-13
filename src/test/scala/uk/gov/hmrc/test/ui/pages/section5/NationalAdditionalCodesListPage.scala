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
import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys.NatureOfTransaction
import uk.gov.hmrc.test.ui.pages.section4.NatureOfTransactionPage
import uk.gov.hmrc.test.ui.pages.section5.AdditionalProcedureCodesPage.lowValueDeclaration
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{AdditionalProcedureCodes, NationalAdditionalCodes}

object NationalAdditionalCodesListPage extends BasePage {

  def backButtonHref: String =
    detail(DeclarationType) match {
      case Occasional | Simplified =>
        if (details(AdditionalProcedureCodes(itemId)).contains(lowValueDeclaration)) VatRatingPage.path
        else VatRatingPage.backButtonHref

      case Standard =>
        detail(NatureOfTransaction) match {
          case NatureOfTransactionPage.Sale | NatureOfTransactionPage.BusinessPurchase => VatRatingPage.path
          case _ => VatRatingPage.backButtonHref
        }

      case Supplementary => VatRatingPage.backButtonHref
    }

  def path: String = itemUrl("national-additional-codes-list")

  def title: String =
    details(NationalAdditionalCodes(itemId)).size match {
      case 1 => "You have added 1 national additional code"
      case n => s"You have added $n national additional codes"
    }

  override def checkExpanders(): Unit = ()

  // No  => performActionsAndStore(no)
  // Yes => performActionsAndStore(yes)

  override protected def performActionsAndStore(values: String*): Unit = selectYesOrNoRadio(values.head)
}
