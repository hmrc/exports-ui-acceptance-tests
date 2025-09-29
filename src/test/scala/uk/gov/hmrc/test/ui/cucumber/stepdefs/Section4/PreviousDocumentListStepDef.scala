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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.Section4

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.section4.PreviousDocumentListPage

class PreviousDocumentListStepDef extends BaseStepDef {

  And("""^I should land on Previous-Documents-list page""")(() => PreviousDocumentListPage.checkPage())

  And("""^I select (.*) on previous documents list page""") { (yesNo: String) =>
    PreviousDocumentListPage.fillPage(yesNo)
  }

  And("""^I navigate to Previous Documents List page""")(() =>
    PreviousDocumentListPage.navigateToPage(PreviousDocumentListPage.path)
  )

  And("""^I remove previous document""") { () =>
    PreviousDocumentListPage.removePreviousDoc(0)
  }

}
