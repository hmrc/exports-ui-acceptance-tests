/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddSecuritySealsOptionPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/containers/([^/]+)/seals"
  val addSecuritySealsOptionPageTitle = "Does container"
  var addSecuritySealsOptionDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AddSecuritySealsOptionPage.onPage(addSecuritySealsOptionPageTitle)
  }

  def selectDoesContainerHaveAnySecuritySealsOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    declarationDetailsMap += ("securitySealsOption" -> selectOption)
    submit()
  }
}
