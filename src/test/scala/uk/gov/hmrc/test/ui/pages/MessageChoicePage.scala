/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By

object MessageChoicePage extends BasePage {

  val messageChoiceTitle          = "View messages - CDS document uploads and secure messages - GOV.UK"
  val welshMessageChoiceTitle     =
    "Bwrw golwg dros eich negeseuon - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"
  val exportMessageChoice         = "ExportMessages"
  val importMessageChoice         = "ImportMessages"
  val messageChoiceWarningMessage = "Select which messages you want to view"

  def selectMessageChoice(option: String): MessagesPage.type = {
    option match {
      case "ExportMessages" => driver.findElement(By.id(exportMessageChoice)).click()
      case "ImportMessages" => driver.findElement(By.id(importMessageChoice)).click()
    }
    submit()
    MessagesPage
  }
}
