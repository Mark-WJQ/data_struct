package 单调栈

object 柱状图中最大矩形 {



  def main(args: Array[String]): Unit = {

  }


  /**
   * 力扣 84 题
   *
   * 暴力解法
   * 1. 从左向右遍历，计算以当前柱子为终点的最大面积
   *  1. 设当前位置为 i , 高度为 hi = heights(i), 数组长度为 hl, 记 minh 为遍历过程中最小的高度，初始值 minh = hi， 记maxs 为遍历中最大面积
   *  2. 向前遍历 位置为 0<=n < i, 高度为 hn = heights(n)，minh = min(minh,hn)
   *  3. 通过minh，n，i 计算出面积s，maxs = max(s,maxs)
   *  4. 针对每个柱子这样计算
   *
   * 2. 从左向右遍历，检查每个柱子的左右两边，直到小于当前的柱子出现
   *    1. 设当前的位置为 i ， 高度为 heights(i),记maxs 为遍历中最大面积
   *    2. 向左遍历，左下标为 n ，  0 <= n < i, 终止条件 heights(n) < heights(i) || n == 0 ,记录 n
   *    3. 向右遍历,右下标为m, i < m < heights.length , 终止条件 heights(m) < heights(i) || m == heights.length ,记录 m
   *    4. 通过m，n，heights(i) 计算出面积 s, maxs = max(s,maxs)
   *    5. 针对每个柱子都这样计算，找出最大的面积
   * 3. 使用单调栈
   *    1. 从第二种解法中可以抽象出，我们是在求，第一个比当前位置低的位置，设当前位置为 i,高度记为 hi；第一个比当前位置低的为 j，高度记为 hj； 中间位置为k，高度记为 hk； 则有  hk >= hi > hj, j < k <= i
   *    2. 当我们在使用单调栈计算这种情况时,单调递减 此时 hj 在栈中，如果 hk >= hj 记录k 位置左边第一个小于他的位置为j，且hk不入栈，如果 hk < hj 则将 hk 入栈
   *
   * @param args
   */
  def largestRectangleArea(heights: Array[Int]): Int = {


    0
  }

}
