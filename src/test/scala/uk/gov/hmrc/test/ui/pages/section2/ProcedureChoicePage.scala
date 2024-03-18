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

package uk.gov.hmrc.test.ui.pages.section2

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.PageLinks._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.ProcedureChoice

object ProcedureChoicePage extends BasePage {

  val path: String = "/declaration/authorisation-choice"
  val title: String = "Which export procedure are you using?"
  def backButtonHref: String = OtherPartiesInvolvedPage.path

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(
      Common -> List(
        endUseRelief,
        outwardProcessing,
        onwardSupplyRelief,
        reExportFollowingSpecialProcedure,
        temporaryExport,
        removalOfGoodsFromExciseWarehouse,
        inwardProcessing
      )
    )

  val exportProcedure = 0

  override def fillPage(values: String*): Unit = {
    values(exportProcedure) match {
      case "Permanent"             => clickById("Code1040")
      case "Permanent with excise" => clickById("Code1007")
      case "Temporary"             => clickById("CodeOther")
    }

    store(ProcedureChoice -> Detail(values(exportProcedure)))
  }
}