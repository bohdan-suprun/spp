package ua.nure.lab5

import java.io.File

import akka.actor.{Actor, ActorIdentity, ActorRef, ActorSystem, Props, Terminated}

import scala.collection.mutable
import scala.io.Source

/**
  * Class Matchers implementation. 
  *
  * @author Bohdan_Suprun
  */
object Matchers {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem()
    val actor = system.actorOf(Props[SubTreeWalkerActor])

    actor ! ("C:/Users/Bohdan_Suprun/git/spp/src", "class")
  }

}

class MatcherDetectorActor extends Actor {

  private var collector: ActorRef = _

  override def receive: PartialFunction[Any, Unit] = {
    case (file: File, regExp: String) =>
      var cnt = 0
      for (line <- Source.fromFile(file).getLines) {
        if (line.contains(regExp)) {
          cnt += 1
        }
      }
      context.stop(self)
      collector ! (file.getAbsolutePath, cnt)
    case ActorIdentity("collector", actor) => collector = actor.get
  }

}

class SubTreeWalkerActor extends Actor {

  private var childTerminated: Int = 0
  private val collector: ActorRef = context.actorOf(Props[CollectorActor])

  override def receive: PartialFunction[Any, Unit] = {
    case (root: String, regExp: String) =>
      for (file <- recursiveListFiles(new File(root))) {
        if (file.isFile) {
          val matcher = context.actorOf(Props[MatcherDetectorActor])
          context.watch(matcher)

          matcher ! ActorIdentity("collector", Option(collector))
          matcher ! (file, regExp)
        }
      }

    case Terminated(_) =>
      childTerminated += 1
      if (childTerminated >= context.children.size) {
        collector ! "finish"
        context.stop(self)
        context.system.shutdown()
      }
  }

  def recursiveListFiles(f: File): Array[File] = {
    val these = f.listFiles
    these ++ these.filter(_.isDirectory).flatMap(recursiveListFiles)
  }
}

class CollectorActor extends Actor {
  val set: mutable.Set[String] = mutable.HashSet()

  override def receive: PartialFunction[Any, Unit] = {
    case (file: String, cnt: Int) =>
      if (cnt > 0) {
        set.add(file)
      }

    case "finish" =>
      println("Finished [")
      set.foreach(println)
      println("]")
      context.stop(self)
  }
}
