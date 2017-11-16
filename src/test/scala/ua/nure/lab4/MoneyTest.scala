package ua.nure.lab4

import org.specs2.mutable.Specification

/**
  * Class MoneyTest implementation. 
  */
class MoneyTest extends Specification {

  "MoneyTest" should {
    "$eq$eq" in {
      new Money(10, 30) == new Money(10, 30)
      new Money(10, 30) != new Money(10, 20)
      new Money(10, 30) != new Money(9, 30)
    }

    "$plus" in {
      new Money(10, 30) + new Money(10, 30) == new Money(20, 60)
      new Money(10, 50) + new Money(10, 60) == new Money(21, 10)
      new Money(1, 75)  +  new Money(0, 50) == new Money(2, 25)
    }

    "$minus" in {
      new Money(10, 30) - new Money(10, 30) == new Money(0, 0)
      new Money(10, 50) - new Money(10, 60) == new Money(0, -10)
    }

    "$less" in {
      new Money(10, 30) < new Money(10, 40)
      !(new Money(10, 30) < new Money(10, 10))
      !(new Money(10, 30) < new Money(9, 30))
    }
  }
}
