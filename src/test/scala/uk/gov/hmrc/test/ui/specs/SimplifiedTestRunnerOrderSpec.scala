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
import uk.gov.hmrc.test.ui.specs.Section1.SimplifiedJourneySpec as Simplified1
import uk.gov.hmrc.test.ui.specs.Section2.SimplifiedJourneySpec as Simplified2
import uk.gov.hmrc.test.ui.specs.Section3.SimplifiedJourneySpec as Simplified3
import uk.gov.hmrc.test.ui.specs.Section4.SimplifiedJourneySpec as Simplified4
import uk.gov.hmrc.test.ui.specs.Section5.SimplifiedJourneySpec as Simplified5
import uk.gov.hmrc.test.ui.specs.Section6.SimplifiedJourneySpec as Simplified6

class SimplifiedTestRunnerOrderSpec extends Suites(
new Simplified1,
  new Simplified2,
  new Simplified3,
  new Simplified4,
  new Simplified5,
  new Simplified6
)

