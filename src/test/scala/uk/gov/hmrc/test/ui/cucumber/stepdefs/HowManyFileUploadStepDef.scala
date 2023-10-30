/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.HowManyFilesUploadPage

class HowManyFileUploadStepDef extends BaseStepDef {

  Given("""^I enters (.*) file to upload$""") { (fileCount: Int) =>
    HowManyFilesUploadPage.enterHowManyFilesToUpload(fileCount)
  }

  When("""^I fill number of files to upload page with invalid data$""") { () =>
    HowManyFilesUploadPage.enterHowManyFilesToUpload(20)
  }

  And("""^I submit the files to upload page with empty data$""") { () =>
    HowManyFilesUploadPage.clearHowManyFilesToUpload()
    HowManyFilesUploadPage.submit()
  }
}
