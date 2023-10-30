/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object ExpressConsignmentPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/express-consignment"
  val expressConsignmentPageTitle = "Is this an express consignment?"
  var expressConsignmentrDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AreYouTheExporterPage.onPage(expressConsignmentPageTitle)
  }

  def selectIsThisExpressConsignmentOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    expressConsignmentrDetailsMap += ("IsThisExpressConsignmentDetails" -> selectOption)
    submit()
  }
}
