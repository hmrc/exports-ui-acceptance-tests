/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants}
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{traderReference, traderReferenceCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Ducr

object ConfirmDucrPage extends BasePage {

  def backButtonHref: String = TraderReferencePage.path

  val path: String = "/declaration/confirm-ducr"

  val title: String = "Do you want to use this DUCR?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(traderReference),
    Clearance -> Seq(traderReferenceCL)
  )

   def fillPage(values: String*): Unit = {
    val yesNo = values.head
    selectYesOrNoRadio(yesNo)
    yesNo match {
      case Constants.yes => ()
      case Constants.no => clear(Ducr)
    }
  }
}
