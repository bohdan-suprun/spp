package ua.nure.lab2

import java.time.LocalDate

/**
 * @author Bohdan_Suprun
 */
class Car(val manufacturer: String, val model: String, val yearOfManufacturing: Int, private var regNumber: String) {
  def this(manufacturer: String, model: String) {
    this(manufacturer, model, -1, "")
  }

  def this(manufacturer: String, model: String, yearOfManufacturing: Int) {
    this(manufacturer, model, yearOfManufacturing, "")
  }

  def this(manufacturer: String, model: String, date: LocalDate) {
    this(manufacturer, model, date.getYear, "")
  }

  def getRegNumber = regNumber

  def setRegNumber(number: String) = regNumber = number

  override def toString = f"$manufacturer - $model - $yearOfManufacturing - $regNumber"
}

object Car {
  def apply(manufacturer: String, model: String) = new Car(manufacturer, model)
}
