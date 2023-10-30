/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.utils

object Multiline {
  def prepare(value: String): String = value.replaceAll("(\\r\\n)|\\r|\\n", " ")
}
