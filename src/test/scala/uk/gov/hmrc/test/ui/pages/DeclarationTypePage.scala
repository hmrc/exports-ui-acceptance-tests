/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object DeclarationTypePage extends BasePage {

  val url: String                = TestConfiguration.url("exports-frontend") + "/declaration/type"
  val homePageTitle              = "Do you have to make an arrived export declaration? - Section 1 of 6: Declaration details - Make an export declaration online - GOV.UK"

  val arrivedDeclaration = "arrived"
  val prelodegedDeclaration = "prelodged"

  def checkPageTitle():Unit= {
    DeclarationTypePage.onPage(homePageTitle)
  }

  def selectDeclarationTypeOption(selectOption: String): Unit = {
    selectOption match {
      case "ArrivedDeclaration"   => findElement("id", "arrived" ).click()
      case "PreLodgedDeclaration" => findElement("id", "prelodged").click()
    }
    submit()
  }



}
