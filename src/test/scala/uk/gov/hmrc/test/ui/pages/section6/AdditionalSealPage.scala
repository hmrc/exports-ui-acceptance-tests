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
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.Seals

object AdditionalSealPage extends BasePage {

  def path: String           = s"/declaration/containers/$containerId/add-seals"
  def title                  = s"What is the security seal for container $containerId"
  def backButtonHref: String = SealsChoicePage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(containersSeals),
    Clearance -> List(containersSealsCL)
  )

  private val id = 0

  override def fillPage(values: String*): Unit = {
    val seal  = values(id)
    fillTextBoxById("id", seal)
    val seals = maybeDetails(Seals(containerId)).fold(Seq(seal))(_ :+ seal)
    store(Seals(containerId) -> Details(seals))
  }
}
