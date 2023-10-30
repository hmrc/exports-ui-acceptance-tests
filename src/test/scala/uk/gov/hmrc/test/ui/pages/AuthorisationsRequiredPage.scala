/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AuthorisationsRequiredPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/authorisations-required"
  val authorisationsRequiredPageTitle = "You have added"
  var authorisationsRequiredDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AuthorisationsRequiredPage.onPage(authorisationsRequiredPageTitle)
  }

  def selectDoYouNeedToAddAnotherAuthorisation(addAnotherAuhorisationOption: String): Unit = {
    addAnotherAuhorisationOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    declarationDetailsMap += ("AddAnotherAuthorisation" -> addAnotherAuhorisationOption)
    submit()
  }
}
