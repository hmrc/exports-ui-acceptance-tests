/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object AddDeclarationItemPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/add-declaration-item"
  val addDeclarationItemPageTitle = "Add declaration item"

  def checkPageTitle(): Unit = {
    AreYouTheExporterPage.onPage(addDeclarationItemPageTitle)
  }

  def clickToAddItem(): Unit = {
   findElement("id","add").click()
  }
}
