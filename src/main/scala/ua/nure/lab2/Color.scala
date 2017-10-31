package ua.nure.lab2

/**
 * @author Bohdan_Suprun
 */
object Color extends Enumeration {

  val WHITE = Value(0xFFFFFF)
  val BLACK = Value(0x000000)
  val RED = Value(0xFF0000)
  val BLUE = Value(0x0000FF)
  val MAGENTA = Value(0xFF00FF)
  val CYAN = Value(0x00FFFF)
  val GREEN = Value(0x00FF00)
  val YELLOW = Value(0xFFFF00)

  def main(args: Array[String]) {
    Color.values.toArray.sorted.foreach {
      case any => println(f"$any -> ${any.id}")
    }
  }
}
