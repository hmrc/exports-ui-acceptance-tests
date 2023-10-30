/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object DoYouHaveDUCRPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/declarant-details"
  val homePageTitle = "Do you have a Declaration Unique Consignment Reference Number (DUCR)? - Section 1 of 6: Declaration details - Make an export declaration online - GOV.UK"


  def checkPageTitle(): Unit = {
    DoYouHaveDUCRPage.onPage(homePageTitle)
  }

  def selectDoYouHaveADucr(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    submit()
  }

}
