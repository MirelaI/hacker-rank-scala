package sorting

/**
  * Created by mirela on 03/11/2017.
  *
  * Consider an array of numeric strings, here each string is a positive
  * number with anywhere from 1  to 10~6 digits. Sort the array's elements in
  * non-decreasing (i.e., ascending) order of their real-world integer values
  * and print each element of the sorted array on a new line.
  */
object BigSorting {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val unsorted = new Array[String](n)

    (0 until n).foreach{ index => unsorted(index) = sc.next() }

    val sortedList: List[String] = bigSort(unsorted)

    sortedList.foreach { println(_)}
  }

  def bigSort(inputValues: Array[String]): List[String] = {
    inputValues.sorted.sortBy( _.length ).toList
  }
}
