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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsIsAdditionalInformationRequired, itemsIsAdditionalInformationRequiredCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{NoAdditionalInformation, PackageInformationType}

object AdditionalInformationYesNoPage extends BasePage {

  def backButtonHref: String =
    detail(DeclarationType) match {
      case Occasional | Simplified =>
        maybeDetail(PackageInformationType(itemId, "0")).fold(PackageInformationPage.path)(_ => PackageInformationListPage.path)

      case _ => CommodityMeasurePage.path
    }

  def path: String  = itemUrl("is-additional-information-required")
  val title: String = "Do you need to make any Additional Information statements?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(itemsIsAdditionalInformationRequired),
    Clearance -> List(itemsIsAdditionalInformationRequiredCL)
  )

  override def pageLinkHrefs: Seq[String] =
    super.pageLinkHrefs ++ List(
      "https://www.gov.uk/government/publications/appendix-1-de-110-requested-and-previous-procedure-codes/requested-procedure-10-permanent-export-or-dispatch#additional-information-de-22-1",
      "https://www.gov.uk/guidance/additional-information-ai-statement-codes-for-data-element-22-of-the-customs-declaration-service-cds"
    )

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit =
    if (!selectYesOrNoRadio(values.head)) store(NoAdditionalInformation(itemId) -> Detail("None"))
}
