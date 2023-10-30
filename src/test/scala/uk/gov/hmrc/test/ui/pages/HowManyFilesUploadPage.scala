/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

object HowManyFilesUploadPage extends BasePage {

  val howManyFilesUploadPageTitle    =
    "How many files do you need to upload? - CDS document uploads and secure messages - GOV.UK"
  val numberOfFilesToUpload          = "value"
  val welshHowManyFilesUploadTitle   =
    "Sawl ffeil y mae angen i chi ei huwchlwytho? - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"
  val fileToUploadEmptyDataWarning   = "Enter a number of files to upload"
  val fileToUploadInvalidDataWarning = "Enter a number between 1 and 10"

  def enterHowManyFilesToUpload(count: Int): UploadFilesPage.type = {
    onPage(howManyFilesUploadPageTitle)
    findElement("id", numberOfFilesToUpload).clear()
    findElement("id", numberOfFilesToUpload).sendKeys(count.toString)
    submit()
    UploadFilesPage
  }

  def clearHowManyFilesToUpload(): Unit =
    findElement("id", numberOfFilesToUpload).clear()
}
