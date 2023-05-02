package 递归

import java.util

object 算24 {


  /**
   *
   * 给出4个小于10的正整数，你可以使用加减乘除四种运算以及括号把这四个数连接起来得到一个表达式。现在的问题是是否存在一种方式，使得得到的表达式的结果等于24.
   *
   *  n个数算24 必然有两个数要先算，这两个数算的结果跟剩余n-2个数就构成了n-1个数求24的问题。枚举先算的两个数以及这两个数的运算方式
   *  边界条件：
   *  当 n = 1 时，一个数等于24
   *
   *
   *
   * @param args
   */

  def main(args: Array[String]): Unit = {

    val deque:util.Deque[String] = new util.LinkedList[String]();
    deque.push("1")
    deque.push("2")
    deque.push("3")
    deque.push("4")
    while (!deque.isEmpty){
      println(deque.pollLast())
      println(deque.pop())
    }


  }

}
