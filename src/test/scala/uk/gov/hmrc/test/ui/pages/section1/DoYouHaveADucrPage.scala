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
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, yesNo}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{ducr, ducrCL}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType

object DoYouHaveADucrPage extends BasePage {

  def backButtonHref: String =
    if (detail(DeclarationType) == Clearance) DeclarationTypePage.path
    else DeclarantDetailsPage.path

  val path: String = "/declaration/do-you-have-ducr"
  val title: String = "Do you have a Declaration Unique Consignment Reference Number (DUCR)?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> Seq(ducr), Clearance -> Seq(ducrCL))

  // No  => fillPage(no)
  // Yes => fillPage(yes)

  override def fillPage(values: String*): Unit = selectYesOrNoRadio(values(yesNo))
}
