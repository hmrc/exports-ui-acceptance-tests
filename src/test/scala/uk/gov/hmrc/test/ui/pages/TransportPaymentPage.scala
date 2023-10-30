/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.conf.TestConfiguration

import scala.collection.immutable.HashMap

object TransportPaymentPage extends BasePage {

  val url: String = TestConfiguration.url("exports-frontend") + "/declaration/nature-of-transaction"
  val transportPaymentPageTitle = "How did you pay for the express transport?"
  var transportPaymentDetailsMap: Map[String, String] = HashMap[String, String]()

  def checkPageTitle(): Unit = {
    TransportPaymentPage.onPage(transportPaymentPageTitle)
  }

  def selectHowDoyouPayForTheExpressTransportOption(selectOption: String): Unit = {
    selectOption match {
      case "Payment in cash" => findElement("id", "cash").click()
      case "Payment by credit card" => findElement("id", "creditCard").click()
      case "Payment by cheque" => findElement("id", "cheque").click()
      case "Other" => findElement("id", "other").click()
      case "Electronic funds transfer" => findElement("id", "eFunds").click()
      case "Account holder with carrier" => findElement("id", "accHolder").click()
      case "Not pre-paid" => findElement("id", "notPrePaid").click()
      case "Payment information is not available" => findElement("id", "notAvailable").click()
    }
    transportPaymentDetailsMap += ("TransportPaymentDetails" -> selectOption)
    submit()
  }
}
