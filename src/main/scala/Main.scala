import scala.io.StdIn
import scala.util.control.Breaks


@main def hello: Unit = 
  StdIn.readLine()
  Breaks.breakable{
    
  }
  println("Hello world!")
  println(msg)

def msg = "I was compiled by Scala 3. :)"

