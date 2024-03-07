package uk.gov.hmrc.test.ui.pages.base

import scala.collection.mutable

case class DetailKey(label: String, sectionId: Int, additionalId: Option[String] = None)

trait DeclarationDetails

case class Detail(value: String) extends DeclarationDetails
case class Details(values: Seq[String]) extends DeclarationDetails

object DeclarationDetails {

  type Cache = mutable.Map[DetailKey, DeclarationDetails]

  val cache: Cache = mutable.Map.empty[DetailKey, DeclarationDetails]
}
