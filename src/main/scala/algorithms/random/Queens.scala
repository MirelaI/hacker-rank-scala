package algorithms.random

import java.util.Scanner

/**
  * Created by mirela on 21/01/2018.
  */
object Queens {

  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] = {
      if (k == 0) {
        List(List())
      } else {
        for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens
      }
    }

    placeQueens(n)
  }

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]): Boolean = {
    queens forall (q => !inCheck(queen, q))
  }

  def inCheck(q1: (Int, Int), q2: (Int, Int)) =
    q1._1 == q2._1 || // on same row
    q1._2 == q2._2 || // on same column
    (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // on n diagonal


  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    // Number of queens to be placed
    val n = sc.nextLine().toInt

    queens(n)
  }
}
