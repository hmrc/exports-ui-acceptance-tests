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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.section1

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.section1._

class DucrEntryStepDef extends BaseStepDef {

  And("""^I should land on Ducr-Entry page""")(() => DucrEntryPage.checkPage())

  And("""^I enter Ducr (.*)""") { (ducr: String) =>
    DucrEntryPage.fillPage(ducr)
  }

  And("""^I validate duplicate ducr warning on ducr entry page""") { () =>
    DucrEntryPage.ducrWarning.getText must be("DUCR reference is a duplication or is invalid")
  }
}
