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
import uk.gov.hmrc.test.ui.specs.Section1.ClearanceJourneySpec as Clearance1
import uk.gov.hmrc.test.ui.specs.Section2.ClearanceJourneySpec as Clearance2
import uk.gov.hmrc.test.ui.specs.Section3.ClearanceJourneySpec as Clearance3
import uk.gov.hmrc.test.ui.specs.Section4.ClearanceJourneySpec as Clearance4
import uk.gov.hmrc.test.ui.specs.Section5.ClearanceJourneySpec as Clearance5
import uk.gov.hmrc.test.ui.specs.Section6.ClearanceJourneySpec as Clearance6

class ClearanceTestRunnerOrderSpec extends Suites(
  new Clearance1,
  new Clearance2,
  new Clearance3,
  new Clearance4,
  new Clearance5,
  new Clearance6
)