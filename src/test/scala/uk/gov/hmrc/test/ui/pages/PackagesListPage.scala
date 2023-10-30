/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object PackagesListPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/packages-list"
  val packagesListPageTitle = "You have added"
  var packagesListPageDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    PackagesListPage.onPage(packagesListPageTitle)
  }

  def selectDoYouNeedToAddAnotherPackageTypeOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    packagesListPageDetailsMap += ("packagesListDetails" -> selectOption)
    submit()
  }
}
