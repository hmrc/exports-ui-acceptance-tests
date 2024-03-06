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
import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.cache

object AddAuthorisationRequiredPage extends BasePage {

  val path: String                                          = "/declaration/consignee-details"
  val title                        = "Add any authorisations for this export"
  val backButtonHrefs: List[String] = ???
  val superKey: Keys                                       = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def typeAuthorisationCode(authorisationCode: String): Unit = {
    findElementById("authorisationTypeCode").clear()
    findElementById("authorisationTypeCode").sendKeys(Keys.chord(superKey, "a"))
    findElementById("authorisationTypeCode").sendKeys(authorisationCode)
    findElementById("authorisationTypeCode").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
  }

  override protected def performActionsAndCache(values: String*): Unit = {
    values.head match {
      case "UserEori"  => findElementById("UserEori")
      case "OtherEori" => findElementById("OtherEori")
    }
    typeAuthorisationCode(values.head)
    cache ++ Map("WhoHoldsAuthorisation" -> values.last, "authorisationCode"     -> values.head)
  }
}
