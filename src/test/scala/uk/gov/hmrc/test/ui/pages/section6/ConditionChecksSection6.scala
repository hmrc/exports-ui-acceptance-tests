package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys._
import uk.gov.hmrc.test.ui.pages.section6.BorderTransportPage.detail
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.TransportLeavingBorder
import uk.gov.hmrc.test.ui.pages.section6.InlandOrBorderPage.listOfItemDetailFor

object ConditionChecksSection6 {

  def hasEndingCodes: Boolean =
    listOfItemDetailFor(ProcedureCodeLabel).exists(code =>
      code.endsWith("07") || code.endsWith("71") || code.endsWith("78")
    )

  def isSPOFFNotNeeded: Boolean =
    listOfItemDetailFor(ProcedureCodeLabel).contains("1040") &&
      listOfItemDetailFor(AdditionalProcedureCodeLabel).contains("00")

  def shouldSkipInlandOrBorder(): Boolean = {

    def furtherChecks: Boolean =
      if (detail(TransportLeavingBorder) == "Roll on roll off (RoRo) transport") true
      else if (hasEndingCodes) true
      else if (declaration.holderOfAuthorisation.data.map(_.authorisationCode).contains("EXRR")) true
      else if (declaration.holderOfAuthorisation.data.map(_.authorisationCode).contains("CSE")) true
      else if (depCodes.contains(declaration.locationOfGoods.code)) true
      else false

    detail(DeclarationType) match {
//      case AdditionalDeclarationTypeEnum.SUPPLEMENTARY_EIDR       => true
//      case AdditionalDeclarationTypeEnum.SUPPLEMENTARY_SIMPLIFIED => furtherChecks
//      case AdditionalDeclarationTypeEnum.STANDARD_FRONTIER        => furtherChecks
//      case AdditionalDeclarationTypeEnum.STANDARD_PRE_LODGED      => furtherChecks
//      case AdditionalDeclarationTypeEnum.SIMPLIFIED_FRONTIER      => furtherChecks
//      case AdditionalDeclarationTypeEnum.SIMPLIFIED_PRE_LODGED    => furtherChecks
//      case AdditionalDeclarationTypeEnum.OCCASIONAL_FRONTIER      => furtherChecks
//      case AdditionalDeclarationTypeEnum.OCCASIONAL_PRE_LODGED    => furtherChecks
//      case _                                                      => false
    }
  }
}
