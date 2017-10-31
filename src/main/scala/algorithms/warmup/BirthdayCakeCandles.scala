package algorithms.warmup

/**
  * Created by mirela on 31/10/2017.
  */
object BirthdayCakeCandles {
  def birthdayCakeCandles(n: Int, ar: List[Int]): Int = {
    val maxHeight = ar.max
    ar.count(_ == maxHeight)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val candles = for (index <- 0 until n) yield sc.nextInt()

    val result = birthdayCakeCandles(n, candles.toList)
    println(result)
  }
}
