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

import org.openqa.selenium.Keys
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddAuthorisationRequiredPage extends BasePage {

  val url: String                                          = TestConfiguration.url("exports-frontend") + "/declaration/consignee-details"
  val addAuthorisationRequiredPage                         = "Add any authorisations for this export"
  var authorisationRequiredDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys                                       = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit =
    AddAuthorisationRequiredPage.checkUrlAndTitle(addAuthorisationRequiredPage)

  def typeAuthorisationCode(authorisationCode: String): Unit = {
    findElement("id", "authorisationTypeCode").clear()
    findElement("id", "authorisationTypeCode").sendKeys(Keys.chord(superKey, "a"))
    findElement("id", "authorisationTypeCode").sendKeys(authorisationCode)
    findElement("id", "authorisationTypeCode").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
  }

  def enterAuthorisationCodeWithDetails(authorisationCode: String, whoHoldsThisAuthorisation: String): Unit = {
    whoHoldsThisAuthorisation match {
      case "UserEori"  => findElement("id", "UserEori")
      case "OtherEori" => findElement("id", "OtherEori")
    }
    val authorisationCodeEntered: String = typeAuthorisationCode(authorisationCode).toString

    declarationDetailsMap += ("WhoHoldsAuthorisation" -> whoHoldsThisAuthorisation)
    declarationDetailsMap += ("authorisationCode"     -> authorisationCodeEntered)
    submit()
  }
}
