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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.Section5

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.section5.SummarySection5Page

class MiniCYASection5StepDef extends BaseStepDef {

  And("""^I should land on MiniCYA-Section-5 page""")(() => SummarySection5Page.checkPage())

  And("""^I check the MiniCYA page for Section-5""") { () =>
    SummarySection5Page.fillPage()
  }

  And("""^I navigate to MiniCYA page for Section-5""") { () =>
    SummarySection5Page.navigateToPage(SummarySection5Page.path)
  }

  And("""^I click back on MiniCya section 5""") { () =>
    SummarySection5Page.back()
  }

  And("""^I should be displayed with a warning text to add items""") { () =>
    SummarySection5Page.addItemWarning().getText should include(
      "You need to add at least one item before submitting your declaration"
    )
  }

  And("""^I click on Add Item link""") { () =>
    SummarySection5Page.addItem()
  }

}
