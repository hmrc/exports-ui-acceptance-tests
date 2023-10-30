/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.driver

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import uk.gov.hmrc.webdriver.SingletonDriver

trait BrowserDriver extends LazyLogging {
  logger.info(
    s"Instantiating Browser: ${sys.props.getOrElse("browser", "'browser' System property not set. This is required")}"
  )

  val options = new ChromeOptions()
  options.addArguments("--remote-allow-origins=*")

  implicit lazy val driver: WebDriver = SingletonDriver.getInstance(Some(options))
}
