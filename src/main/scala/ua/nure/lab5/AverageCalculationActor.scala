package ua.nure.lab5

import akka.actor.{Actor, ActorRef}

/**
  * Class AverageCalculationActor implementation. 
  *
  * @author Bohdan_Suprun
  */
class AverageCalculationActor(sum: ActorRef) extends Actor {

  def receive: PartialFunction[Any, Unit] = {
    case x: Array[Double] => sum ! (x.sum / x.length)
  }
}
