/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

object UnAuthorisedPage extends BasePage {

  val unAuthorisedPageTitle =
    "To continue, you need to get access to the Customs Declaration Service (CDS) - CDS document uploads and secure messages - GOV.UK"

  def validateUnAuthorisedPage(): Unit =
    onPage(unAuthorisedPageTitle)
}
