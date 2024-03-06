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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.DeclarationDetails._

object InlandModeOfTransportPage extends BasePage {

  val url: String                   = "/declaration/inland-transport-details"
  def title: String                 = "How will the goods be transported to the UK border?"
  val backButtonHrefs: List[String] = List.empty
  override val expanderHrefs        = List(
    "group-7-transport-information-modes-means-and-equipment#de-75-inland-mode-of-transport-box-26-inland-mode-of-transport"
  )

  override def checkBackButton(): Unit = {}

  def performActionsAndCache(selectOptions: String*): Unit = {
    val optionToIdMap: Map[String, String] = Map(
      "Road transport"                           -> "Inland_Road",
      "Rail transport"                           -> "Inland_Rail",
      "Sea transport"                            -> "Inland_Sea",
      "Air transport"                            -> "Inland_Air",
      "Postal or mail"                           -> "Inland_PostalOrMail",
      "Fixed transport installations"            -> "Inland_FixedTransportInstallations",
      "Inland waterway transport"                -> "Inland_InlandWaterway",
      "Mode unknown, for example own propulsion" -> "Inland_Unknown"
    )

    for (selectOption <- selectOptions)
      optionToIdMap.get(selectOption).foreach { id =>
        clickById(id)
        DeclarationDetails.cache += (InlandModeOfTransportId -> "Inland mode of transport", InlandModeOfTransportValue -> selectOption)
      }
  }
}
