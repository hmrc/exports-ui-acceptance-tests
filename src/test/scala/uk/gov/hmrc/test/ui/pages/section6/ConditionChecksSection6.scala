package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes
import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys._
import uk.gov.hmrc.test.ui.pages.section6.BorderTransportPage.detail
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._
import uk.gov.hmrc.test.ui.pages.section6.InlandOrBorderPage.listOfItemDetailFor

object ConditionChecksSection6 {

  val inlandOrBorderValue: Boolean = !shouldSkipInlandOrBorder && detail(InlandOrBorder) == "Border Location"

  val checkIfDecIsOcaOrSim: Boolean =
    detail(DeclarationType) == DeclarationTypes.Occasional || detail(DeclarationType) == DeclarationTypes.Simplified

  val checkIfDecIsStdOrSup: Boolean =
    detail(DeclarationType) == DeclarationTypes.Standard || detail(DeclarationType) == DeclarationTypes.Supplementary

  val checkIfDecIsClr: Boolean = detail(DeclarationType) == DeclarationTypes.Clearance

  val checkIfDecIsStd: Boolean = detail(DeclarationType) == DeclarationTypes.Standard

  val checkIfDecIsSup: Boolean = detail(DeclarationType) == DeclarationTypes.Supplementary

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
      else if (declaration.holderOfAuthorisation.data.map(_.authorisationCode).contains("EXRR")) true
      else if (declaration.holderOfAuthorisation.data.map(_.authorisationCode).contains("CSE")) true
      else if (depCodes.contains(declaration.locationOfGoods.code)) true
      else false

    (detail(DeclarationType), detail(AdditionalDeclarationType)) match {
      case (Supplementary, TypeZ)  => true
      case (Supplementary, TypeY)  => furtherChecks
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
