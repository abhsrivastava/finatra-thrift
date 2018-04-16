package com.abhi

import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.routing.ThriftRouter
import com.twitter.finatra.thrift.filters._

object CalculatorServerMain extends CalculatorServer
class CalculatorServer extends ThriftServer {
  override def defaultFinatraThriftPort = ":9090"
  override def configureThrift(router: ThriftRouter) = {
    router
      .filter[LoggingMDCFilter]
      .filter[TraceIdMDCFilter]
      .filter[ThriftMDCFilter]
      .filter[AccessLoggingFilter]
      .filter[StatsFilter]
      .add[CalculatorController]
  }
}