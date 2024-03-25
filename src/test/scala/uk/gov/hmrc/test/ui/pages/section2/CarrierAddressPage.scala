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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{carrierAddress, carrierAddressCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Details}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{addressHelper, CarrierDetails}

object CarrierAddressPage extends BasePage {

  def backButtonHref: String = CarrierEORINumberPage.path
  override def changeLink: String = CarrierEORINumberPage.path
  val path: String = "/declaration/carrier-address"
  val title: String = "Carrier or haulier details"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(carrierAddress), Clearance -> List(carrierAddressCL))

  // ex: fillPage(Constants.Address)

  override def fillPage(values: String*): Unit = {
    addressHelper(values: _*)
    store(CarrierDetails -> Details(values))
  }
}
