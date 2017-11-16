package ua.nure.lab4

/**
  * Class Money implementation. 
  */
class Money(dollars: Int, cents: Int) {

  private val absCents: Int = dollars * 100 + cents

  def +(other: Money): Money = {
    new Money(absCents + other.absCents)
  }

  def -(other: Money): Money = {
    new Money(absCents - other.absCents)
  }

  def ==(other: Money): Boolean = {
    absCents == other.absCents
  }

  def <(other: Money): Boolean = {
    absCents < other.absCents
  }

  private def this(cents: Int) {
    this(cents / 100, cents % 100)
  }

  override def toString: String = s"$dollars, $cents"
}
