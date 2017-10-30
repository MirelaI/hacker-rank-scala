package algorithms.warmup

/**
  * Created by mirela on 30/10/2017.
  */
object SimpleArraySum {

  def simpleArraySum(n: Int, ar: Array[Int]): Int =  {
    val sum: Int = recursionSum(ar.toList)

    sum
  }

  def recursionSum(xs: List[Int]): Int = {
    xs match {
      case x::tail => x + recursionSum(tail)
      case Nil => 0
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val ar = new Array[Int](n)

    (0 until n-1).map{ x: Int => ar(x) = sc.nextInt()}

    val result = simpleArraySum(n, ar)
    println(result)
  }
}