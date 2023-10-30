/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object UnDangerousGoodsCodePage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/un-dangerous-goods-code"
  val unDangerousGoodsCodePagePageTitle = "Is there a UN dangerous goods code for this item?"
  var unDangerousGoodsCodeDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    AreYouTheExporterPage.onPage(unDangerousGoodsCodePagePageTitle)
  }

  def selectIsThereAUndangerousGoodsOption(selectOption: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No" => findElement("id", "code_no").click()
    }
    unDangerousGoodsCodeDetailsMap += ("UndangerousGoodsCode" -> selectOption)
    submit()
  }
}
