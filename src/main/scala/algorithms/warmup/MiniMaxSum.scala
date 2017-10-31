package algorithms.warmup

/**
  * Created by mirela on 31/10/2017.
  */
object MiniMaxSum {

  def minMaxSum(arr: List[Long]): List[Long] = {
    val sortedList = arr.sorted

    List(
      sortedList.sum - sortedList.last,
      sortedList.sum - sortedList.head
    )
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val arr = for (index <- 0 until 5) yield sc.nextLong()

    val minMaxSumValues = minMaxSum(arr.toList)

    println(minMaxSumValues.mkString(" "))
  }
}
