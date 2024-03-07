package uk.gov.hmrc.test.ui.pages.base

import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.cache

trait CacheHelper {

  def clear(): Unit = cache.clear()

  def detail(id: String): Detail              =
    cache(id) match { case (value: Detail) => value }

  def details(id: String): Details            =
    cache(id) match { case (values: Details) => values }

  def itemDetail(id: String): Seq[Detail]     =
    cache.collect { case (key: String, value: Detail) if key.endsWith(s"/$id") => value }.toList

  def itemDetails(id: String): Seq[Details]   =
    cache.collect { case (key: String, values: Details) if key.endsWith(s"/$id") => values }.toList

  def maybeDetail(id: String): Option[Detail] =
    cache.get(id) match {
      case Some(value: Detail) => Some(value)
      case _                   => None
    }

  def maybeDetails(id: String): Option[Details] =
    cache.get(id) match {
      case Some(values: Details) => Some(values)
      case _                     => None
    }

  def store(elements: (String, DeclarationDetails)*): cache.type = cache.addAll(elements)
}
