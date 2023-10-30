/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.{OutputType, TakesScreenshot}
import uk.gov.hmrc.test.ui.cucumber.utils.MongoOps
import uk.gov.hmrc.test.ui.driver.BrowserDriver

class Hooks extends ScalaDsl with EN with BrowserDriver {
  After { scenario: Scenario =>
    if (scenario.isFailed) {
      val screenshotName = scenario.getName.replaceAll(" ", "_")
      val screenshot     = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.BYTES)
      scenario.attach(screenshot, "image/png", screenshotName)
    }
  }

  Before {
    driver.manage().deleteAllCookies()
    MongoOps.clearLocalMongoDB()
  }
}
