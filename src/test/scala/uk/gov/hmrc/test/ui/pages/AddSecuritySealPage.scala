/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddSecuritySealPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/containers/([^/]+)/add-seal"
  val addSecuritySealPageTitle = "What is the security seal for container"
  var addSecuritySealDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AddSecuritySealPage.onPage(addSecuritySealPageTitle)
  }

  def addSecuritySealInformation(): Unit = {
      val securitySealName : WebElement = findElement("id", "id")
          securitySealName.sendKeys("Seal1")
    declarationDetailsMap += ("securitySealsOption" -> securitySealName.getText)
    submit()
  }
}
