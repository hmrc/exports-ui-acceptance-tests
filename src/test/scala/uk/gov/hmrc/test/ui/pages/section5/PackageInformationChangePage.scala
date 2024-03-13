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

package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.BasePage

object PackageInformationChangePage extends BasePage {

  def backButtonHref: String = PackageInformationListPage.path
  def path: String = changeUrl("package-information")
  def title: String = PackageInformationPage.title

  override val expanderHrefs: Map[String, Seq[String]] = PackageInformationPage.expanderHrefs

  // ex: processPage("Aerosol", "20", "No shipping mark")

  def processPage(values: String*): Unit = PackageInformationPage.processPage(values:_*)
}
