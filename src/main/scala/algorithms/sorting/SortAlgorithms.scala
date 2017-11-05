package algorithms.sorting

import scala.collection.mutable.ArrayBuffer


/**
  * Created by mirela on 05/11/2017.
  */
object SortAlgorithms {

  def bubbleSort(array: Array[Int]): Array[Int] = {
    val listLength: Int = array.length

    for (i <- 0 until listLength) {
      // Last i elements are in place
      for (j <- 0 until listLength - i - 1) {
        if (array(j) > array(j + 1)) {
          // Do the swapping
          val min = array(j + 1)

          array(j + 1) = array(j)
          array(j) = min
        }
      }
    }

    array
  }

  /** Selects the min element of the array and swaps it with the first element
    * of the list. Then it finds the second smallest and moves it again.
    * Continue duing this till all elements are in place.
    */
  def selectionSort(array: Array[Int]): Array[Int] = {
    val n: Int = array.length
    var mutableArray = array.to[ArrayBuffer]

    for (i <- 0 until n) {

      for(i <- i until n) {
        val min = mutableArray.drop(i).min

        mutableArray -= min
        mutableArray.insertAll(i, Seq(min))
      }
    }

    mutableArray.toArray
  }
}
