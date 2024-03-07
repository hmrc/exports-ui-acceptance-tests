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

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{ExpressConsignmentId, ExpressConsignmentValue, cache}

object ExpressConsignmentPage extends BasePage {

  val path: String                   = "/declaration/express-consignment"
  def title                         = "Is this an express consignment?"
  val backButtonHrefs: List[String] = List.empty
  override val expanderHrefs: List[String] = List(
    "group-1-message-information-including-procedure-codes#de-17-specific-circumstance-indicator"
  )

  override def checkBackButton(): Unit = {}

  def performActionsAndCache(selectOption: String*): Unit = {
    selectOption match {
      case "Yes" => clickById("code_yes")
      case "No"  => clickById("code_no")
    }
    cache += (ExpressConsignmentId -> "Express consignment", ExpressConsignmentValue -> selectOption)
  }
}
