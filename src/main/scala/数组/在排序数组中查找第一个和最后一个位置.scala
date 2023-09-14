package 数组


/**
 * leetcode 34
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。

 */
object 在排序数组中查找第一个和最后一个位置 {


  /**
   * 使用二分查找法，排除法
   *
   * 设左边起点位置为l，右边起点位置为r,中间位置为mid
   * 初始化 l=0,r=nums.length
   *
   * while l < r{
   *   mid = (l+r)/2
   *   if(nums[mid] > target){
   *      r = mid
   *   }else{
   *      l = mid
   *   }
   * }
   * nums[left] == target ? left : -1
   *
   * 经过排除，最终返回的下标一定是与target相等的元素
   *
   * 假设第一次mid指向的元素就等于target，但相等的元素并不止一个
   * 根据算法会检查重置l=mid，假设第二次求出的mid页等于target，那么l=mid，所以循环下去最终会找到最右面的与target相等的元素，此时向前遍历直到第一个不等于target的元素
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   * @param nums
   * @param target
   * @return
   */



  def searchRange(nums: Array[Int], target: Int): Array[Int] = {

    Array(1)
  }
}
