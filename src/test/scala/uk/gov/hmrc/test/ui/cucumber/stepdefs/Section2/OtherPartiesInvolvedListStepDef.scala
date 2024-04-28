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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.Section2

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.section2.OtherPartiesInvolvedListPage

class OtherPartiesInvolvedListStepDef extends BaseStepDef {

  And("""^I should land on Other-Parties-Involved-List page""")(() => OtherPartiesInvolvedListPage.checkPage())

  And("""I navigate to Other-Parties-Involved-List page""")(() => OtherPartiesInvolvedListPage.navigateToPage(OtherPartiesInvolvedListPage.path))

  And("""^I select (.*) on other party involved list page""")((yesNo: String) => OtherPartiesInvolvedListPage.fillPage(yesNo))

  And("""^I click on remove link to delete party (.*)""")((index: Int) => OtherPartiesInvolvedListPage.removeOtherPartiesInvolvedLink(index))
}
