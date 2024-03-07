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

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.DeclarationDetails._

object WarehousePage extends BasePage {

  val path: String                   = "/declaration/warehouse-details"
  def title: String                 = "What is the customs approved warehouse number?"
  val backButtonHrefs: List[String] = List.empty
  override val expanderHrefs        = List(
    "group-2-references-of-messages-document-certificates-and-authorisations#de-27-identification-of-warehouse-box-49-warehouse-id"
  )

  def performActionsAndCache(wareHouseRefs: String*): Unit =
    wareHouseRefs.headOption.foreach { wareHouseRef =>
      fillTextBoxById("identificationNumber", wareHouseRef)
      cache += (WareHouseId -> "Warehouse ID", WareHouseValue -> wareHouseRef)
    }
}
