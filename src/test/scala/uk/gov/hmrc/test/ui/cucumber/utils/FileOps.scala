/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.utils

import com.typesafe.scalalogging.LazyLogging

import java.io.File
import scala.io.Source

object FileOps extends LazyLogging {

  def fileAsString(fileName: String): String = {

    val source       = scala.io.Source.fromFile(fileName)
    val jsonAsString = source.mkString
    source.close()

    jsonAsString
  }

  def readFile(filename: String): Seq[String] = {

    val bufferedSource = Source.fromFile(filename)
    val lines          = bufferedSource.getLines().toSeq
    bufferedSource.close()

    lines
  }

  def removeFiles(folder: String, extension: String): Unit = {

    logger.info(s"-> cleaning folder: $folder, extension: $extension")

    for {
      files <- Option(new File(folder).listFiles)
      file  <- files if file.getName.endsWith(extension)
    } file.delete()
  }
}
