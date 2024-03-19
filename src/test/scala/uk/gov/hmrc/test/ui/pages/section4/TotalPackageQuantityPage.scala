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

package uk.gov.hmrc.test.ui.pages.section4

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.totalPackageQuantity
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.TotalAmountInvoiced
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys.TotalAmountInvoiced


object TotalPackageQuantityPage extends BasePage {

  val path: String = "/declaration/total-package-quantity"

  def title = "What is the total number of packages in this declaration?"

  val backButtonHref: String = InvoiceAndExchangeRatePage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(totalPackageQuantity)
  )

  def fillPage(values: String*): Unit = {
    val enteredTotalNumberOfPackages = values.head
    fillTextBoxById("totalPackage",enteredTotalNumberOfPackages)
   store(TotalAmountInvoiced -> Detail(enteredTotalNumberOfPackages))
  }

}
