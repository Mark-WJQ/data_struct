package 递归

import scala.io.StdIn

/**
 * 逆波兰表达式是一种把运算符前置的算术表达式，eg：普通的表达式2+3 的逆波兰表示法为 + 2 3.
 * 逆波兰表达式的优点是运算符之间不必有优先级关系，也不必用括号改变运算次序，例如（2+3）*4 的逆波兰表示法：* + 2 3 4.
 * 本题求解逆波兰表达式的值，其中运算符包括 + - * /
 * 定义：
 * 1. 一个数是一个逆波兰表达式，值为该数
 * 2. "运算符 逆波兰表达式 逆波兰表达式" 是逆波兰表达式，值为两个逆波兰表达式的值运算结果
 */
object 逆波兰表达式 {

  def main(args: Array[String]): Unit = {

    println(exp());
  }



  def exp():Double = {
    val v = StdIn.readLine()
    v match{
      case "+" => exp() + exp()
      case "-" => exp() - exp()
      case "*" => exp() * exp()
      case "/" => exp() / exp()
      case _ => v.toDouble
    }
  }


}
