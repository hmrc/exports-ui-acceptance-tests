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

object CommodityCodeDetailsPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/commodity-details"
  val commodityCodeDetailsPage = "Commodity code and item details"
  var commodityCodeDetailsDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    CommodityCodeDetailsPage.pageTitle(commodityCodeDetailsPage)
  }


  def enterCommodityCodeDetails(): Unit = {
    val commodityCodeReference : WebElement = findElement("id","combinedNomenclatureCode")
    commodityCodeReference.sendKeys("4203400090")
    val commodityCodeDescription: WebElement = findElement("id", "descriptionOfGoods")
    commodityCodeDescription.sendKeys("Test Plastic")

    commodityCodeDetailsDetailsMap+=("CommodityCode" -> commodityCodeReference.getText)
    commodityCodeDetailsDetailsMap+=("CommodityCodeDescription" -> commodityCodeDescription.getText)
    submit()
  }
}
