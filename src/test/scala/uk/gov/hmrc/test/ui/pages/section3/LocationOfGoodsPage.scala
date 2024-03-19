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

package uk.gov.hmrc.test.ui.pages.section3

import uk.gov.hmrc.test.ui.pages.base.Constants.{Arrived, Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{locationOfGoods, locationOfGoodsCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{AdditionalDeclarationType, DeclarationType}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{AuthorisationType, AuthorisationTypeLabel, section2}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.LocationOfGoodsCode

import scala.util.Random

object LocationOfGoodsPage extends BasePage {

  val path: String = "/declaration/location-of-goods"

  def title = titleForDecTypeAndAuthCode

  val backButtonHref: String = CountryOfRoutingPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(locationOfGoods),
    Clearance -> List(locationOfGoodsCL)
  )

  def titleForDecTypeAndAuthCode(): String = {
   val  allSectionDetails(section2, Some(AuthorisationTypeLabel)).values
    detail(AdditionalDeclarationType) match {
      case Arrived  if .filter(_._1.label == AuthorisationType()).contains("CSE") => "Enter the code for the CSE premises"
      case Arrived                                        => "Select a permitted goods location for exports using the Goods Vehicle Movement Service"
      case _                                              => "Where will the goods be presented to customs?"
    }
  }

  //If i select goods location code as GBAUABDABDABDGVM by clicking Yes
  def fillPage(values: String*): Unit = {
     val random = new Random()
     val option = if(values.length<2) { if (random.nextBoolean()) "Yes" else "No"} else values(1)
    val locationOfGoodsCode: String = values.head
      selectYesOrNoRadio(option)
      option match {
        case "Yes" => fillAutoComplete("glc", locationOfGoodsCode)
        case "No" => findElementById("code").sendKeys(locationOfGoodsCode)
      }
      store(LocationOfGoodsCode -> Details(Seq(locationOfGoodsCode)))
    }

}
