/*
 * Copyright 2023 HM Revenue & Customs
 *
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
    CommodityCodeDetailsPage.onPage(commodityCodeDetailsPage)
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
