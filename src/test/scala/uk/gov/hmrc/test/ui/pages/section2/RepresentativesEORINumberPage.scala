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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{representativesEoriNumber, representativesEoriNumberCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.RepresentativeEORI

object RepresentativesEORINumberPage extends BasePage {

  def backButtonHref: String = OnBehalfOfAnotherAgentPage.path
  val path: String = "/declaration/representatives-eori-number"
  val title: String = "What is the EORI number of the other agent?"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(representativesEoriNumber), Clearance -> List(representativesEoriNumberCL))

  val EORI = 0

  // ex: fillPage("GB121212121212")

  override def fillPage(values: String*): Unit = {
    fillTextBoxById("details_eori", values(EORI))
    store(RepresentativeEORI -> Detail(values(EORI)))
  }
}
