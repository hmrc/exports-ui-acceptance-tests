/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.Keys
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object AddProcedureCodesPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/procedure-codes"
  val AddProcedureCodesPageTitle = "What is the procedure code for this item?"
  var addProcedureCodesDetailsMap: Map[String, String] = HashMap[String, String]()
  val superKey: Keys = if (System.getProperty("os.name").toLowerCase.contains("mac")) Keys.COMMAND else Keys.CONTROL

  def checkPageTitle(): Unit = {
    AddProcedureCodesPage.onPage(AddProcedureCodesPageTitle)
  }

  def typeProcedureCode(procedureCode:String): Unit = {
    findElement("id", "procedureCode").clear()
    findElement("id", "procedureCode").sendKeys(Keys.chord(superKey, "a"))
    findElement("id", "procedureCode").sendKeys(procedureCode)
    findElement("id", "procedureCode").sendKeys(Keys.ARROW_DOWN)
    driver.switchTo().activeElement().sendKeys(Keys.TAB)
  }

  def enterProcedureCode(procedureCode:String): Unit = {

    val procedureCodeEntered: String = typeProcedureCode(procedureCode).toString

    declarationDetailsMap+=("procedureCode" -> procedureCodeEntered )
    submit()
  }
}
