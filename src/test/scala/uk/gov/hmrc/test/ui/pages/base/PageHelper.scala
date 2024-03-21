/*
 * Copyright 2023 HM Revenue & Customs
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

import scala.util.matching.Regex

trait PageHelper extends DriverHelper {

  private val initPart: String  = "/declaration"
  private val elementId: String = "[\\w]+"

  private val containerIdPattern: Regex = s"/$initPart/containers/($elementId)/.+".r
  protected def containerId: String     =
    (Option(driver.getCurrentUrl) collect { case containerIdPattern(group) => group }).head

  private val itemIdPattern: Regex = s"/$initPart/items/($elementId)/.+".r
  protected def itemId: String     = (Option(driver.getCurrentUrl) collect { case itemIdPattern(group) => group }).head

  protected def changeUrl(partId: String): String = s"$initPart/$partId/$elementId/change"

  protected def changeUrl(partId: String, additionalPartId: String): String =
    s"$initPart/$partId/$elementId/$additionalPartId/$elementId/change"

  protected def itemUrl(partId: String): String = s"$initPart/items/$elementId/$partId"
  protected def pathUrl(partId: String): String = s"$initPart/$partId/$elementId"

  protected def removeUrl(partId: String): String = s"$initPart/$partId/$elementId/remove"

  protected def removeUrl(partId: String, additionalPartId: String): String =
    s"$initPart/$partId/$elementId/$additionalPartId/$elementId/remove"
}