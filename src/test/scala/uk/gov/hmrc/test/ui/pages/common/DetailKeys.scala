/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.common

import uk.gov.hmrc.test.ui.pages.base.DetailKey

object DetailKeys {

  val sectionCommon = 7

  val MrnOnDashboard: DetailKey = DetailKey("Mrn on Dashboard", sectionCommon, skipRowCheck = true)
  var StatusOnDashboard: DetailKey = DetailKey("Status on Dashboard", sectionCommon, skipRowCheck = true)
  val DeclarationInfoPath: DetailKey = DetailKey("Declaration Info Path", sectionCommon, skipRowCheck = true)
  val RemoveSavedDecLink: DetailKey = DetailKey("Remove Saved Dec Link", sectionCommon, skipRowCheck = true)

  val AmendmentModeOnOff: DetailKey = DetailKey("Amendment Mode", sectionCommon, skipRowCheck = true)
}
