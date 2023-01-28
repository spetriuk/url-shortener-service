package com.petriuk.config

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import java.lang

object Config {
  val tmpFileLocation = "src/test/resources/data/hashes.csv"
  val startUsers: Double = sys.props.get("startUsers").map(_.toDouble).getOrElse(1.0)
  val endUsers: Double = sys.props.get("endUsers").map(_.toDouble).getOrElse(1.0)
  val time: lang.Long = java.lang.Long.getLong("time", 30)
  val records: Int = Integer.getInteger("records", 1000).intValue()
  val host: String = sys.props.get("host").getOrElse("http://localhost:8080/api/url")

  val httpConf = http
    .baseUrl(host)
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

}
