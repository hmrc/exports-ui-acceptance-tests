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

package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.Constants._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks._
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.ConditionChecksSection6._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys._

object ContainerPage extends BasePage {

  val path: String = "/declaration/container"

  def title =
    if (elementByIdDoesNotExist("code_yes")) "What is the container ID?"
    else "Are the goods in a container or containers?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(container),
    Clearance -> List(containerCL, containerCL1)
  )

  private def SupplementaryBackNavigation: String =
    if (
      (isInlandModeOfTransportPostalOrFixed && inlandOrBorderValue && !shouldSkipInlandOrBorder && !isGuernseyOrJersey)
      || (isGuernseyOrJersey && inlandOrBorderValue && !shouldSkipInlandOrBorder)
    )
      InlandOrBorderPage.path
    else if (
      !isInlandModeOfTransportPostalOrFixed && !isTransportLeavingBorderModePostalOrFixedOrRail && !isGuernseyOrJersey
    )
      TransportCountryPage.path
    else if (
      !isGuernseyOrJersey && isTransportLeavingBorderModeRail && inlandOrBorderValue && !shouldSkipInlandOrBorder
    )
      DepartureTransportPage.path
    else if (
      (!isGuernseyOrJersey && isTransportLeavingBorderModeRail && !inlandOrBorderValue) ||
      (shouldSkipInlandOrBorder && isTransportLeavingBorderModeRail)
    )
      BorderTransportPage.path
    else InlandModeOfTransportPage.path

  def backButtonHref: String =
    if (checkIfDecIsSup)
      SupplementaryBackNavigation
    else if (isExpressConsignment)
      TransportPaymentPage.path
    else
      ExpressConsignmentPage.path

  private val yesNo          = 0
  private val code           = 1
  private val additionalCode = 0

  private def saveContainerId(containerId: String): Unit = {
    fillTextBoxById("id", containerId)
    store(Container(containerId) -> Detail(containerId))
  }

  override def fillPage(values: String*): Unit =
    if (elementByIdDoesNotExist("code_yes")) saveContainerId(values(additionalCode))
    else if (selectYesOrNoRadio(values(yesNo))) saveContainerId(values(code))
    else store(NoContainers -> Detail("None"))
}
