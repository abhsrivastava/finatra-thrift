package com.abhi

import org.apache.thrift.protocol._
import org.apache.thrift.transport._
import Calculator._

object ThriftClient extends App {
  val transport = new TSocket("localhost", 9090)
  transport.open()
  val protocol = new TBinaryProtocol(transport)
  val client = new Client(protocol)
  val result = client.add(10, 20)
  println(result)
}