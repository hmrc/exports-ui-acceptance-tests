/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object TaricCodePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/additional-taric-code"
  val taricCodePagePageTitle = "Is there a TARIC additional code?"
  var taricCodeDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    TaricCodePage.onPage(taricCodePagePageTitle)
  }

  def selectIsThereAUndangerousGoodsOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    taricCodeDetailsMap += ("taricCodeDetails" -> selectOption)
    submit()
  }
}
