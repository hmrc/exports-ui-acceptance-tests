/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.Keys
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddAdditionalProcedureCodesPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/additional-procedure-codes"
  val addAdditionalProcedureCodesPageTitle = "Add any additional procedure codes to"
  var addAdditionalProcedureCodesDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    AddProcedureCodesPage.onPage(addAdditionalProcedureCodesPageTitle)
  }

  def typeAdditionalProcedureCode(procedureCode: String): Unit = {
    findElement("id", "additionalProcedureCode").clear()
    findElement("id", "additionalProcedureCode").sendKeys(Keys.chord(superKey, "a"))
    findElement("id", "additionalProcedureCode").sendKeys(procedureCode)
    findElement("id", "additionalProcedureCode").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
  }

  def enterAdditionalProcedureCodeDetails(additionalProcedureCode: String): Unit = {

    val additionalProcedureCodeEntered: String = typeAdditionalProcedureCode(additionalProcedureCode).toString

    declarationDetailsMap += ("AdditionalProcedureCode" -> additionalProcedureCodeEntered)
    submit()
  }
}
