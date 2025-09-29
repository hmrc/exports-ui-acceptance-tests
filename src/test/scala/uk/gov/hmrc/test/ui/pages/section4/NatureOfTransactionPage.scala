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

package uk.gov.hmrc.test.ui.pages.section4

import uk.gov.hmrc.test.ui.pages.base.Constants.{Common, Standard, Supplementary}
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.natureOfTransaction
import uk.gov.hmrc.test.ui.pages.base.{BasePage, Detail}
import uk.gov.hmrc.test.ui.pages.section1.DetailKeys.DeclarationType
import uk.gov.hmrc.test.ui.pages.section3.DestinationCountryPage.isGuernseyOrJerseyDestination
import uk.gov.hmrc.test.ui.pages.section4.DetailKeys.{NatureOfTransaction, TotalAmountInvoiced}

object NatureOfTransactionPage extends BasePage {

  val Sale = "Goods being sold"
  val BusinessPurchase = "Item purchased new in the UK for business use"

  def backButtonHref: String =
    detail(DeclarationType) match {
      case Standard | Supplementary
          if isGuernseyOrJerseyDestination && detail(TotalAmountInvoiced) == "Less than £100,000" =>
        InvoicesAndExchangeRateChoicePage.path
      case Standard | Supplementary if isGuernseyOrJerseyDestination => InvoicesAndExchangeRatePage.path
      case _                                                         => TotalPackageQuantityPage.path
    }

  val path: String = "/declaration/nature-of-transaction"
  val title = "What sort of export is it?"

  override val expanderHrefs: Map[String, Seq[String]] = Map(Common -> List(natureOfTransaction))

  // ex: fillPage("Goods being sold")
  //     fillPage("Item purchased")
  //     fillPage("...")

  override def fillPage(values: String*): Unit = {
    val label = values(0) match {
      case "Goods being sold"              => clickById("Sale"); Sale
      case "Item purchased"                => clickById("BusinessPurchase"); BusinessPurchase
      case "House removal"                 => clickById("HouseRemoval"); "House removal or not-new vehicle"
      case "A return or a replacement"     => clickById("Return"); "A return or a replacement, free of charge"
      case "Non Commercial change"         => clickById("Donation"); "Non-commercial change of ownership"
      case "Being sent out for processing" => clickById("Processing"); "Being sent out for processing"
      case "Goods have been processed"     => clickById("Processed"); "Goods have been processed"
      case "Inter Governmental"            => clickById("Military"); "Inter-governmental or defence purposes"

      case "Goods for construction or civil engineering" =>
        clickById("Construction"); "Goods supplied under a contract for construction purposes"

      case _ => clickById("Other"); "Other"
    }

    store(NatureOfTransaction -> Detail(label))
  }
}
