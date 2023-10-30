/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object IsAdditionalInformationReqiuredPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/additional-taric-code"
  val isAdditionalInformationReqiuredPageTitle = "Do you need to make any Additional Information statements?"
  var isAdditionalInformationReqiuredDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    IsAdditionalInformationReqiuredPage.onPage(isAdditionalInformationReqiuredPageTitle)
  }

  def selectDoYouNeedToProvideAdditionalInformationStatementsOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    isAdditionalInformationReqiuredDetailsMap += ("additionalInformationStatements" -> selectOption)
    submit()
  }
}
