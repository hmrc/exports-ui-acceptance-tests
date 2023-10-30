/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.utils

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import play.api.libs.json.JsValue
import play.api.libs.ws.JsonBodyWritables.writeableOf_JsValue
import play.api.libs.ws.{StandaloneWSRequest, WSCookie}
import play.api.libs.ws.ahc.{AhcWSClientConfigFactory, StandaloneAhcWSClient}

import scala.concurrent.Future

object WSClient {
  private implicit val system: ActorSystem = ActorSystem()
  private val wsClient = StandaloneAhcWSClient(config = AhcWSClientConfigFactory.forConfig(ConfigFactory.load()))


  def httpGet(url: String, cookie: Set[WSCookie]=Set.empty, headers: Seq[(String, String)]=Nil): Future[StandaloneWSRequest#Response] = {
    def request(url: String): StandaloneWSRequest = {
      wsClient.url(url)
    }
    request(url).addHttpHeaders(headers:_*).withCookies(cookie.toSeq:_*).get()
  }

  def httpPost(url: String, requestBody: JsValue, headers: (String, String)*) = {
    def request(url: String): StandaloneWSRequest = {
      wsClient.url(url)
    }
    request(url).withHttpHeaders(headers: _*).post(requestBody)
  }

}
