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
import uk.gov.hmrc.test.ui.specs.Section1.OccasionalJourneySpec as Occasional1
import uk.gov.hmrc.test.ui.specs.Section2.OccasionalJourneySpec as Occasional2
import uk.gov.hmrc.test.ui.specs.Section3.OccasionalJourneySpec as Occasional3
import uk.gov.hmrc.test.ui.specs.Section4.OccasionalJourneySpec as Occasional4
import uk.gov.hmrc.test.ui.specs.Section5.OccasionalJourneySpec as Occasional5
import uk.gov.hmrc.test.ui.specs.Section6.OccasionalJourneySpec as Occasional6


class OccasionalTestRunnerOrderSpec extends Suites(
  new  Occasional1,
  new Occasional2,
  new Occasional3,
  new Occasional4,
  new Occasional5,
  new Occasional6
)
