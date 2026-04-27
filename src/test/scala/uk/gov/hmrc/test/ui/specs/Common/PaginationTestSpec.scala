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

package uk.gov.hmrc.test.ui.specs.Common

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.test.ui.pages.base.CommonPage.*
import uk.gov.hmrc.test.ui.pages.common.{DashboardPage, DeclarationInformationPage}
import uk.gov.hmrc.test.ui.specs.BaseSpec
import uk.gov.hmrc.test.ui.specs.Tags.Pagination

class PaginationTestSpec  extends AnyFeatureSpec
  with BaseSpec
  with GivenWhenThen
  with ShouldVerb
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Browser
  with TableDrivenPropertyChecks
  with ScreenshotOnFailure {
Feature("Validate Dashboard and Declaration Information"){
  /*Below scenario -
  1. creates the number of declarations that we want by passing the number from step def
  2. Submit the created declarations and validates the pagination component is present
   */
  Scenario("Full Standard Journey and view declaration in submission dashboard",Pagination){
    Given("the user clears data in cache")
    background()
    When("User fills all sections of the declaration and submits the declaration to land on Saved-Summary page")
    fillAllSectionsForDeclaration("STANDARD", "prelodged")
    Then("User checks the section headings and continue to validate details on declaration information page")
    checksTheSectionHeadingsAndContinueToValidateDetails()
    When("User creates 30 draft declarations")
    createDraftDeclarations(30)
    And("User clicks the Back to Your Declarations link")
    DeclarationInformationPage.backToYourDeclarationsLink()
    Then("User validates the functionality of the pagination component")
    DashboardPage.viewPaginationComponent()
  }
}
}
