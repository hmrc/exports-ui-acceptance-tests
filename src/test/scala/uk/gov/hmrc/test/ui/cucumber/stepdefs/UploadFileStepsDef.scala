/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.pages.UploadFilesPage

class UploadFileStepsDef extends BaseStepDef {

  Given("""^Upload (.*) supplied above$""") { (fileCount: String) =>
    UploadFilesPage.uploadFiles(fileCount)
  }

  When("""I click on cancel upload link on file upload page$""") { () =>
    UploadFilesPage.pressCancelLink()
  }

  And("""^I submit upload file page (.*)$""") { (fileType: String) =>
    fileType match {
      case "without uploading a file" => UploadFilesPage.uploadButton()
      case _                          => UploadFilesPage.uploadFiles(fileType)
    }
  }

  Then("""^I validate error message displayed (.*)$""") { (fileType: String) =>
    fileType match {
      case "without uploading a file"     =>
        UploadFilesPage.errorSummaryAtTopOfPage().getText must be("Select a file")
        UploadFilesPage.errorValidation().getText         must be("Select a file")
      case "with file greater than 10 MB" =>
        UploadFilesPage.errorValidation().getText         must be("File size must not be bigger than 10 Megabytes (MB)")
        UploadFilesPage.errorSummaryAtTopOfPage().getText must be("File size must not be bigger than 10 Megabytes (MB)")
        UploadFilesPage.uploadButtonDisabled().isDisplayed
      case "with invalid file extension"  =>
        println("into the code")
        UploadFilesPage.errorValidation().getText         must be(
          "File must have an extension of .jpeg, .jpg, .png, .pdf, .txt"
        )
        UploadFilesPage.errorSummaryAtTopOfPage().getText must be(
          "File must have an extension of .jpeg, .jpg, .png, .pdf, .txt"
        )
        UploadFilesPage.uploadButtonDisabled()
      case "with invalid file name"       =>
        UploadFilesPage.errorValidation().getText         must be(
          "File name must start with a letter or number, and only contain hyphen, underscore or dot as special characters"
        )
        UploadFilesPage.errorSummaryAtTopOfPage().getText must be(
          "File name must start with a letter or number, and only contain hyphen, underscore or dot as special characters"
        )
        UploadFilesPage.uploadButtonDisabled()
    }
  }
}
