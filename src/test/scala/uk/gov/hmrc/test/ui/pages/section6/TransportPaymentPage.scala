package uk.gov.hmrc.test.ui.pages.section6

import uk.gov.hmrc.test.ui.pages.base.DeclarationTypes._
import uk.gov.hmrc.test.ui.pages.base.TariffLinks.{transportPayment, transportPaymentCL}
import uk.gov.hmrc.test.ui.pages.base._
import uk.gov.hmrc.test.ui.pages.section6.DetailKeys.TransportPayment

object TransportPaymentPage extends BasePage {

  val path: String           = "/declaration/transport-payment"
  def title                  = "How did you pay for the express transport?"
  val backButtonHref: String = ExpressConsignmentPage.path

  override val expanderHrefs: Map[String, Seq[String]] = Map(
    Common    -> List(transportPayment),
    Clearance -> List(transportPaymentCL)
  )

  val paymentType = 0

  def performActionsAndStore(values: String*): Unit = {
    val elementId           = values(paymentType) match {
      case "Payment in cash"                      => "cash"
      case "Payment by credit card"               => "creditCard"
      case "Payment by cheque"                    => "cheque"
      case "Other"                                => "other"
      case "Electronic funds transfer"            => "eFunds"
      case "Account holder with carrier"          => "accHolder"
      case "Not pre-paid"                         => "notPrePaid"
      case "Payment information is not available" => "notAvailable"
      case _                                      => ""
    }
    clickById(elementId)
    val updatedSelectOption =
      if (elementId == "other") "Other (e.g. Direct debit to cash account)"
      else values(paymentType)
    store(TransportPayment -> Detail(updatedSelectOption))
  }
}