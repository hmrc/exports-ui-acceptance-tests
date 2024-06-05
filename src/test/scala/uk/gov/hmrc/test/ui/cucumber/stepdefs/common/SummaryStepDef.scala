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
import uk.gov.hmrc.test.ui.pages.common.SummaryPage

class SummaryStepDef extends BaseStepDef {

  And("""^I should land on Saved-Summary page""")(() => SummaryPage.checkPage())

  And("""^I check the sections' headings and click confirm and continue""") { () =>
    SummaryPage.fillPage()
  }

  And("""^I click continue on summary""") { () =>
    SummaryPage.clickContinueOnSummary()
  }

  And("""^I validate that change links are not present for Section 1""") { () =>
    SummaryPage.checkChangeLinkIsNotPresentFor("ducr-entry")
    SummaryPage.checkChangeLinkIsNotPresentFor("local-reference-number")
    SummaryPage.checkChangeLinkIsNotPresentFor("mucr-row")
    SummaryPage.checkChangeLinkIsNotPresentFor("link-to-mucr")
  }

  And("""^I validate that change link is not present for location of goods""") { () =>
    SummaryPage.checkChangeLinkIsNotPresentFor("location-of-goods")
  }

  And("""^I click remove link to remove item (.*)"""){ (itemIndex : Int) =>
    SummaryPage.removeItemLink(itemIndex).click()
  }

  And("""^I navigate to summary page""") { () =>
    SummaryPage.navigateToPage(SummaryPage.path)
  }
}
