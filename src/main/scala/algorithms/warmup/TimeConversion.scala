package algorithms.warmup

/**
  * Created by mirela on 03/11/2017.
  *
  * Given a time in -hour AM/PM format, convert it to military (-hour) time.
  *
  * Note: Midnight is  on a -hour clock, and  on a -hour clock. Noon is on a
  * -hour clock, and  on a -hour clock.
  */

class InvalidTimeException(m: String) extends Exception

object TimeConversion {

  def timeConversion(timeInput: String): String =  {
    val Time = """(\d{2}):(\d{2}):(\d{2})(AM|PM)""".r

    timeInput match {
      case Time(hour, minute, second, period) =>
        val convertedHour = convertHour(hour.toInt, period)

        List(convertedHour.toString, minute,second).mkString(":")
      case _ => throw new InvalidTimeException("Time not formatted properly")
    }
  }

  def convertHour(hour: Int, period: String): String = {
    period match {
      case "AM" => "%02d".format(hour.toInt % 12)
      case "PM" if hour < 12 => (hour.toInt + 12).toString
      case _ => hour.toString
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val inputTime = sc.next()

    val result = timeConversion(inputTime)

    println(result)
  }
}
