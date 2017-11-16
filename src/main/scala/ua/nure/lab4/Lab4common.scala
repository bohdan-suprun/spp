package ua.nure.lab4

import scala.collection.mutable
import scala.collection.parallel.immutable

/**
  * Class Lab4common implementation. 
  *
  * @author Bohdan_Suprun
  */
object Lab4common {
  def values(fun: (Int) => Int, low: Int, high: Int): List[(Int, Int)] = {
    var list: List[(Int, Int)] = List()
    for (value <- low to high) {
      list = list ++ List((value, fun(value)))
    }
    list
  }

  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    inputs.map(fun).max
  }

  def indexes(str: String): mutable.Map[String, Set[Int]] = {
    val map = new mutable.LinkedHashMap[String, Set[Int]]()

    str.toUpperCase.zipWithIndex.groupBy {
      case (sym: Char, _) => sym
    }.foreach {
      case (sym: Char, occur: IndexedSeq[(Char, Int)]) =>
        val indexes = occur.map {
          case (_, index: Int) => index
        }
        map.put(String.valueOf(sym), indexes.toSet)
    }
    map
  }

  def removeZeroMembers(linkedList: List[Int]): List[Int] = {
    linkedList.filter(x => x != 0)
  }
}
