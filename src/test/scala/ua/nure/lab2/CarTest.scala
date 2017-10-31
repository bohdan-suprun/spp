package ua.nure.lab2

import java.time.LocalDate

import org.specs2.mutable.Specification

/**
 * @author Bohdan_Suprun
 */
class CarTest extends Specification {

  "Car" should {
    "be constructed using manufacturer and model params" in {
      new Car("BMW", "X6").toString() == "BMW - X6 - -1 - "
    }

    "be constructed using manufacturer, model and year:Int params" in {
      new Car("BMW", "X6", 2017).toString() == "BMW - X6 - 2017 - "
    }

    "be constructed using manufacturer, model and year:LocalDate params" in {
      new Car("BMW", "X6", LocalDate.ofYearDay(2016, 256)).toString() == "BMW - X6 - 2016 - "
    }

    "be constructed using manufacturer, model, year, regNumber params" in {
      new Car("BMW", "X6", 2000, "AX1234BA").toString() == "BMW - X6 - 2000 - AX1234BA"
    }

    "allow changing of regNumber" in {
      val car = new Car("BMW", "X6", 2000)
      car.toString() == "BMW - X6 - 2000 - "
      car.setRegNumber("AX1234BA")
      car.toString == "BMW - X6 - 2000 - AX1234BA"
    }

    "allow creating without new keyword" in {
      val car = Car("BMW", "X6")
      car.toString() == "BMW - X6 - -1 - "
    }
  }
}
