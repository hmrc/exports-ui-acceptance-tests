/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object SupplementaryUnitsPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/supplementary-units"
  val supplementaryUnitsPageTitle = "Do you need to add supplementary units?"
  var supplementaryUnitsDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    SupplementaryUnitsPage.onPage(supplementaryUnitsPageTitle)
  }

  def selectDoYouNeedToAddSupplementaryUnitsOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "Yes").click()
                    findElement("id", "supplementaryUnits").sendKeys("10")
      case "No" =>  findElement("id", "No").click()
    }
    supplementaryUnitsDetailsMap += ("supplementaryDetails" -> selectOption)
    submit()
  }
}
