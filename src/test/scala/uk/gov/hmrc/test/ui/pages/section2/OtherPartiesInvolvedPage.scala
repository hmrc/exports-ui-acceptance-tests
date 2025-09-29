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

import uk.gov.hmrc.test.ui.pages.base.Constants.{none, sequenceId}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{
  AdditionalPartiesInvolvedEORI,
  AdditionalPartiesInvolvedType,
  NoAdditionalPartiesInvolved
}

object OtherPartiesInvolvedPage extends BasePage {

  def backButtonHref: String = ConsigneeDetailsPage.path

  val path: String = "/declaration/other-parties-involved"

  override def changeLink: String =
    maybeDetail(NoAdditionalPartiesInvolved).fold(OtherPartiesInvolvedListPage.path)(_ => path)

  val title: String = "What are the EORI numbers of others involved in this export?"

  override def checkExpanders(): Unit = ()

  val choice = 1
  val EORI = 2

  // ex: fillPage(Constants.none)

  // The 1st parameter is the sequenceId of the current "Other Party" element: "0", "1", "2", ...
  // ex: fillPage({sequenceId}, "Consolidator", "GB121212121212")

  override def fillPage(values: String*): Unit =
    if (values.head == none) {
      store(NoAdditionalPartiesInvolved -> Detail(none))
      clickById("no")
    } else {
      val id = values(choice) match {
        case "Consolidator"                 => "CS"
        case "Manufacturer"                 => "MF"
        case "Additional freight forwarder" => "FW"
        case "Warehouse keeper"             => "WH"
      }
      clickById(id)
      fillTextBoxById(s"eori$id", values(EORI))
      store(
        AdditionalPartiesInvolvedType(values(sequenceId)) -> Detail(values(choice)),
        AdditionalPartiesInvolvedEORI(values(sequenceId)) -> Detail(values(EORI))
      )
    }
}
