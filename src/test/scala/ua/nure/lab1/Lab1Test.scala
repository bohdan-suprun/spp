package ua.nure.lab1

import org.specs2.mutable.Specification

import scala.collection.mutable

/**
  * @author Bohdan_Suprun
  */
class Lab1Test extends Specification {
  "Lab1" should {
    val lab1 = new Lab1()
    "sign for positive number be 1" in {
      lab1 sign 234545 mustEqual 1

    }
    "sign for negative number be -1" in {
      lab1 sign -234545 mustEqual -1

    }
    "sign for 0 be 0" in {
      lab1 sign 0 mustEqual 0

    }
    "getStringCodeProduction2" in {
      lab1 getStringCodeProduction2 "ddd" mustEqual Math.pow('d'.asInstanceOf[Int], 3)
      lab1 getStringCodeProduction2 "" mustEqual 0
    }

    "getStringCodeProduction" in {
      lab1 getStringCodeProduction "ddd" mustEqual Math.pow('d'.asInstanceOf[Int], 3)
      lab1 getStringCodeProduction "" mustEqual 0
    }

    "changeNearNumbers" in {
      lab1 changeNearNumbers Array(10, 20) mustEqual Array(20, 10)
      lab1 changeNearNumbers Array(10, 20, 30, 40) mustEqual Array(20, 10, 40, 30)
      lab1 changeNearNumbers Array(10, 20, 30, 40, 50) mustEqual Array(20, 10, 40, 30, 50)
      lab1 changeNearNumbers Array() mustEqual Array()
    }
    "changeNearNumbersForYield" in {
      lab1 changeNearNumbersForYield Array(10, 20) mustEqual Array(20, 10)
      lab1 changeNearNumbersForYield Array(10, 20, 30, 40) mustEqual Array(20, 10, 40, 30)
      lab1 changeNearNumbersForYield Array(10, 20, 30, 40, 50) mustEqual Array(20, 10, 40, 30, 50)
      lab1 changeNearNumbersForYield Array() mustEqual Array()
    }

    "sortArray" in {
      lab1 sortArray Array(10, 20) mustEqual Array(10, 20)
      lab1 sortArray Array(-10, -20) mustEqual Array(-10, -20)
      lab1 sortArray Array(-10, 20, -30, 40) mustEqual Array(20, 40, -10, -30)
      lab1 sortArray Array(10, -20, 30, -40, -50) mustEqual Array(10, 30, -20, -40, -50)
      lab1 sortArray Array() mustEqual Array()
    }
    "getUniqueElements" in {
      lab1.getUniqueElements(Array(10, 20)).contains(Array(10, 20))
      !lab1.getUniqueElements(Array(10, 20, 10)).contains(10)
      lab1.getUniqueElements(Array(50, 100, 10, 20, 10)).contains(Array(10))
      lab1.getUniqueElements(Array("q", "a", "b", "c", "a", "1", "c")).contains(Array("a", "c"))
      lab1 getUniqueElements Array() mustEqual Array()
    }

    "getAmericaTimezones" in {
      lab1.getAmericaTimezones.length == 165
    }

    "getMapOfProducts" in {
      lab1.getMapOfProducts.nonEmpty
    }

    "getDaysOfWeek" in {
      lab1.getDaysOfWeek.size == 7
    }

    "countWords" in {
      lab1 countWords getClass
        .getResourceAsStream("test.txt") mustEqual mutable.Map("scala" -> 2, "hello" -> 2, "test" -> 1)
    }

    "printPropTable" in {
      lab1.printPropTable.nonEmpty
    }

    "lteqgt" in {
      lab1 lteqgt (Array(10, 20, 30, 40), 20) mustEqual (1, 1, 2)
    }
  }
}
