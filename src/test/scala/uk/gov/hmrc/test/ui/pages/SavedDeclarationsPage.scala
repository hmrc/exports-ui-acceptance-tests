/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.jdk.CollectionConverters._

object SavedDeclarationsPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/saved-declarations"
  val homePageTitle = "Your saved declarations - Make an export declaration online - GOV.UK"

  val backToSelectionPageNavigationLink = "back-link"

  def declarationLinks()(implicit driver: WebDriver): List[WebElement] = driver.findElements(By.cssSelector("""a[href*="saved-declarations/"]""")).asScala.toList


  def clickDraftDeclarationByUsingDUCR(ducr: String): Unit = {
    SavedDeclarationsPage.onPage(homePageTitle)
    val obtainedDucrLink = declarationLinks().find(_.getText.contains(ducr)).getOrElse(fail(s"Could not find declaration $ducr on list"))
    obtainedDucrLink.click()
    }

}
