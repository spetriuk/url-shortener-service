package com.petriuk.simulations;

import com.petriuk.config.Config._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps

class GetUrlSimulation extends Simulation {

  val getDataScenario = scenario("Simulate the users trying to get full url by hash")
    .feed(csv(tmpFileLocation).random)
      .exec(http("Get data")
        .get("/${hash}")
        .check(status.is(200))
      )

  setUp(getDataScenario.inject(constantUsersPerSec(endUsers) during time)).protocols(httpConf)

}
