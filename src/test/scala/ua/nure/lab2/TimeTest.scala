package ua.nure.lab2

import org.specs2.mutable.Specification

/**
  * @author Bohdan_Suprun
  */
class TimeTest extends Specification {

  "TimeTest" should {
    val time = new Time(10, 12)
    "before" in {
      time before new Time(12, 0) mustEqual true
      time before new Time(10, 11) mustEqual false
    }

  }
}
