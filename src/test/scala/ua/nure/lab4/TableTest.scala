package ua.nure.lab4

import org.specs2.mutable.Specification

/**
  * Class TableTest implementation. 
  *
  * @author Bohdan_Suprun
  */
class TableTest extends Specification {

  "TableTest" should {
    "$bar$bar" in {
      (new Table | "Hello" | "WORLD" || "A bit" | "scala").toString.toLowerCase == "<table><tr><td>hello</td><td>world</td></tr>" +
        "<tr><td>a bit</td><td>scala</td></tr></table>"
    }
  }
}
