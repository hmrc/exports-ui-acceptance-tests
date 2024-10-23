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

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common, sequenceId}
import uk.gov.hmrc.test.ui.pages.base.PageLinks.aiCodes
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsAdditionalInformation, itemsAdditionalInformationCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail, DetailKey}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.{AdditionalInformation, AdditionalInformationCode, AdditionalInformationCodeLabel, AdditionalInformationDescription}

object AdditionalInformationPage extends BasePage {

  def backButtonHref: String =
    maybeDetail(AdditionalInformationCode(itemId, "0")).fold(AdditionalInformationYesNoPage.path)(_ =>
      AdditionalInformationListPage.path
    )

  def path: String = itemUrl("additional-information")
  val title: String = "Additional Information"

  override def changeLink: String = AdditionalInformationListPage.path

  override val expanderHrefs: Map[String, Seq[String]] =
    Map(Common -> List(itemsAdditionalInformation), Clearance -> List(itemsAdditionalInformationCL))

  override val pageLinkHrefs: Seq[String] = super.pageLinkHrefs ++ List(aiCodes)

  val code = 1
  val description = 2

  // The 1st parameter is the sequenceId of the current "Additional Information" element: "0", "1", "2", ...
  // ex: fillPage("2", "00400", "EXPORTER")

  override def fillPage(values: String*): Unit = {
    fillTextBoxById("code", values(code))
    fillTextBoxById("description", values(description))

    val keyAndValues: Seq[(DetailKey, Detail)] =
      List(
        if (itemDetailFor(itemId, AdditionalInformationCodeLabel).nonEmpty) None
        else Some(AdditionalInformation(itemId) -> Detail("value ignored")),

        Some(AdditionalInformationCode(itemId, values(sequenceId)) -> Detail(values(code))),

        Some(AdditionalInformationDescription(itemId, values(sequenceId)) -> Detail(values(description)))
      ).flatten

    store(keyAndValues:_*)
  }
}
