/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specs

import org.scalatest.Suites
import uk.gov.hmrc.test.ui.specs.AmendScenarios.AmendSpec
import uk.gov.hmrc.test.ui.specs.Common.{DashboardSpec, RejectedNotificationsSpec}
import uk.gov.hmrc.test.ui.specs.Section6.{ClearanceJourneySpec as Clearance6, OccasionalJourneySpec as Occasional6, SimplifiedJourneySpec as Simplified6, StandardJourneySpec as Standard6, SupplementaryJourneySpec as Supplementary6}

class Regression3TestRunnerOrderSpec  extends Suites(
  new AmendSpec,
  new DashboardSpec,
  new RejectedNotificationsSpec,
  new Clearance6,
  new Occasional6,
  new Simplified6,
  new Standard6,
  new Supplementary6
)
