/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object CountryOfRoutingPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/country-of-routing"
  val countryOfRoutingPageTitle = "Will the goods pass through any other countries before arriving in"
  var countryOfRoutingDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    CountryOfRoutingPage.onPage(countryOfRoutingPageTitle)
  }

  def selectCountryOfRoutingOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "Yes").click()
      case "No" => findElement("id", "No").click()
    }
    countryOfRoutingDetailsMap += ("CountryOfRouting" -> selectOption)
    submit()
  }
}
