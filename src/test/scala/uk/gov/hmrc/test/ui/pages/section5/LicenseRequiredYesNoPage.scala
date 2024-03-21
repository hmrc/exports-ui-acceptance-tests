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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, yes, yesNo}
import uk.gov.hmrc.test.ui.pages.base.PageLinks.{isLicenceRequired, tariffCommodities}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.itemsIsLicenceRequired
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{AdditionalInformationCodeLabel, CommodityDetailsCode, IsLicenceRequired}

object LicenseRequiredYesNoPage extends BasePage {

  def backButtonHref: String =
    if (itemDetailFor(itemId, AdditionalInformationCodeLabel).nonEmpty) AdditionalInformationListPage.path
    else AdditionalInformationYesNoPage.path

  def path: String = itemUrl("is-licence-required")
  val title: String = "Do these goods require a licence?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(itemsIsLicenceRequired))

  override def pageLinkHrefs: Seq[String] = {
    val commodityCode = detail(CommodityDetailsCode(itemId))
    super.pageLinkHrefs :+ List(s"$tariffCommodities$commodityCode#export", isLicenceRequired)
  }

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo))
    store(IsLicenceRequired(itemId) -> Detail(values(yesNo)))
  }

  def isLicenseRequired: Boolean = detail(DeclarationType) != Clearance && detail(IsLicenceRequired(itemId)) == yes
}
