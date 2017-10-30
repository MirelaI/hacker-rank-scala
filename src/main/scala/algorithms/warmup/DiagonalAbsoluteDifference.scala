package algorithms.warmup

/**
  * Created by mirela on 30/10/2017.
  */
object DiagonalAbsoluteDifference {

  def absoluteDifference(matrix: Array[Array[Int]]): Int = {
    val diagonal: List[Int] = diag(matrix)
    val oDiag: List[Int] = opposedDiagonal(matrix)

    val diff = diagonal.sum - oDiag.sum

    diff match {
      case e: Int if e < 0 => e * (-1)
      case _ => diff
    }
  }

  def diag(matrix: Array[Array[Int]]): List[Int] = {
    for ( x <- matrix.indices.toList) yield matrix(x)(x)
  }

  def opposedDiagonal(matrix: Array[Array[Int]]): List[Int] = {
    val size = matrix.size - 1

    for (x <- matrix.indices.toList) yield matrix(size - x)(x)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val a = Array.ofDim[Int](n, n)

    for (a_i <- 0 until n) {
      for (a_j <- 0 until n ) {
        a(a_i)(a_j) = sc.nextInt()
      }
    }

    println(absoluteDifference(a))
  }
}
