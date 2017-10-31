package ua.nure.lab5

import akka.actor.{Actor, ActorIdentity, ActorRef, Identify}

/**
  * Class AverageCalculationActor implementation. 
  *
  * @author Bohdan_Suprun
  */
class AverageCalculationActor extends Actor {
  private var sum: ActorRef = _

  def receive: PartialFunction[Any, Unit] = {
    case x: Array[Double] => sum ! (x.sum / x.length)
    case ActorIdentity("sum", x) => sum = x.get
  }
}
