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
import uk.gov.hmrc.test.ui.pages.base.Constants.{no, yes}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{PackageInformationNumber, PackageInformationShippingMark, PackageInformationType}

object PackageInformationRemovePage extends BasePage {

  def backButtonHref: String = PackageInformationListPage.path
  def path: String           = removeUrl("items", "package-information")
  val title: String          = "Are you sure you want to remove this package type?"

  override def checkExpanders(): Unit = ()

  // No  => fillPage(no)

  // The 1st parameter is the sequenceId of the current "Packing Details" element: "0", "1", "2", ...
  // Yes => fillPage("2", yes)

  override def fillPage(values: String*): Unit = {
    if (values.head == no) selectYesOrNoRadio(no)
    else {
      selectYesOrNoRadio(yes)
      clear(
        PackageInformationType(itemId, values(sequenceId)),
        PackageInformationNumber(itemId, values(sequenceId)),
        PackageInformationShippingMark(itemId, values(sequenceId))
      )
    }
  }
}
