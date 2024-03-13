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
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{decType, decTypeCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType

object DeclarationChoicePage extends BasePage {

  val backButtonHref: String = StandardOrOtherPage.path
  val path: String           = "/declaration/declaration-choice"
  val title                  = "Select a declaration type"
  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(decType),
    Clearance -> Seq(decTypeCL)
  )

  override def performActionsAndStore(values: String*): Unit = {
    val declarationType = values(0)
    declarationType match {
      case Occasional    => clickById(Occasional)
      case Simplified    => clickById(Simplified)
      case Clearance     => clickById(Clearance)
      case Supplementary => clickById(Supplementary)
    }
    store(DeclarationType -> Detail(declarationType))
  }
}
