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
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap

object AddProcedureCodesPage extends BasePage {

  val path: String                                      = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/procedure-codes"
  val AddProcedureCodesPageTitle                       = "What is the procedure code for this item?"
  var addProcedureCodesDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys                                   = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit =
    AddProcedureCodesPage.checkUrlAndTitle(AddProcedureCodesPageTitle)

  def typeProcedureCode(procedureCode: String): Unit = {
    findElement("id", "procedureCode").clear()
    findElement("id", "procedureCode").sendKeys(Keys.chord(superKey, "a"))
    findElement("id", "procedureCode").sendKeys(procedureCode)
    findElement("id", "procedureCode").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
  }

  def enterProcedureCode(procedureCode: String): Unit = {

    val procedureCodeEntered: String = typeProcedureCode(procedureCode).toString

    declarationDetailsMap += ("procedureCode" -> procedureCodeEntered)
    submit()
  }
}
