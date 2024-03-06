package uk.gov.hmrc.test.ui.pages.base

import scala.collection.mutable

object DeclarationDetails {

  val cache: mutable.Map[String, String] = mutable.Map.empty[String, String]

  val DepartureTransportId = "departureTransportId"
  val DepartureTransportValue = "departureTransportValue"

  val DeclarationChoiceId = "declarationChoiceId"
  val DeclarationChoiceValue = "declarationChoiceValue"
}
