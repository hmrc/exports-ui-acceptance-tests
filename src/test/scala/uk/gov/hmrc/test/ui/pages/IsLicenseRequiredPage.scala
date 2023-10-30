/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object IsLicenseRequiredPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/is-licence-required"
  val isLicenseRequiredPageTitle = "Do these goods require a licence?"
  var iisLicenseRequiredDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    IsLicenseRequiredPage.onPage(isLicenseRequiredPageTitle)
  }

  def selectDoTheseGoodsRequireLicenseOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    iisLicenseRequiredDetailsMap += ("isLicenseRequired" -> selectOption)
    submit()
  }
}
