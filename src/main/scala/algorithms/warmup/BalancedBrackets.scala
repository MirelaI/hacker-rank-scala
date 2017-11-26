package algorithms.warmup

import java.util.Scanner

import scala.collection.mutable.ListBuffer

/**
  * Created by mirela on 26/11/2017.
  *
  * Given an array of brackets, write a method that
  * returns true if the array is balanced, or false
  * otherwise. Note, a balanced list of brackets means
  * that any opening bracket has a closing one.
  * For example: [{()}] is balances
  * and {]} is not
  *
  * Also the opening and closing brackets have to be
  * consistent, for example the list [{]} is not consistent
  */
object BalancedBrackets {

  val bracketsMapping: Map[Char, Char] = Map(
    '(' -> ')',
    '[' -> ']',
    '{' -> '}'
  )

  def isBalanced(brackets: List[Char]): Boolean = {
    var listOfOpenBr: ListBuffer[Char] = ListBuffer()
    brackets.size match {
      case 0 => false
      case n if n % 2 == 1 => false
      case _ => {
        var isBalanced = true

        for (br <- brackets) {
          if (bracketsMapping.isDefinedAt(br)) {
            listOfOpenBr += br
          } else {
            // We are on the closing br branch
            val openBr = listOfOpenBr.remove(listOfOpenBr.size - 1)
            if (br != bracketsMapping(openBr)) {
              isBalanced = false
            }
          }
        }

        isBalanced
      }
    }
  }


  def main(args: Array[String]) = {
    val sc: Scanner = new Scanner(System.in)

    val bracketsString: String = sc.nextLine()
    val balancedList: List[Char] = bracketsString.toList

    val bracketsAreBalanced: Boolean = isBalanced(balancedList)

    println(s"String ${bracketsString} is balanced: ${bracketsAreBalanced}")
  }
}
