/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.scalatest.matchers.should.Matchers
import org.scalatest.concurrent.Eventually
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import io.cucumber.scala.{EN, ScalaDsl}
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try

trait BaseStepDef extends ScalaDsl with EN with BrowserDriver with Eventually with Matchers {

  sys.addShutdownHook {
    Try(SingletonDriver.closeInstance())
  }
}
