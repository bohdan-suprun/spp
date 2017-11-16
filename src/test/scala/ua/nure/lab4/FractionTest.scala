package ua.nure.lab4

import org.specs2.mutable.Specification

/**
  * Class FractionTest implementation. 
  *
  * @author Bohdan_Suprun
  */
class FractionTest extends Specification {

  "FractionTest" should {
    "$times" in {
      new Fraction(10, 20) * new Fraction(15, 45) mustEqual new Fraction(1, 6)
    }

    "$plus" in {
      new Fraction(10, 20) + new Fraction(15, 45) mustEqual new Fraction(5, 6)
    }

    "$minus" in {
      new Fraction(10, 20) - new Fraction(15, 45) mustEqual new Fraction(1, 6)
    }

    "$div" in {
      new Fraction(10, 20) / new Fraction(15, 45) mustEqual new Fraction(3, 2)
    }
  }
}
