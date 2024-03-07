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

object DoYouKnowTheCarrierEORINumberPage extends BasePage {

  val path: String                                            = "/are-you-the-exporter"
  val title                             =
    "Do you know the EORI number of your carrier or haulier?"


  def checkPageTitle(): Unit =
    AreYouTheExporterPage.checkUrlAndTitle(areYouTheExporterPageTitle)

  def selectAreYouAnExporterOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" =>
        findElementById("Yes").click()
        findElementById("eori").sendKeys("GB121212121212")
      case "No"  => findElementById("No").click()
    }
cache += ("DoYouKnowTheCarrierEORI" -> selectOption)
    submit()
  }
}
