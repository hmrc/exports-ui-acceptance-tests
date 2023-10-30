/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object SealsPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/containers/([^/]+)/seals"
  val sealsPageTitle = "Does container"
  var sealsPageTitleDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    ContainerPage.onPage(sealsPageTitle)
  }

  def selectDoesTheContainerHaveAnySecuritySealsOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    sealsPageTitleDetailsMap += ("securitySealsDetails" -> selectOption)
    submit()
  }
}
