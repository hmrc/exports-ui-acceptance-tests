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

import uk.gov.hmrc.test.ui.pages.base.Constants.{yesNo, Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{locationOfGoods, locationOfGoodsCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.AdditionalDeclarationType
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{section2, AuthorisationTypeLabel}
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys.{CountriesOfRouting, LocationOfGoods, RRS01}

object LocationOfGoodsPage extends BasePage {

  def backButtonHref: String =
    if (details(CountriesOfRouting).head == Constants.none) CountryOfRoutingPage.path
    else CountriesOfRoutingPage.path

  val path: String = "/declaration/location-of-goods"

  private val customsTitle = "Where will the goods be presented to customs?"
  private val gvmsTitle = "Select a permitted goods location for exports using the Goods Vehicle Movement Service"

  def title: String = {
    val adt = detail(AdditionalDeclarationType)
    val authorisationType = detailForLabel(section2, AuthorisationTypeLabel)

    if (isPrelodgedDeclaration(adt)) customsTitle
    else if (authorisationType.startsWith("CSE -") && isArrivedDeclaration(adt)) "Enter the code for the CSE premises"
    else if (authorisationType.startsWith("EXRR -") && adt.startsWith("Arrived -")) gvmsTitle
    else if (!authorisationType.startsWith("MIB -") && adt.startsWith("Arrived -")) gvmsTitle
    else customsTitle
  }

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(locationOfGoods), Clearance -> List(locationOfGoodsCL))

  val code = 1

  // No  => fillPage(no, "GBAUNHVNHVNHVGVM")
  // Yes => fillPage(yes, "GBAUABDABDABDGVM")

  override def fillPage(values: String*): Unit = {
    val locationOfGoods = values(code)
    fillDropdown(if (selectYesOrNoRadio(values(yesNo))) "glc" else "code", locationOfGoods)
    store(LocationOfGoods -> Detail(locationOfGoods))
    if (locationOfGoods.endsWith("GVM")) store(RRS01 -> Detail("RRS01 (GVMS releases)"))
  }

  private def isArrivedDeclaration(adt: String): Boolean =
    adt.startsWith("Arrived -") || adt.startsWith("Simplified -") || adt.startsWith("EIDR -")

  private def isPrelodgedDeclaration(adt: String): Boolean =
    adt.startsWith("Pre-lodged -") || adt.startsWith("Simplified -") || adt.startsWith("EIDR -")
}
