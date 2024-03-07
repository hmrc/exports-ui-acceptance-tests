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

  def detail(detailKey: DetailKey): Detail = cache(detailKey) match { case (value: Detail) => value }

  def details(detailKey: DetailKey): Details = cache(detailKey) match { case (values: Details) => values }

  def maybeDetail(detailKey: DetailKey): Option[Detail] =
    cache.get(detailKey) match {
      case Some(value: Detail) => Some(value)
      case _                   => None
    }

  def maybeDetails(detailKey: DetailKey): Option[Details] =
    cache.get(detailKey) match {
      case Some(values: Details) => Some(values)
      case _                     => None
    }

  def store(elements: (DetailKey, DeclarationDetails)*): Cache = cache.addAll(elements)
}
