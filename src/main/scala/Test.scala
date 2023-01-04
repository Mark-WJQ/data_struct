import scala.io.StdIn
import scala.util.control.Breaks

object Test {

  def main(args: Array[String]): Unit = {


    StdIn.readLine()
    Breaks.breakable {
      println("------")
    }
    println("Hello world!")
  }

}
