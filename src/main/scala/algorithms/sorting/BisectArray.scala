package algorithms.sorting

import java.util.Scanner

/**
  * Created by mirela on 19/11/2017.
  */
object BisectArray {

  def findLastTrue(elements: List[(Int, Int)]): Int = {
    elements.size match {
      case 0 => -1
      case 1 => if (isTrue(elements(0)._1)) elements(0)._2 else -1

      case _ => {
        val pivot: Int = elements.size / 2

        if (isTrue(elements(pivot)._1)) {
          findLastTrue(elements.drop(pivot))
        } else {
          findLastTrue(elements.take(pivot))
        }
      }
    }
  }

  def isTrue(elem: Int): Boolean = elem match {
    case 1 => true
    case _ => false
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val listOfElements = sc.nextLine().split(" ").map{ _.toInt }.toList

    val lastIndex: Int = findLastTrue(listOfElements.zipWithIndex)

    println(s"Last positive found at index: $lastIndex")
  }
}
