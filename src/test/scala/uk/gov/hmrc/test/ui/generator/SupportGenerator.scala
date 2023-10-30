/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.generator

import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicLong

object SupportGenerator {

  private val BIG_LETTERS         = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  private val SMALL_LETTERS       = "abcdefghijklmnopqrstuvwxyz"
  private val DIGITS              = "123456789"
  private val ALPHABET            = BIG_LETTERS + SMALL_LETTERS
  private val ALPHABET_AND_DIGITS = ALPHABET + DIGITS
  private val eoriCounter         = new AtomicLong(System.currentTimeMillis())
  val mrn: String                 = "22GB123456789AB012"
  val noAccessMrn: String         = "21GB49ANNFJUNO999******9"

  private def random: ThreadLocalRandom = ThreadLocalRandom.current()

  def generateEORI: String = "GB" + s"${eoriCounter.getAndIncrement()}".padTo(15, '0')

  def generateString(min: Int = 1, max: Int): String = {

    val howMany       = min + random.nextInt((max - min) + 1)
    val stringBuilder = new StringBuilder(max)

    for (_ <- 0 until howMany) stringBuilder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length)))

    stringBuilder.toString()
  }

  def generateDigits(min: Int = 1, max: Int): String = {

    val howMany       = min + random.nextInt((max - min) + 1)
    val stringBuilder = new StringBuilder(max)

    for (_ <- 0 until howMany) stringBuilder.append(DIGITS.charAt(random.nextInt(DIGITS.length)))

    stringBuilder.toString()
  }

  def generateAlphaNumeric(min: Int = 1, max: Int): String = {

    val howMany       = min + random.nextInt((max - min) + 1)
    val stringBuilder = new StringBuilder(max)

    for (_ <- 0 until howMany)
      stringBuilder.append(
        ALPHABET_AND_DIGITS.charAt(random.nextInt(ALPHABET_AND_DIGITS.length))
      )

    stringBuilder.toString()
  }
}
