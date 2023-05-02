package 动态规划

object 粉刷房子 {

  def main(args: Array[String]): Unit = {



  }

  def minCost(costs: Array[Array[Int]]): Int = {
    val l = costs.length
    val il = costs(0).length
    var r = Array.ofDim[Int](l,il)
    for (i <- 0 until(il)){
      r(0)(i) = costs(0)(i)
     }

    for (i <- 1 until(l)){
      for (j <- 0 until(il)){
        if (j == 0){
          r(i)(j) = math.min(r(i-1)(1),r(i-1)(2)) + costs(i)(j)
        }
        if (j == 1){
          r(i)(j) = math.min(r(i-1)(0),r(i-1)(2)) + costs(i)(j)
        }
        if (j == 2) {
          r(i)(j) = math.min(r(i - 1)(0), r(i - 1)(1)) + costs(i)(j)
        }
      }
    }
    math.min(math.min(r(l-1)(0),r(l-1)(1)),r(l-1)(2))
  }






  /**
   * 第n个房子用颜色c来粉刷，第n-1个房子只能用 c以外的颜色粉刷
   * @param n
   * @param c
   * @return
   */
  def f(n:Int,c:Int,costs: Array[Array[Int]]): Int = {
    if(n == 1){
      return costs(0)(c)
    }
    var r = Int.MaxValue
    for (i <- 0 until(3)){
      if(i != c){
        r  = math.min(f(n-1,i,costs)+costs(n-1)(c),r)
      }
    }
    r
  }



}
