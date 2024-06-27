/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.io.FileHandler.{copy, createDir}
import org.openqa.selenium.{OutputType, TakesScreenshot}
import uk.gov.hmrc.selenium.webdriver.{Browser, Driver}
import uk.gov.hmrc.test.ui.conf.TestConfiguration.setBrowser

import java.io.File

object Hooks extends ScalaDsl with EN with Browser {

  BeforeAll {
    setBrowser()
    startBrowser()
    Driver.instance.manage().deleteAllCookies()
  }

  private def captureScreenshot(screenshotName: String, screenshotDirectory: String): Unit = {
    val tmpFile = Driver.instance.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    val screenshotFile = new File(screenshotDirectory, screenshotName)

    createDir(new File(screenshotDirectory))
    copy(tmpFile, screenshotFile)
  }

  After { scenario: Scenario =>
//    logger.info(s"After scenario -> ${scenario.getName}")
    if (scenario.isFailed) {
      val testName = scenario.getName.replaceAll(" ", "-").replaceAll(":", "")
      val screenshotName = testName + ".png"
      val screenshotDirectory = "./target/screenshots/"
      captureScreenshot(screenshotName, screenshotDirectory)
      scenario.attach(screenshotName, "image/png", testName)
    }
  }


  AfterAll {
    quitBrowser()
  }
}
