/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.base.BasePage

import scala.jdk.CollectionConverters._

object SavedDeclarationsPage extends BasePage {

  val path: String   = "/saved-declarations"
  val title = "Your saved declarations - Make an export declaration online - GOV.UK"

  val backToSelectionPageNavigationLink = "back-link"

  def declarationLinks()(implicit driver: WebDriver): List[WebElement] =
    driver.findElements(By.cssSelector("""a[href*="saved-declarations/"]""")).asScala.toList

  def clickDraftDeclarationByUsingDUCR(ducr: String): Unit = {
    SavedDeclarationsPage.checkUrlAndTitle(title)
    val obtainedDucrLink =
      declarationLinks().find(_.getText.contains(ducr)).getOrElse(fail(s"Could not find declaration $ducr on list"))
    obtainedDucrLink
  }

}
