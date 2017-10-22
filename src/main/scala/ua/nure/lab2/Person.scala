package ua.nure.lab2

/**
  * @author Bohdan_Suprun
  */
class Person(private val name: String) {
  private val reg = """(.+)\s(.+)""".r

  private val (_firstName, _lastName) = name match {
    case reg(f, l) => (f, l)
  }

  def firstName = _firstName

  def lastName = _lastName

  override def toString = f"$firstName $lastName"
}
