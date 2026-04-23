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
import uk.gov.hmrc.test.ui.specs.Section3.{ClearanceJourneySpec as Clearance3, OccasionalJourneySpec as Occasional3, SimplifiedJourneySpec as Simplified3, StandardJourneySpec as Standard3, SupplementaryJourneySpec as Supplementary3}

class Section3TestRunnerOrderSpec extends Suites(
  new Clearance3,
  new Occasional3,
  new Simplified3,
  new Standard3,
  new Supplementary3
)
