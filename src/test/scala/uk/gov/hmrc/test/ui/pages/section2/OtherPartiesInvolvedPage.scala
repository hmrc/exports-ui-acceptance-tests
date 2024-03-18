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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, none}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.otherPartiesInvolved
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{AdditionalPartiesInvolved, AdditionalPartiesInvolvedEORI, AdditionalPartiesInvolvedType}

object OtherPartiesInvolvedPage extends BasePage {

  val path: String = "/declaration/other-parties-involved"
  val title: String = "What are the EORI numbers of others involved in this export?"
  def backButtonHref: String = ConsigneeDetailsPage.path

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(otherPartiesInvolved), Clearance -> List(otherPartiesInvolved))

  // the method can be called like follows
  // fillPage("{sequenceId}", "None")
  // fillPage("{sequenceId}", "Consolidator", "GB...")

  val choice = 1
  val EORI = 2

  val map: Map[String, String] = Map(
    "None" -> "no",
    "Consolidator" -> "CS",
    "Manufacturer" -> "MF",
    "Freight forwarder" -> "FW",
    "Warehouse keeper" -> "WH"
  )

  override def fillPage(values: String*): Unit = {
    val id = map(values(choice))
    clickById(id)

    id match {
      case "no" =>
        val otherParties = maybeDetails(AdditionalPartiesInvolvedType(values(sequenceId)))
        if (otherParties.isEmpty) store(AdditionalPartiesInvolved -> Detail(none))

      case _ =>
        fillTextBoxById(s"eori$id", values(EORI))
        store(
          AdditionalPartiesInvolvedType(values(sequenceId)) -> Detail(values(choice)),
          AdditionalPartiesInvolvedEORI(values(sequenceId)) -> Detail(values(EORI))
        )
    }
  }
}