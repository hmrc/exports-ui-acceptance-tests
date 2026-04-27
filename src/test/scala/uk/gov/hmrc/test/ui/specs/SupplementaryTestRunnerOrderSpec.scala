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
import uk.gov.hmrc.test.ui.specs.Section1.SupplementarySpec as Supplementary1
import uk.gov.hmrc.test.ui.specs.Section2.SupplementaryJourneySpec as Supplementary2
import uk.gov.hmrc.test.ui.specs.Section3.SupplementaryJourneySpec as Supplementary3
import uk.gov.hmrc.test.ui.specs.Section4.SupplementaryJourneySpec as Supplementary4
import uk.gov.hmrc.test.ui.specs.Section5.SupplementaryJourney5Spec as Supplementary5
import uk.gov.hmrc.test.ui.specs.Section6.SupplementaryJourneySpec as Supplementary6

class SupplementaryTestRunnerOrderSpec extends Suites(
  new Supplementary1,
  new Supplementary2,
  new Supplementary3,
  new Supplementary4,
  new Supplementary5,
  new Supplementary6
)
