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

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object CommodityMeasurePage extends BasePage {

  val path: String                                     = "/declaration/items/([^/]+)/commodity-measure"
  val title                       = "What is the weight of the goods?"

  val superKey: Keys                                  = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit =
    CommodityMeasurePage.checkUrlAndTitle(commodityMeasurePageTitle)

  def enterGoodsWeightDetails(): Unit = {
    val grossWeight: WebElement = findElementById("grossMass")
    grossWeight.sendKeys("1000")
    val netWeight: WebElement   = findElementById("netMass")
    netWeight.sendKeys("1000")

store += ("grossWeight" -> grossWeight.getText)
store += ("netWeight"   -> netWeight.getText)
    submit()
  }
}
