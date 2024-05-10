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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.Section6

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.section6.SummarySection6Page

class MiniCYASection6StepDef extends BaseStepDef {

  And("""^I should land on MiniCYA-Section-6 page""")(() => SummarySection6Page.checkPage())

  And("""^I navigate to MiniCYA page for Section-6""") { () =>
    SummarySection6Page.navigateToPage(SummarySection6Page.path)
  }

  And("""^I check the MiniCYA page for Section-6""") { () =>
    SummarySection6Page.fillPage()
  }
}
