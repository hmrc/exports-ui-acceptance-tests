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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.section1._

class CommonStepDef extends BaseStepDef {

  And("""^I click continue""")(() => StandardOrOtherPage.continue())

  And("""^I click continue on MiniCya""")(() => StandardOrOtherPage.continueOnMiniCya())

  And("""^I fill section1""") { () =>
    LoginPage.fillPage("GB123456789000"); LoginPage.continue()
    ChoicePage.fillPage("create a declaration"); ChoicePage.continue()
    StandardOrOtherPage.fillPage("STANDARD"); StandardOrOtherPage.continue()
    DeclarationTypePage.fillPage("prelodged"); DeclarationTypePage.continue()
    DeclarantDetailsPage.fillPage("Yes"); DeclarantDetailsPage.continue()
    DoYouHaveADucrPage.fillPage("Yes"); DoYouHaveADucrPage.continue()
    DucrEntryPage.fillPage("3GB986007773125-INVOICE123"); DucrEntryPage.continue()
    LrnPage.fillPage("MSLRN2872100"); LrnPage.continue()
    LinkMucrPage.fillPage("Yes"); LinkMucrPage.continue()
    EnterAMucrPage.fillPage("GB/AZ09-B12345"); EnterAMucrPage.continue()
    SummarySection1Page.continue()
  }
}

object CommonStepDef {
  def genSequenceId(seqId: String): String =
    seqId match {
      case "first"  => "0"
      case "second" => "1"
      case "third"  => "2"
    }
}
