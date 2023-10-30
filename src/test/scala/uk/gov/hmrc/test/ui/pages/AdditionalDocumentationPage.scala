/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AdditionalDocumentationPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/additional-documentation"
  val additionalDocumentationPage = "Enter licence details, authorisation numbers and any other document details"
  var additionalDocumentationPageDetails: Map[String, String]= HashMap[String, String]()

  def checkPageTitle(): Unit =
    AdditionalDocumentationPage.onPage(additionalDocumentationPage)


  def enterLicenceDocumentDetails(): Unit = {

    val documentCode: WebElement = findElement("id", "documentTypeCode")
    documentCode.sendKeys("C501")

    val documentIdentifier: WebElement = findElement("id", "documentIdentifier")
    documentIdentifier.sendKeys("GBAEOC717572504502801")

    declarationDetailsMap += ("documentCode"       -> documentCode.getText)
    declarationDetailsMap += ("documentIdentifier"     -> documentIdentifier.getText)

    submit()
  }
}
