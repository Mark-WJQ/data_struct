package 递归

/**
 * 树老师爬楼梯，他可以每次走1级或2级，输入楼梯的级数，求不同的走法数
 * eg: 楼梯一共有3级，他可以每次都走1级，或者第一次走一级，第二次走两级，也可以第一次走两级第二次走一级，一共三种方法
 *
 * n级台阶走法 = 先走一级后，n-1级台阶的走法 + 先走两级后，n-2级台阶的走法
 * f(n) = f(n-1) + f(n-2)
 *
 * 边界条件
 * f(0) = 1
 * f(1) = 1
 */
object 爬楼梯 {

  def main(args: Array[String]): Unit = {
    println(step(10))
  }

  def step(n:Int): Int = {
    if(n == 1 || n == 0){
      return 1;
    }

    step(n-1) + step(n-2)

  }




}
