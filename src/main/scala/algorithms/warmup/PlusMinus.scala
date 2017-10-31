package algorithms.warmup

import java.text.DecimalFormat

/**
  * Created by mirela on 31/10/2017.
  */
object PlusMinus {
  val formatter = new DecimalFormat("#.######")

  def plusMinusElements(listInts: List[Int]): List[Double] = {
    List(
      listInts.count( _ > 0),
      listInts.count( _ < 0),
      listInts.count( _ == 0)
    ).map { counter =>
      formatter.format(counter.toDouble / listInts.size.toDouble).toDouble
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()

    val arr = for (index <- (0 until n).toList) yield sc.nextInt()
    val fractions: List[Double] = plusMinusElements(arr)

    println(fractions.mkString("\n"))
  }
}

