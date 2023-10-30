/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object ConsigneeDetailsPage extends BasePage {

  val url: String                                                  = TestConfiguration.url("exports-frontend") + "/declaration/consignee-details"
  val consigneeDetailsPageTitle                                    = "Where will the goods be delivered?"
  var goodsDeliveredAddressDetails: Map[String, String]            = HashMap[String, String]()
  var consigneeDetailsAddressMap: Map[String, Map[String, String]] = HashMap[String, Map[String, String]]()
  val superKey: Keys                                               = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit =
    CarrierOrHaulierDetailsPage.onPage(consigneeDetailsPageTitle)

  def typeCountry(): String = {
    findElement("id", "details_address_country").clear()
    findElement("id", "details_address_country").sendKeys(Keys.chord(superKey, "a"))
    val country: WebElement = findElement("id", "details_address_country")
    country.sendKeys("AD")
    findElement("id", "details_address_country").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    country.getText
  }

  def enterAddressDetailsToGetGoodsToBeDelivered(): Unit = {

    val fullName: WebElement = findElement("id", "details_address_fullName")
    fullName.sendKeys("TEST Full Name")

    val addressLine: WebElement = findElement("id", "details_address_addressLine")
    addressLine.sendKeys("TEST Address Line 1")

    val town: WebElement = findElement("id", "details_address_townOrCity")
    town.sendKeys("TEST Town")

    val postCode: WebElement = findElement("id", "details_address_postCode")
    postCode.sendKeys("SL6 0FF")

    val countryEntered: String = typeCountry()

    goodsDeliveredAddressDetails += ("fullName"       -> fullName.getText)
    goodsDeliveredAddressDetails += ("adressLine"     -> addressLine.getText)
    goodsDeliveredAddressDetails += ("town"           -> town.getText)
    goodsDeliveredAddressDetails += ("postCode"       -> postCode.getText)
    goodsDeliveredAddressDetails += ("countryEntered" -> countryEntered)

    consigneeDetailsAddressMap += ("registeredAddress" -> goodsDeliveredAddressDetails)
    submit()
  }
}
