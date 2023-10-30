/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.generator.FileListGenerator

import scala.util.control.Breaks.{break, breakable}

object UploadFilesPage extends BasePage {
  val uploadFileTitle      = "Upload your first file - CDS document uploads and secure messages - GOV.UK"
  val welshUploadFileTitle =
    "Uwchlwythwch eich ffeil gyntaf - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"
  val cancelUpload         = "cancel-link"
  val fileUploadLocator    = "file-upload-component"
  val uploadAndContinue    = "submit"

  private val userDir: String = System.getProperty("user.dir")
  val filePath: String        = userDir + "/src/test/scala/uk/gov/hmrc/test/ui/cucumber/datafiles/"
  val fileGenerator           = new FileListGenerator();

  def filePicker(): WebElement = findElement("id", fileUploadLocator)

  def pressCancelLink(): Unit = findElement("id", cancelUpload).click()

  def uploadButton(): Unit = findElement("xpath", "//*[@name='submit']").click()

  def uploadButtonDisabled(): WebElement =
    findElement("xpath", "//button[@disabled]")

  def errorValidation(): WebElement =
    findElement("cssSelector", "#file-upload-component-error span:last-child")

  def errorSummaryAtTopOfPage(): WebElement =
    findElement("cssSelector", ".govuk-error-summary__body a")

  def uploadFiles(fileType: String): Unit = {

    onPage(uploadFileTitle)

    fileType match {
      case "with four files"                                 => uploadFiles(fileGenerator.fourFiles(), 4, true)
      case "with file greater than 10 MB"                    =>
        uploadFiles(fileGenerator.errorMessageOneFileTest("11mb-file.pdf"), 1, false)
      case "with invalid file extension"                     =>
        uploadFiles(fileGenerator.errorMessageOneFileTest("invalidFileExtension.html"), 1, false)
      case "with invalid file name"                          =>
        uploadFiles(fileGenerator.errorMessageOneFileTest("+invalidFileName.html"), 1, false)
      case "with four files and cancel upload after 2 files" => uploadFiles(fileGenerator.fourFiles(), 2, false)
      case _                                                 => uploadFiles(fileGenerator.oneFile(), 1, true)
    }
  }

  def uploadFile(fileName: String): Unit = {
    filePicker().clear()
    filePicker().sendKeys(fileName)
  }

  def uploadFiles(fileList: List[String], cancelAfter: Int, submitFiles: Boolean = true): Unit =
    breakable {
      for (i <- fileList.indices)
        if (i == cancelAfter) {
          pressCancelLink()
          break()
        } else {
          uploadFile(filePath + fileList(i))
          if (submitFiles) {
            uploadButton()
          }
        }
    }

  def errorMessageOneFileTest(filename: String): List[String] = Seq(s"$filename").toList
}
