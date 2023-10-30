/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

import io.cucumber.scala.{EN, ScalaDsl}
import uk.gov.hmrc.test.ui.cucumber.utils.MongoOps
import uk.gov.hmrc.test.ui.pages.SavedSummaryPage

class TestStepDefs extends ScalaDsl with EN {

  Given("""^I load the declaration in mongo with (.*),(.*),(.*)$""") { (eori: String, lrn: String, ducr: String) =>
    MongoOps.loadDraftDeclarationData(eori, lrn, ducr)
  }

  And("""^click change link to navigate to (.*)$""") { (pageToNavigate: String) =>
    pageToNavigate match {
      case "AreYouTheExporter" => SavedSummaryPage.clickChangeLink("declarantIsExporter-row")
      case "ExportersData"     => SavedSummaryPage.clickChangeLink("exporter-address-row")
      case _                   => "No change link matched"
    }
  }

  When("""change the data in the navigated page""") { () =>
    //AreYouTheExporterPage.validateData()
  }
  Then("""validate the data in the check your answers page""") { () => }
}
