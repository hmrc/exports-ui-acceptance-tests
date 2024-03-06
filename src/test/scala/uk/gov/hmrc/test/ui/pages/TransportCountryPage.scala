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
import uk.gov.hmrc.test.ui.pages.CarrierOrHaulierDetailsPage.superKey
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object TransportCountryPage extends BasePage {

  val path: String                                     = TestConfiguration.url("exports-frontend") + "/are-you-the-exporter"
  val transportCountryPageTitle                       = "Select the country where the sea transport is registered"
  var transportCountryDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    TransportCountryPage.checkUrlAndTitle(transportCountryPageTitle)

  def typeTransportCountryCode(currencyCode: String): String = {
    findElement("id", "transport-country").click()
    findElement("id", "transport-country").sendKeys(Keys.chord(superKey, "a"), Keys.BACK_SPACE)
    val enteredCurrencyCode: WebElement = findElement("id", "transport-country")
    enteredCurrencyCode.sendKeys(currencyCode)
    findElement("id", "transport-country").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    enteredCurrencyCode.getText
  }

  def selectDoYouKnowTheCountryWhereTheSeaTransportIsRegisteredOption(): Unit = {
    typeTransportCountryCode("South Africa")

    transportCountryDetailsMap += ("TransportCountryDetails" -> "South Africa")
    submit()
  }
}
