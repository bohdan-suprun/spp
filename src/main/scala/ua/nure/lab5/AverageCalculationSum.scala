package ua.nure.lab5

import akka.actor.{Actor, ActorSystem, Props}

import scala.util.Random

/**
  * Class AverageCalculationProducer implementation. 
  *
  * @author Bohdan_Suprun
  */
class AverageCalculationSum(arr: Array[Double]) extends Actor {
  private var avg: Double = 0
  private var cnt: Int = 0
  private val expectedCnt: Int = if (arr.length % 200 == 0) arr.length / 200 else arr.length / 200 + 1

  def receive: PartialFunction[Any, Unit] = {
    case x: Double =>
      avg = (avg * cnt + x) / (cnt + 1)
      cnt += 1
      if (expectedCnt >= cnt) {
        self ! "finish"
      }
    case "finish" =>
      println(s"Avg is $avg")
      context.children.foreach(x => context.stop(x))
      context.stop(self)
      context.system.shutdown()
    case "start" =>
      for (num <- arr.grouped(expectedCnt)) {
        val actor = context.system.actorOf(Props[AverageCalculationActor](new AverageCalculationActor(self)))
        context.watch(actor)
        actor ! num
      }
  }

  def getAvg: Double = avg
}

object AverageCalculationSum {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("averageSumator")
    val sum = system.actorOf(Props[AverageCalculationSum](new AverageCalculationSum(generateArray)), "summator")

    sum ! "start"
  }


  def generateArray: Array[Double] = {
    val rand = new Random()
    val array = Array.fill(1000000) {
      rand.nextDouble()
    }
    array
  }
}