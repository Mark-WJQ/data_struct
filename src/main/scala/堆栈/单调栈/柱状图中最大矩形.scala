package 堆栈.单调栈

import scala.collection.mutable


object 柱状图中最大矩形 {

  def main(args: Array[String]): Unit = {
    println(largestRectangleArea(Array(2,1,5,6,2,3)));
    println(largestRectangleArea(Array(2,4)));
    println(largestRectangleArea(Array(1)));
    println(largestRectangleArea(Array(2,3)));




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
   *    2. 当我们在使用单调栈计算这种情况时,单调递增 此时 hj 在栈中，如果 hk >= hj 记录k 位置左边第一个小于他的位置为j，hk入栈，如果 hk < hj 将hj 出栈，知道找到比hk小的位置 j，记录j，并入栈hk
   *    3. 计算右边第一个小于当前的index，单调递增
   *    然后遍历高度数组
   *
   *
   * 4. 单调栈+常数优化
   *  以位置i为起点，向左右两边遍历，直到找到第一个小于自己的元素，所以问题可以转换为，求左/右侧第一个比当前元素小的值
   *  使用单调递增，
   *
   * @param args
   */
  def largestRectangleArea(heights: Array[Int]): Int = {
    val hl = heights.length
    val stack = mutable.Stack[Int](-1)
    val left  = Array.ofDim[Int](hl)
    val right  = Array.ofDim[Int](hl)
    for (i <- 0 until(hl)){
      var top = stack.head
      while (top!= -1 && heights(i) <= heights(top) ){
        stack.pop()
        top = stack.head
      }
      stack.push(i)
      left(i) = top

    }

    //求右边的位置
    stack.clear()
    stack.push(hl)
    for (i <- hl-1 to(0) by(-1)){
      var top = stack.head
      while (top != hl && heights(i) <= heights(top)) {
        stack.pop()
        top = stack.head
      }
      stack.push(i)
      right(i) = top
    }
    var max = heights(0);
    for (i <- 0 until(hl)){
     max = math.max( heights(i) * (right(i)-(left(i)+1)),max)
    }
    max
  }

}
