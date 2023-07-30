package 动态规划

import scala.util.control.Breaks.{break, breakable}

object 跳跃游戏 {

  def main(args: Array[String]): Unit = {

    println(canJump(Array(2,3,1,1,4)));
    println(canJump(Array(3,2,1,0,4)));
    println(canJump2(Array(2,3,1,1,4)));
    println(canJump2(Array(3,2,1,0,4)));
    println(canJump3(Array(2,3,1,1,4)));
    println(canJump3(Array(1)));





  }


  def canJump(nums: Array[Int]): Boolean = {
    val n = nums.length
    val result = Array.ofDim[Boolean](n)
    result(0) = true

    for (i <- 1 until(n)){
      breakable{
        for (j <- i to (0) by (-1)) {
          if (result(j) && i - j <= nums(j)) {
            result(i) = true
            break
          }
        }
      }
    }
    result(n-1)
  }


  /**
   * 问题可以转化为 调到第i的位置，最少跳 j 步
   *  状态转义
   *  计算 第 i 哥位置时，回溯检查 0~i-1 位置中到i 最少的步数 +1
   *
   *  初始状态 result(0) = 0
   *
   *
   *
   * @param nums
   * @return
   */
  def canJump2(nums: Array[Int]): Int = {
    val n = nums.length
    val result = Array.ofDim[Int](n)
    result(0) = 0

    for (i <- 1 until (n)) {
      result(i) = Int.MaxValue
      breakable {
        for (j <- i-1 to (0) by (-1)) {
          if(result(j) == Int.MaxValue){
            return 0;
          }
          if ( i - j <= nums(j)) {
            result(i) = math.min(result(j)+1,result(i))
          }
        }
      }
    }
    if (result(n - 1) == Int.MaxValue){
      return 0
    }
    result(n - 1)
  }


  def canJump3(nums: Array[Int]): Int = {
    val n = nums.length
    val result = Array.ofDim[Int](n)
    result(0) = 0
    var max = 0
    for (i <- 0 until (n)) {
      val cur = i + nums(i)
      if (cur > max) {
        for (k <- cur until (max) by (-1)) {
          if (k < n){
            result(k) = result(i) + 1
          }
        }
        max = cur
        if(max >= n-1){
          return result(n - 1)
        }
      }
    }
    result(n - 1)
  }







}
