/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.utils

import scala.util.Random
import io.circe.{Decoder, Encoder}

object YesNoEnum extends Enumeration {

  type YesNoEnum = Value

  val YES: YesNoEnum = Value("Yes")
  val NO: YesNoEnum = Value("No")

  implicit val decoder: Decoder[YesNoEnum.Value] = Decoder.decodeEnumeration(YesNoEnum)
  implicit val encoder: Encoder[YesNoEnum.Value] = Encoder.encodeEnumeration(YesNoEnum)

  def random: YesNoEnum = YesNoEnum(Random.nextInt(YesNoEnum.maxId))
}
