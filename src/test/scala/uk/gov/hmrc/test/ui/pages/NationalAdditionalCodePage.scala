/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object NationalAdditionalCodePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/national-additional-code"
  val nationalAdditionalCodePageTitle = "Do you need to add a national additional code?"
  var nationalAdditionalCodeDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    NationalAdditionalCodePage.onPage(nationalAdditionalCodePageTitle)
  }

  def selectDoYouNeedANationalAdditionalCodeOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    nationalAdditionalCodeDetailsMap += ("NationalAdditionalCode" -> selectOption)
    submit()
  }
}
