package algorithms.sorting

import java.util.Scanner

/**
  * Created by mirela on 05/11/2017.
  */
object InsertionSortII {

  /**
    * function insertionSort(array A)
    *  for i from 1 to length[A]-1 do
    *      value := A[i]
    *      j := i-1
    *      while j >= 0 and A[j] > value do
    *          A[j+1] := A[j]
    *          j := j-1
    *      done
    *      A[j+1] = value
    *  done
    */

  def insertSort(n: Int, arr: Array[Int]): Array[Int] = {
    for (i <- 0 until n) {

      val elem = arr(i)

      var j = i-1
      while(j>=0 && elem < arr(j)) {
        arr(j+1) = arr(j)

        j -= 1
      }

      arr(j+1) = elem
    }

    arr
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt
    val unsortedList: Array[Int] = sc.nextLine().split(" ").map { _.toInt }

    val sortedArray = insertSort(n, unsortedList)
    println(sortedArray.mkString(" "))
  }
}
