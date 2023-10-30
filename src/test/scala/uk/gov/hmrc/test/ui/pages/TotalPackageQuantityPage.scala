/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object TotalPackageQuantityPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/total-package-quantity"
  val totalPackageQuantityPageTitle = "What is the total number of packages in this declaration?"
  var totalPackageQuantityDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AreYouTheExporterPage.onPage(totalPackageQuantityPageTitle)
  }

  def enterTotalPackageQuantity(totalPackageQty: String): Unit = {
      val totalPackageQuantity : WebElement = findElement("id","totalPackage")
        totalPackageQuantity.sendKeys(totalPackageQty)
      totalPackageQuantityDetailsMap += ("TotalPackageQuantityDetails" -> totalPackageQuantity.getText)
    submit()
  }
}
