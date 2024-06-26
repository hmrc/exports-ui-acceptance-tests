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
import uk.gov.hmrc.test.ui.pages.section2.DetailKeys.{ExporterEORI, ExporterYesNo, IsThisExs}
import uk.gov.hmrc.test.ui.pages.section2.EntryIntoDeclarantRecordsPage.isEidr

object IsThisExsPage extends BasePage {

  def backButtonHref: String =
    if (detail(ExporterYesNo) == yes) AreYouTheExporterPage.path
    else if (isEidr) ExporterEORINumberPage.path
    else maybeDetail(ExporterEORI) match {
      case Some(_) => ExporterEORINumberPage.path
      case None    => ExporterAddressPage.path
    }

  val path: String = "/declaration/is-this-exs"
  val title: String = "Do you need to give us safety and security information?"

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = {
    selectYesOrNoRadio(values(yesNo))
    store(IsThisExs -> Detail(values(yesNo)))
  }

  override def checkExpanders(): Unit = ()

  def isThisExs: Boolean = maybeDetail(IsThisExs).fold(false)(_ == yes)
}
