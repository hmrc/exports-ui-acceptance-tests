/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.generator.SupportGenerator
import uk.gov.hmrc.test.ui.pages.MrnEntryPage

class MrnEntryStepDef extends BaseStepDef {

  Given("""^I fill the Mrn page with valid (.*)$""") { (mrnType: String) =>
    mrnType match {
      case "mrn"         => MrnEntryPage.enterMRN(SupportGenerator.mrn)
      case "invalid mrn" => MrnEntryPage.enterMRN(SupportGenerator.noAccessMrn)
    }
  }

  Then("""^user is navigated to mrn page$""") { () =>
    MrnEntryPage.validateMrn()
  }

  Then("""^I submit MRN page with empty data$""") { () =>
    MrnEntryPage.clearMRN()
    MrnEntryPage.submit()
  }
}
