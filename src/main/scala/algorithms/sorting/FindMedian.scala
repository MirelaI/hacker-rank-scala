package algorithms.sorting

import java.util.Scanner

/**
  * Created by mirela on 26/11/2017.
  *
  * Challenge
  * =========
  *
  * Given a list of numbers, can you find the median?
  */
object FindMedian {

  def findMedian(li: Array[Int], n: Int): Int = {
    val sorted = li.sorted

    sorted(n/2)
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt
    val elements: Array[Int] = sc.nextLine().split(" ").map { _.toInt }

    println(findMedian(elements, n))
  }
}
