package algorithms.sorting

import java.util.Scanner

/**
  * Created by mirela on 20/11/2017.
  */
class CountingSort {

  def countSort(lof: List[Int]): List[Int] = {
    (0 until 100).toList.map { elem => lof.count(elem == _) }
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt
    val unsortedList: List[Int] = sc.nextLine().split(" ").map {
      _.toInt
    }.toList

    val countApparences: List[Int] = countSort(unsortedList)

    println(countApparences.mkString(" "))
  }

}
