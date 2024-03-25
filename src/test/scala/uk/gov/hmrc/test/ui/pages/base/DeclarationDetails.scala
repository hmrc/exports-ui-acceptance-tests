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

import scala.collection.mutable

case class DetailKey(
  label: String,
  sectionId: Int,
  id: Option[String] = None,
  additionalId: Option[String] = None,

  // Flags specifying what validation must be skipped, or not, on the related mini-CYA page
  // skipRowCheck(true) implies skipValueCheck(true) and checkChangeLink(false)
  skipRowCheck: Boolean = false,
  skipValueCheck: Boolean = false,
  checkChangeLink: Boolean = true
)

trait DeclarationDetails

case class Detail(value: String) extends DeclarationDetails
case class Details(values: Seq[String]) extends DeclarationDetails

object DeclarationDetails {

  type Cache = mutable.Map[DetailKey, DeclarationDetails]

  val cache: Cache = mutable.LinkedHashMap.empty[DetailKey, DeclarationDetails]

  val changeLinks = mutable.Map.empty[DetailKey, String]
}
