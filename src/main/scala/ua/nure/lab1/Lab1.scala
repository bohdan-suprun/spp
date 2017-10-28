package ua.nure.lab1

import java.io.InputStream
import java.util.{Calendar, Scanner}

import ua.nure.lab2.Time

import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.mutable

/**
 * @author Bohdan_Suprun
 */
object Lab1 {

  def sign(num: Double): Int = {
    num match {
      case a if a > 0 => 1
      case a if a < 0 => -1
      case _ => 0
    }
  }

  def getStringCodeProduction(str: String): Int = {
    if (str.isEmpty) return 0

    var prod = 1
    for (ch <- str.toCharArray) {
      prod *= ch
    }

    prod
  }

  def getStringCodeProduction2(str: String): Int = {
    if (str.isEmpty) return 0

    str.map(_.asInstanceOf[Int]).product
  }

  def changeNearNumbers(arr: Array[Any]): Array[Any] = {
    val copy = arr.clone()

    for (i <- 0 until copy.length - 1 by 2) {
      (copy(i), copy(i + 1)) match {
        case (f, s) => copy(i) = s; copy(i + 1) = f
      }
    }

    copy
  }

  def changeNearNumbersForYield(arr: Array[Any]): Array[Any] = {
    (for {group <- arr.grouped(2)
          reversed <- group.reverse} yield reversed
      ).toArray
  }

  def sortArray(arr: Array[Double]): Array[Double] = {
    (for (pos <- arr if pos >= 0) yield pos) ++ (for (neg <- arr if neg < 0) yield neg)
  }

  def getUniqueElements(arr: Array[Any]): Array[Any] = {
    arr.groupBy(p => p)
      .collect({ case (key, Array(_)) => key })
      .toArray
  }

  def getAmericaTimezones: Array[String] = {
    val prefix = "America/"
    java.util.TimeZone.getAvailableIDs
      .filter(zone => zone.startsWith(prefix))
      .transform(zone => zone.replaceFirst(prefix, ""))
      .sorted
      .toArray
  }

  def getMapOfProducts: Map[String, Double] = {
    val firstMap = Map("Notebook" -> 1000, "Car" -> 4000, "Chocolate" -> 4000)
    var secondMap = Map[String, Double]()

    for ((name, price) <- firstMap) {
      secondMap += name -> price * 0.9
    }

    println(secondMap)
    secondMap
  }

  def getDaysOfWeek: mutable.LinkedHashMap[String, Int] = {
    val firstMap = mutable.LinkedHashMap("Monday" -> Calendar.MONDAY,
      "Tuesday" -> Calendar.TUESDAY,
      "Wednesday" -> Calendar.WEDNESDAY,
      "Thursday" -> Calendar.THURSDAY,
      "Friday" -> Calendar.FRIDAY,
      "Saturday" -> Calendar.SATURDAY,
      "Sunday" -> Calendar.SUNDAY)

    for ((name, value) <- firstMap) {
      println(f"$name -> $value")
    }

    firstMap
  }

  def countWords(in: InputStream): mutable.Map[String, Int] = {
    val map = mutable.HashMap[String, Int]()
    var scanner: Scanner = null
    try {
      scanner = new Scanner(in)
      while (scanner.hasNext) {
        val word = scanner.next()
        map.update(word, map.getOrElse(word, 0) + 1)
      }
    } finally {
      if (scanner != null) {
        scanner.close()
      }
    }

    for ((word, cnt) <- map) {
      println(f"$word -> $cnt")
    }
    map
  }

  def printPropTable: String = {
    val props = propertiesAsScalaMap(System.getProperties)
    val maxKey = props.maxBy({ case (key, value) => key.length }).toString().length
    val maxProp = props.maxBy({ case (key, value) => value.length }).toString().length

    val result = props.map({ case (key, value) => f"${key.padTo(maxKey, ' ')} | ${value.padTo(maxProp, ' ')} |\n" })
      .reduce((a, b) => a + b)

    println(result)

    result
  }

  def lteqgt(arr: Array[Int], v: Int): (Int, Int, Int) = {
    ((for (a <- arr if a < v) yield a).length,
      (for (a <- arr if a == v) yield a).length,
      (for (a <- arr if a > v) yield a).length)
  }
}
