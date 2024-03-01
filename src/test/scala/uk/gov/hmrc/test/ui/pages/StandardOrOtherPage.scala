/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object StandardOrOtherPage extends BasePage {

  val url: String                = TestConfiguration.url("exports-frontend") + "/choice"
  val homePageTitle              = "Make and manage export declarations - Make an export declaration online - GOV.UK"


  def checkTitle():Unit = {
    ExportsHomePage.onPage(homePageTitle)
  }



  def selectOptionToProgressWith(selectOption: String): Unit = {
    selectOption match {
      case "StandardDeclaration" => findElement("id", "").click()
      case "OtherDeclaration" => findElement("id", "").click()
    }
  }

  def selectOptionToMakeAndManageDeclaration(selectOption: String): Unit = {
    selectOption match {
      case "CreateDeclaration"   => findElement("id", createDeclaration ).click()
      case "ManageDraftDeclaration" => findElement("id", manageDraftDeclaration).click()
      case "ManageSubmitDeclaration" => findElement("id", manageSubmitDeclaration).click()
    }
  }

}
