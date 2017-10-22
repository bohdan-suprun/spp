package ua.nure.lab2

import org.specs2.mutable.Specification

/**
  * @author Bohdan_Suprun
  */
class PersonTest extends Specification {

  "PersonTest" should {
    val person = new Person("Bohdan Suprun")
    "test" in {
      person.lastName.equals("Suprun")
      person.firstName.equals("Bohdan")
    }

  }
}
