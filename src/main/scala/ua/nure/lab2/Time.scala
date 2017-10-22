package ua.nure.lab2

/**
  * @author Bohdan_Suprun
  */
class Time(private val hrs: Int, private val min: Int) {
  private val minutes = hrs * 60 + min

  def before(other: Time): Boolean = {
    minutes < other.minutes
  }
}
