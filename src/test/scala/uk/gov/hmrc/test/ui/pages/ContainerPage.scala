/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object ContainerPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/container"
  val containerPageTitle = "Are the goods in a container or containers?"
  var containerPageDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    ContainerPage.onPage(containerPageTitle)
  }

  def selectAreTheGoodsInAContainerOrContainersOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
                    findElement("id","id").sendKeys("Container1")
      case "No" => findElement("id", "code_no").click()
    }
    containerPageDetailsMap += ("containerDetails" -> selectOption)
    submit()
  }
}
