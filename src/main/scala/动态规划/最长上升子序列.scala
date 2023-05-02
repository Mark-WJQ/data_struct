package 动态规划


/**
 * 1. 求解子问题
 *   以a[k] 为终点的最长上升子序列
 * 2. 状态
 *  下标 k
 * 3. 状态转移方程
 * max(k) =
 *  if(k == 1){
 *   max(1) = 1
 *  } else{
 *
 *     max{max[i]+1} 0< i < k,且 a[i] < a[k]
 *     若找不到 = 1
 *
 *
 *  }
 *
 */
object 最长上升子序列 {


  def main(args: Array[String]): Unit = {
    
  }
  
  
  def maxIncreaseArray(array: Array[Int]):Int= {
    var la = Array.ofDim[Int](array.length)
    la(0) = 1
    var max = 1
    for (i <- 1 until array.length){
      if (array(i) > array(i-1)){
        la(i) = la(i-1) + 1;
      }else{
        la(i) = 1
      }
      if (la(i) > max){
        max = la(i)
      }
    }
    max
  }
  

}
