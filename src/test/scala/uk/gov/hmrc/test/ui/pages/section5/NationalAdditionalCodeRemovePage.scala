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
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.NationalAdditionalCodes

object NationalAdditionalCodeRemovePage extends BasePage {

  def backButtonHref: String = NationalAdditionalCodesListPage.path
  def path: String = removeUrl("items", "national-additional-code")
  val title: String = "Are you sure you want to remove this national additional code?"

  override def checkExpanders(): Unit = ()

  val yesNo = 0
  val code  = 1
  val anotherNationalCode  = 0

  // No  => processPage(no)
  // Yes => processPage(yes)

  def processPage(values: String*): Unit = {
    val nationalAdditionalCodes =
      if (elementByIdDoesNotExist("code_yes")) details(NationalAdditionalCodes(itemId)) :+ values(anotherNationalCode)
      else if (selectYesOrNoRadio(values(yesNo))) List(values(code)) else List("None")

    store(NationalAdditionalCodes(itemId) -> Details(nationalAdditionalCodes))
  }
}
