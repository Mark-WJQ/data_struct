package 动态规划

object 下降路径最小和 {

  def main(args: Array[String]): Unit = {

    val matrix = Array(Array(2,1,3),Array(6,5,4),Array(7,8,9))
    println(minFallingPathSum(matrix))

    val m1 = Array(Array(-19,57),Array(-40,-5))
    println(minFallingPathSum(m1))

  }


  /**
   * 广度优先搜索
   * 或 动态规划
   *  状态为当前元素所在位置 f(i,j)
   *  求 f(i,j) = min{f(i-1,j),f(i-1,j-1),f(i-1,j+1)}+s(i,j)
   *
   * @param matrix
   * @return
   */
  def minFallingPathSum(matrix: Array[Array[Int]]): Int = {
    val n = matrix.length
    val result = Array.ofDim[Int](n,n)

    for (i <- 1 until(n)){
      for(j <- 0 until(n)){
        val v = matrix(i)(j)
        var p = matrix(i-1)(j)
        if (j > 0){
          p = math.min(p,matrix(i-1)(j-1))
        }
        if (j < n-1){
          p = math.min(p,matrix(i-1)(j+1))
        }
        matrix(i)(j) = p+v
      }
    }
    var min = matrix(n-1)(0)
    for (i <- matrix(n-1)){
      min = math.min(min,i)
    }
    min
  }

}
