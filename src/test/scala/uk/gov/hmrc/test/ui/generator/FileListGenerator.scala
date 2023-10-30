/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.generator

class FileListGenerator {

  def oneFile(): List[String] = Seq("example.PDF").toList

  def errorMessageOneFileTest(filename: String): List[String] = Seq(s"$filename").toList

  def fourFiles(): List[String] =
    Seq(
      "example.PDF",
      "example.png",
      "example.jpg",
      "exampleTextFile.txT"
    ).toList
}
