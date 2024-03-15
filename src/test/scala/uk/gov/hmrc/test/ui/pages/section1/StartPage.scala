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

package uk.gov.hmrc.test.ui.pages.section1

import uk.gov.hmrc.test.ui.pages.base.BasePage
import uk.gov.hmrc.test.ui.pages.base.BasePage._

object StartPage extends BasePage {

  def backButtonHref: String              = ""
  val path: String                        = "/start"
  val title: String                       = "Declare your goods for export from the UK to other countries"
  override val pageLinkHrefs: Seq[String] =
    List(feedbackBanner, govUkLogo, languageToggle, signOut, technicalIssue)

  override protected def checkBackButton(): Unit = ()

  def fillPage(values: String*): Unit = ()
}
