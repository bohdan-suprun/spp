package ua.nure.lab2

import java.util.{Set => JavaSet}

import scala.collection.mutable.{HashSet => ScalaHashSet, Set => ScalaSet}

/**
 * @author Bohdan_Suprun
 */
object Lab2SubPrograms {

  def convert[T](javaSet: JavaSet[T]): ScalaSet[T] = {
    val scalaSet = new ScalaHashSet[T]()
    val arr = javaSet.toArray.asInstanceOf[Array[T]]

    arr.foreach {
      case x => scalaSet.add(x)
    }

    scalaSet
  }

  def checkPassword() = {
    val number = "Number"
    val uppercase = "Uppercase"
    val lowercase = "Lowercase"
    val other = "Other"

    val userName = System.getProperty("user.name")
    println(f"Hi, $userName enter your password:")
    val password = Console.in.readLine()


    val checkRes = password.toCharArray.groupBy({
      case x if String.valueOf(x).matches("[0-9]") => number
      case x if String.valueOf(x).matches("[A-Z]") => uppercase
      case x if String.valueOf(x).matches("[a-z]") => lowercase
      case _ => other
    }).map {
      case (x, array) => x -> array.length
    }

    if (checkRes.getOrElse(number, 0) < 2) {
      Console.err.println("Your password must contain at least 2 numbers")
    }

    if (checkRes.getOrElse(uppercase, 0) < 2) {
      Console.err.println("Your password must contain at least 2 uppercase symbols")
    }
  }

  def main(args: Array[String]) {
    checkPassword()
  }
}
