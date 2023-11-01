package 堆栈

import scala.collection.mutable

/**
 *
 * leetcode 227
 *
 * 给你一个计算表达式s，请你实现一个基本计算器来计算并返回它的值
 * 整数除法仅保留整数部分
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 *
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
object 基本计算器 {


  def main(args: Array[String]): Unit = {


    println(calculate("3+2*2"))
    println(calculate("13+2*2-4"))
    println(calculate(" 13 +2*2-4+ 3 "))
    println(calculate("13"))


  }


  /**
   * 使用栈
   * 假设初始 op = '+'
   * 执行以下操作
   *  1. 初始化栈，遍历字符串s，乘除优先计算
   *  2. 如果当前遍历元素为数字，检查op的值
   *      1. 如果 op = '+',元素入栈
   *      2. 如果op = '-',元素取反入栈
   *      3. 如果op='*' 或 op ='/',取出栈顶元素，计算后入栈
   *  3. 否则将操作符赋值给op
   *  4. 最后将栈中元素相加
   *
   *
   *该思路实际上是将所有计算转成加法运算了
   *
   *
   * @param s
   * @return
   */
  def calculate(s: String): Int = {
    val l = s.length
    if(l == 1){
      return s.toInt
    }

    val ops = Array('+','-','*','/')
    var op = '+';
    var i = 0
    val stack =  mutable.Stack[Int]()
    while (i < l){
      if (s(i).isDigit) {
        //获取数字
        var pre = 0
        while ( i < l && s(i).isDigit){
          pre = pre*10+(s(i)-'0').toInt
          i+=1
        }
        op match {
          case '+' => stack.push(pre)
          case '-' => stack.push(-pre)
          case '*' => stack.push(stack.pop()*pre)
          case  '/' => stack.push(stack.pop()/pre)
        }
      }
      if (i < l && ops.contains(s(i))) {
         op = s(i)
      }
      i+=1
    }
    stack.sum
  }





}
