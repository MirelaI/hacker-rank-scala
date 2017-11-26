package algorithms.sorting

import java.util.Scanner

import scala.collection.mutable.ListBuffer

/**
  * Created by mirela on 26/11/2017.
  */
object LilisHomework {

  def findNoSwaps(unsorted: ListBuffer[Int], sorted: ListBuffer[Int]): Int = {
    var swap: Int = 0

    var indexes: Map[Int, Int] = unsorted.zipWithIndex.toMap

    for (i <- unsorted.indices) {
      if (unsorted(i) != sorted(i)) {
        swap += 1

        val indexToSwap = indexes(sorted(i))
        val elemToSwap = sorted(i)
        val temp = unsorted(i)
        indexes += (unsorted(i) -> indexes(elemToSwap))

        unsorted.update(i, sorted(i))
        unsorted.update(indexToSwap, temp)
      }
    }

    swap
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt

    val unsortedList: ListBuffer[Int] = sc.nextLine.split(" ").map{ _.toInt }.to[ListBuffer]

    val noOfSwaps: Int = findNoSwaps(unsortedList, unsortedList.sorted)
    val noOfSwapsReversed: Int = findNoSwaps(unsortedList, unsortedList.sorted.reverse)

    println(List(noOfSwaps, noOfSwapsReversed).min)
  }
}
