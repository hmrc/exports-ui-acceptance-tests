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

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.common.DeclarationInformationPage

class DeclarationInformationStepDef extends BaseStepDef {

  And("""^I should land on Declaration-Information page""") { () =>
    DeclarationInformationPage.checkPage()
  }

  And("""^I validate details on declaration information page""") { () =>
    DeclarationInformationPage.validateTimelineDetails()
  }

  And("""^I click on copy link""")(() => DeclarationInformationPage.copyDeclaration())

  And("""^I fix errors on the declaration""")(() => DeclarationInformationPage.fixErrors())

  And("""^I click Amend declaration link""")(() => DeclarationInformationPage.amendDeclaration())

  And("""^I validate (.*) status on timeline""") { (status: String) =>
    DeclarationInformationPage.checkStatusOnTimeLine(status)
  }

  And("""^I click on cancel link on rejected amendment""") {
    ()
    DeclarationInformationPage.clickCancelLinkOnRejectedAmendment()
  }

  And("""^And I validate that the Amend declaration link and Copy declaration link is displayed""") {
    ()
    DeclarationInformationPage.validateCopyAndAmendDeclarationLinks()
  }

}
