/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object LocationOfGoodsPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/location-of-goods"
  val locationOfGoodsPageTitle = "Where will the goods be presented to customs?"
  var locationOfGoodsDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    LocationOfGoodsPage.onPage(locationOfGoodsPageTitle)
  }

  def selectDoYouWantToSearchForAGoodsLocationCodeOption(selectOption: String , locationOfGoodsCode: String): Unit = {
    selectOption match {
      case "Yes" => findElement("id", "code_yes").click()
      case "No"  => findElement("id", "code_no").click()
                    findElement("id","code").sendKeys(locationOfGoodsCode)

    }
    locationOfGoodsDetailsMap += ("LocationOfGoodsSelectOption" -> selectOption)
    locationOfGoodsDetailsMap += ("LocationOfGoodsCodeEntered" -> locationOfGoodsCode)
    submit()
  }
}
