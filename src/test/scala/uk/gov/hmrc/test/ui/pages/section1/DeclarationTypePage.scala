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

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{decType, decTypeCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{AdditionalDeclarationType, DeclarationType}
import uk.gov.hmrc.test.ui.pages.section1.StandardOrOtherPage.isStandard

object DeclarationTypePage extends BasePage {

  def backButtonHref: String = if (isStandard) StandardOrOtherPage.path else DeclarationChoicePage.path
  val path: String = "/declaration/type"

  def title: String =
    if (detail(DeclarationType) == Supplementary) "What type of supplementary declaration do you want to make?"
    else "Do you have to make an arrived export declaration?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> Seq(decType),
    Clearance -> Seq(decTypeCL)
  )

  // ex: fillPage("arrived")

  override def fillPage(values: String*): Unit = {
    val additionalDeclarationType =
      (detail(DeclarationType), values(0)) match {
        case (Supplementary, NonEidr) => clickById(NonEidr); "Simplified - type Y"
        case (Supplementary, Eidr)    => clickById(Eidr); "EIDR - type Z"
        case (Standard, Arrived)      => clickById(Arrived); "Arrived - type A"
        case (Standard, Prelodged)    => clickById(Prelodged); "Pre-lodged - type D"
        case (Simplified, Arrived)    => clickById(Arrived); "Arrived - type C"
        case (Simplified, Prelodged)  => clickById(Prelodged); "Pre-lodged - type F"
        case (Occasional, Arrived)    => clickById(Arrived); "Arrived - type B"
        case (Occasional, Prelodged)  => clickById(Prelodged); "Pre-lodged - type E"
        case (Clearance, Arrived)     => clickById(Arrived); "Arrived - type J"
        case (Clearance, Prelodged)   => clickById(Prelodged); "Pre-lodged - type K"
      }
    store(AdditionalDeclarationType -> Detail(additionalDeclarationType))
  }
}
