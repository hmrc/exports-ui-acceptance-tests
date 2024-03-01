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

import scala.collection.immutable.HashMap

object CommodityMeasurePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/commodity-measure"
  val commodityMeasurePageTitle = "What is the weight of the goods?"
  var commodityMeasureDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    CommodityMeasurePage.onPage(commodityMeasurePageTitle)
  }

  def enterGoodsWeightDetails(): Unit = {
    val grossWeight: WebElement = findElement("id", "grossMass")
    grossWeight.sendKeys("1000")
    val netWeight: WebElement = findElement("id", "netMass")
    netWeight.sendKeys("1000")

    commodityMeasureDetailsMap += ("grossWeight" -> grossWeight.getText)
    commodityMeasureDetailsMap += ("netWeight" -> netWeight.getText)
    submit()
  }
}
