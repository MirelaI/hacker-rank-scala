package algorithms.sorting

import scala.collection.mutable.ArrayBuffer

/**
  * Created by mirela on 05/11/2017.
  */
object MergeSort {

  def mergeSort(arr: Array[Int]): Array[Int] = {
    arr.length match {
      case l: Int if l <= 1 => arr
      case l: Int =>
        val middle: Int = l/2

        val left =  mergeSort(arr.take(middle))
        val right = mergeSort(arr.drop(middle))

        merge(left, right)
    }
  }

  def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
    var result = new ArrayBuffer[Int]
    var leftIndex, rightIndex = 0

    while (leftIndex < left.length && rightIndex < right.length) {
      if (left(leftIndex) <= right(rightIndex)) {
        result += left(leftIndex)
        leftIndex += 1
      } else {
        result += right(rightIndex)
        rightIndex += 1
      }
    }

    if (leftIndex < left.length) {
      result ++= left.drop(leftIndex)
    }

    if (rightIndex < right.length) {
      result ++= right.drop(rightIndex)
    }

    result.toArray
  }
}
