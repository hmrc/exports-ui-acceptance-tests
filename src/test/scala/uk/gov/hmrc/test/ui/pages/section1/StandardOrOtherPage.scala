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

package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.PageLinks.fullExportDeclaration
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType

object StandardOrOtherPage extends BasePage {

  def backButtonHref: String = ChoicePage.path
  val path: String = "/declaration/standard-or-other"
  val title: String = "Which type of declaration do you want to make?"

  override val pageLinkHrefs: Seq[String] = super.pageLinkHrefs ++ List(fullExportDeclaration)

  // ex: fillPage("STANDARD")
  // ex: fillPage("Other")

  override def fillPage(values: String*): Unit =
    if (values(0) != "STANDARD") clickById("NonStandardDeclarationType")
    else {
      clickById(values(0))
      store(DeclarationType -> Detail(Standard))
    }

  def isStandard: Boolean = detail(DeclarationType) == Standard
}
