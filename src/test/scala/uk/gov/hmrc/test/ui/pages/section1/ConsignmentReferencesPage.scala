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

import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.base.Constants.{Clearance, Common}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.{Ducr, Lrn, Mrn}

object ConsignmentReferencesPage extends BasePage {

  def backButtonHref: String = DeclarantDetailsPage.path
  val path: String = "/declaration/consignment-references"
  val title = "Consignment references"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> Seq(consignmentReferencesSUP, consignmentReferences, lrn),
    Clearance -> Seq(consignmentReferencesSUP, consignmentReferencesCL, lrnCL)
  )

  // ex: fillPage(ducr, mrn, lrn)
  override def fillPage(values: String*): Unit = {
    val ducr = values(0)
    val mrn = values(1)
    val lrn = values(2)
    fillTextBoxById("ducr_ducr", ducr)
    fillTextBoxById("mrn", mrn)
    fillTextBoxById("lrn", lrn)

    store(Ducr -> Detail(ducr), Mrn -> Detail(mrn), Lrn -> Detail(lrn))
  }
}
