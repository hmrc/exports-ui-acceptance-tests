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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.Section3

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.section3.DestinationCountryPage

class DestinationCountryStepDef extends BaseStepDef {

  And("""^I should land on Destination-Country page"""){ () =>
    DestinationCountryPage.checkPage()
  }

  And("""^I select (.*) as the destination country""") { country: String =>
    DestinationCountryPage.fillPage(country)
  }

  And("""^I navigate to Destination Country page""")(() => DestinationCountryPage.navigateToPage(DestinationCountryPage.path))
}
