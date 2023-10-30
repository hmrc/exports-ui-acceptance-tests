/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object DeclarationItemsListPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/additional-documentation-list"
  val declarationItemsListPageTitle = "You have added"
  var declarationItemsListPageDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    DeclarationItemsListPage.onPage(declarationItemsListPageTitle)
  }

  def selectDoYouNeedToAddAnotherItemOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    declarationItemsListPageDetailsMap += ("AddAnotherItemOption" -> selectOption)
    submit()
  }
}
