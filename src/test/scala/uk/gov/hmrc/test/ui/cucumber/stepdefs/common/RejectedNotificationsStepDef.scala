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

package uk.gov.hmrc.test.ui.cucumber.stepdefs.common

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.base.CommonPage.detail
import uk.gov.hmrc.test.ui.pages.common.RejectedNotificationPage
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.Lrn

class RejectedNotificationsStepDef extends BaseStepDef {

  And("""^I should land on Rejected-Notifications page""") { () =>
    RejectedNotificationPage.checkPage()
  }

  And("""^I click on Lrn change link to fix error""") { () =>
    RejectedNotificationPage.FixErrorsAndValidateWarning()
  }

  And("""^I validate Lrn error details on rejected notifications""") { () =>
    RejectedNotificationPage.validateErrorDetails(detail(Lrn))
  }

  And("""^I check updated Lrn error details on rejected notifications""") { () =>
    RejectedNotificationPage.validateUpdatedErrorDetails(detail(Lrn))
  }

  And("""^I navigate to check you answer from rejected notification page""") { () =>
    RejectedNotificationPage.checkYourAnswer()

  }

}
