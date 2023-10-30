/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object PreviousDocumentsListPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/previous-documents-list"
  val previousDocumentsListPageTitle = "What documents are you using to make this declaration?"
  var previousDocumentsListDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AreYouTheExporterPage.onPage(previousDocumentsListPageTitle)
  }

  def selectDoYouNeedToAddAnotherDocumentOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    previousDocumentsListDetailsMap += ("AreYouAnExporter" -> selectOption)
    submit()
  }
}
