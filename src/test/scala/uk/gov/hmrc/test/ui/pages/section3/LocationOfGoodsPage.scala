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

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationChoicePage.{isClearance, isSupplementary}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationTypePage._
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section3.DetailKeys._

object LocationOfGoodsPage extends BasePage {

  def backButtonHref: String =
    if (isClearance || isSupplementary) {
      DestinationCountryPage.path
    } else
      CountriesOfRoutingPage.path

  val path: String = "/declaration/location-of-goods"

  private val customsTitle = "Where will the goods be presented to customs?"
  private val gvmsTitle = "Select a permitted goods location for exports using the Goods Vehicle Movement Service"

  def authorisationType = detailForLabel(section2, AuthorisationTypeLabel)

  def hasAuthorisationType(code: String): Boolean = authorisationType.exists(_.startsWith(s"$code -"))

  val locationMappings = Map(
    "Joint Dover/Eurotunnel" -> "GBAUDEUDEUDEUGVM",
    "Dover" -> "GBAUDVRDOVDVRGVM",
    "Eurotunnel" -> "GBAUEUTEUTEUTGVM",
    "Fishguard" -> "GBAUFISFISFISGVM",
    "Heysham" -> "GBAUHYMHEYHYMGVM",
    "Holyhead" -> "GBAUHLYHLDHLYGVM",
    "Liverpool" -> "GBAULIVLIVLIVGVM",
    "Pembroke Docks" -> "GBAUPEDMILPEDGVM"
  )

  def title: String =
    if (hasAuthorisationType("CSE") && (isArrivedDeclaration || isSupplementary)) "Enter the code for the CSE premises"
    else if (hasAuthorisationType("EXRR") && isArrivedDeclaration) gvmsTitle
    else if (hasAuthorisationType("MIB") && isArrivedDeclaration) gvmsTitle
    else if (isArrivedDeclaration) gvmsTitle
    else customsTitle

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(locationOfGoods), Clearance -> List(locationOfGoodsCL))

  val selection = 0
  val code = 1

  def handleUserChoice(location: String): Unit = {
    selectRadioAndClick("radio-userChoice")
    fillTextBoxById("userChoice", location)
    store(LocationOfGoods -> Detail(location))
    if (locationOfGoods.endsWith("GVM")) store(RRS01 -> Detail("RRS01 (GVMS releases)"))
  }

  // No  => fillPage(no, "GBAUNHVNHVNHVGVM")
  // Yes => fillPage(yes, "GBAUABDABDABDGVM")

  override def fillPage(values: String*): Unit = {

    val goodsSelection = values(selection)

    val isAuthorisedMIB = hasAuthorisationType("MIB")
    val isAuthorisedCSE = hasAuthorisationType("CSE")
    val isUserChoice = values(selection).equals("User Choice")

    def storeLocation(location: String): Unit = {
      selectRadioAndClick(s"radio-$location")
      store(LocationOfGoods -> Detail(location))
      if (location.endsWith("GVM")) store(RRS01 -> Detail("RRS01 (GVMS releases)"))
    }

    def handleDefaultSelection(): Unit = {
      fillDropdown(if (selectYesOrNoRadio(values(yesNo))) "glc" else "code", values(code))
      store(LocationOfGoods -> Detail(values(code)))
      if (values(code).endsWith("GVM")) store(RRS01 -> Detail("RRS01 (GVMS releases)"))
    }

    def shouldHandleGoodsSelection =
      isArrivedDeclaration && !(isAuthorisedMIB || isAuthorisedCSE) && !isUserChoice && !isSupplementary

    if (shouldHandleGoodsSelection) {
      locationMappings.get(goodsSelection).foreach(storeLocation)
    } else if (goodsSelection.equals("User Choice")) {
      handleUserChoice(values(code))
    } else {
      handleDefaultSelection()
    }
  }
}
