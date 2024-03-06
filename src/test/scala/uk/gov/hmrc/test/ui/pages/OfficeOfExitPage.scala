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
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object OfficeOfExitPage extends BasePage {

  val path: String                                     = "/declaration/office-of-exit"
  val title                           = "Where is the customs office of exit?"

  val superKey: Keys                                  = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit =
    AddAuthorisationRequiredPage.checkUrlAndTitle(officeOfExitPageTitle)

  def typeOfficeOfExitCode(officeOfExitCode: String): String = {
    findElementById("officeId").clear()
    findElementById("officeId").sendKeys(Keys.chord(superKey, "a"))
    val officeOfExitCodeEntered: WebElement = findElementById("officeId")
    officeOfExitCodeEntered.sendKeys(officeOfExitCode)
    findElementById("officeId").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
    officeOfExitCodeEntered.getText
  }

  def enterOfficeOfExitCodeDetails(officeOfExitCode: String): Unit = {
    val officeOfExitCodeEntered: String = typeOfficeOfExitCode(officeOfExitCode)
cache += ("officeOfExitCode" -> officeOfExitCodeEntered)
    submit()
  }
}
