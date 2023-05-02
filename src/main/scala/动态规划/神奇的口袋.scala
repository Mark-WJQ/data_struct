package 动态规划

import scala.io.StdIn

object 神奇的口袋 {


  /**
   * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出
   * 一些物品，这些物品的总体积必须是40。
   *  John现在有n（1≤n ≤ 20）个想要得到的物品，每个物品
   * 的体积分别是a1，a2……an。John可以从这些物品中选择一
   * 些，如果选出的物体的总体积是40，那么利用这个神奇的
   * 口袋，John就可以得到这些物品。现在的问题是，John有
   * 多少种不同的选择物品的方式。
   *
   *
   *  解题思路
   *  设目标体积为w，物品个数为k
   *  f(w,k) = f(w,k-1) + f(w-a[k],k-1)
   *  分两种情况第k个物品是否计入目标体积
   *  边界值
   *  w = 0 ,f(w,k) = 1
   *  k <=0,f(w,k) = 0
   *
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {



  }

  var N = StdIn.readInt();
  var a = Array.ofDim[Int](N)
  def ways( w:Int,k:Int):Int={
    if(w == 0){
      return 1

  }
    if (k<=0){
      return 0
    }
    ways(w,k-1) + ways(w-a(k),k-1)
  }


  def waysDp(w: Int, k: Int): Int = {
    val r = Array.ofDim[Int](w,k)
    for (i <- 0 until k ){
      r(0)(i) = 1
    }
    for (i <- 1 until w){
      for (j <- 1 until k){
        r(i)(j) = r(i)(j-1);
        if (i >= a(j)){
          r(i)(j) = r(i)(j) + r(i-a(j))(j-1)
        }
      }
    }
    r(w-1)(k-1)
  }



}
