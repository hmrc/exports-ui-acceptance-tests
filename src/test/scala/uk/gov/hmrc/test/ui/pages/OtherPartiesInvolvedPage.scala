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
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object OtherPartiesInvolvedPage extends BasePage {

  val path: String                                         = "/declaration/other-parties-involved"
  val title                       =
    "What are the EORI numbers of others involved in this export?"


  def checkPageTitle(): Unit =
    OtherPartiesInvolvedPage.checkUrlAndTitle(otherPartiesInvolvedPageTitle)

  def selectAreYouAnExporterOption(selectOption: String): Unit = {
    selectOption match {
      case "Consolidator"                  => findElementById("CS").click()
      case "Manufacturer"                  => findElementById("MF").click()
      case "Additional_freight_forwarder"  => findElementById("FW").click()
      case "Warehouse_keeper"              => findElementById("WF").click()
      case "No_other_parties_are_involved" => findElementById("no").click()
    }
store += ("OtherPartiesInvolved" -> selectOption)
    submit()
  }
}
