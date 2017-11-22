package algorithms.sorting

import java.util.Scanner

/**
  * Created by mirela on 20/11/2017.
  */
object CountingSort {

  def countSort(lof: List[Int]): List[Int] = {
    // Use in-memory caching caching here as is
    // too expensive to call the count method
    // each time.
    var countCache: Map[Int, Int] = Map()

    (0 until 100).toList.map { elem =>
      val count = countCache.get(elem) match {
        case Some(count) => count
        case None =>
          val newCount = lof.count(elem == _)
          countCache += (elem -> newCount)
          newCount
      }
      elem -> count
    }.flatMap { result =>
      List.fill(result._2)(result._1)
    }
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt
    val unsortedList: List[Int] = sc.nextLine().split(" ").map {
      _.toInt
    }.toList

    val sortedList: List[Int] = countSort(unsortedList)

    println(sortedList.mkString(" "))
  }
}
