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

package uk.gov.hmrc.test.ui.pages.section3

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{officeOfExit, officeOfExitCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.OfficeOfExit

object OfficeOfExitPage extends BasePage {

  def backButtonHref: String = LocationOfGoodsPage.path
  val path: String = "/declaration/office-of-exit"
  val title = "Where is the customs office of exit?"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(officeOfExit), Clearance -> List(officeOfExitCL))

  val place = 0
  val code = 1

  // ex: fillPage("Folkestone", "GB000041")

  override def fillPage(values: String*): Unit = {
    fillDropdown("officeId", values(place))
    store(OfficeOfExit -> Detail(values(code)))
  }
}
