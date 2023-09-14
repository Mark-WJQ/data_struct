package 数组


/**
 * leetcode 153
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
object 寻找旋转排序数组中的最小值 {


  def main(args: Array[String]): Unit = {

  }


  /**
   * 数组旋转的结果有两种
   * 1. 旋转正好是整圈数，还是单调上升的数组，这个很好判断，直接 tail > head? 如果是 return head
   * 2. 非整圈数，数组由两个单调的子数组组成
   *  1. 问题的关键是如何快速找到包含最小值的子数组
   *     2. 暴力遍历
   *     3. 二分查找
   *    1. 将数组一分为二
   *       2. 找出非单调递增的数组
   *       3. 如果两个都是单调递增，则选一个最小的head
   *       4. 否则直到剩下一个元素
   *
   * @param nums
   * @return
   */
  def findMin(nums: Array[Int]): Int = {
    val l = nums.length
    var left = 0
    var right = l - 1
    if (nums(left) <= nums(right)) {
      return nums(left);
    }
    while (left < right) {
      var mid = (left + right) / 2;
      if (nums(left) > nums(mid)) {
        right = mid;
      } else if (nums(mid + 1) > nums(right)) {
        left = mid + 1
      } else {
        return math.min(nums(left), nums(mid + 1))
      }
    }
    nums(left);
}




}
