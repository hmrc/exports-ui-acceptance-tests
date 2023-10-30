/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.cucumber.utils.MongoOps

class MongoStepDef extends BaseStepDef {

  Given("""^I load (.*) record into DB for (.*)""") { (eori: String, message: String) =>
    val messages: List[String] = message match {
      case "exports" => List("cm-exports")
      case "imports" => List("cm-imports")
      case _         => List("cm-other")
    }
    MongoOps.insertMessages(messages, eori)
  }
}
