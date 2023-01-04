package 递归

import java.util
import scala.io.StdIn

/**
 * 表达式 = 项 或 项 + 项 或项 -项
 * 项 = 因子 或 因子*因子 或 因子/因子
 * 因子 = （表达式） 或 数字
 */
object 表达式计算 {

  val q = new util.LinkedList[String]
  val stack = new util.LinkedList[String]


  def main(args: Array[String]): Unit = {
    var s = StdIn.readLine();
    while (s  != "\t"){
      q.offer(s)
      s = StdIn.readLine();
    }
    println(expression_value());
  }


  def factor_value():Int={
    val factor = q.poll();
    factor match
      case "(" => val r = expression_value();q.poll();r
      case _ =>  factor.toInt
  }

  def term_value():Int={
    val t = factor_value();
    val op = getOp();
    op match
      case "*" => q.poll(); t * factor_value();
      case "/" => q.poll(); t / factor_value();
      case _ => t
  }

  def expression_value():Int ={
    val t = term_value()
    val op = getOp();
    op match
      case "+" => q.poll(); t + term_value();
      case "-" => q.poll(); t - term_value();
      case _ => t
  }

  def getOp(): String = {
    q.peek()
  }


}
