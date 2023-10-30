/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.generator.SupportGenerator.{generateAlphaNumeric, generateDigits}

object ContactDetailsPage extends BasePage {

  val contactDetailsPageTitle          = "Your contact details - CDS document uploads and secure messages - GOV.UK"
  val welshContactDetailsTitle         = "Eich manylion cyswllt - Dogfennau CDS wedi’u huwchlwytho a negeseuon diogel - GOV.UK"
  val fullName                         = "name"
  val companyName                      = "companyName"
  val phoneNumber                      = "phoneNumber"
  val fullNameWarningMessage           = "Enter a name"
  val companyNameWarningMessage        = "Enter a company name"
  val phoneNumberWarningMessage        = "Enter a telephone number"
  val invalidPhoneNumberWarningMessage = "Telephone number must contain only numbers"
  val longerPhoneNumberWarningMessage  = "Number must contain 15 digits or fewer"

  def mrn(): WebElement = findElement("className", "govuk-caption-l")

  def nameSelector(): WebElement = findElement("id", "name")

  def companyNameSelector(): WebElement = findElement("id", "companyName")

  def phoneNumberSelector(): WebElement = findElement("id", "phoneNumber")

  // elements actions
  def typeName(nameValue: String): Unit = {

    nameSelector().clear()
    nameSelector().sendKeys(nameValue)
  }

  def typeCompanyName(companyNameValue: String): Unit = {

    companyNameSelector().clear()
    companyNameSelector().sendKeys(companyNameValue)
  }

  def typePhoneNumber(phoneNumberValue: String): Unit = {

    phoneNumberSelector().clear()
    phoneNumberSelector().sendKeys(phoneNumberValue)
  }

  def enterAddress(): HowManyFilesUploadPage.type = {
    onPage(contactDetailsPageTitle)
    typeName(generateAlphaNumeric(1, 10))
    typeCompanyName(generateAlphaNumeric(1, 10))
    typePhoneNumber(generateDigits(1, 10))
    submit()
    HowManyFilesUploadPage
  }

  def clearContactDetails(): Unit = {
    nameSelector().clear()
    companyNameSelector().clear()
    phoneNumberSelector().clear()
  }

  def enterPhoneNumber(number: String): Unit = {
    typePhoneNumber(number)
    submit()
  }
}
