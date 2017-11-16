package ua.nure.lab4

import org.specs2.mutable.Specification

import scala.collection.mutable

/**
  * Class Lab4commonTest implementation. 
  *
  * @author Bohdan_Suprun
  */
class Lab4commonTest extends Specification {

  "Lab4commonTest" should {
    "values" in {
      Lab4common values ((x) => x * x, 1, 3) mustEqual List((1, 1), (2, 4), (3, 9))
    }

    "largest" in {
      Lab4common largest ((x) => 10 * x - x * x, 1 to 10) mustEqual 25
    }

    "indexes" in {
      Lab4common indexes  "Mississippi" mustEqual mutable.LinkedHashMap[String, Set[Int]]("M" -> Set(0),
        "I" -> Set(1, 4, 7,10), "S" -> Set(2, 3, 5, 6), "P" -> Set(8, 9))
    }

    "removeZeroMembers" in {
      Lab4common removeZeroMembers  List(10, 20, 0, 30, 50, 0) mustEqual List(10, 20, 30, 50)
    }

  }
}
