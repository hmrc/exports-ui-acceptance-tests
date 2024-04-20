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
import uk.gov.hmrc.test.ui.pages.section2.ConsignorEORINumberPage

class ConsignorEoriNumberStepDef extends BaseStepDef {

  And("""^I should land on Consingor-EORI-Number page""")(() => ConsignorEORINumberPage.checkPage())

  And("""^I select (.*) to consignor eori number""")((consignorEoriChoice: String) =>
    ConsignorEORINumberPage.fillPage(consignorEoriChoice)
  )

  And("""^I navigate to Consingor EORI Number page""")(() =>
    ConsignorEORINumberPage.navigateToPage(ConsignorEORINumberPage.path)
  )

  And("""^I select (.*) on consignor eori number page and enter eori number as (.*)""") {
    (yesNo: String, eori: String) =>
      ConsignorEORINumberPage.fillPage(yesNo, eori)
  }
}
