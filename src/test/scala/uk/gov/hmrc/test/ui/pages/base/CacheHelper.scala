package uk.gov.hmrc.test.ui.pages.base

import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{Cache, cache}

trait CacheHelper {

  def allSectionDetails(sectionId: Int, maybeAdditionalId: Option[String] = None): Cache =
    maybeAdditionalId.fold(cache.filter(_._1.sectionId == sectionId)) { additionalId =>
      cache.filter { case (detailKey: DetailKey, _) =>
        detailKey.sectionId == sectionId && detailKey.additionalId.contains(additionalId)
      }
    }

  def clear(): Unit = cache.clear()

  def clear(sectionId: Int): Cache = cache --= allSectionDetails(sectionId).keys

  def clear(detailKeys: DetailKey*): Cache = cache --= detailKeys

  // Use a detailKey to retrieve the value of a Detail (a Detail corresponds to a single value)
  def detail(detailKey: DetailKey): String = cache(detailKey) match { case (detail: Detail) => detail.value }

  // Use a detailKey to retrieve the values of a Details (a Details corresponds to a list of values)
  def details(detailKey: DetailKey): Seq[String] = cache(detailKey) match { case (details: Details) => details.values }

  def maybeDetail(detailKey: DetailKey): Option[String] =
    cache.get(detailKey) match {
      case Some(detail: Detail) => Some(detail.value)
      case _                   => None
    }

  def maybeDetails(detailKey: DetailKey): Option[Seq[String]] =
    cache.get(detailKey) match {
      case Some(details: Details) => Some(details.values)
      case _                     => None
    }

  def store(elements: (DetailKey, DeclarationDetails)*): Cache = cache.addAll(elements)
}