package ua.nure.lab4

/**
  * Class Matrix implementation. 
  *
  * @author Bohdan_Suprun
  */
class Matrix(private[Matrix] val base: Array[Array[Double]]) {

  def apply(x: Int, y: Int): Double = base(x)(y)

  def *(scalar: Double): Matrix = {
    for (i <- base.indices) {
      for (j <- base(i).indices) {
        base(i)(j) *= scalar
      }
    }

    this
  }

  def *(other: Matrix): Matrix = {
    val copyBase = base.clone()
    val copyOtherBase = other.base

    for (row <- copyBase)
      yield for (col <- copyOtherBase.transpose)
        yield (row zip col map Function.tupled(_ * _)).sum

    new Matrix(copyOtherBase)
  }

  def +(other: Matrix): Matrix = {
    val copyBase = base.clone()
    val copyOtherBase = other.base

    for (row <- copyBase)
      yield for (col <- copyOtherBase.transpose)
        yield (row zip col map Function.tupled(_ + _)).sum

    new Matrix(copyBase)
  }

}

object Matrix {
  def main(args: Array[String]): Unit = {
    val arr: Array[Array[Double]] = Array.ofDim(3, 3)
    arr(0)(0) = 10
    arr(0)(1) = 20
    arr(0)(2) = 30
    arr(1)(0) = 40
    arr(1)(1) = 50
    arr(1)(2) = 60
    arr(2)(0) = 70
    arr(2)(1) = 80
    arr(2)(2) = 90

    val matr = new Matrix(arr)
    println(s"Expected 60: ${matr(1, 2) == 60}")
    matr * 100
    println(s"Multiplication on 100: ${matr(1, 2) == 6000}")
  }
}
