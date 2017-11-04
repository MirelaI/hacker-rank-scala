package algorithms.sorting

import java.util.Scanner

/**
  * Created by mirela on 04/11/2017.
  *
  * Insert element into sorted list
  * Given a sorted list with an unsorted number  in the rightmost cell, can you
  * write some simple code to insert  into the array so that it remains sorted?
  * Print the array every time a value is shifted in the array until the array
  * is fully sorted. The goal of this challenge is to follow the correct order
  * of insertion sort.
  *
  * Guideline: You can copy the value of  to a variable and consider its cell
  * "empty". Since this leaves an extra cell empty on the right, you can shift
  * everything over until  can be inserted. This will create a duplicate of
  * each value, but when you reach the right spot, you can replace it with .
  *
  * Input Format
  * ------------
  * There will be two lines of input:
  *   - the size of the array
  *   - the array containing  sorted integers and  unsorted integer
  *     in the rightmost cell
  */
object InsertionSortI {

  // TODO: this is fugly .. improve it. 
  def insertSort(n: Int, arr: List[Int]): List[List[Int]] = {
    val list = arr.take(n-1)
    val elem = arr.last
    var added = false

    val tempList = for (i <- (list.length -1 to 0 by -1).toList if !added) yield {
      val toAdd: Int = elem < list(i) match {
        case true => list(i)
        case _ => added = true
          elem
      }

      println(list.take(i) + List(toAdd).mkString(" ") + list.drop(i))
      list.take(i+1) ++ List(toAdd) ++ list.drop(i+1)
    }

    added match {
      case true => tempList
      case false =>  tempList :+ List(elem) ++ list
    }
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt
    val sortedList: List[Int] = sc.nextLine().split(" ").map { _.toInt }.toList

    val listSorted = insertSort(n, sortedList)

    for (list <- listSorted) println(list.mkString(" "))
  }
}
