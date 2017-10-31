package ua.nure.lab3

import org.specs2.mutable.Specification

/**
 * @author Bohdan_Suprun
 */
class Lab3CommonTest extends Specification {

  "Lab3Common" should {
    "swap two numbers" in {
      Lab3Common swap(10, 20) mustEqual(20, 10)
    }

    "swap two first elements in array" in {
      Lab3Common swap Array(10, 20) mustEqual Array(20, 10)
    }

    "swap two first elements in array with length more then 2" in {
      Lab3Common swap Array(10, 20, 102, 104) mustEqual Array(20, 10, 102, 104)
    }

    "not fail with array with length 1" in {
      Lab3Common swap Array(10) mustEqual Array(10)
    }

    "calculate leaf sum" in {
      Lab3Common leafSum Array(Array(10, 40), 30, Array(50)) mustEqual 100
    }

    "calculate leaf sum for bin tree using classes" in {
      val binaryTree = Node(null, Node(null, Leaf(10), Leaf(20)), Node(null, Leaf(20), null))
      Lab3Common leafSum binaryTree mustEqual 50
    }

    "calculate leaf sum using classes" in {
      val tree = Node(null, Node(null, Leaf(3), Leaf(8)), Leaf(2), Node(null, Leaf(5)))
      Lab3Common leafSum tree mustEqual 18
    }

    "swap pairs" in {
      val pair = new PairMutable[Int](10, 20)
      pair.swap().mustEqual(20, 10)
    }

    "swap and return new Pair" in {
      val pair = Pair(30, 40)
      pair swap Pair(50, 80) mustEqual Pair(80, 50)
    }

    "return middle element" in {
      Lab3Common middle Array[Int](10, 20, 30) mustEqual 30
      Lab3Common middle Array[Int](10, 20) mustEqual 20
      Lab3Common middle Array[Int]() mustEqual null
      Lab3Common middle "World" mustEqual "r"
    }
  }
}
