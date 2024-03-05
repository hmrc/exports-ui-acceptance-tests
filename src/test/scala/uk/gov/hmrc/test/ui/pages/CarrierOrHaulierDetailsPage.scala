/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{Keys, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object CarrierOrHaulierDetailsPage extends BasePage {

  val url: String                                                         = TestConfiguration.url("exports-frontend") + "/declaration/carrier-address"
  val carrierOrHaulierPageTitle                                           = "Carrier or haulier details"
  var registeredAddressEntry: Map[String, String]                         = HashMap[String, String]()
  var doYouKnowTheCarrierEORIDetailsMap: Map[String, Map[String, String]] = HashMap[String, Map[String, String]]()
  val superKey: Keys                                                      = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL
  def checkPageTitle(): Unit                                              =
    CarrierOrHaulierDetailsPage.pageTitle(carrierOrHaulierPageTitle)

  def typeCountry(): String = {
    findElement("id", "details_address_country").clear()
    findElement("id", "details_address_country").sendKeys(Keys.chord(superKey, "a"),Keys.BACK_SPACE)
    val country: WebElement = findElement("id", "details_address_country")
    country.sendKeys("AD")
    findElement("id", "details_address_country").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    country.getText
  }

  def enterDetailsForRegisteredBusiness(): Unit = {

    val fullName: WebElement    = findElement("id", "details_address_fullName")
    fullName.sendKeys("TEST Full Name")
    val addressLine: WebElement = findElement("id", "details_address_addressLine")
    addressLine.sendKeys("TEST Address Line 1")
    val town: WebElement        = findElement("id", "details_address_townOrCity")
    town.sendKeys("TEST Town")
    val postCode: WebElement    = findElement("id", "details_address_postCode")
    postCode.sendKeys("SL6 0FF")
    val countryEntered: String  = typeCountry()

    registeredAddressEntry += ("fullName"       -> fullName.getText)
    registeredAddressEntry += ("adressLine"     -> addressLine.getText)
    registeredAddressEntry += ("town"           -> town.getText)
    registeredAddressEntry += ("postCode"       -> postCode.getText)
    registeredAddressEntry += ("countryEntered" -> countryEntered)

    //declarationDetailsMap.put("registeredAddress" -> registeredAddressEntry)
    submit()
  }
}
