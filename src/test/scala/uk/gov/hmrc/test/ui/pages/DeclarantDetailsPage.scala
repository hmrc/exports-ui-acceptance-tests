/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object DeclarantDetailsPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/declarant-details"
  val homePageTitle = "Is your EORI number"
  var declarantDetailsMap: Map[String, String] = HashMap[String, String]()


  def checkPageTitle(): Unit = {
    DeclarantDetailsPage.onPage(homePageTitle)
  }

  def selectOptionForISYourEori(selectOption: String): Unit = {
    selectOption match {
      case "Yes" =>  findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    // Add elements to the HashMap
    declarantDetailsMap += ("DeclarantDetails" -> selectOption)
    submit()
  }

}
