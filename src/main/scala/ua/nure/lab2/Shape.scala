package ua.nure.lab2

/**
 * @author Bohdan_Suprun
 */
abstract class Shape {

  def centerPoint: (Int, Int)
}

class Circle(center: (Int, Int), radius: Double) extends Shape {
  override def centerPoint: (Int, Int) = center
}

class Rectangle(aCoordinates: (Int, Int), bCoordinates: (Int, Int)) extends Shape {
  override def centerPoint: (Int, Int) = {
    val x = Math.max(aCoordinates._1, bCoordinates._1) - Math.min(aCoordinates._1, bCoordinates._1)
    val y = Math.max(aCoordinates._2, bCoordinates._2) - Math.min(aCoordinates._2, bCoordinates._2)

    (x, y)
  }
}
