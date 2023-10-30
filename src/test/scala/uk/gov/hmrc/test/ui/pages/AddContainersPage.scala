/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddContainersPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/containers"
  val addContainersPageTitle = "You have added"
  var addContainersDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    ContainerPage.onPage(addContainersPageTitle)
  }

  def selectDoYouWantToAddAnotherContainerOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    declarationDetailsMap += ("addContainersDetails" -> selectOption)
    submit()
  }
}
