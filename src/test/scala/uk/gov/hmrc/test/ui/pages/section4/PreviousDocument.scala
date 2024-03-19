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

package uk.gov.hmrc.test.ui.pages.section4

import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{addPreviousDocument, addPreviousDocumentCL}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys.{DocumentCode, DocumentReference}


object PreviousDocument extends BasePage {

  val backButtonHref: String = NatureOfTransactionPage.path

  val path: String = "/declaration/add-previous-document"

  def title = "Details for each document that supports this declaration"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(addPreviousDocument),
    Clearance -> List(addPreviousDocumentCL)
  )

  val documentCode = 1
  val documentReference = 2

  //ex: fillPage("3", "Commercial Invoice", "SMITH 321/890")

  def fillPage(values: String*): Unit = {
    fillAutoComplete("documentType", values(documentCode))
    fillTextBoxById("documentReference", values(documentReference))

    store(DocumentCode(values(sequenceId)) -> Detail(findElementById("documentType__option--0").getText),
         DocumentReference(values(sequenceId)) -> Detail(values(documentReference)))
  }
}
