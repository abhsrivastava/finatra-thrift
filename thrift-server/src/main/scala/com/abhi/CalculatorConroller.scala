package com.abhi

import javax.inject.Singleton
import com.twitter.util.Future
import com.twitter.finatra.thrift.Controller
import Calculator._

@Singleton
class CalculatorController extends Controller with Calculator.BaseServiceIface {
  override val add = handle(Add) { args: Add.Args => 
    Future.value(args.a + args.b)
  }
  override val subtract = handle(Subtract) { args : Subtract.Args => 
    Future.value(args.a - args.b)
  }
  override val multiply = handle(Multiply) { args: Multiply.Args => 
    Future.value(args.a * args.b)
  }
}