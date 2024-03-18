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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{representationTypeAgreed, representationTypeAgreedCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Constants, Detail}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{RepresentativeTypeAgreed, onBehalfOfOtherAgentYesNo}

object RepresentationTypeAgreedPage extends BasePage {

  val path: String = "/declaration/representation-type-agreed"
  val title: String = "What type of representation will be used?"
  def backButtonHref: String = maybeDetail(onBehalfOfOtherAgentYesNo) match {
    case Some(Constants.yes) => OnBehalfOfOtherAgentPage.path
    case Some(Constants.no)  => RepresentativeEORINumberPage.path
  }

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(representationTypeAgreed), Clearance -> List(representationTypeAgreedCL))

  val representationType = 0

  override def fillPage(values: String*): Unit = {
    values(representationType) match {
      case "Direct"   => clickById("2")
      case "Indirect" => clickById("3")
    }
    store(RepresentativeTypeAgreed -> Detail(values(representationType)))
  }
}
