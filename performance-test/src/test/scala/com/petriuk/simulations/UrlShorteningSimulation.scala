package com.petriuk.simulations

import com.petriuk.config.Config._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps
import scala.reflect.io.File
import scala.util.Random

class UrlShorteningSimulation extends Simulation {

  val addDataScenario = scenario("Add urls and save the hashes to the local cache")
    .exec { session =>
      val newSession = session.set("hashes", List("hash"))
      newSession
    }
    .repeat(records) {
      exec(session => session.set("url", Random.alphanumeric.take(10).mkString))
        .exec(http("Add data")
          .post("/shorten")
          .body(StringBody("{\"originalUrl\": \"https://www.${url}.com\"}"))
          .check(jsonPath("$.hash").saveAs("hash"))
          .check(status.is(200))
        )
        .exec(session => {
          val hash = session("hash").as[String]
          session.set("hashes", session("hashes").as[List[String]] :+ hash)
        })
    }
    .exec(session => {
      File(tmpFileLocation).appendAll(session("hashes").as[Seq[String]].mkString("\n"))
      session
    })

  setUp(addDataScenario.inject(atOnceUsers(1))).protocols(httpConf)

}
