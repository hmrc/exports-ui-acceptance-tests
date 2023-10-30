/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object DoYouKnowTheCarrierEORINumberPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/are-you-the-exporter"
  val areYouTheExporterPageTitle =
    "Do you know the EORI number of your carrier or haulier?"
  var doYouKnowTheCarrierEORIDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AreYouTheExporterPage.onPage(areYouTheExporterPageTitle)
  }

  def selectAreYouAnExporterOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "Yes").click()
                    findElement("id", "eori").sendKeys("GB121212121212")
      case "No" => findElement("id", "No").click()
    }
    doYouKnowTheCarrierEORIDetailsMap += ("DoYouKnowTheCarrierEORI" -> selectOption)
    submit()
  }
}
