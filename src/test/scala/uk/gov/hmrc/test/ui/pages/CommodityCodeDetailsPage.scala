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

object CommodityCodeDetailsPage extends BasePage {

  val path: String                                         = "/declaration/items/([^/]+)/commodity-details"
  val commodityCodeDetailsPage                            = "Commodity code and item details"

  val superKey: Keys                                      = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit =
    CommodityCodeDetailsPage.checkUrlAndTitle(commodityCodeDetailsPage)

  def enterCommodityCodeDetails(): Unit = {
    val commodityCodeReference: WebElement   = findElementById("combinedNomenclatureCode")
    commodityCodeReference.sendKeys("4203400090")
    val commodityCodeDescription: WebElement = findElementById("descriptionOfGoods")
    commodityCodeDescription.sendKeys("Test Plastic")

cache += ("CommodityCode"            -> commodityCodeReference.getText)
cache += ("CommodityCodeDescription" -> commodityCodeDescription.getText)
    submit()
  }
}
