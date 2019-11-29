package com.evolutiongaming.kafka

import org.scalatest.funsuite.AnyFunSuite

class StartKafkaSpec extends AnyFunSuite {

  test("start and stop kafka") {
    val shutdown = StartKafka()
    shutdown()
  }
}
