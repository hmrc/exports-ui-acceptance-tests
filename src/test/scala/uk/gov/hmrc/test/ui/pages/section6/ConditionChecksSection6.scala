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

import uk.gov.hmrc.test.ui.pages.base.Constants
import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys._
import uk.gov.hmrc.test.ui.pages.section6.BorderTransportPage.detail
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section6.InlandOrBorderPage.listOfItemDetailFor

object ConditionChecksSection6 {

  val inlandOrBorderValue: Boolean = !shouldSkipInlandOrBorder && detail(InlandOrBorder) == "Border Location"

  val checkIfDecIsOcaOrSim: Boolean =
    detail(DeclarationType) == Constants.Occasional || detail(DeclarationType) == Constants.Simplified

  val checkIfDecIsStdOrSup: Boolean =
    detail(DeclarationType) == Constants.Standard || detail(DeclarationType) == Constants.Supplementary

  val checkIfDecIsClr: Boolean = detail(DeclarationType) == Constants.Clearance

  val checkIfDecIsStd: Boolean = detail(DeclarationType) == Constants.Standard

  val checkIfDecIsSup: Boolean = detail(DeclarationType) == Constants.Supplementary

  def hasEndingCodes: Boolean =
    listOfItemDetailFor(ProcedureCodeLabel).exists(code =>
      code.endsWith("07") || code.endsWith("71") || code.endsWith("78")
    )

  def isSPOFFNotNeeded: Boolean =
    listOfItemDetailFor(ProcedureCodeLabel).contains("1040") &&
      listOfItemDetailFor(AdditionalProcedureCodeLabel).contains("00")

  def isTransportLeavingBorderModePostalOrFixed: Boolean =
    detail(TransportLeavingBorder) == "Postal" || detail(TransportLeavingBorder) == "Fixed transport installation"

  def isTransportLeavingBorderModeRail: Boolean =
    detail(TransportLeavingBorder) == "Rail"

  def isTransportLeavingBorderModePostalOrFixedOrRail: Boolean =
    detail(TransportLeavingBorder) == "Postal" ||
      detail(TransportLeavingBorder) == "Fixed transport installation" ||
      isTransportLeavingBorderModeRail

  def isInlandModeOfTransportPostalOrFixed: Boolean =
    detail(InlandModeOfTransport) == "Postal" || detail(InlandModeOfTransport) == "Fixed transport installation"

  def isGuernseyOrJersey: Boolean =
    detail(InlandModeOfTransport) == "Guernsey" || detail(InlandModeOfTransport) == "Jersey"

  def isExpressConsignment: Boolean = detail(ExpressConsignment) == "Yes"

  def shouldSkipInlandOrBorder: Boolean = {

    def furtherChecks: Boolean =
      if (detail(TransportLeavingBorder) == "Roll on roll off (RoRo) transport") true
      else if (hasEndingCodes) true
      // else if (contains("EXRR")) true  // need to add logics once section 2 and section 4 changes are pushed
      // else if (contains("CSE")) true
      // else if (locationOfGoods.code) true
      else false

    (detail(DeclarationType), detail(AdditionalDeclarationType)) match {
      case (Supplementary, NonEidr)  => true
      case (Supplementary, Eidr)  => furtherChecks
      case (Standard, Arrived)     => furtherChecks
      case (Standard, Prelodged)   => furtherChecks
      case (Simplified, Arrived)   => furtherChecks
      case (Simplified, Prelodged) => furtherChecks
      case (Occasional, Arrived)   => furtherChecks
      case (Occasional, Prelodged) => furtherChecks
      case _                       => false
    }
  }
}
