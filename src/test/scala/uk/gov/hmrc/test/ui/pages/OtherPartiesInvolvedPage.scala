/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object OtherPartiesInvolvedPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/other-parties-involved"
  val otherPartiesInvolvedPageTitle =
    "What are the EORI numbers of others involved in this export?"
  var otherPartiesInvolvedDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    OtherPartiesInvolvedPage.onPage(otherPartiesInvolvedPageTitle)
  }

  def selectAreYouAnExporterOption(selectOption: String): Unit = {
    selectOption match {
      case "Consolidator"                 => findElement("id", "CS").click()
      case "Manufacturer"                 => findElement("id", "MF").click()
      case "Additional_freight_forwarder" => findElement("id", "FW").click()
      case "Warehouse_keeper"             => findElement("id", "WF").click()
      case "No_other_parties_are_involved"=> findElement("id", "no").click()
    }
    otherPartiesInvolvedDetailsMap += ("OtherPartiesInvolved" -> selectOption)
    submit()
  }
}
