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

package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.PageLinks.{aiCodes, aiCodesForContainers, licensesForExportingGoods, previousProcedureCodes, tariffCommodities}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsAdditionalDocuments, itemsAdditionalDocumentsCL, itemsIsAdditionalInformationRequired, itemsIsAdditionalInformationRequiredCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{AdditionalInformationCodeLabel, CommodityDetailsCode, IsLicenceRequired, NoAdditionalDocuments, NoAdditionalInformation, PackageInformationType}
import uk.gov.hmrc.test.ui.pages.section5.ProcedureCodesPage.isPermanentExportOfUKGoods

object AdditionalDocumentsYesNoPage extends BasePage {

  def backButtonHref: String =
    if (detail(DeclarationType) != Clearance) LicenseRequiredYesNoPage.path
    else if (itemDetailFor(itemId, AdditionalInformationCodeLabel).nonEmpty) AdditionalInformationListPage.path
    else AdditionalInformationYesNoPage.path

  def path: String  = itemUrl("is-additional-information-required")

  val title: String =
    if (detail(DeclarationType) == Clearance) "Do you need to declare any additional documents for this item?"
    else "Do you need to enter any other document details?"

  override def checkExpanders(): Unit = ()

  override def pageLinkHrefs: Seq[String] = {
    val commodityCode = detail(CommodityDetailsCode(itemId))
    super.pageLinkHrefs ++ List(s"$tariffCommodities$commodityCode#export", licensesForExportingGoods)
  }

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit =
    if (!selectYesOrNoRadio(values(yesNo))) store(NoAdditionalDocuments(itemId) -> Detail("None"))
}
