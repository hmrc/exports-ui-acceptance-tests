/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object IsAuthorisationRequiredPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/is-authorisation-required"
  val isAuthorisationRequiredPageTitle = "Do you want to add any authorisations? - Section 2 of 6: Parties involved - Make an export declaration online - GOV.UK"
  var isAuthorisationRequiredDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    driver.getCurrentUrl should be (url)
    IsAuthorisationRequiredPage.onPage(isAuthorisationRequiredPageTitle)
  }

  def selectIsAuthorisationRequiredOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    isAuthorisationRequiredDetailsMap += ("IsAuthorisationRequired" -> selectOption)
    submit()
  }
}
