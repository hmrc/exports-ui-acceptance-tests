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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section2.IsThisExsPage.isThisExs
import uk.gov.hmrc.test.ui.pages.section5.AdditionalProcedureCodesPage.isLowValueDeclaration
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{PackageInformationNumber, PackageInformationShippingMark, PackageInformationType}

object PackageInformationPage extends BasePage {

  def backButtonHref: String =
    maybeDetail(PackageInformationType(itemId, "0")).fold(
      detail(DeclarationType) match {
        case Clearance                    => if (isThisExs) DangerousGoodsCodePage.path else CommodityDetailsPage.path
        case Occasional | Simplified      => if (isLowValueDeclaration) StatisticalValuePage.path else NationalAdditionalCodesListPage.path
        case Standard | Supplementary | _ => StatisticalValuePage.path
      }
    )(_ => PackageInformationListPage.path)

  override def changeLink: String = PackageInformationListPage.path

  def path: String = itemUrl("package-information")
  val title: String = "Enter the packing details for this item"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(itemsPackageInformation, itemsPackageInformation1, itemsPackageInformation2),
    Clearance -> List(itemsPackageInformationCL, itemsPackageInformationCL1, itemsPackageInformationCL2)
  )

  val packageType      = 1
  val numberOfPackages = 2
  val shippingMark     = 3

  // The 1st parameter is the sequenceId of the current "Packing Details" element: "0", "1", "2", ...
  // ex: fillPage("2", "Aerosol", "20", "No shipping mark")

  override def fillPage(values: String*): Unit = {
    val typeOfPackage = fillDropdown("typesOfPackages", values(packageType), Some("typesOfPackages__option--0"))
    fillTextBoxById("numberOfPackages", values(numberOfPackages))
    fillTextBoxById("shippingMarks", values(shippingMark))
    store(
      PackageInformationType(itemId, values(sequenceId))         -> Detail(typeOfPackage),
      PackageInformationNumber(itemId, values(sequenceId))       -> Detail(values(numberOfPackages)),
      PackageInformationShippingMark(itemId, values(sequenceId)) -> Detail(values(shippingMark))
    )
  }
}
