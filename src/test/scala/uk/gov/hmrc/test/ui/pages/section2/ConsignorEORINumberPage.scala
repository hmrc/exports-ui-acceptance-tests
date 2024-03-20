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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, yesNo}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.consignorEoriNumberCL
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{ConsignorEORI, EORI}

object ConsignorEORINumberPage extends BasePage {

  def backButtonHref: String = IsThisExsPage.path
  val path: String = "/declaration/consignor-eori-number"
  val title: String = "Does the consignor have an EORI number?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Clearance -> List(consignorEoriNumberCL))

  // No  => fillPage(no)
  // Yes => fillPage(yes, "GB12314567897000")

  override def fillPage(values: String*): Unit =
    if (selectYesOrNoRadio(values(yesNo), "Yes", "No")) {
      fillTextBoxById("eori", values(EORI))
      store(ConsignorEORI -> Detail(values(EORI)))
    }
}
