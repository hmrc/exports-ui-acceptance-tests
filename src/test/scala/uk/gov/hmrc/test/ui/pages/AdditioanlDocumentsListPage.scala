/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AdditioanlDocumentsListPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/additional-documentation-list"
  val additioanlDocumentsListPageTitle = "You’ve added details for"
  var additioanlDocumentsListDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AdditioanlDocumentsListPage.onPage(additioanlDocumentsListPageTitle)
  }

  def selectDoYouNeedToAddAnotherDocumentOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    declarationDetailsMap += ("AdditionalDocumentList" -> selectOption)
    submit()
  }
}
