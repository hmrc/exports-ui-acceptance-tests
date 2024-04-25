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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, yesNo}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{areYouTheExporter, areYouTheExporterCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section1.{DeclarantDetailsPage, SummarySection1Page}
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.ExporterYesNo

object AreYouTheExporterPage extends BasePage {

  def backButtonHref: String = detail(DeclarationType) match {
    case Clearance => DeclarantDetailsPage.path
    case _         => SummarySection1Page.path
  }

  val path: String = "/declaration/are-you-the-exporter"
  val title: String = "Are you the exporter?"

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(areYouTheExporter), Clearance -> List(areYouTheExporterCL))

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo))
    store(ExporterYesNo -> Detail(values(yesNo)))
  }

  def isExporter: Boolean = detail(ExporterYesNo) == "Yes"
}
