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

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object TotalPackageQuantityPage extends BasePage {

  val url: String                                         = TestConfiguration.url("exports-frontend") + "/declaration/total-package-quantity"
  val totalPackageQuantityPageTitle                       = "What is the total number of packages in this declaration?"
  var totalPackageQuantityDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit =
    AreYouTheExporterPage.checkUrlAndTitle(totalPackageQuantityPageTitle)

  def enterTotalPackageQuantity(totalPackageQty: String): Unit = {
    val totalPackageQuantity: WebElement = findElement("id", "totalPackage")
    totalPackageQuantity.sendKeys(totalPackageQty)
    totalPackageQuantityDetailsMap += ("TotalPackageQuantityDetails" -> totalPackageQuantity.getText)
    submit()
  }
}
