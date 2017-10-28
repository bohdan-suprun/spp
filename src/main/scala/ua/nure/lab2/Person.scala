package ua.nure.lab2

/**
 * @author Bohdan_Suprun
 */
class Person(name: String) {
  private val reg = """(.+)\s(.+)""".r

  val (firstName, lastName) = name match {
    case reg(f, l) => (f, l)
  }

  override def toString = f"$firstName $lastName"
}
