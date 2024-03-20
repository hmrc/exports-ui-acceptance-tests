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

package uk.gov.hmrc.test.ui.pages.base

object Constants {

  // Required for multi-value pages, like "Package Information", "Additional Information", "Containers", ...
  // The page sequence must be always at zero-position in the list of values passed to "fillPage".
  val sequenceId = 0

  // Zero-position of the parameter passed to fillPage for Yes/No Pages
  val yesNo = 0

  val yes  = "Yes"
  val no   = "No"
  val none = "None"

  val Common = "COMMON" // Used for the tariff expander only

  val Clearance     = "Customs clearance request (C21)"
  val Occasional    = "Simplified declaration (occasional use)"
  val Simplified    = "Simplified declaration (regular use)"
  val Standard      = "Standard declaration"
  val Supplementary = "Supplementary declaration"

  val Arrived   = "arrived"
  val Prelodged = "prelodged"

  val NonEidr = "simplified"
  val Eidr    = "eidr"

  // Generally we need to pass different values for a drop down and the cache
  // ex : for countries
  val enteredValue = 0
  val storedValue  = 1

  val Address = List("XYZ Carrier", "School Road", "London", "WS1 2AB", "Ukraine - UA")
}
