package algorithms.sorting

import java.util.Scanner

/**
  * Created by mirela on 20/11/2017.
  */
object QuickSortPartition {

  def partition(lof: List[Int]): List[Int] = {
    val pivot: Int = lof(0)

    var left: List[Int] = List()
    var right: List[Int] = List()
    var equal: List[Int] = List()

    lof.foreach { elem: Int =>
      elem match {
        case e: Int if e < pivot =>
          left = left :+ e
        case e: Int if e > pivot =>
          right = right :+ e
        case e: Int if e == pivot =>
          equal = equal :+ e
      }
    }

    left ::: equal ::: right
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt
    val unsortedList: List[Int] = sc.nextLine().split(" ").map {
      _.toInt
    }.toList

    val partitionedList: List[Int] = partition(unsortedList)

    println(partitionedList.mkString(" "))
  }
}
