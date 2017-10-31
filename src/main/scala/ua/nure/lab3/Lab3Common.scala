package ua.nure.lab3

/**
 * @author Bohdan_Suprun
 */
object Lab3Common {

  def swap(first: Int, second: Int): (Int, Int) = (first, second) match {
    case (f, s) => (s, f)
  }

  def swap(arr: Array[Any]): Array[Any] = {
    arr match {
      case Array(x, y, _*) => arr(0) = y; arr(1) = x
      case _ =>
    }

    arr
  }

  def leafSum(arr: Array[Any]): Int = {
    var leafSum = 0
    for (elem <- arr) {
      val leaf = elem match {
        case x: Array[Int] => x
        case _ => Array[Int]()
      }
      if (leaf.length > 0) {
        leafSum += leaf.sum
      }
    }

    leafSum
  }

  def leafSum(tree: BinaryTree): Int = {
    var sum = 0
    if (tree != null) {
      tree match {
        case x: Leaf => sum += x.value
        case x: Node => sum += (for {node <- x.nodes} yield leafSum(node)).sum
        case _ =>
      }
    }

    sum
  }

  def middle[T](it: Iterable[T]): Option[T] = {
    var mid = it.size / 2
    var midValue: T = null.asInstanceOf[T]

    for (v <- it if mid > 0) {
      midValue = v
      mid -= 1
    }
    Option[T](midValue)
  }
}

sealed abstract class BinaryTree

case class Leaf(value: Int) extends BinaryTree

case class Node(op: String, nodes: BinaryTree*) extends BinaryTree

case class Pair[F, S](first: F, second: S) {
  def swap: (S, F) = (second, first)

  def swap[F2, S2](pair: Pair[F2, S2]): Pair[S2, F2] = pair match {
    case Pair(f, s) => Pair(s, f)
  }
}

final class PairMutable[T](var first: T, var second: T) {
  def swap(): (T, T) = (first, second) match {
    case (f, s) => first = s; second = f; (first, second)
  }
}

