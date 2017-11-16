package ua.nure.lab4

/**
  * Class Fraction implementation. 
  *
  * @author Bohdan_Suprun
  */
class Fraction(n: Int, d: Int) {

  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)


  def +(that: Fraction): Fraction = {
    new Fraction(num * that.den + that.num * den, that.den * den)
  }

  def -(that: Fraction): Fraction = {
    new Fraction(num * that.den - that.num * den, that.den * den)
  }

  def *(that: Fraction): Fraction = {
    new Fraction(num * that.num, that.den * den)
  }

  def /(that: Fraction): Fraction = {
    this * new Fraction(that.den, that.num)
  }

  private def sign(a: Int): Int = if (a > 0) 1 else if (a < 0) -1 else 0

  private def gcd(a: Int, b: Int): Int = if (b == 0) Math.abs(a) else gcd(b, a % b)

  override def toString: String = s"$num/$den"

  override def equals(obj: scala.Any): Boolean = {
    if (obj == null) {
      return false
    }

    if (super.equals(obj)) {
      return true
    }

    if (!obj.isInstanceOf[Fraction]) {
      return false
    }

    val that = obj.asInstanceOf[Fraction]

    num == that.num && den == that.den
  }
}
