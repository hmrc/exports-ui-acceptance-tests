/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object StatisticalValuePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/statistical-value"
  val statisticalValuePageTitle = "The statistical value of this item in pounds"
  var statisticalValueDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AreYouTheExporterPage.onPage(statisticalValuePageTitle)
  }

  def enterStatisticalValue(): Unit = {

      val statisticalValue : WebElement = findElement("id", "statisticalValue")
          statisticalValue.sendKeys("1000")

    statisticalValueDetailsMap += ("statisticalValue" -> statisticalValue.getText)
    submit()
  }
}
