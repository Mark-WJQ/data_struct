package 贪心算法

import 贪心算法.跳跃游戏.main

/**
 * 力扣 55
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
class 跳跃游戏 {


  /**
   * 贪心算法
   * 从位置i 能到达最远的距离是  i + nums(i)
   *
   * 从每个位置都跳最远的距离
   * 记录一个最远的距离，从每个位置都跳一遍，如果超过前面最远的距离则更新，并计算是否到达最远处
   *
   *
   *
   * @param nums
   * @return
   */
  def canJump(nums: Array[Int]): Boolean = {
    val l = nums.length
    var max = 0
    for (i <- 0 until(l)){
      if (i <= max) {
        val cur = max + nums(i)
        max = math.max(cur, max)
        if (max >= l - 1) {
          return true
        }
      }
    }
    false
  }









}



object 跳跃游戏{
  def main(args: Array[String]): Unit = {
    println(canJump(Array(3,2,1,0,4)))
  }


  def canJump(nums: Array[Int]): Boolean = {
    val l = nums.length
    var max = 0
    for (i <- 0 until (l)) {
      if (i <= max) {
        val cur = i + nums(i)
        max = math.max(cur, max)
        if (max >= l - 1) {
          return true
        }
      }
    }
    false
  }
}
