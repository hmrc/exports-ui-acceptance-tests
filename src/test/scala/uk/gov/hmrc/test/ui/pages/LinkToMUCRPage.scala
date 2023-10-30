/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object LinkToMUCRPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/link-to-mucr"
  val homePageTitle = "Do you want to link this declaration’s DUCR to a MUCR?"
  var linkToMUCRDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    LinkToMUCRPage.onPage(homePageTitle)
  }

  def selectDoYouHaveADucr(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    linkToMUCRDetailsMap += ("LinkToMucrDetails" -> selectOption)
    submit()
  }

}
