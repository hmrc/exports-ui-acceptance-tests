/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specs.Section4

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage
import uk.gov.hmrc.test.ui.pages.base.CommonPage.{background, fillSection1ForDeclaration}
import uk.gov.hmrc.test.ui.pages.section4.SummarySection4Page
import uk.gov.hmrc.test.ui.pages.section4.SummarySection4Page.section4Journey1
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.*

class OccasionalJourneySpec extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure{
  Feature("Section4 Occasional Journey") {
    Scenario("Complete Transactions section on Occasional Prelodged and Arrived declaration journey",Regression2,Regression,Section4,Occasional) {
      forAll( Table("DecType", "prelodged", "arrived")) { decType =>
        Given("the user clears data in cache")
        background()
        When(s"User fills Section1 for OCCASIONAL, $decType declaration")
        fillSection1ForDeclaration("OCCASIONAL", decType)
        And("User fills section2/3 and continues their journey to previous documents list page")
        section4Journey1()
        Then("User should land on MiniCYA-Section-4 page")
        SummarySection4Page.checkPage()
        And("User checks the MiniCYA page for Section-4")
        SummarySection4Page.fillPage()
        And("User clicks continue on MiniCya")
        CommonPage.continueOnMiniCya()
      }
    }
    
    }

}
