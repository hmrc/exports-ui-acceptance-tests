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

package uk.gov.hmrc.test.ui.pages.section5

import uk.gov.hmrc.test.ui.pages.base.Constants.Common
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{itemsStatisticalValue, itemsStatisticalValue1, itemsStatisticalValue2}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.StatisticalValue

object StatisticalValuePage extends BasePage {

  def backButtonHref: String = NationalAdditionalCodesListPage.path
  def path: String = itemUrl("statistical-value")
  val title: String = "What is the statistical value of this item in pounds?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common -> List(itemsStatisticalValue, itemsStatisticalValue1, itemsStatisticalValue2)
  )

  // ex: fillPage("1000")

  override def fillPage(values: String*): Unit = {

    fillTextBoxById("statisticalValue", values.head)

    if (values.head.isEmpty)
      store(StatisticalValue(itemId) -> Detail("None"))
    else
      store(StatisticalValue(itemId) -> Detail(values.head))
  }
}
