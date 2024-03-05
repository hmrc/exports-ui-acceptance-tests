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

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object NatureOfTransactionPage extends BasePage {

  val url: String                                        = TestConfiguration.url("exports-frontend") + "/declaration/nature-of-transaction"
  val natureOfTransactionPageTitle                       = "What sort of export is it?"
  var natureOfTransactionDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    NatureOfTransactionPage.checkUrlAndTitle(natureOfTransactionPageTitle)

  def selectWhatSortOfExportOption(selectOption: String): Unit = {
    selectOption match {
      case "Goods Being Sold"                      => findElement("id", "Sale").click()
      case "Item purchased new in the UK"          => findElement("id", "BusinessPurchase").click()
      case "House removal or not"                  => findElement("id", "HouseRemoval").click()
      case "A return or a replacement"             => findElement("id", "Return").click()
      case "Non-commercial change of ownership"    => findElement("id", "Donation").click()
      case "Being sent out for processing"         => findElement("id", "Processing").click()
      case "Goods have been processed"             => findElement("id", "Processed").click()
      case "Inter-governmental or joint defence"   => findElement("id", "Military").click()
      case "Goods being supplied under a contract" => findElement("id", "Construction").click()
      case "Other"                                 => findElement("id", "Other").click()
    }
    natureOfTransactionDetailsMap += ("NatureOfTransactionDetails" -> selectOption)
    submit()
  }
}
