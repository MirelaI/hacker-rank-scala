package algorithms.sorting

import scala.io.StdIn
import scala.math.abs

/**
  * Created by mirela on 26/11/2017.
  *
  * Challenge
  * =========
  * Given a list of unsorted integers, A = {a1, ... , an}, can you find the pair
  * of elements that have the smallest absolute difference between them? If
  * there are multiple pairs, find them all.
  *
  */
object ClosestNumber {

  def findMinPairs(numbers: List[Int]): List[Int] = {
    val sorted = numbers.sorted.sliding(2).map { li => (abs(li(1) - li(0)), li) }.toList
    val min: Int = sorted.minBy { _._1 }._1

    sorted.filter { _._1 == min }.flatMap{ _._2 }
  }

  def main(args: Array[String]) = {
    val sc = StdIn
    sc.readLine()

    val listOfInts = sc.readLine.split(" ").map { _.toInt }.toList

    val minPairs = findMinPairs(listOfInts)
println(minPairs)
    println(minPairs.mkString(" ") )
  }
}
