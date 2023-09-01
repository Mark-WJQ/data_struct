package 双指针

import scala.collection.{immutable, mutable}
import scala.runtime.Arrays
import scala.util.control.Breaks.{break, breakable}

object 三数之和 {

  def main(args: Array[String]): Unit = {
    println(threeSum(Array(0,0,0,0,0)))
  }


  /**
   * 先排序
   * 使用头指针指向起点 nh，尾指针指向终点 nt
   *  v=  target - nh+nt
   *  if(v > 0) nt 向前移动  v<0 nh 后移  
   * 
   * @param nums
   * @return
   */
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val sortNums = nums.sorted
    val l = nums.length
    var result = List[List[Int]]()


      for (i <- 0 until (l - 1)) {
        breakable {
        if (i > 0 && sortNums(i) == sortNums(i - 1)) {
          break
        }
        var t = sortNums(i)
        var left = i + 1
        var right = l - 1
        var target = 0 - t;
        while (left < right) {
          breakable {
            val r = sortNums(left) + sortNums(right)
            if (left +1 < right-1 && sortNums(left) == sortNums(left + 1) && sortNums(right - 1) == sortNums(right)){
              if (r == target){
                left += 1
                right -= 1
                break
              }
            }
              if (target == r) {
                result = (List(t, sortNums(left), sortNums(right)))::result
                left += 1
                right -= 1
              } else if (target > r) {
                left += 1
              } else {
                right -= 1
              }
          }
        }
      }
    }
    result
  }
}
