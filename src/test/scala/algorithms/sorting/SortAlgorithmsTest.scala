package algorithms.sorting

import org.scalatest.Matchers

import scala.collection.mutable.ArrayBuffer

/**
  * Created by mirela on 05/11/2017.
  */
class SortAlgorithmsTest extends org.scalatest.FunSuite with Matchers {

  test("should sort array with only one misplaced element") {
    val array = Array(1, 2, 5, 3)

    val sortedArray = SortAlgorithms.bubbleSort(array)

    sortedArray should be(List(1, 2, 3, 5))
  }

  test("should sort array with multiple elements misplaced") {
    val array = Array(5, 2, 1, 3)

    val sortedArray = SortAlgorithms.bubbleSort(array)

    sortedArray should be(List(1, 2, 3, 5))
  }

  test("selection sort should sort array") {
    val array = Array(5, 2, 1, 3)

    val sortedArray = SortAlgorithms.selectionSort(array)

    sortedArray should be(List(1, 2, 3, 5))
  }

  test("merge sort should sort array") {
    val array = Array(5, 2, 1, 3)

    val sortedArray = MergeSort.mergeSort(array)

    sortedArray should be(List(1, 2, 3, 5))
  }
}
