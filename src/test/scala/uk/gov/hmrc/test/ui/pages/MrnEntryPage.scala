/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

object MrnEntryPage extends BasePage {

  val mrnEntryPageTitle         =
    "What is the MRN of the declaration you want to attach files to? - CDS document uploads and secure messages - GOV.UK"
  val mrnTextField              = "value"
  val welshMrnTitle             =
    "Beth yw MRN y datganiad yr hoffech atodi ffeiliau iddo? - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"
  val mrnWarningEmptyData       = "Enter a movement reference number (MRN)"
  val mrnWarningWithInvalidData = "Movement reference number (MRN) must be in the correct format"

  def validateMrn(): Unit =
    onPage(mrnEntryPageTitle)

  def clearMRN(): Unit = findElement("id", "value").clear()

  def enterMRN(mrn: String): ContactDetailsPage.type = {
    onPage(mrnEntryPageTitle)
    findElement("id", "value").clear()
    findElement("id", "value").sendKeys(mrn)
    submit()
    ContactDetailsPage
  }
}
