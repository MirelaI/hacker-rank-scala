package algorithms.warmup

/**
  * Created by mirela on 30/10/2017.
  */
object CompareTriplets {

  def compare(leftReview: List[Int], rightReview: List[Int]) = {
    var leftReviewTotal = 0
    var rightReviewTotal = 0
    for (x <- leftReview.indices) {
      leftReview(x) match {
        case s: Int if s > rightReview(x) => leftReviewTotal += 1
        case s: Int if s < rightReview(x) => rightReviewTotal += 1
        case _ =>
      }
    }

    (leftReviewTotal, rightReviewTotal)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val a0 = sc.nextInt()
    val a1 = sc.nextInt()
    val a2 = sc.nextInt()
    val b0 = sc.nextInt()
    val b1 = sc.nextInt()
    val b2 = sc.nextInt()

    val score = compare(List(a0, a1, a2), List(b0, b1, b2))

    println(score._1 + " " + score._2)
  }
}
