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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, no, yes}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{areYouCompletingThisDeclarationOnBehalfOfAnotherAgent, areYouCompletingThisDeclarationOnBehalfOfAnotherAgentCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys._

object OnBehalfOfOtherAgentPage extends BasePage {

  val path: String = "/declaration/are-you-completing-this-declaration-on-behalf-of-another-agent"
  val title: String = "Do you hold the contract to complete the customs formalities?"
  def backButtonHref: String = detail(DeclarationType) match {
    case Clearance =>
      if (detail(IsThisExs) == no) IsThisExsPage.path
      else if (detail(ExporterYesNo) == yes) ConsignorEORINumberPage.path
      else ConsignorDetailsPage.path
    case _ =>
      if (maybeDetail(ExporterEORI).isEmpty) ExporterDetailsPage.path else ExporterEORINumberPage.path
  }

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(
      Common -> List(areYouCompletingThisDeclarationOnBehalfOfAnotherAgent),
      Clearance -> List(areYouCompletingThisDeclarationOnBehalfOfAnotherAgentCL)
    )

  override def fillPage(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo), "agent_yes", "agent_no")
    store(onBehalfOfOtherAgentYesNo -> Detail(values(yesNo)))
  }
}
