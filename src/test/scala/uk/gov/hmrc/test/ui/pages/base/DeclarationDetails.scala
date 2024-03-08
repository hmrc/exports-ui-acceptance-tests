package uk.gov.hmrc.test.ui.pages.base

import scala.collection.mutable

case class DetailKey(label: String, sectionId: Int, id: Option[String] = None, additionalId: Option[String] = None)

trait DeclarationDetails

case class Detail(value: String) extends DeclarationDetails
case class Details(values: Seq[String]) extends DeclarationDetails

object DeclarationDetails {

  type Cache = mutable.Map[DetailKey, DeclarationDetails]

  val cache: Cache = mutable.LinkedHashMap.empty[DetailKey, DeclarationDetails]
}
