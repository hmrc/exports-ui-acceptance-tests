/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object ExpressConsignmentPage extends BasePage {

  val path: String  = "/declaration/express-consignment"
  val title: String = "Is this an express consignment?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(expressConsignment),
    Clearance -> List(expressConsignmentCL)
  )

  private val yesNo = 0

  private def ocaAndSimBackNavigation: String =
    if (isTransportLeavingBorderModePostalOrFixed && inlandOrBorderValue && !shouldSkipInlandOrBorder)
      InlandOrBorderPage.path
    else if (!isInlandModeOfTransportPostalOrFixed && !isTransportLeavingBorderModePostalOrFixed)
      TransportCountryPage.path
    else
      InlandModeOfTransportPage.path

  private def clearanceBackNavigation: String =
    if (isTransportLeavingBorderModePostalOrFixed)
      SupervisingCustomsOfficePage.path
    else
      DepartureTransportPage.path

  private def standardBackNavigation: String =
    if (
      (isTransportLeavingBorderModePostalOrFixed && inlandOrBorderValue && !shouldSkipInlandOrBorder) ||
      (!shouldSkipInlandOrBorder && isGuernseyOrJersey && inlandOrBorderValue)
    )
      InlandOrBorderPage.path
    else if (
      !isTransportLeavingBorderModePostalOrFixedOrRail && !isInlandModeOfTransportPostalOrFixed && !isGuernseyOrJersey
    )
      TransportCountryPage.path
    else if (
      !isGuernseyOrJersey && isTransportLeavingBorderModeRail && inlandOrBorderValue && !shouldSkipInlandOrBorder
    )
      DepartureTransportPage.path
    else if (
      (!isGuernseyOrJersey && isTransportLeavingBorderModeRail && !inlandOrBorderValue) ||
      (shouldSkipInlandOrBorder && isTransportLeavingBorderModeRail)
    )
      BorderTransportPage.path
    else InlandModeOfTransportPage.path

  def backButtonHref: String =
    if (checkIfDecIsOcaOrSim) ocaAndSimBackNavigation
    else if (checkIfDecIsClr) clearanceBackNavigation
    else standardBackNavigation

  override def fillPage(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo))
    store(ExpressConsignment -> Detail(values(yesNo)))
  }
}
