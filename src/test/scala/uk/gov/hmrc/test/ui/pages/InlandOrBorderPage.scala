/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object InlandOrBorderPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/inland-or-border"
  val inlandOrBorderPageTitle = "Where are you presenting your goods to customs?"
  var inlandOrBorderDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    InlandOrBorderPage.onPage(inlandOrBorderPageTitle)
  }

  def selectInlandOrBorderOption(selectOption: String): Unit = {
    selectOption match {
      case "Border" => findElement("id", "Border").click()
      case "Inland" => findElement("id", "Inland").click()
    }
    inlandOrBorderDetailsMap += ("InlandOrBoderDetails" -> selectOption)
    submit()
  }
}
