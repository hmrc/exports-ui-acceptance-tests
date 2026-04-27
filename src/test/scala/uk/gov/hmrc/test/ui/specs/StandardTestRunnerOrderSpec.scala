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
import uk.gov.hmrc.test.ui.specs.Section1.StandardJourneySpec as Standard1
import uk.gov.hmrc.test.ui.specs.Section2.StandardJourneySpec as Standard2
import uk.gov.hmrc.test.ui.specs.Section3.StandardJourneySpec as Standard3
import uk.gov.hmrc.test.ui.specs.Section4.StandardJourneySpec as Standard4
import uk.gov.hmrc.test.ui.specs.Section5.StandardJourneySpec as Standard5
import uk.gov.hmrc.test.ui.specs.Section6.StandardJourneySpec as Standard6

class StandardTestRunnerOrderSpec extends Suites(
  new Standard1,
  new Standard2,
  new Standard3,
  new Standard4,
  new Standard5,
  new Standard6
)
