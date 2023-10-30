/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AuthorisationChoicePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/authorisation-choice"
  val authorisationChoicePageTitle = "Which export procedure are you using?"
  var authorisationChoiceDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AuthorisationChoicePage.onPage(authorisationChoicePageTitle)
  }

  def selectAuthorisationChoiceOption(selectOption: String): Unit = {
    selectOption match {
      case "Permanent_export_of_UK_goods" => findElement("id", "Code1040").click()
      case "Permanent_export_of_excise_goods " => findElement("id", "Code1007").click()
      case "Temporary_exports" => findElement("id", "CodeOther").click()
    }
    declarationDetailsMap += ("AuthorisationChoice" -> selectOption)
    submit()
  }
}
