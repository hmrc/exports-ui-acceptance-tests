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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.common

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.common.CopyDeclarationPage

class CopyDeclarationStepDef extends BaseStepDef {

  And("""^I should land on copy declaration page""")(() => CopyDeclarationPage.checkPage())

  And("""^I enter ducr (.*) and lrn starting with (.*) prefix""") { (ducr: String, lrn: String) =>
    CopyDeclarationPage.fillPage(ducr, lrn)
  }

  And("""^I enter ducr (.*) and lrn used within (.*) hours""") { (ducr: String, usedLrn: String) =>
    CopyDeclarationPage.fillPage(ducr, usedLrn)
  }

  And("""^I enter ducr (.*) and a (.*) lrn""") { (ducr: String, usedLrn: String) =>
    CopyDeclarationPage.fillPage(ducr, usedLrn)
  }

  And("""^I am displayed with a lrn warning message""") { () =>
    CopyDeclarationPage.lrnWarning().getText mustBe "You already submitted a declaration with this LRN in the past 48 hours. If you are resubmitting after correcting an error or updating information, add a version number at the end."
  }
}
