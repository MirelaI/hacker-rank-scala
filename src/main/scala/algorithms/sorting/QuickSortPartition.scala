package algorithms.sorting

import java.util.Scanner

/**
  * Created by mirela on 20/11/2017.
  */
object QuickSortPartition {

  def partition(lof: List[Int]): List[Int] = {
    val pivot: Int = lof(0)

    var left: Seq[Int] = Seq()
    var right: Seq[Int] = Seq()
    var equal: Seq[Int] = Seq()

    lof.foreach { elem: Int =>
      elem match {
        case e: Int if e < pivot =>
          left = left :+ e
        case e: Int if e > pivot =>
          right = right :+ e
        case e: Int if e == pivot => equal = equal :+ e
      }
    }

    left.toList ::: equal.toList ::: right.toList
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
