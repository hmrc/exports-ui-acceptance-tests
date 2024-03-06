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
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.collection.immutable.HashMap
import scala.util.Random

object EnterMUCRPage extends BasePage {

  val path: String                         = "/declaration/enter-a-mucr"
  val title                           = "Enter the MUCR"


  def checkPageTitle(): Unit =
    DUCRDetailsPage.checkUrlAndTitle(pageTitle)

  def generateAndEnterRanomMUCREntry(): Unit = {
    def generateRandomString(length: Int): String = {
      val dynamicNumber = "0123456789"
      val random        = new Random

      val randomChars = (1 to length).map(_ => dynamicNumber(random.nextInt(dynamicNumber.length)))
      randomChars.mkString
    }

    def generateRandomMUCRString(): String = {
      val randomString = generateRandomString(5)
      s"3GB$randomString${Random.nextInt(100)}"
    }

    val generatedMucr = generateRandomMUCRString()

    //Enter the Ducr Value
    findElementById("MUCR").sendKeys("GB/123456789100-AB123")
cache += ("MucrDetailsEntered" -> "GB/123456789100-AB123")
    submit()
  }
}
