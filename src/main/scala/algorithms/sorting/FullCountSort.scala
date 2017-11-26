package algorithms.sorting

import scala.io
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import scala.io.StdIn

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

  def fullCountSort(list: ListBuffer[(Int,String)], n: Int ) = {
    var mapValToCount: Map[Int, String] = Map.empty[Int, String]

    list.zipWithIndex.foreach { case ((fakeIndex, value), index) =>
      val stringToAdd: String = if (index < n/2) "-" else value

      val listOfValues: String = if (mapValToCount.isDefinedAt(fakeIndex)) {
        val x: String = mapValToCount(fakeIndex)
        x + " " + stringToAdd
      } else {
        stringToAdd
      }

      mapValToCount += (fakeIndex -> listOfValues)
    }

    (0 until n).foreach { index: Int =>
      mapValToCount.getOrElse(index, "")
    }
  }

  def main(args: Array[String]) = {
    val sc = StdIn
    val n = sc.readLine().toInt
    var listOfList: ListBuffer[(Int, String)] = ListBuffer()

    var line = ""
    while ({line = StdIn.readLine(); !line.isEmpty}) {
      val splitAsTuple = line.split(" ")
      val asTuple: (Int, String) =(splitAsTuple(0).toInt, splitAsTuple(1))

      listOfList += asTuple
    }

     val listOfString = fullCountSort(listOfList, n)

     println(listOfList.mkString(" "))
  }
}
