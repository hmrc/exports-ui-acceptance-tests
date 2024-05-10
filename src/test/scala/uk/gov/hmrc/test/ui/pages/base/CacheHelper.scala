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

import uk.gov.hmrc.test.ui.pages.base.DeclarationDetails.{Cache, cache, changeLinks}
import uk.gov.hmrc.test.ui.pages.section5.DetailsKeys.section5

trait CacheHelper {

  protected def path: String
  protected def changeLink: String = path

  def clear(): Unit = cache.clear()

  def clear(sectionId: Int, maybeId: Option[String] = None): Cache =
    cache --= allSectionDetails(sectionId, maybeId).keys

  // To use when the detailKeys provided are expected to be in the cache
  def clear(detailKeys: DetailKey*): Cache = {
    val size = cache.size
    cache --= detailKeys
    assert(
      cache.size == size - detailKeys.size,
      s"One or more of the DetailKey(s) to clear were not found in the cache"
    )
    cache
  }

  // To use when the detailKeys provided can also not be in the cache
  def clearIfAny(detailKeys: DetailKey*): Cache = cache --= detailKeys

  def detailKeys(labels: String*): Seq[DetailKey] = cache.filter(kv => labels.contains(kv._1.label)).keys.toList

  // Use a detailKey to retrieve the value of a Detail (a Detail corresponds to a single value)
  def detail(detailKey: DetailKey): String =
    cache(detailKey) match {
      case detail: Detail => detail.value
      case _ => assert(false, s"Cache does not contain a value for $detailKey"); ""
    }

  // Use a detailKey to retrieve the values of a Details (a Details corresponds to a list of values)
  def details(detailKey: DetailKey): Seq[String] =
    cache(detailKey) match {
      case details: Details => details.values
      case _ => assert(false, s"Cache does not contain a value for $detailKey"); List.empty
    }

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

  def allSectionDetails(sectionId: Int, maybeId: Option[String] = None): Cache =
    maybeId.fold(cache.filter(_._1.sectionId == sectionId)) { id =>
      cache.filter { case (detailKey: DetailKey, _) =>
        detailKey.sectionId == sectionId && detailKey.id.contains(id)
      }
    }

  def detailForLabel(sectionId: Int, label: String): Seq[String] =
    allSectionDetails(sectionId).filter(_._1.label == label).values.flatMap {
      case detail: Detail => Some(detail.value)
      case _              => None
    }.toList

  def detailsForLabel(sectionId: Int, label: String): Seq[Seq[String]] =
    allSectionDetails(sectionId).filter(_._1.label == label).values.flatMap {
      case details: Details => Some(details.values)
      case _              => None
    }.toList

  def itemDetailFor(itemId: String, label: String): Seq[String] =
    allSectionDetails(section5, Some(itemId)).filter(_._1.label == label).values.flatMap {
      case detail: Detail => Some(detail.value)
      case _              => None
    }.toList

  def itemDetailsFor(itemId: String, label: String): Seq[Seq[String]] =
    allSectionDetails(section5, Some(itemId)).filter(_._1.label == label).values.flatMap {
      case details: Details => Some(details.values)
      case _              => None
    }.toList

  def listOfItemDetailFor(label: String): Seq[String] =
    allSectionDetails(section5).filter(_._1.label == label).values.flatMap {
      case detail: Detail => Some(detail.value)
      case _              => None
    }.toList

  def listOfItemDetailsFor(label: String): Seq[Seq[String]] =
    allSectionDetails(section5).filter(_._1.label == label).values.flatMap {
      case details: Details => Some(details.values)
      case _                => None
    }.toList

  def store(elements: (DetailKey, DeclarationDetails)*): Cache = {
    cache.addAll(elements)
    elements.foreach(element => if (element._1.checkChangeLink) changeLinks += (element._1 -> changeLink))
    cache
  }
}
