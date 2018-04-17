package com.abhi

import Calculator._
import com.twitter.finagle._
import com.twitter.util.{Await, Awaitable, Duration, Future}
import com.twitter.conversions.time._

object ThriftClient extends App {
  val ep = Thrift.client.build[MethodPerEndpoint]("localhost:9090")
  val resultFuture : Future[Int] = ep.add(2, 10)
  val result = Await.result(resultFuture, 5 seconds)
  println(result)
}