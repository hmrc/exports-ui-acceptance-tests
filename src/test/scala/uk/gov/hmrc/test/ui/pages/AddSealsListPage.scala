/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddSealsListPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/containers/([^/]+)/seals"
  val addSealsListPageTitle = "You have added"
  var addSealsListDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AddSealsListPage.onPage(addSealsListPageTitle)
  }

  def selectDoYouWantToAddAnotherSealOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    declarationDetailsMap += ("sealsListDetails" -> selectOption)
    submit()
  }
}
