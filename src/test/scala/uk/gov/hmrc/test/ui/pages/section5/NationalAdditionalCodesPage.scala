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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.itemsNationalAdditionalCode
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.NationalAdditionalCodes

object NationalAdditionalCodesPage extends BasePage {

  def backButtonHref: String =
    if (elementByIdDoesNotExist("code_yes")) NationalAdditionalCodesListPage.path
    else NationalAdditionalCodesListPage.backButtonHref

  def path: String = itemUrl("national-additional-code")

  def title: String =
    if (elementByIdDoesNotExist("code_yes")) "Do you need to add a national additional code?"
    else "What is the next national additional code?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(itemsNationalAdditionalCode))

  val yesNo = 0
  val code  = 1
  val anotherNationalCode  = 0

  // No  => processPage(no)
  // Yes => processPage(yes, "A123")
  //     => processPage("A123")

  def processPage(values: String*): Unit = {
    val nationalAdditionalCodes =
      if (elementByIdDoesNotExist("code_yes")) details(NationalAdditionalCodes(itemId)) :+ values(anotherNationalCode)
      else if (selectYesOrNoRadio(values(yesNo))) List(values(code)) else List("None")

    store(NationalAdditionalCodes(itemId) -> Details(nationalAdditionalCodes))
  }
}
