/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.base

import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{cache, cacheForAmendments, changeLinks, Cache}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.section5

trait CacheHelper {

  protected def path: String
  protected def changeLink: String = path

  def startAmendmentMode(): Unit = cacheForAmendments.addAll(cache.iterator)

  def isAmendmentMode: Boolean = cacheForAmendments.nonEmpty

  def getCache: Cache =
    if (isAmendmentMode) cacheForAmendments else cache

  def clear(): Unit = getCache.clear()

  def clearAllCaches(): Unit = {
    cache.clear()
    cacheForAmendments.clear()
  }

  def clear(sectionId: Int, maybeId: Option[String] = None): Cache =
    getCache --= allSectionDetails(sectionId, maybeId).keys

  // To use when the detailKeys provided are expected to be in the cache
  def clear(detailKeys: DetailKey*): Cache = {
    val size = getCache.size
    getCache --= detailKeys
    assert(
      getCache.size == size - detailKeys.size,
      s"One or more of the DetailKey(s) to clear were not found in the cache"
    )
    getCache
  }

  // To use when the detailKeys provided can also not be in the cache
  def clearIfAny(detailKeys: DetailKey*): Cache = getCache --= detailKeys

  def detailKeys(labels: String*): Seq[DetailKey] = getCache.filter(kv => labels.contains(kv._1.label)).keys.toList

  // Use a detailKey to retrieve the value of a Detail (a Detail corresponds to a single value)
  def detail(detailKey: DetailKey): String =
    getCache(detailKey) match {
      case detail: Detail => detail.value
      case _              => assert(false, s"Cache does not contain a value for $detailKey"); ""
    }

  // Use a detailKey to retrieve the values of a Details (a Details corresponds to a list of values)
  def details(detailKey: DetailKey): Seq[String] =
    getCache(detailKey) match {
      case details: Details => details.values
      case _                => assert(false, s"Cache does not contain a value for $detailKey"); List.empty
    }

  def maybeDetail(detailKey: DetailKey): Option[String] =
    getCache.get(detailKey) match {
      case Some(detail: Detail) => Some(detail.value)
      case _                    => None
    }

  def maybeDetails(detailKey: DetailKey): Option[Seq[String]] =
    getCache.get(detailKey) match {
      case Some(details: Details) => Some(details.values)
      case _                      => None
    }

  def allSectionDetails(sectionId: Int, maybeId: Option[String] = None): Cache =
    maybeId.fold(getCache.filter(_._1.sectionId == sectionId)) { id =>
      getCache.filter { case (detailKey: DetailKey, _) =>
        detailKey.sectionId == sectionId && detailKey.id.contains(id)
      }
    }

  def detailForLabel(sectionId: Int, label: String): Seq[String] =
    allSectionDetails(sectionId)
      .filter(_._1.label == label)
      .values
      .flatMap {
        case detail: Detail => Some(detail.value)
        case _              => None
      }
      .toList

  def detailsForLabel(sectionId: Int, label: String): Seq[Seq[String]] =
    allSectionDetails(sectionId)
      .filter(_._1.label == label)
      .values
      .flatMap {
        case details: Details => Some(details.values)
        case _                => None
      }
      .toList

  def itemDetailFor(itemId: String, label: String): Seq[String] =
    allSectionDetails(section5, Some(itemId))
      .filter(_._1.label == label)
      .values
      .flatMap {
        case detail: Detail => Some(detail.value)
        case _              => None
      }
      .toList

  def itemDetailsFor(itemId: String, label: String): Seq[Seq[String]] =
    allSectionDetails(section5, Some(itemId))
      .filter(_._1.label == label)
      .values
      .flatMap {
        case details: Details => Some(details.values)
        case _                => None
      }
      .toList

  def listOfItemDetailFor(label: String): Seq[String] =
    allSectionDetails(section5)
      .filter(_._1.label == label)
      .values
      .flatMap {
        case detail: Detail => Some(detail.value)
        case _              => None
      }
      .toList

  def listOfItemDetailsFor(label: String): Seq[Seq[String]] =
    allSectionDetails(section5)
      .filter(_._1.label == label)
      .values
      .flatMap {
        case details: Details => Some(details.values)
        case _                => None
      }
      .toList

  def store(elements: (DetailKey, DeclarationDetails)*): Cache =
    if (isAmendmentMode) {
      cacheForAmendments.addAll(elements)
      cacheForAmendments
    } else {
      cache.addAll(elements)
      elements.foreach(element => if (element._1.checkChangeLink) changeLinks += (element._1 -> changeLink))
      cache
    }

  def storeOne(element: (DetailKey, DeclarationDetails), maybeChangeLink: Option[String] = None): Cache =
    if (isAmendmentMode) {
      cacheForAmendments.put(element._1, element._2)
      cacheForAmendments
    }
    else {
      cache.put(element._1, element._2)
      maybeChangeLink.map(changeLink => changeLinks += (element._1 -> changeLink))
      cache
    }
}
