/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object VatRatingPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/items/([^/]+)/vat-rating"
  val vatRatingPageTitle = "Are these goods being zero-rated for VAT?"
  var vatRatingDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    VatRatingPage.onPage(vatRatingPageTitle)
  }

  def selectAreTheseGoodsBeingZeroRatedOption(selectOption: String): Unit = {
    selectOption match {
      case "VATZ" => findElement("id", "VATZ").click()
      case "VATR" => findElement("id", "VATR").click()
      case "VATE" => findElement("id", "VATE").click()
      case "VAT_NO" => findElement("id", "VAT_NO").click()
    }
    vatRatingDetailsMap += ("vatRatingDetails" -> selectOption)
    submit()
  }
}
