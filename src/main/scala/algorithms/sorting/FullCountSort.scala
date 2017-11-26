package algorithms.sorting

import java.util.Scanner
import scala.collection.mutable.ListBuffer

/**
  * Created by mirela on 22/11/2017.
  *
  * Challenge
  * ---------
  * In the previous challenge, you created a "helper array" that contains information about the
  * starting position of each element in a sorted array. Can you use this array to help you
  * create a sorted array of the original list?
  *
  * Hint
  * ----
  * You can go through the original array to access the strings. You can then use your helper
  * array to help determine where to place those strings in the sorted array. Be careful about
  * being one off.
  */
object FullCountSort {

  def fullCountSort(list: ListBuffer[List[String]], n: Int) = {
    val zippedList: ListBuffer[(List[String], Int)] = list.zipWithIndex

    (0 until n).toList.flatMap { elem =>
      // Remove the elements after you filter them ...
      val filteredList = zippedList.filter { listElems => listElems._1.head.toInt == elem }

      filteredList.foreach{ elem => zippedList -= elem }

      filteredList.map { filList =>
        filList._2 match {
          case e if e < n/2 => "-"
          case _ => filList._1.tail.head
        }
      }
    }
  }

  def main(args: Array[String]) = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt
    var listOfList: ListBuffer[List[String]] = ListBuffer()

    while (sc.hasNextLine() && listOfList.size < n) {
      val line = sc.nextLine().split(" ").toList

      listOfList += line
    }

     val something = fullCountSort(listOfList, n)

     println(something.mkString(" "))
  }
}
