/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AreYouTheExporterPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/are-you-the-exporter"
  val areYouTheExporterPageTitle =
    "Are you the exporter? - Section 2 of 6: Parties involved - Make an export declaration online - GOV.UK"
  var areYouAnExporterDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AreYouTheExporterPage.onPage(areYouTheExporterPageTitle)
  }

  def selectAreYouAnExporterOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    declarationDetailsMap += ("AreYouAnExporter" -> selectOption)
    submit()
  }
}
