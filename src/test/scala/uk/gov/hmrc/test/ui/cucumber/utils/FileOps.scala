/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.utils

import com.typesafe.scalalogging.LazyLogging

import java.io.File
import scala.io.Source

object FileOps extends LazyLogging {

  def fileAsString(fileName: String): String = {

    val source = scala.io.Source.fromFile(fileName)
    val jsonAsString = source.mkString
    source.close()

    jsonAsString
  }

  def readFile(filename: String): Seq[String] = {

    val bufferedSource = Source.fromFile(filename)
    val lines = bufferedSource.getLines().toSeq
    bufferedSource.close()

    lines
  }

  def removeFiles(folder: String, extension: String): Unit = {

    logger.info(s"-> cleaning folder: $folder, extension: $extension")

    for {
      files <- Option(new File(folder).listFiles)
      file <- files if file.getName.endsWith(extension)
    } file.delete()
  }
}
