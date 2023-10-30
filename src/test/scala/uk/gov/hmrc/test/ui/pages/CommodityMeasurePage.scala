/*
 * Copyright 2023 HM Revenue & Customs
 *
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
