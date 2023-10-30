/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object PackageInformationPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/package-information"
  val packageInformationPageTitle = "Enter the packing details for this item"
  var packageInformationMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    PackageInformationPage.onPage(packageInformationPageTitle)
  }

  def typePackageDetailsCode(packageType: String): String = {
    findElement("id", "typesOfPackages").clear()
    findElement("id", "typesOfPackages").sendKeys(Keys.chord(superKey, "a"))
    val enteredCurrencyCode: WebElement = findElement("id", "typesOfPackages")
    enteredCurrencyCode.sendKeys(packageType)
    findElement("id", "typesOfPackages").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    enteredCurrencyCode.getText
  }

  def enterPackageDetails(): Unit = {

    val enteredPackageType = typePackageDetailsCode("AE")
    val numberOfPackages: WebElement = findElement("id", "numberOfPackages")
    numberOfPackages.sendKeys("10")
    val shippingMarks: WebElement = findElement("id", "shippingMarks")
    shippingMarks.sendKeys("Test Shipping")

    packageInformationMap += ("packageInformationDetails" -> enteredPackageType)
    packageInformationMap += ("numberOfPackagesDetails" -> numberOfPackages.getText)
    packageInformationMap += ("shippingMarksDetails" -> shippingMarks.getText)
    submit()
  }
}
