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
import uk.gov.hmrc.test.ui.specs.Section1.SupplementarySpec as Supplementary1
import uk.gov.hmrc.test.ui.specs.Section1.{ClearanceJourneySpec as Clearence1, OccasionalJourneySpec as Occasional1, SimplifiedJourneySpec as Simplified1, StandardJourneySpec as Standard1}
import uk.gov.hmrc.test.ui.specs.Section2.{ClearanceJourneySpec as Clearance2, OccasionalJourneySpec as Occasional2, SimplifiedJourneySpec as Simplified2, StandardJourneySpec as Standard2, SupplementaryJourneySpec as Supplementary2}
import uk.gov.hmrc.test.ui.specs.Section3.{ClearanceJourneySpec as Clearance3, OccasionalJourneySpec as Occasional3, SimplifiedJourneySpec as Simplified3, StandardJourneySpec as Standard3, SupplementaryJourneySpec as Supplementary3}
import uk.gov.hmrc.test.ui.specs.Section4.{ClearanceJourneySpec as Clearance4, OccasionalJourneySpec as Occasional4, SimplifiedJourneySpec as Simplified4, StandardJourneySpec as Standard4, SupplementaryJourneySpec as Supplementary4}
import uk.gov.hmrc.test.ui.specs.Section5.{ClearanceJourneySpec as Clearance5, OccasionalJourneySpec as Occasional5, SimplifiedJourneySpec as Simplified5, StandardJourneySpec as Standard5, SupplementaryJourney5Spec as Supplementary5}
import uk.gov.hmrc.test.ui.specs.Section6.{ClearanceJourneySpec as Clearance6, OccasionalJourneySpec as Occasional6, SimplifiedJourneySpec as Simplified6, StandardJourneySpec as Standard6, SupplementaryJourneySpec as Supplementary6}

class RegressionTestRunnerOrderSpec extends Suites(
  new AmendSpec,
  new DashboardSpec,
  new RejectedNotificationsSpec,
  new Clearence1,
  new Occasional1,
  new Simplified1,
  new Standard1,
  new Supplementary1,
  new Clearance2,
  new Occasional2,
  new Simplified2,
  new Standard2,
  new Supplementary2,
  new Clearance3,
  new Occasional3,
  new Simplified3,
  new Standard3,
  new Supplementary3,
  new Clearance4,
  new Occasional4,
  new Simplified4,
  new Standard4,
  new Supplementary4,
  new Clearance5,
  new Occasional5,
  new Simplified5,
  new Standard5,
  new Supplementary5,
  new Clearance6,
  new Occasional6,
  new Simplified6,
  new Standard6,
  new Supplementary6
)
