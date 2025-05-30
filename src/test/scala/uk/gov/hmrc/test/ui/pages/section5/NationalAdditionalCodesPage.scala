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

import uk.gov.hmrc.test.ui.pages.base.Constants.yesNo
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.NationalAdditionalCodes

object NationalAdditionalCodesPage extends BasePage {

  def backButtonHref: String =
    if (elementByIdDoesNotExist("code_yes")) NationalAdditionalCodesListPage.path
    else NationalAdditionalCodesListPage.backButtonHref

  override def changeLink: String = NationalAdditionalCodesListPage.path

  def path: String = itemUrl("national-additional-code")

  def title: String =
    if (elementByIdDoesNotExist("code_yes")) "What is the next national additional code?"
    else "Do you need to add a national additional code?"

  override def checkExpanders(): Unit = ()

  val code = 1
  val anotherNationalCode = 0

  // No  => fillPage(no)
  // Yes => fillPage(yes, "A123")
  //     => fillPage("A123")

  override def fillPage(values: String*): Unit = {
    val nationalAdditionalCodes =
      if (elementByClassDoesNotExist("govuk-radios", 10)) {
        fillTextBoxById("nactCode", values(anotherNationalCode))
        details(NationalAdditionalCodes(itemId)) :+ values(anotherNationalCode)
      } else if (selectYesOrNoRadio(values(yesNo))) {
        fillTextBoxById("nactCode", values(code))
        List(values(code))
      } else List(Constants.none)

    store(NationalAdditionalCodes(itemId) -> Details(nationalAdditionalCodes))
  }
}
