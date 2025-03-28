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

package uk.gov.hmrc.test.ui.pages.section2

import uk.gov.hmrc.test.ui.pages.base.Constants.{yes, yesNo}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DeclarationChoicePage.isClearance
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys._

object ThirdPartyGoodsTransportationPage extends BasePage {

  def backButtonHref: String = if (detail(ExporterYesNo) == yes) AreYouTheExporterPage.path
  else if (isClearance) {
    if (detail(EntryIntoDeclarantsRecords).equals("Yes")) ConsignorEORINumberPage.path else ConsignorDetailsPage.path
  } else RepresentationTypeAgreedPage.path

  val path: String = "/declaration/third-party-goods-transportation"

  val title: String = "Will the goods be moved by a third party carrier or haulier?"

  override def checkExpanders(): Unit = ()

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = {
    if (!selectYesOrNoRadio(values(yesNo))) clearIfAny(CarrierEORI, CarrierDetails)
    store(ThirdPartyGoodsTransportation -> Detail(values(yesNo)))
  }

  def isThirdPartyGoods: Boolean = detail(ThirdPartyGoodsTransportation) == "Yes"
}
