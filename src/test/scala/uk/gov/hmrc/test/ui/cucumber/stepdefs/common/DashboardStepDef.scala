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
import uk.gov.hmrc.test.ui.pages.common.DashboardPage

class DashboardStepDef extends BaseStepDef {

  And("""^I should land on Dashboard page""")(() => DashboardPage.checkPage())

  And("""^I validate declaration details on (.*) tab and check Status is (.*)""") { (tab: String, status: String) =>
   DashboardPage.refreshPage()
    DashboardPage.validateDashboard(tab, status)
  }

  And("""^I navigate to declaration information page after clicking on mrn link""") { () =>
    DashboardPage.mrnLink.click()
  }

  And("""^I click on (.*) tab""") { (tab: String) =>
    DashboardPage.clickOnTab(tab)
  }

  Then("""^I should validate the functionality of pagination component""") { () =>
    DashboardPage.viewPaginationComponent()
  }

}
