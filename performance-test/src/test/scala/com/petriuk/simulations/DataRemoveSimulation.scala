package com.petriuk.simulations
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import com.petriuk.config.Config._
import scala.language.postfixOps
import scala.reflect.io.File
import io.gatling.core.scenario.Simulation

class DataRemoveSimulation extends Simulation {

  val cleanDataAfterTestScenario = scenario("Delete all data after test")
    .exec(http("Delete all data")
      .delete("")
      .check(status.is(200))
    )
    .exec(session => {
      val file = File(tmpFileLocation);
      file.delete()
      session
    })

  setUp(cleanDataAfterTestScenario.inject(atOnceUsers(1))).protocols(httpConf)

}
