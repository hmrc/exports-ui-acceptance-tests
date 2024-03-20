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
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.NationalAdditionalCodes

object NationalAdditionalCodeRemovePage extends BasePage {

  def backButtonHref: String = NationalAdditionalCodesListPage.path
  def path: String = removeUrl("items", "national-additional-code")
  val title: String = "Are you sure you want to remove this national additional code?"

  override def checkExpanders(): Unit = ()

  val nationalCodeToTemove = 1

  // No  => fillPage(no)

  // The 2nd parameter is the "National Code" to remove
  // Yes => fillPage(yes, "A123")

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo))) {
      val detailKey = NationalAdditionalCodes(itemId)
      val codes = details(detailKey).filterNot(_ == values(nationalCodeToTemove))
      store(detailKey -> Details(if (codes.isEmpty) List("None") else codes))
    }
}
